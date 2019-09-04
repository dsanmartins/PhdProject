package br.ufscar.sas.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.LibraryLocation;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.nebula.jface.gridviewer.GridTableViewer;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;

import br.ufscar.sas.checkconstraint.CheckConstraint;
import br.ufscar.sas.createKDM.CreateKDM;
import br.ufscar.sas.cripto.CriptoBase64;
import br.ufscar.sas.database.QueryClass;
import br.ufscar.sas.dataconstraint.DataConstraint;
import br.ufscar.sas.parser.FieldClassVisitor;
import br.ufscar.sas.parser.MethodVisitor;
import br.ufscar.sas.parser.VariableVisitor;
import br.ufscar.sas.recommendation.RefactoringRecommendation;
import br.ufscar.sas.report.Report;
import br.ufscar.sas.tableviewer.Anomaly;
import br.ufscar.sas.tableviewer.Data;
import br.ufscar.sas.tableviewer.EditingAnnotationInstance;
import br.ufscar.sas.tableviewer.MappedAnomaly;
import br.ufscar.sas.tableviewer.TableLabelAnomalyMappedProvider;
import br.ufscar.sas.tableviewer.TableLabelAnomalyProvider;
import br.ufscar.sas.tableviewer.TableLabelProvider;
import br.ufscar.sas.transformation.AdaptiveSystemUMLProfile;
import br.ufscar.sas.transformation.ComputeModelDiff;
import br.ufscar.sas.transformation.Kdm2Uml;
import br.ufscar.sas.transformation.OpenComponentDiagram;
import br.ufscar.sas.transformation.Uml2PlantUML;

public class MainView extends ViewPart implements IPartListener2 {

	// get workbench window
	IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	// set selection service
	ISelectionService service = window.getSelectionService();
	// set structured selection
	IStructuredSelection structured = (IStructuredSelection) service.getSelection();
	// Progress Monitor
	ProgressMonitorDialog dialog = new ProgressMonitorDialog(window.getShell());
	// TableViewer
	TableViewer viewer;
	//TreeViewer
	TreeViewer treeViewer;
	// Data
	ArrayList<Data> arrData = new ArrayList<Data>();
	//Database Path
	static String databaseUrl = "";
	//Resultset
	List<String> rs = null;
	//Tree
	Tree tree = null;

	@Override
	public void createPartControl(Composite parent) {

		String projectName = null;
		if (structured != null) {

			IProject jProject = (IProject) structured.getFirstElement();
			projectName = jProject.getName();
			URI path = jProject.getLocationURI();
			databaseUrl = path.getPath() + "/";

			try 
			{	
				QueryClass queryClass = new QueryClass(databaseUrl);
				queryClass.createTables(); 
				queryClass.populateAbstractions(); 

				DataConstraint dataConstraint = new DataConstraint(databaseUrl);
				dataConstraint.createTables();

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} 
		// Register add listener
		final IWorkbenchWindow workbenchWindow = getSite().getWorkbenchWindow();
		workbenchWindow.getPartService().addPartListener(this);

		parent.setLayout(new GridLayout(1, false));
		TabFolder tabFolder = new TabFolder(parent, SWT.NONE);
		GridData gd_tabFolder = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_tabFolder.widthHint = 1280;
		gd_tabFolder.heightHint = 850;
		tabFolder.setLayoutData(gd_tabFolder);

		// Tab1
		this.UIAbstractionMaintainer(tabFolder, projectName);
		// Tab2
		this.UIAnnotation(tabFolder, projectName);
		//Tab3
		this.UIControPanel(tabFolder, projectName);
		// this.UIArchitecturalRefactoring(tabFolder, projectName);
		// Tab4
		// this.UICodeGenerator(tabFolder, projectName);

		tabFolder.setSelection(1);
	}

	private void UIAbstractionMaintainer(TabFolder tabFolder, String projectName)
	{	
		TabItem tab1 = new TabItem(tabFolder, SWT.NONE);
		tab1.setText("Configurations");

		Group group = new Group(tabFolder, SWT.NONE);
		Group treeViewGroup = new Group(group, SWT.NONE | SWT.V_SCROLL | SWT.H_SCROLL);
		treeViewGroup.setText("Abstractions Instances");
		treeViewGroup.setBounds(10, 55, 500, 450);
		treeViewGroup.setLayout(new FillLayout());
		tab1.setControl(group);

		Group controlGroup = new Group(group, SWT.NONE);
		controlGroup.setText("Control");
		controlGroup.setBounds(10, 0, 500, 50);

		Label label1 = new Label(controlGroup, SWT.NONE);
		label1.setText("Project Name: " + projectName);
		label1.setBounds(15, 3, 300, 20);


		tree = new Tree(treeViewGroup, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		tree.setLayout(new FillLayout());

		List<String> abstractions = null;
		final Menu menu = new Menu(tree);
		tree.setMenu(menu);

		try 
		{
			QueryClass queryClass = new QueryClass(MainView.getDatabaseUrl());
			abstractions = queryClass.getAbstractions();
			for (String abstraction : abstractions)
			{
				TreeItem item = new TreeItem(tree,0);
				item.setText(abstraction);
				String child = this.searchForChild(abstraction);
				if (child != null)
				{
					TreeItem itemChild = new TreeItem(item, 0);
					itemChild.setText(child);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		menu.addListener(SWT.Show, new Listener() {
			public void handleEvent(Event event) {
				MenuItem[] menuItems = menu.getItems();
				for (int i = 0; i < menuItems.length; i++) {
					menuItems[i].dispose();
				}
				TreeItem[] treeItems = tree.getSelection();
				for (int i = 0; i < treeItems.length; i++) {

					MenuItem menuItem1 = new MenuItem(menu, SWT.PUSH);
					menuItem1.setText("Add Instance");
					menuItem1.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
							if (tree.getSelection()[0].getItemCount() == 0)
							{
								if (tree.getSelection()[0].getParentItem() == null)
								{
									TreeItem treeItem = new TreeItem(tree.getSelection()[0],0);
									treeItem.setText(tree.getSelection()[0].getText() + "_" + 1);
									try {

										QueryClass queryClass = new QueryClass(MainView.getDatabaseUrl());
										queryClass.insertInstance(tree.getSelection()[0].getText(), treeItem.getText());
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}

								}
							}
							else
							{
								TreeItem[] items = tree.getSelection()[0].getItems();
								int number = Integer.valueOf((items[items.length-1]).getText().split(Pattern.quote("_"))[1]);
								number = number + 1;
								TreeItem treeItem = new TreeItem(tree.getSelection()[0],0);
								treeItem.setText(tree.getSelection()[0].getText() + "_" + number);

								try {

									QueryClass queryClass = new QueryClass(MainView.getDatabaseUrl());
									queryClass.insertInstance(tree.getSelection()[0].getText(), treeItem.getText());
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

							}
							tree.getSelection()[0].setExpanded(true);
						}
					});

					MenuItem menuItem2 = new MenuItem(menu, SWT.PUSH);
					menuItem2.setText("Remove Instance");
					menuItem2.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {

							TreeItem[] items = tree.getSelection()[0].getItems();
							String text = items[items.length-1].getText();


							try {
								QueryClass queryClass = new QueryClass(MainView.getDatabaseUrl());
								boolean rtn = queryClass.isUsingData(items[items.length-1].getText());
								if (rtn == false)
								{
									items[items.length-1].dispose();
									queryClass.deleteInstance(text);
								}
								else
									MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Info", "It can not be delete because it is already in use!");



							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						}
					});
				}
			}
		});

		Group tableViewGroup = new Group(group, SWT.NONE);
		tableViewGroup.setText("Architectural Anomalies");
		tableViewGroup.setBounds(10, 520, 500, 300);
		tableViewGroup.setLayout(new FillLayout());
		tab1.setControl(group);

		GridTableViewer gridTableViewer = new GridTableViewer(tableViewGroup, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.WRAP);
		gridTableViewer.setUseHashlookup(true);
		gridTableViewer.getGrid().setLinesVisible(true);
		gridTableViewer.getGrid().setHeaderVisible(true);
		gridTableViewer.getGrid().setVisibleLinesColumnPack(true);

		GridColumn column1 = new GridColumn(gridTableViewer.getGrid(), SWT.NONE);
		column1.setResizeable(false);
		column1.setWidth(75);
		column1.setText("Anomaly");

		GridColumn column2 = new GridColumn(gridTableViewer.getGrid(), SWT.NONE);
		column2.setResizeable(false);
		column2.setWidth(210);
		column2.setText("Name");

		GridColumn column3 = new GridColumn(gridTableViewer.getGrid(), SWT.NONE);
		column3.setResizeable(false);
		column3.setWidth(210);
		column3.setWordWrap(true);
		column3.setText("Description");

		gridTableViewer.setContentProvider(new ArrayContentProvider());
		gridTableViewer.setLabelProvider(new TableLabelAnomalyProvider());

		DataConstraint queryClass = null;
		List<Anomaly> anomalyObject = new ArrayList<Anomaly>();

		try {
			queryClass = new DataConstraint(databaseUrl);
			List<String> lstAnomaly= queryClass.getAnomalies();
			for (String anomaly :lstAnomaly )
				anomalyObject.add(new Anomaly(anomaly.split(Pattern.quote("|"))[0], anomaly.split(Pattern.quote("|"))[1], anomaly.split(Pattern.quote("|"))[2]  ));

			gridTableViewer.setInput(anomalyObject);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		GridColumn []cols = gridTableViewer.getGrid().getColumns();
		for (GridItem item : gridTableViewer.getGrid().getItems()) {
			GC gc = new GC(item.getDisplay());
			int hmax = 80;
			int max = 0;
			Point tb=null;
			for(GridColumn col : cols){
				tb = col.getCellRenderer().computeSize(gc, col.getWidth(), SWT.DEFAULT, item);
				max = Math.max(max, tb.y);
				if(max > hmax){
					break;
				}
			}

			if(hmax==-1){

			}else if(max > hmax){
				max=hmax;
			}

			gc.dispose();
			item.setHeight(max);
		}
	}

	private void UIAnnotation(TabFolder tabFolder, String projectName) {
		TabItem tab1 = new TabItem(tabFolder, SWT.NONE);
		tab1.setText("Code Elements Annotation");

		Group group = new Group(tabFolder, SWT.NONE);

		Group controlGroup = new Group(group, SWT.NONE);
		controlGroup.setText("Control");
		controlGroup.setBounds(10, 0, 500, 50);

		Label label1 = new Label(controlGroup, SWT.NONE);
		label1.setText("Project Name: " + projectName);
		label1.setBounds(15, 3, 300, 20);

		Group tableViewGroup = new Group(group, SWT.NONE);
		tableViewGroup.setText("Mapping Code Elements with Abstraction Instances");
		tableViewGroup.setBounds(10, 55, 550, 450);
		tableViewGroup.setLayout(new FillLayout());
		tab1.setControl(group);

		viewer = new TableViewer(tableViewGroup, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		final Table table = viewer.getTable();

		TableViewerColumn column0 = new TableViewerColumn(viewer, SWT.CENTER);
		column0.getColumn().setText("Element");
		column0.getColumn().setWidth(75);
		column0.getColumn().setResizable(false);

		TableViewerColumn column = new TableViewerColumn(viewer, SWT.CENTER);
		column.getColumn().setText("Element Name");
		column.getColumn().setWidth(250);
		column.getColumn().setResizable(false);

		TableViewerColumn column2 = new TableViewerColumn(viewer, SWT.CENTER);
		column2.getColumn().setText("Abstraction");
		column2.getColumn().setWidth(130);
		column2.getColumn().setResizable(false);


		EditingAnnotationInstance editingAnnotation = new EditingAnnotationInstance(column2.getViewer());
		column2.setEditingSupport(editingAnnotation);

		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setLabelProvider(new TableLabelProvider());

		//Update combocellviewer
		tabFolder.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent event) {
				if (tabFolder.getSelection()[0].getText().equals("Code Elements Annotation"))
				{
					EditingAnnotationInstance editingAnnotation = new EditingAnnotationInstance(column2.getViewer());
					column2.setEditingSupport(editingAnnotation);
				}
			}
		});

		Button processAnnotation = new Button(controlGroup, SWT.NONE);
		processAnnotation.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		processAnnotation.setBounds(350, 0, 140, 25);
		processAnnotation.setText("Process Annotations");

		processAnnotation.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				
				try {
					dialog.run(true, true, new IRunnableWithProgress()
					{ 
						public void run(IProgressMonitor monitor) 
						{ 
							//Creates KDM instance 
							int totalUnitsOfWork = IProgressMonitor.UNKNOWN;
							
							try {
								QueryClass queryClass1 = new QueryClass(databaseUrl);
								queryClass1.variableBelongsTo();
								QueryClass queryClass2 = new QueryClass(databaseUrl);
								queryClass2.fieldBelongsTo();
								QueryClass queryClass3 = new QueryClass(databaseUrl);
								queryClass3.methodBelongsTo();
								QueryClass queryClass4 = new QueryClass(databaseUrl);
								queryClass4.classBelongsTo();
							
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
							monitor.beginTask("Creating Structure Package in KDM...",totalUnitsOfWork); 
							String projectName = MainView.getDatabaseUrl().split("\\/")[MainView.getDatabaseUrl().split("\\/").length-1];
							CreateKDM ck = new CreateKDM();
							ck.createKDMFile(projectName); 
							monitor.done(); 
							try 
							{ 
								refreshProjects(); 
							}
							catch (CoreException e) 
							{
								e.printStackTrace();
							} 
						} 
					});

				} catch (InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	private void UIControPanel(TabFolder tabFolder, String projectName) {

		TabItem tab1 = new TabItem(tabFolder, SWT.NONE);
		tab1.setText("Control Panel");
		Group group = new Group(tabFolder, SWT.NONE);

		Button generateReport = new Button(group, SWT.NONE);
		generateReport.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		generateReport.setBounds(10, 10, 100, 25);
		generateReport.setText("Create Report");
		generateReport.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_BLUE)); 
		generateReport.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE)); 

		Group controlGroup = new Group(group, SWT.NONE);
		controlGroup.setText("Architecture Visualization");
		controlGroup.setBounds(10, 50, 450, 130);

		Label label1 = new Label(controlGroup, SWT.NONE);
		label1.setText("Project Name: " + projectName);
		label1.setBounds(15, 3, 300, 20);

		Group radioButtons = new Group(controlGroup, SWT.NONE);
		radioButtons.setLayout(new RowLayout(SWT.HORIZONTAL));
		radioButtons.setBounds(10, 35, 280, 30);

		Button[] radios = new Button[3];
		radios[0] = new Button(radioButtons, SWT.RADIO);
		radios[0].setText("Current");
		radios[0].setBounds(10, 35, 200, 30);
		radios[0].setSelection(true);

		radios[1] = new Button(radioButtons, SWT.RADIO);
		radios[1].setText("Planned");
		radios[1].setBounds(120, 35, 160, 30);

		radios[2] = new Button(radioButtons, SWT.RADIO);
		radios[2].setText("Differences");
		radios[2].setBounds(200, 35, 160, 30);

		Button btnFCA = new Button(controlGroup, SWT.NONE);
		btnFCA.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnFCA.setBounds(10, 75, 100, 25);
		btnFCA.setText("Show");

		Group controlGroup2 = new Group(group, SWT.NONE);
		controlGroup2.setText("Check Constraints");
		controlGroup2.setBounds(10, 200, 450,260);

		Label lblExistence =  new Label(controlGroup2, SWT.NONE);
		lblExistence.setText("Lack of abstractions:");
		lblExistence.setBounds(15, 15, 150, 20);

		Text txtExistence =  new Text(controlGroup2, SWT.NONE);
		txtExistence.setText("0");
		txtExistence.setBounds(151, 15, 30, 20);
		txtExistence.setEditable(false);

		Label lblInfo1 =  new Label(controlGroup2, SWT.NONE);
		lblInfo1.setText(", after applying");
		lblInfo1.setBounds(200, 15, 150, 20);

		Text txtExistenceRule =  new Text(controlGroup2, SWT.NONE);
		txtExistenceRule.setText("0");
		txtExistenceRule.setBounds(310, 15, 30, 20);
		txtExistenceRule.setEditable(false);

		Label lblInfoRule =  new Label(controlGroup2, SWT.NONE);
		lblInfoRule.setText("rules.");
		lblInfoRule.setBounds(350, 15, 150, 20);

		Label lblComposite =  new Label(controlGroup2, SWT.NONE);
		lblComposite.setText("Wrong composition:");
		lblComposite.setBounds(15, 60, 150, 20);

		Text txtComposition =  new Text(controlGroup2, SWT.NONE);
		txtComposition.setText("0");
		txtComposition.setBounds(151, 60, 30, 20);
		txtComposition.setEditable(false);

		Label lblInfo2 =  new Label(controlGroup2, SWT.NONE);
		lblInfo2.setText(", after applying");
		lblInfo2.setBounds(200, 60, 150, 20);

		Text txtCompositionRule =  new Text(controlGroup2, SWT.NONE);
		txtCompositionRule.setText("0");
		txtCompositionRule.setBounds(310, 60, 30, 20);
		txtCompositionRule.setEditable(false);

		Label lblInfoRule2 =  new Label(controlGroup2, SWT.NONE);
		lblInfoRule2.setText("rules.");
		lblInfoRule2.setBounds(350, 60, 150, 20);

		Label lblAccess =  new Label(controlGroup2, SWT.NONE);
		lblAccess.setText("Lack of relations:");
		lblAccess.setBounds(15, 105, 150, 20);

		Text txtAccess =  new Text(controlGroup2, SWT.NONE);
		txtAccess.setText("0");
		txtAccess.setBounds(151, 105, 30, 20);
		txtAccess.setEditable(false);

		Label lblInfo3 =  new Label(controlGroup2, SWT.NONE);
		lblInfo3.setText(", after applying");
		lblInfo3.setBounds(200, 105, 150, 20);

		Text txtAccessRule =  new Text(controlGroup2, SWT.NONE);
		txtAccessRule.setText("0");
		txtAccessRule.setBounds(310, 105, 30, 20);
		txtAccessRule.setEditable(false);

		Label lblInfoRule3 =  new Label(controlGroup2, SWT.NONE);
		lblInfoRule3.setText("rules.");
		lblInfoRule3.setBounds(350, 105, 150, 20);

		Label lblDrifts1 =  new Label(controlGroup2, SWT.NONE);
		lblDrifts1.setText("Untested abstractions");
		lblDrifts1.setBounds(50, 145, 150, 20);

		Text txtDrifts1 =  new Text(controlGroup2, SWT.NONE);
		txtDrifts1.setText("0");
		txtDrifts1.setBounds(110, 175, 30, 20);
		txtDrifts1.setEditable(false);

		Label lblDrifts2 =  new Label(controlGroup2, SWT.NONE);
		lblDrifts2.setText("Untested relations");
		lblDrifts2.setBounds(300, 145, 150, 20);

		Text txtDrifts2 =  new Text(controlGroup2, SWT.NONE);
		txtDrifts2.setText("0");
		txtDrifts2.setBounds(350, 175, 30, 20);
		txtDrifts2.setEditable(false);

		Button checkConstraint = new Button(controlGroup2, SWT.NONE);
		checkConstraint.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		checkConstraint.setBounds(10, 200, 60, 25);
		checkConstraint.setText("Check");


		Group controlGroup3 = new Group(group, SWT.NONE);
		controlGroup3.setText("Identified Architectural Anomalies");
		controlGroup3.setBounds(10, 480, 450,260);
		controlGroup3.setLayout(new GridLayout());

		final GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		layoutData.minimumWidth = 300;
		GridTableViewer gridTableViewer = new GridTableViewer(controlGroup3, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.WRAP);
		gridTableViewer.setUseHashlookup(true);
		gridTableViewer.getGrid().setLinesVisible(true);
		gridTableViewer.getGrid().setHeaderVisible(true);
		gridTableViewer.getGrid().setVisibleLinesColumnPack(true);
		gridTableViewer.getGrid().setLayoutData(layoutData);

		GridColumn column1 = new GridColumn(gridTableViewer.getGrid(), SWT.NONE);
		column1.setResizeable(true);
		column1.setWidth(215);
		column1.setText("Rule");

		GridColumn column2 = new GridColumn(gridTableViewer.getGrid(), SWT.NONE);
		column2.setResizeable(false);
		column2.setWidth(235);
		column2.setWordWrap(true);
		column2.setText("Name");

		gridTableViewer.setContentProvider(new ArrayContentProvider());
		gridTableViewer.setLabelProvider(new TableLabelAnomalyMappedProvider());

		Button generateRecommendation = new Button(controlGroup3, SWT.NONE);
		generateRecommendation.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		generateRecommendation.setBounds(10, 400, 120, 25);
		generateRecommendation.setText("Refactoring Recommendation");

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject project  = root.getProject(projectName);
		IFile kdmCurrent = project.getFile(projectName + "_KDM.xmi");
		IFile kdmPlanned = project.getFile("PlannedArchitecture/src-gen/PlannedArchitecture.xmi");

		IFile iUmlCurrent = project.getFile("CurrentArchitecture/currentArchitecture.uml");
		IFile iUmlPlanned = project.getFile("PlannedArchitecture/src-gen/plannedArchitecture.uml");


		IFile constraintPath = project.getFile("PlannedArchitecture/src-gen/Constraints.ocl");

		String folder = workspace.getRoot().getLocation().toFile().getPath().toString();
		String umlCurrent =  folder + "/" + projectName + "/CurrentArchitecture/currentArchitecture.uml";
		String umlPlanned = folder + "/" + projectName + "/PlannedArchitecture/src-gen/plannedArchitecture.uml" ; 
		String plannedArchitecture = folder + "/" + projectName + "/PlannedArchitecture/src-gen/ComponentDiagram.txt" ; 

		String umlFolderPlannedRelative = "/" + projectName + "/PlannedArchitecture/src-gen/" ;
		String umlFolderPlannedAbsolute = folder + "/" + projectName + "/PlannedArchitecture/src-gen/" ;
		String umlFolderCurrentAbsolute = folder +  "/" + projectName + "/CurrentArchitecture/";
		String umlFolderCurrentRelative =  "/" + projectName + "/CurrentArchitecture/";

		String mappingString = folder + "/"+projectName + "/CurrentArchitecture/mapping.txt";
		String workspacePath = folder + "/";
		String projectWorkspace = folder + "/" + projectName + "/";

		generateReport.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				try {
					dialog.run(true, true, new IRunnableWithProgress() {
						public void run(IProgressMonitor monitor) {
							int totalUnitsOfWork = IProgressMonitor.UNKNOWN;
							monitor.beginTask("Creating architectural report....", totalUnitsOfWork);
							Report report = new Report();
							DataConstraint dataConstraint = null;
							try {
								dataConstraint = new DataConstraint(databaseUrl);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							try {
								report.create(workspacePath + projectName + "/", projectName, umlFolderCurrentAbsolute, umlFolderPlannedAbsolute, dataConstraint);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							monitor.done();
							try {refreshProjects();}catch (CoreException e) {e.printStackTrace();} 
						}});
					MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Information", "The report was generated in the root of the project.");
				} catch (InvocationTargetException  | InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});

		generateRecommendation.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {

				try {
					dialog.run(true, true, new IRunnableWithProgress() {

						public void run(IProgressMonitor monitor) {
							int totalUnitsOfWork = IProgressMonitor.UNKNOWN;
							monitor.beginTask("Generation architectural refactorings recommendation....", totalUnitsOfWork);
							RefactoringRecommendation recomendation = new RefactoringRecommendation();
							try {
								recomendation.generateRecommendation(kdmCurrent, databaseUrl,projectWorkspace);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							monitor.done();
							try {refreshProjects();}catch (CoreException e) {e.printStackTrace();} 
						}});
				} catch (InvocationTargetException  | InterruptedException e1) {
					e1.printStackTrace();
				}
				MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Information", "The refactoring recommendations were generated in the 'Recommendations' folder");

			}
		});

		checkConstraint.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {

				CheckConstraint checkConstraintMethod = new CheckConstraint(workspacePath, projectName);
				List<MappedAnomaly> anomalyObject = new ArrayList<MappedAnomaly>();

				if (constraintPath.exists() && kdmCurrent.exists()) {

					try {
						dialog.run(true, true, new IRunnableWithProgress() {
							public void run(IProgressMonitor monitor) {
								int totalUnitsOfWork = IProgressMonitor.UNKNOWN;
								monitor.beginTask("Verifying constraints....", totalUnitsOfWork);

								try {
									checkConstraintMethod.checkConstraint(kdmCurrent, constraintPath);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								try {
									checkConstraintMethod.checkDrifts(kdmCurrent, kdmPlanned);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								try {
									DataConstraint queryClass = new DataConstraint(databaseUrl);
									List<String> lstAnomaly= queryClass.getAnomaliesIdentified();
									for (String anomaly :lstAnomaly )
										anomalyObject.add(new MappedAnomaly(anomaly.split(Pattern.quote("|"))[0], anomaly.split(Pattern.quote("|"))[1]));
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								monitor.done();
							}});
					} catch (InvocationTargetException  | InterruptedException e1) {
						e1.printStackTrace();
					}
					try {
						final List<Integer> lstValues = checkConstraintMethod.getExistenceAbstractions();
						txtExistence.setText(lstValues.get(0).toString());
						txtExistenceRule.setText(lstValues.get(1).toString());
					} catch (Exception e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					try {
						final List<Integer> lstValues = checkConstraintMethod.getCompositeAbstractions();
						txtComposition.setText(lstValues.get(0).toString());
						txtCompositionRule.setText(lstValues.get(1).toString());
					} catch (Exception e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					try {
						final List<Integer> lstValues = checkConstraintMethod.getAccessAbstractions();
						txtAccess.setText(lstValues.get(0).toString());
						txtAccessRule.setText(lstValues.get(1).toString());
					} catch (Exception e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					try {
						final List<Integer> lstValues = checkConstraintMethod.getUntestedValues();
						int value = lstValues.get(0) + lstValues.get(1);
						txtDrifts1.setText(String.valueOf(value));
						txtDrifts2.setText(lstValues.get(2).toString());
					} catch (Exception e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					gridTableViewer.setInput(anomalyObject);
					MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Information", "The model was checked against ocl restrictions.");
				}
				else {
					MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Information", "Please verify whether .ocl and current architecture files exist.");
				}
			}
		});


		btnFCA.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {

				if (radios[0].getSelection())
				{
					if(kdmCurrent.exists())
					{

						String title = "This is the current architecture of project: " + projectName;
						try {
							dialog.run(true, true, new IRunnableWithProgress() {
								public void run(IProgressMonitor monitor) {
									// Creates KDM instance
									int totalUnitsOfWork = IProgressMonitor.UNKNOWN;
									monitor.beginTask("Component Diagram of Current Architecture....", totalUnitsOfWork);
									try 
									{
										AdaptiveSystemUMLProfile umlProfile = new AdaptiveSystemUMLProfile();
										try {
											umlProfile.createProfile(umlFolderCurrentAbsolute);
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}

										Kdm2Uml rc = new Kdm2Uml();
										Uml2PlantUML up = new Uml2PlantUML();
										up.createPlantComponentDiagram(rc.createComponentDiagram(kdmCurrent, umlCurrent, projectName, mappingString), umlFolderCurrentAbsolute, projectName, mappingString, title);
										refreshProjects();
									} catch (ExecutionException e1) {e1.printStackTrace();} catch (CoreException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									monitor.done();
								}
							});
							OpenComponentDiagram od = new OpenComponentDiagram();
							od.open(umlFolderCurrentRelative + "ComponentDiagram.txt", projectName);
						} catch (InvocationTargetException | InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else 
						MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Current Architecture", "The file " + projectName + "_KDM.xmi" + " does not exist! ");

				}
				else
				{
					if (radios[1].getSelection()) {

						String title = "This is the planned architecture of project: " + projectName;
						try {
							dialog.run(true, true, new IRunnableWithProgress() {
								public void run(IProgressMonitor monitor) {
									// Creates KDM instance
									int totalUnitsOfWork = IProgressMonitor.UNKNOWN;
									monitor.beginTask("Component Diagram of Planned Architecture....", totalUnitsOfWork);
									try 
									{
										AdaptiveSystemUMLProfile umlProfile = new AdaptiveSystemUMLProfile();
										try {
											umlProfile.createProfile(umlFolderCurrentAbsolute);
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										Kdm2Uml rc = new Kdm2Uml();
										Uml2PlantUML up = new Uml2PlantUML();
										up.createPlantComponentDiagram(rc.createComponentDiagram(kdmPlanned, umlPlanned, "", mappingString), umlFolderPlannedAbsolute, projectName,mappingString, title );
										refreshProjects();
									} catch (ExecutionException e1) {e1.printStackTrace();} catch (CoreException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									monitor.done();
								}
							});
							OpenComponentDiagram od = new OpenComponentDiagram();
							od.open(umlFolderPlannedRelative + "ComponentDiagram.txt", projectName);
						} catch (InvocationTargetException | InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
					else
					{
						if (radios[2].getSelection()) {
							if (Files.exists(Paths.get(umlCurrent)) && Files.exists(Paths.get(umlPlanned)))
							{
								try {
									dialog.run(true, true, new IRunnableWithProgress() {
										public void run(IProgressMonitor monitor) {
											// Creates KDM instance
											int totalUnitsOfWork = IProgressMonitor.UNKNOWN;
											monitor.beginTask("Computing differences....", totalUnitsOfWork);
											ComputeModelDiff computeModelDiff = new ComputeModelDiff();
											computeModelDiff.compute(iUmlCurrent, iUmlPlanned, plannedArchitecture, umlFolderCurrentAbsolute);
											try {
												refreshProjects();
											} catch (CoreException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											monitor.done();
										}
									});
									OpenComponentDiagram od = new OpenComponentDiagram();
									od.open(umlFolderCurrentRelative + "differences.txt", projectName);
								} catch (InvocationTargetException | InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							else
								MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Information", "Current or planned diagram does not exist! ");

						}
					}
				}
			}
		});

		tab1.setControl(group);
	}

	public void moveFile(String in, String out) {

		InputStream inStream = null;
		OutputStream outStream = null;

		try {

			File afile = new File(in);
			File bfile = new File(out);

			inStream = new FileInputStream(afile);
			outStream = new FileOutputStream(bfile);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = inStream.read(buffer)) > 0) {

				outStream.write(buffer, 0, length);

			}

			inStream.close();
			outStream.close();

			// delete the original file
			afile.delete();

			System.out.println("File is copied successful!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void refreshProjects() throws CoreException {
		for (IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		}
	}

	public IPath createRefactoredJavaProject(String projectName) throws CoreException {

		// create a simple project of type org.eclipse.core.resources.IProject:
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		String newProjectName = projectName + "_Refactored";
		IProject project = root.getProject(newProjectName);
		project.create(null);
		project.open(null);
		IPath path = project.getLocation();
		// set the Java nature to the created project:
		IProjectDescription description = project.getDescription();
		description.setNatureIds(new String[] { JavaCore.NATURE_ID });
		project.setDescription(description, null);
		// create our Java project
		IJavaProject javaProject = JavaCore.create(project);
		IFolder binFolder = project.getFolder("bin");
		binFolder.create(false, true, null);
		javaProject.setOutputLocation(binFolder.getFullPath(), null);
		// set the Java build path
		List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
		IVMInstall vmInstall = JavaRuntime.getDefaultVMInstall();
		LibraryLocation[] locations = JavaRuntime.getLibraryLocations(vmInstall);
		for (LibraryLocation element : locations) {
			entries.add(JavaCore.newLibraryEntry(element.getSystemLibraryPath(), null, null));
		}
		// add libs to project class path
		javaProject.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), null);

		// source folder created:
		IFolder sourceFolder = project.getFolder("src");
		sourceFolder.create(false, true, null);
		// the created source folder should be added to the class entries of the
		// project,
		IPackageFragmentRoot _root = javaProject.getPackageFragmentRoot(sourceFolder);
		IClasspathEntry[] oldEntries = javaProject.getRawClasspath();
		IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 1];
		System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
		newEntries[oldEntries.length] = JavaCore.newSourceEntry(_root.getPath());
		javaProject.setRawClasspath(newEntries, null);

		return path;
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

	@Override
	public void partActivated(IWorkbenchPartReference arg0) {

		arrData.clear();

		// TODO Auto-generated method stub
		if (arg0 instanceof IEditorReference) {
			IEditorReference editor = (IEditorReference) arg0;

			IEditorInput input = null;
			try {
				input = editor.getEditorInput();
			} catch (PartInitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			IPath path = ((IFileEditorInput) input).getFile().getFullPath();
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IWorkspaceRoot root = workspace.getRoot();
			IResource resource = root.findMember(path);

			try 
			{	
				QueryClass queryClass = new QueryClass(databaseUrl);
				rs = queryClass.selectInstance(2);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


			if (resource != null) {
				if (resource.getLocation().toOSString().split("\\.")[1].equals("java")) {

					//Package Name
					CriptoBase64 criptoBase64 = new CriptoBase64();
					String pathCode = criptoBase64.codeBase64Path(resource.getLocation().toOSString().split("\\.")[0]);
					String packageName = resource.getLocation().toOSString().split("\\/src/")[1];
					String realPackages[] = packageName.split("\\/");
					String realPackage = "";
					for (int p=0; p<realPackages.length-1; p++)
						realPackage = realPackage + "." + realPackages[p];

					realPackage = realPackage.substring(1);

					QueryClass queryClass;
					List <String> lstAnnotation = new ArrayList<String>();
					try {

						queryClass = new QueryClass(databaseUrl);
						String projectName = MainView.getDatabaseUrl().split("\\/")[MainView.getDatabaseUrl().split("\\/").length-1];
						String realPath = criptoBase64.decodeBase64Path(pathCode);
						lstAnnotation = queryClass.selectAnnotationPackage(projectName, realPackage, realPath);

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					if (lstAnnotation.isEmpty())
						arrData.add(new Data("Package", realPackage, pathCode,  rs.get(0), "", "", rs.get(0)));
					else
						arrData.add(new Data("Package", realPackage, pathCode,  lstAnnotation.get(0).split(Pattern.quote("|"))[0], "", "", lstAnnotation.get(0).split(Pattern.quote("|"))[1]));

					// Class Name
					String strPath[] = resource.getLocation().toOSString().split("\\/");
					String className = strPath[strPath.length - 1].split("\\.")[0];
					criptoBase64 = new CriptoBase64();
					pathCode = criptoBase64.codeBase64Path(resource.getLocation().toOSString().split("\\.")[0]);

					try {

						queryClass = new QueryClass(databaseUrl);
						String projectName = MainView.getDatabaseUrl().split("\\/")[MainView.getDatabaseUrl().split("\\/").length-1];
						String realPath = criptoBase64.decodeBase64Path(pathCode);
						lstAnnotation = queryClass.selectAnnotationClass(projectName, className, realPath);

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					if (lstAnnotation.isEmpty())
						arrData.add(new Data("Class Name", className, pathCode,  rs.get(0), realPackage, "", rs.get(0)));
					else
						arrData.add(new Data("Class Name", className, pathCode,  lstAnnotation.get(0).split(Pattern.quote("|"))[0], realPackage, "", lstAnnotation.get(0).split(Pattern.quote("|"))[1]));

					// Class fields
					try 
					{
						NodeList<VariableDeclarator> nl = this.classField(new File(resource.getLocation().toOSString()));
						queryClass = new QueryClass(databaseUrl);
						String projectName = MainView.getDatabaseUrl().split("\\/")[MainView.getDatabaseUrl().split("\\/").length-1];
						String realPath = criptoBase64.decodeBase64Path(pathCode);

						for (int j = 0; j < nl.size(); j++)
						{
							lstAnnotation = queryClass.selectAnnotationFieldClass(projectName, className, nl.get(j).getNameAsString().toString(), realPath);
							if (lstAnnotation.isEmpty())
								arrData.add(new Data("Field Class", nl.get(j).getNameAsString().toString(),  pathCode, rs.get(0), className, "", rs.get(0)));
							else
								arrData.add(new Data("Field Class", nl.get(j).getNameAsString().toString(),  pathCode,  lstAnnotation.get(0).split(Pattern.quote("|"))[0], className, "", lstAnnotation.get(0).split(Pattern.quote("|"))[1]));
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// methods and variables
					try {
						List<String> nl = this.methodAndVariables(new File(resource.getLocation().toOSString()));
						queryClass = new QueryClass(databaseUrl);
						String projectName = MainView.getDatabaseUrl().split("\\/")[MainView.getDatabaseUrl().split("\\/").length-1];
						String realPath = criptoBase64.decodeBase64Path(pathCode);

						for (int j = 0; j < nl.size(); j++) {
							if (nl.get(j).toString().contains("|")) {
								String mv[] = nl.get(j).toString().split("\\|");
								lstAnnotation = queryClass.selectAnnotationMethod(projectName, className, mv[0], realPath);
								if (lstAnnotation.isEmpty())
									arrData.add(new Data("Method", mv[0],  pathCode, rs.get(0), className, "", rs.get(0)));
								else
									arrData.add(new Data("Method", mv[0],  pathCode, lstAnnotation.get(0).split(Pattern.quote("|"))[0], className, "", lstAnnotation.get(0).split(Pattern.quote("|"))[1]));

								for (int k = 1; k < mv.length; k++)
								{
									pathCode = criptoBase64.codeBase64Path(resource.getLocation().toOSString().split("\\.")[0]);
									lstAnnotation = queryClass.selectAnnotationVariable(projectName, className, mv[0], mv[k], realPath);
									if (lstAnnotation.isEmpty())
										arrData.add(new Data("Variable", mv[k], pathCode, rs.get(0), className, mv[0], rs.get(0)));
									else
										arrData.add(new Data("Variable", mv[k], pathCode, lstAnnotation.get(0).split(Pattern.quote("|"))[0], className, mv[0], lstAnnotation.get(0).split(Pattern.quote("|"))[1]));
								}
							} 
							else
							{
								lstAnnotation = queryClass.selectAnnotationMethod(projectName, className, nl.get(j).toString(), realPath);
								if (lstAnnotation.isEmpty())
									arrData.add(new Data("Method", nl.get(j).toString(),  pathCode, rs.get(0), className,"",rs.get(0)));
								else
									arrData.add(new Data("Method", nl.get(j).toString(),  pathCode, lstAnnotation.get(0).split(Pattern.quote("|"))[0], className, "", lstAnnotation.get(0).split(Pattern.quote("|"))[1]));
							}
						}

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					viewer.setInput(arrData);
				}
			}
		}
	}

	private NodeList<VariableDeclarator> classField(File file) throws FileNotFoundException {

		NodeList<VariableDeclarator> nl = new NodeList<VariableDeclarator>();
		CompilationUnit cu = JavaParser.parse(file);
		FieldClassVisitor fdc = new FieldClassVisitor();
		List<FieldDeclaration> listFd = fdc.getFieldClasses(cu);
		for (int i = 0; i < listFd.size(); i++)
			nl.addAll(listFd.get(i).getVariables());
		return nl;
	}

	private List<String> methodAndVariables(File file) throws FileNotFoundException {
		// Methods and variables
		List<String> methodAndVariables = new ArrayList<String>();
		String str = "";
		MethodVisitor md = new MethodVisitor();
		CompilationUnit cu = JavaParser.parse(file);
		List<MethodDeclaration> listMd = md.getMethodClasses(cu);
		for (int i = 0; i < listMd.size(); i++) {
			String methodName = listMd.get(i).getName().toString();
			VariableVisitor vv = new VariableVisitor();
			List<VariableDeclarator> listVD = vv.getVariableExpr(listMd.get(i));
			for (int j = 0; j < listVD.size(); j++) {
				String variable = listVD.get(j).getNameAsString().toString();
				str = str + "|" + variable;
			}
			methodAndVariables.add(methodName + str);
			str = "";
		}
		return methodAndVariables;
	}

	@Override
	public void partBroughtToTop(IWorkbenchPartReference arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void partClosed(IWorkbenchPartReference arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void partDeactivated(IWorkbenchPartReference arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void partHidden(IWorkbenchPartReference arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void partInputChanged(IWorkbenchPartReference arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void partOpened(IWorkbenchPartReference arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void partVisible(IWorkbenchPartReference arg0) {
		// TODO Auto-generated method stub

	}

	public static String getDatabaseUrl() {
		return databaseUrl;
	}

	private String searchForChild(String parent) throws Exception
	{
		QueryClass queryClass = new QueryClass(databaseUrl);
		List<String> instances = queryClass.selectInstance(1);
		for (String instance: instances)
			if (instance.split(Pattern.quote("|"))[0].equals(parent))
				return instance.split(Pattern.quote("|"))[1];

		return null;
	}
}
