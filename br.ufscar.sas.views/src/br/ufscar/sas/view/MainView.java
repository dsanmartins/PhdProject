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
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.nebula.jface.gridviewer.GridTableViewer;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.experimental.chart.swt.ChartComposite;
import org.jfree.util.Rotation;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;

import br.ufscar.sas.checkconstraint.CheckConstraint;
import br.ufscar.sas.createKDM.CreateKDM;
import br.ufscar.sas.cripto.CriptoBase64;
import br.ufscar.sas.database.QueryClass;
import br.ufscar.sas.dataconstraint.DataConstraint;
import br.ufscar.sas.parser.ConstructorVisitor;
import br.ufscar.sas.parser.FieldClassVisitor;
import br.ufscar.sas.parser.MethodVisitor;
import br.ufscar.sas.parser.VariableVisitor;
import br.ufscar.sas.recommendation.RefactoringRecommendation;
import br.ufscar.sas.report.Report;
import br.ufscar.sas.tableviewer.ColumnLabelProviderFifth;
import br.ufscar.sas.tableviewer.ColumnLabelProviderFirst;
import br.ufscar.sas.tableviewer.ColumnLabelProviderFourth;
import br.ufscar.sas.tableviewer.ColumnLabelProviderSecond;
import br.ufscar.sas.tableviewer.ColumnLabelProviderThird;
import br.ufscar.sas.tableviewer.Data;
import br.ufscar.sas.tableviewer.EditingAnnotationInstance;
import br.ufscar.sas.tableviewer.EditingRulesInstance;
import br.ufscar.sas.tableviewer.TableLabelProvider;
import br.ufscar.sas.tableviewer.TableMetaData;
import br.ufscar.sas.tableviewer.abstractions.Abstraction;
import br.ufscar.sas.tableviewer.abstractions.EditingAbstractionQuantityInstance;
import br.ufscar.sas.tableviewer.abstractions.TableLabelAbstractionProvider;
import br.ufscar.sas.tableviewer.instances.ColumnLabelProviderCheckbox;
import br.ufscar.sas.tableviewer.instances.ColumnLabelProviderInstance;
import br.ufscar.sas.tableviewer.instances.EditingInstanceCheck;
import br.ufscar.sas.tableviewer.instances.EditingInstanceName;
import br.ufscar.sas.tableviewer.instances.Instance;
import br.ufscar.sas.tableviewer.instances.InstanceFilter;
import br.ufscar.sas.tableviewer.result.MappedAnomaly;
import br.ufscar.sas.tableviewer.result.TableLabelAnomalyMappedProvider;
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
	//
	TableViewer viewerRules;
	// Data
	ArrayList<Data> arrData = new ArrayList<Data>();
	//Database Path
	static String databaseUrl = "";
	//Resultset
	List<String> rs = null;

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
				List<String> lstDomainRules = queryClass.getDomainRules();
				if (lstDomainRules.size() == 0)
					queryClass.populateDomainRules();

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
		TabFolder tabFolder = new TabFolder(parent, SWT.NONE );
		GridData gd_tabFolder = new GridData(SWT.LEFT,  SWT.CENTER, false, false, 1, 1);
		gd_tabFolder.widthHint = 1390;
		gd_tabFolder.heightHint = 850;
		tabFolder.setLayoutData(gd_tabFolder);

		// Tab1
		this.UIAbstractionMaintainer(tabFolder, projectName);
		// Tab2
		this.UIAnnotation(tabFolder, projectName);
		//Tab3
		this.UIControPanel(tabFolder, projectName);
		// Tab4
		// this.UIArchitecturalRefactoring(tabFolder, projectName);
		// Tab5
		// this.UICodeGenerator(tabFolder, projectName);
		// Tab6
		this.UIDomainRules(tabFolder, projectName);

		tabFolder.setSelection(1);
	}

	private void UIAbstractionMaintainer(TabFolder tabFolder, String projectName)
	{	
		TabItem tab1 = new TabItem(tabFolder, SWT.NONE);
		tab1.setText("Configurations");

		Group group = new Group(tabFolder, SWT.NONE);
		Group abstractionGroup = new Group(group, SWT.NONE | SWT.V_SCROLL | SWT.H_SCROLL);
		abstractionGroup.setText("Adaptive System Abstractions and Instances");
		abstractionGroup.setBounds(10, 55, 500, 510);
		abstractionGroup.setLayout(new FillLayout());
		tab1.setControl(group);

		Group controlGroup = new Group(group, SWT.NONE);
		controlGroup.setText("Control");
		controlGroup.setBounds(10, 0, 500, 50);

		Label label1 = new Label(controlGroup, SWT.NONE);
		label1.setText("Project Name: " + projectName);
		label1.setBounds(15, 3, 300, 20);

		//Abstractions Table
		TableViewer tableAbstraction = new TableViewer(abstractionGroup, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.WRAP |  SWT.FULL_SELECTION);
		tableAbstraction.setUseHashlookup(true);
		tableAbstraction.getTable().setLinesVisible(true);
		tableAbstraction.getTable().setHeaderVisible(true);
		tableAbstraction.getTable().setBounds(0, 0, 250, 450);

		TableViewerColumn abstractionName = new TableViewerColumn(tableAbstraction, SWT.NONE);
		abstractionName.getColumn().setResizable(false);
		abstractionName.getColumn().setWidth(150);
		abstractionName.getColumn().setText("Abstraction");

		TableViewerColumn quantity = new TableViewerColumn(tableAbstraction, SWT.CENTER);
		quantity.getColumn().setResizable(false);
		quantity.getColumn().setWidth(100);
		quantity.getColumn().setText("Quantity");
		quantity.setEditingSupport(new EditingAbstractionQuantityInstance(tableAbstraction));

		tableAbstraction.setContentProvider(new ArrayContentProvider());
		tableAbstraction.setLabelProvider(new TableLabelAbstractionProvider());

		QueryClass queryClass = null;
		List<Abstraction> abstractionObject = new ArrayList<Abstraction>();

		try {
			queryClass = new QueryClass(databaseUrl);
			List<String> lstAbstraction= queryClass.getAbstractions();
			for (String abstraction :lstAbstraction )
				abstractionObject.add(new Abstraction(Integer.valueOf(abstraction.split(Pattern.quote("|"))[0]), 
						abstraction.split(Pattern.quote("|"))[1], 
						abstraction.split(Pattern.quote("|"))[2],
						abstraction.split(Pattern.quote("|"))[3]));

			tableAbstraction.setInput(abstractionObject);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Instances Table
		TableViewer tableInstance = new TableViewer(abstractionGroup, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.WRAP |  SWT.FULL_SELECTION);
		tableInstance.setUseHashlookup(true);
		tableInstance.getTable().setLinesVisible(true);
		tableInstance.getTable().setHeaderVisible(true);
		tableInstance.getTable().setBounds(255, 0, 245, 450);

		TableViewerColumn instanceName = new TableViewerColumn(tableInstance, SWT.NONE);
		instanceName.getColumn().setResizable(false);
		instanceName.getColumn().setWidth(150);
		instanceName.getColumn().setText("Instance");
		instanceName.setLabelProvider(new ColumnLabelProviderInstance());
		instanceName.setEditingSupport(new EditingInstanceName(tableInstance));

		TableViewerColumn check = new TableViewerColumn(tableInstance, SWT.CENTER);
		check.getColumn().setResizable(false);
		check.getColumn().setWidth(150);
		check.getColumn().setText("");
		check.setLabelProvider(new ColumnLabelProviderCheckbox());
		check.setEditingSupport(new EditingInstanceCheck(tableInstance));

		tableInstance.setContentProvider(new ArrayContentProvider());

		List<Instance> instanceObject = new ArrayList<Instance>();

		try {
			queryClass = new QueryClass(databaseUrl);
			List<String> lstInstance= queryClass.selectInstance(0);
			for (String instance :lstInstance )
				instanceObject.add(new Instance(Integer.valueOf(instance.split(Pattern.quote("|"))[0]),instance.split(Pattern.quote("|"))[1] , false));

			tableInstance.setInput(instanceObject);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Button generateInstances = new Button(abstractionGroup, SWT.NONE);
		generateInstances.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		generateInstances.setBounds(5, 460, 80, 25);
		generateInstances.setText("Generate");

		generateInstances.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {

				try {
					QueryClass queryClass = new QueryClass(databaseUrl);
					List<String> lstAbstraction = queryClass.getAbstractions();
					for (int i=0 ; i<lstAbstraction.size(); i++) {
						String abstraction = lstAbstraction.get(i).split(Pattern.quote("|"))[1];
						int quantity = Integer.valueOf(lstAbstraction.get(i).split(Pattern.quote("|"))[3]);
						int numberOfInstance = queryClass.getQuantityAbstraction(abstraction.toLowerCase());
						if (quantity > numberOfInstance) {

							int max = queryClass.getMaxValueInstance(abstraction.toLowerCase());
							for (int j=0; j<quantity-numberOfInstance; j++)
							{
								max = max + 1;
								String instance = abstraction.toLowerCase() + "_" + max;
								queryClass.insertInstance(abstraction, instance);
							}
						}
					}

					instanceObject.clear();
					List<String> lstInstance= queryClass.selectInstance(0);
					for (String instance :lstInstance )
						instanceObject.add(new Instance(Integer.valueOf(instance.split(Pattern.quote("|"))[0]),instance.split(Pattern.quote("|"))[1] , false));

					tableInstance.setInput(instanceObject);
					tableInstance.refresh();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		Button clearInstances = new Button(abstractionGroup, SWT.NONE);
		clearInstances.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		clearInstances.setBounds(165, 460, 80, 25);
		clearInstances.setText("Clear");

		clearInstances.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {

				boolean b = MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Information", "Do you want to delete all instances?");
				if (b) {
					try {
						QueryClass queryClass = new QueryClass(databaseUrl);
						queryClass.deleteInstance();
						abstractionObject.clear();
						List<String> lstAbstraction= queryClass.getAbstractions();
						for (String abstraction :lstAbstraction )
							abstractionObject.add(new Abstraction(Integer.valueOf(abstraction.split(Pattern.quote("|"))[0]),
									abstraction.split(Pattern.quote("|"))[1], 
									abstraction.split(Pattern.quote("|"))[2],
									abstraction.split(Pattern.quote("|"))[3]));

						tableAbstraction.setInput(abstractionObject);
						tableAbstraction.refresh();

						instanceObject.clear();
						List<String> lstInstance= queryClass.selectInstance(0);
						for (String instance :lstInstance )
							instanceObject.add(new Instance(Integer.valueOf(instance.split(Pattern.quote("|"))[0]),instance.split(Pattern.quote("|"))[1] , false));

						tableInstance.setInput(instanceObject);
						tableInstance.refresh();

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		Button removeInstances = new Button(abstractionGroup, SWT.NONE);
		removeInstances.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		removeInstances.setBounds(255, 460, 80, 25);
		removeInstances.setText("Remove");
		removeInstances.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {

				List<Instance> lstInstance = (List<Instance>) tableInstance.getInput();
				for (Instance instance : lstInstance)
				{
					if (instance.getIsSelected()) {

						try {
							QueryClass queryClass = new QueryClass(databaseUrl);
							queryClass.deleteInstance(instance.getInstance(), instance.getAbstractionID());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}

				try {
					QueryClass queryClass = new QueryClass(databaseUrl);
					abstractionObject.clear();
					List<String> lstAbstraction= queryClass.getAbstractions();
					for (String abstraction :lstAbstraction )
						abstractionObject.add(new Abstraction(Integer.valueOf(abstraction.split(Pattern.quote("|"))[0]),
								abstraction.split(Pattern.quote("|"))[1], 
								abstraction.split(Pattern.quote("|"))[2],
								abstraction.split(Pattern.quote("|"))[3]));
					
					tableAbstraction.setInput(abstractionObject);
					tableAbstraction.refresh();

					instanceObject.clear();
					List<String> lstInst= queryClass.selectInstance(0);
					for (String instance :lstInst )
						instanceObject.add(new Instance(Integer.valueOf(instance.split(Pattern.quote("|"))[0]),instance.split(Pattern.quote("|"))[1] , false));

					tableInstance.setInput(instanceObject);
					tableInstance.refresh();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		InstanceFilter instanceFilter = new InstanceFilter();

		Button clearFilter = new Button(abstractionGroup, SWT.NONE);
		clearFilter.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		clearFilter.setBounds(415, 460, 80, 25);
		clearFilter.setText("Unfilter");
		clearFilter.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {

				tableInstance.removeFilter(instanceFilter);
				tableInstance.refresh();
				
			}
		});

		
		
		tableAbstraction.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {

				IStructuredSelection selection = (IStructuredSelection)event.getSelection();
				if (!selection.isEmpty()) {
					Object element = selection.getFirstElement();
					if (element instanceof Abstraction) {
						tableInstance.setFilters(instanceFilter);
						Abstraction abstraction = (Abstraction) element;
						instanceFilter.setInstanceFilter(abstraction.getId());
						tableInstance.refresh();
					}
				}
			}
		});


		//Drifts 

		/*
		 * Group tableViewGroup = new Group(group, SWT.NONE);
		 * tableViewGroup.setText("Architectural Drifts"); tableViewGroup.setBounds(10,
		 * 520, 500, 300); tableViewGroup.setLayout(new FillLayout());
		 * tab1.setControl(group);
		 * 
		 * GridTableViewer gridTableViewer = new GridTableViewer(tableViewGroup,
		 * SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.WRAP);
		 * gridTableViewer.setUseHashlookup(true);
		 * gridTableViewer.getGrid().setLinesVisible(true);
		 * gridTableViewer.getGrid().setHeaderVisible(true);
		 * gridTableViewer.getGrid().setVisibleLinesColumnPack(true);
		 * gridTableViewer.getGrid().setBounds(0, 0, 500, 300);
		 * 
		 * GridColumn column1 = new GridColumn(gridTableViewer.getGrid(), SWT.NONE);
		 * column1.setResizeable(false); column1.setWidth(75); column1.setText("Drift");
		 * 
		 * GridColumn column2 = new GridColumn(gridTableViewer.getGrid(), SWT.NONE);
		 * column2.setResizeable(false); column2.setWidth(210); column2.setText("Name");
		 * 
		 * GridColumn column3 = new GridColumn(gridTableViewer.getGrid(), SWT.NONE);
		 * column3.setResizeable(false); column3.setWidth(210);
		 * column3.setWordWrap(true); column3.setText("Description");
		 * 
		 * gridTableViewer.setContentProvider(new ArrayContentProvider());
		 * gridTableViewer.setLabelProvider(new TableLabelAnomalyProvider());
		 * 
		 * DataConstraint dataConstraint = null; List<Anomaly> anomalyObject = new
		 * ArrayList<Anomaly>();
		 * 
		 * try { dataConstraint = new DataConstraint(databaseUrl); List<String>
		 * lstAnomaly= dataConstraint.getAnomalies(); for (String anomaly :lstAnomaly )
		 * anomalyObject.add(new Anomaly(anomaly.split(Pattern.quote("|"))[0],
		 * anomaly.split(Pattern.quote("|"))[1], anomaly.split(Pattern.quote("|"))[2]
		 * ));
		 * 
		 * gridTableViewer.setInput(anomalyObject);
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (Exception e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 * 
		 * GridColumn []cols = gridTableViewer.getGrid().getColumns(); for (GridItem
		 * item : gridTableViewer.getGrid().getItems()) { GC gc = new
		 * GC(item.getDisplay()); int hmax = 80; int max = 0; Point tb=null;
		 * for(GridColumn col : cols){ tb = col.getCellRenderer().computeSize(gc,
		 * col.getWidth(), SWT.DEFAULT, item); max = Math.max(max, tb.y); if(max >
		 * hmax){ break; } }
		 * 
		 * if(hmax==-1){
		 * 
		 * }else if(max > hmax){ max=hmax; }
		 * 
		 * gc.dispose(); item.setHeight(max); }
		 */
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
		table.setBounds(0, 0, 550, 450);

		TableViewerColumn column0 = new TableViewerColumn(viewer, SWT.CENTER);
		column0.getColumn().setText("Element");
		column0.getColumn().setWidth(83);
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
		processAnnotation.setText("Mapping Process");

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

		ScrolledComposite scroller = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		scroller.setExpandVertical(true);
		scroller.setExpandHorizontal(true);

		Composite group = new Composite(scroller, SWT.NONE);
		scroller.setContent(group);
		scroller.setMinSize(group.computeSize(SWT.DEFAULT, SWT.DEFAULT));


		Button generateReport = new Button(group, SWT.NONE);
		generateReport.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		generateReport.setBounds(120, 10, 100, 25);
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
		controlGroup2.setText("Statistics");
		controlGroup2.setBounds(10, 200, 450,340);

		final Color orange = new Color(Display.getCurrent(), 255,0,0);

		Text txtExistence =  new Text(controlGroup2, SWT.NONE);
		txtExistence.setText("0");
		txtExistence.setBounds(10, 15, 30, 20);
		txtExistence.setEditable(false);
		txtExistence.setForeground(orange); 

		Label of1 =  new Label(controlGroup2, SWT.NONE);
		of1.setText("of");
		of1.setBounds(45, 15, 30, 20);

		Text txtExistenceRule =  new Text(controlGroup2, SWT.NONE);
		txtExistenceRule.setText("0");
		txtExistenceRule.setBounds(70, 15, 30, 20);
		txtExistenceRule.setEditable(false);

		Text txtComposition =  new Text(controlGroup2, SWT.NONE);
		txtComposition.setText("0");
		txtComposition.setBounds(10, 45, 30, 20);
		txtComposition.setEditable(false);
		txtComposition.setForeground(orange); 

		Label of2 =  new Label(controlGroup2, SWT.NONE);
		of2.setText("of");
		of2.setBounds(45, 45, 30, 20);

		Text txtCompositionRule =  new Text(controlGroup2, SWT.NONE);
		txtCompositionRule.setText("0");
		txtCompositionRule.setBounds(70, 45, 30, 20);
		txtCompositionRule.setEditable(false);

		Text txtAccess =  new Text(controlGroup2, SWT.NONE);
		txtAccess.setText("0");
		txtAccess.setBounds(10, 75, 30, 20);
		txtAccess.setEditable(false);
		txtAccess.setForeground(orange); 

		Label of3 =  new Label(controlGroup2, SWT.NONE);
		of3.setText("of");
		of3.setBounds(45, 75, 30, 20);

		Text txtAccessRule =  new Text(controlGroup2, SWT.NONE);
		txtAccessRule.setText("0");
		txtAccessRule.setBounds(70, 75, 30, 20);
		txtAccessRule.setEditable(false);

		Text txtDomain =  new Text(controlGroup2, SWT.NONE);
		txtDomain.setText("0");
		txtDomain.setBounds(10, 105, 30, 20);
		txtDomain.setEditable(false);
		txtDomain.setForeground(orange); 

		Label of4 =  new Label(controlGroup2, SWT.NONE);
		of4.setText("of");
		of4.setBounds(45, 105, 30, 20);

		Text txtDomainRule =  new Text(controlGroup2, SWT.NONE);
		txtDomainRule.setText("0");
		txtDomainRule.setBounds(70, 105, 30, 20);
		txtDomainRule.setEditable(false);

		Label lblInfo1 =  new Label(controlGroup2, SWT.NONE);
		lblInfo1.setText("violate abstraction presence rules");
		lblInfo1.setBounds(110, 15, 250, 20);

		Label lblInfo2 =  new Label(controlGroup2, SWT.NONE);
		lblInfo2.setText("violate abstraction composition rules");
		lblInfo2.setBounds(110, 45, 250, 20);

		Label lblInfo3 =  new Label(controlGroup2, SWT.NONE);
		lblInfo3.setText("violate access rules");
		lblInfo3.setBounds(110, 75, 250, 20);

		Label lblInfo4 =  new Label(controlGroup2, SWT.NONE);
		lblInfo4.setText("violate domain rules");
		lblInfo4.setBounds(110, 105, 250, 20);

		Label separator = new Label(controlGroup2, SWT.SEPARATOR | SWT.SHADOW_OUT | SWT.HORIZONTAL);
		separator.setBounds(0, 135, 450, 3);
		separator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Text txtIgnoredComposite =  new Text(controlGroup2, SWT.NONE);
		txtIgnoredComposite.setText("0");
		txtIgnoredComposite.setBounds(10, 145, 30, 20);
		txtIgnoredComposite.setEditable(false);

		Label lblInfo5 =  new Label(controlGroup2, SWT.NONE);
		lblInfo5.setText("composite rules ignored");
		lblInfo5.setBounds(50, 145, 250, 20);

		Text txtIgnoredAccess =  new Text(controlGroup2, SWT.NONE);
		txtIgnoredAccess.setText("0");
		txtIgnoredAccess.setBounds(10, 175, 30, 20);
		txtIgnoredAccess.setEditable(false);

		Label lblInfo6 =  new Label(controlGroup2, SWT.NONE);
		lblInfo6.setText("access rules ignored");
		lblInfo6.setBounds(50, 175, 250, 20);

		Text txtIgnoredDomain =  new Text(controlGroup2, SWT.NONE);
		txtIgnoredDomain.setText("0");
		txtIgnoredDomain.setBounds(10, 205, 30, 20);
		txtIgnoredDomain.setEditable(false);

		Label lblInfo7 =  new Label(controlGroup2, SWT.NONE);
		lblInfo7.setText("domain rules ignored");
		lblInfo7.setBounds(50, 205, 250, 20);

		Label separator2 = new Label(controlGroup2, SWT.SEPARATOR | SWT.SHADOW_OUT | SWT.HORIZONTAL);
		separator2.setBounds(0, 235, 450, 3);
		separator2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Text txtDrifts1 =  new Text(controlGroup2, SWT.NONE);
		txtDrifts1.setText("0");
		txtDrifts1.setBounds(10, 245, 30, 20);
		txtDrifts1.setEditable(false);

		Label lblDrifts1 =  new Label(controlGroup2, SWT.NONE);
		lblDrifts1.setText("unchecked abstractions (in current but not in planned)");
		lblDrifts1.setBounds(50, 245, 330, 20);

		Text txtDrifts2 =  new Text(controlGroup2, SWT.NONE);
		txtDrifts2.setText("0");
		txtDrifts2.setBounds(10, 275, 30, 20);
		txtDrifts2.setEditable(false);

		Label lblDrifts2 =  new Label(controlGroup2, SWT.NONE);
		lblDrifts2.setText("unchecked relations (in current but not in planned)");
		lblDrifts2.setBounds(50, 275, 330, 20);

		Button checkConstraint = new Button(group, SWT.NONE);
		checkConstraint.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		checkConstraint.setBounds(10, 10, 100, 25);
		checkConstraint.setText("Check Drifts");
		checkConstraint.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_RED)); 
		checkConstraint.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE)); 


		//************* Grid for checking abstraction existence *************
		Group controlGroup3 = new Group(group, SWT.NONE);
		controlGroup3.setText("Architectural Drifts: Abstraction Presence");
		controlGroup3.setBounds(10, 560, 450,260);
		controlGroup3.setLayout(new GridLayout());

		//************* Grid for checking abstraction composition *************
		Group controlGroup4 = new Group(group, SWT.NONE);
		controlGroup4.setText("Architectural Drifts: Composite Rules");
		controlGroup4.setBounds(470, 0, 450,260);
		controlGroup4.setLayout(new GridLayout());

		//************* Grid for checking abstraction access *************
		Group controlGroup5 = new Group(group, SWT.NONE);
		controlGroup5.setText("Architectural Drifts: Access Rules");
		controlGroup5.setBounds(470, 280, 450,260);
		controlGroup5.setLayout(new GridLayout());

		//************* Grid for checking abstraction domain *************
		Group controlGroup6 = new Group(group, SWT.NONE);
		controlGroup6.setText("Architectural Drifts: Domain Rules");
		controlGroup6.setBounds(470, 560, 450,260);
		controlGroup6.setLayout(new GridLayout());

		//************* JFreeChart *************
		Group controlGroup7 = new Group(group, SWT.NONE);
		controlGroup7.setText("Pie Chart with Valid Rules");
		controlGroup7.setBounds(930, 280, 450, 260);

		//************* Grid for ignored rules *************
		Group controlGroup8 = new Group(group, SWT.NONE);
		controlGroup8.setText("Ignored Architectural Rules");
		controlGroup8.setBounds(930, 0, 450,260);
		controlGroup8.setLayout(new GridLayout());

		//************* JFreeChart *************
		Group controlGroup9 = new Group(group, SWT.NONE);
		controlGroup9.setText("Pie Chart with All Rules");
		controlGroup9.setBounds(930, 560, 450, 260);


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

		CheckConstraint checkConstraintMethod = new CheckConstraint(workspacePath, projectName);
		GridTableViewer grid1 = this.createGrid(controlGroup3);
		GridTableViewer grid2 = this.createGrid(controlGroup4);
		GridTableViewer grid3 = this.createGrid(controlGroup5);
		GridTableViewer grid4 = this.createGrid(controlGroup6);
		GridTableViewer grid5 = this.createGrid(controlGroup8);
		grid5.getGrid().getColumn(1).setText("Type of Rule");

		checkConstraint.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {

				if (constraintPath.exists() && kdmCurrent.exists()) {

					List<MappedAnomaly> anomalyObject1 = new ArrayList<MappedAnomaly>();
					List<MappedAnomaly> anomalyObject2 = new ArrayList<MappedAnomaly>();
					List<MappedAnomaly> anomalyObject3 = new ArrayList<MappedAnomaly>();
					List<MappedAnomaly> anomalyObject4 = new ArrayList<MappedAnomaly>();
					List<MappedAnomaly> anomalyObject5 = new ArrayList<MappedAnomaly>();

					try {
						dialog.run(true, true, new IRunnableWithProgress() {
							public void run(IProgressMonitor monitor) {
								int totalUnitsOfWork = IProgressMonitor.UNKNOWN;
								monitor.beginTask("Verifying architectural drifts of ASs....", totalUnitsOfWork);

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
									List<String> lstAnomaly= queryClass.getAnomaliesIdentifiedExistence();
									for (String anomaly :lstAnomaly )
										anomalyObject1.add(new MappedAnomaly(anomaly.split(Pattern.quote("|"))[0], anomaly.split(Pattern.quote("|"))[1], anomaly.split(Pattern.quote("|"))[2]));

									lstAnomaly= queryClass.getAnomaliesIdentifiedComposition();
									for (String anomaly :lstAnomaly )
										anomalyObject2.add(new MappedAnomaly(anomaly.split(Pattern.quote("|"))[0], anomaly.split(Pattern.quote("|"))[1], anomaly.split(Pattern.quote("|"))[2]));							

									lstAnomaly= queryClass.getAnomaliesIdentifiedAccess();
									for (String anomaly :lstAnomaly )
										anomalyObject3.add(new MappedAnomaly(anomaly.split(Pattern.quote("|"))[0], anomaly.split(Pattern.quote("|"))[1], anomaly.split(Pattern.quote("|"))[2]));						

									lstAnomaly= queryClass.getAnomaliesIdentifiedDomain();
									for (String anomaly :lstAnomaly )
										anomalyObject4.add(new MappedAnomaly(anomaly.split(Pattern.quote("|"))[0], anomaly.split(Pattern.quote("|"))[1], anomaly.split(Pattern.quote("|"))[2]));

									lstAnomaly= queryClass.getIgnoredRules();
									for (String anomaly :lstAnomaly )
										anomalyObject5.add(new MappedAnomaly(anomaly.split(Pattern.quote("|"))[0], anomaly.split(Pattern.quote("|"))[1], "0"));


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
						final List<Integer> lstValues = checkConstraintMethod.getDomainAbstractions();
						txtDomain.setText(lstValues.get(0).toString());
						txtDomainRule.setText(lstValues.get(1).toString());
					} catch (Exception e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}

					try {
						final List<Integer> lstValues = checkConstraintMethod.getIgnoredValues();
						txtIgnoredComposite.setText(lstValues.get(0).toString());
						txtIgnoredAccess.setText(lstValues.get(1).toString());
						txtIgnoredDomain.setText(lstValues.get(2).toString());
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

					grid1.setInput(anomalyObject1);
					grid2.setInput(anomalyObject2);
					grid3.setInput(anomalyObject3);
					grid4.setInput(anomalyObject4);
					grid5.setInput(anomalyObject5);


					final DefaultPieDataset dataset = new DefaultPieDataset();
					try {
						dataset.setValue("Violations", Integer.parseInt(checkConstraintMethod.getTotalViolations()));
					} catch (NumberFormatException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						dataset.setValue("Passed",Integer.parseInt(checkConstraintMethod.getTotalPassed()));
					} catch (NumberFormatException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}


					//Graph
					JFreeChart jchart = ChartFactory.createPieChart3D("", dataset, true, true, false);
					final PiePlot3D plot = (PiePlot3D) jchart.getPlot();
					plot.setStartAngle(290);
					plot.setDirection(Rotation.CLOCKWISE);
					plot.setForegroundAlpha(0.5f);
					ChartComposite chartComposite = new ChartComposite(controlGroup7, SWT.NONE, jchart, true);
					chartComposite.setSize(450,240);


					final DefaultPieDataset dataset2 = new DefaultPieDataset();
					try {
						dataset2.setValue("Violations", Integer.parseInt(checkConstraintMethod.getTotalViolations()));
					} catch (NumberFormatException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					try {
						dataset2.setValue("Passed", Integer.parseInt(checkConstraintMethod.getTotalPassed()));
					} catch (NumberFormatException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					try {
						dataset2.setValue("Ignored",checkConstraintMethod.getIgnoredValues().get(0)+ checkConstraintMethod.getIgnoredValues().get(1)+checkConstraintMethod.getIgnoredValues().get(2));
					} catch (NumberFormatException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					JFreeChart jchart2 = ChartFactory.createPieChart3D("", dataset2, true, true, false);
					final PiePlot3D plot2 = (PiePlot3D) jchart2.getPlot();
					plot2.setStartAngle(290);
					plot2.setDirection(Rotation.CLOCKWISE);
					plot2.setForegroundAlpha(0.5f);
					ChartComposite chartComposite2 = new ChartComposite(controlGroup9, SWT.NONE, jchart2, true);
					chartComposite2.setSize(450,240);


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
		tab1.setControl(scroller);
	}

	private GridTableViewer createGrid(Group control) {

		GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		layoutData.minimumWidth = 300;
		GridTableViewer gridTableViewer = new GridTableViewer(control, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.WRAP);
		gridTableViewer.setUseHashlookup(true);
		gridTableViewer.getGrid().setLinesVisible(true);
		gridTableViewer.getGrid().setHeaderVisible(true);
		gridTableViewer.getGrid().setVisibleLinesColumnPack(true);
		gridTableViewer.getGrid().setLayoutData(layoutData);
		gridTableViewer.getGrid().setBounds(0, 0, 450, 250);

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
		return gridTableViewer;
	}

	private void UIDomainRules(TabFolder tabFolder, String projectName) {

		TabItem tab1 = new TabItem(tabFolder, SWT.NONE);
		tab1.setText("Domain Rules");
		Group group = new Group(tabFolder, SWT.NONE);

		Group controlGroup = new Group(group, SWT.NONE);
		controlGroup.setText("Control");
		controlGroup.setBounds(10, 0, 500, 50);

		Label label1 = new Label(controlGroup, SWT.NONE);
		label1.setText("Project Name: " + projectName);
		label1.setBounds(15, 3, 300, 20);

		Group tableViewGroup = new Group(group, SWT.NONE);
		tableViewGroup.setText("Predefined Rules of Adaptive Systems Domain");
		tableViewGroup.setBounds(10, 55, 550, 530);
		tableViewGroup.setLayout(new FillLayout());
		tab1.setControl(group);

		viewerRules = new TableViewer(tableViewGroup, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		final Table table = viewerRules.getTable();
		table.setBounds(0, 0, 550, 500);

		TableViewerColumn column0 = new TableViewerColumn(viewerRules, SWT.CENTER);
		column0.getColumn().setText("Id");
		column0.getColumn().setWidth(30);
		column0.getColumn().setResizable(false);
		column0.setLabelProvider(new ColumnLabelProviderFirst());

		TableViewerColumn column1 = new TableViewerColumn(viewerRules, SWT.CENTER);
		column1.getColumn().setText("Abstraction (From)");
		column1.getColumn().setWidth(155);
		column1.getColumn().setResizable(false);
		column1.setLabelProvider(new ColumnLabelProviderSecond());

		TableViewerColumn column2 = new TableViewerColumn(viewerRules, SWT.CENTER);
		column2.getColumn().setText("Type of Access");
		column2.getColumn().setWidth(130);
		column2.getColumn().setResizable(false);
		column2.setLabelProvider(new ColumnLabelProviderThird());

		TableViewerColumn column3= new TableViewerColumn(viewerRules, SWT.CENTER);
		column3.getColumn().setText("Abstraction (To) ");
		column3.getColumn().setWidth(155);
		column3.getColumn().setResizable(false);
		column3.setLabelProvider(new ColumnLabelProviderFourth());


		TableViewerColumn column4 = new TableViewerColumn(viewerRules, SWT.CENTER | SWT.CHECK);
		column4.getColumn().setText("On/Off ");
		column4.getColumn().setWidth(15);
		column4.getColumn().setResizable(false);
		column4.setLabelProvider(new ColumnLabelProviderFifth());

		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		EditingRulesInstance editingRule = new EditingRulesInstance(column4.getViewer());
		column4.setEditingSupport(editingRule);

		viewerRules.setContentProvider(new ArrayContentProvider());


		tabFolder.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent event) {
				if (tabFolder.getSelection()[0].getText().equals("Domain Rules"))
				{
					EditingRulesInstance editingRule = new EditingRulesInstance(column4.getViewer());
					column4.setEditingSupport(editingRule);
				}
			}
		});

		QueryClass queryClass=null;
		List<String> rules = null;

		try {
			queryClass = new QueryClass(MainView.getDatabaseUrl());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rules = queryClass.getDomainRules();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<TableMetaData> ruleContainer = new ArrayList<TableMetaData>();

		for (String rule :rules )
			ruleContainer.add(new TableMetaData(Integer.valueOf(rule.split(Pattern.quote("|"))[0]), rule.split(Pattern.quote("|"))[1], rule.split(Pattern.quote("|"))[3],
					rule.split(Pattern.quote("|"))[2],Boolean.valueOf(rule.split(Pattern.quote("|"))[4])));

		viewerRules.setInput(ruleContainer);

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
						List<String> nl = this.constructor(new File(resource.getLocation().toOSString()));
						nl.addAll(this.methodAndVariables(new File(resource.getLocation().toOSString())));
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

	private List<String> constructor(File file) throws FileNotFoundException {
		
		List<String> methodAndVariables = new ArrayList<String>();
		String str = "";
		ConstructorVisitor md = new ConstructorVisitor();
		CompilationUnit cu = JavaParser.parse(file);
		List<ConstructorDeclaration> listMd = md.getMethodClasses(cu);
		for (int i = 0; i < listMd.size(); i++) {
			String methodName = listMd.get(i).getName().toString();
			VariableVisitor vv = new VariableVisitor();
			List<VariableDeclarator> listVD = vv.getVariableExprConstructor(listMd.get(i));
			for (int j = 0; j < listVD.size(); j++) {
				String variable = listVD.get(j).getNameAsString().toString();
				str = str + "|" + variable;
			}
			methodAndVariables.add(methodName + str);
			str = "";
		}
		return methodAndVariables;
		
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

}
