package br.ufscar.sas.tableviewer;

import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import br.ufscar.sas.cripto.CriptoBase64;
import br.ufscar.sas.database.QueryClass;
import br.ufscar.sas.view.MainView;

public class EditingAnnotationInstance extends EditingSupport {

	private ComboBoxViewerCellEditor cellEditor = null;
	private ColumnViewer viewer = null;
	
	public EditingAnnotationInstance(ColumnViewer viewer) {
		super(viewer);
		this.viewer = viewer;
		cellEditor = new ComboBoxViewerCellEditor((Composite) getViewer().getControl(), SWT.READ_ONLY);
		cellEditor.setLabelProvider(new LabelProvider());
		cellEditor.setContentProvider(new ArrayContentProvider());
	
		List<String> rs = null;

		try 
		{	
			QueryClass queryClass = new QueryClass(MainView.getDatabaseUrl());
			rs = queryClass.selectInstance(2);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		cellEditor.setInput(rs);

	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return cellEditor;
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {
		if (element instanceof Data) {
			Data data = (Data) element;
			return data.getAnnotation();
		}
		return null;
	}

	@Override
	protected void setValue(Object element, Object value) {		
		
		if (element instanceof Data && value instanceof String) {
			Data data = (Data) element;
			String newValue = (String) value;
			/* only set new value if it differs from old one */
			if (!data.getAnnotation().equals(newValue)) {
				data.setAnnotation(newValue);
				this.getViewer().update(element, null);
				if (data.getCodeType().equals("Class Name"))
				{
					try {
						QueryClass queryClass = new QueryClass(MainView.getDatabaseUrl());
						String projectName = MainView.getDatabaseUrl().split("\\/")[MainView.getDatabaseUrl().split("\\/").length-1];
						CriptoBase64 criptoBase64 = new CriptoBase64();
						String path = criptoBase64.decodeBase64Path(data.getPathCode());
						List <String> rs = queryClass.selectAnnotationClass(projectName, data.getName(), path);
						if (rs.isEmpty())
						{
							queryClass.insertAnnotationClass(projectName, data.getName(), path, newValue);
							if (newValue.equals("None"))
								queryClass.updateBelongClass(projectName, data.getName(), path, "None");
						}
						else
						{
							queryClass.updateAnnotationClass(projectName, data.getName(), path, newValue);
							if (newValue.equals("None"))
								queryClass.updateBelongClass(projectName, data.getName(), path, "None");
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else
				{
					if (data.getCodeType().equals("Field Class"))
					{
						try {
							QueryClass queryClass = new QueryClass(MainView.getDatabaseUrl());
							String projectName = MainView.getDatabaseUrl().split("\\/")[MainView.getDatabaseUrl().split("\\/").length-1];
							
							CriptoBase64 criptoBase64 = new CriptoBase64();
							String path = criptoBase64.decodeBase64Path(data.getPathCode());
							List <String> rs = queryClass.selectAnnotationFieldClass(projectName, data.getClassName(), data.getName(), path);
							if (rs.isEmpty())
							{
								queryClass.insertAnnotationFieldClass(projectName, data.getClassName(), data.getName(), path, newValue);
								if (newValue.equals("None"))
									queryClass.updateBelongFieldClass(projectName, data.getClassName(), data.getName(), path, "None");
							}
							else
							{
								queryClass.updateAnnotationFieldClass(projectName, data.getClassName(), data.getName(), path, newValue);
								if (newValue.equals("None"))
									queryClass.updateBelongFieldClass(projectName, data.getClassName(), data.getName(), path, "None");
							}
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
					{
						if (data.getCodeType().equals("Method"))
						{
							try {
								QueryClass queryClass = new QueryClass(MainView.getDatabaseUrl());
								String projectName = MainView.getDatabaseUrl().split("\\/")[MainView.getDatabaseUrl().split("\\/").length-1];
								
								CriptoBase64 criptoBase64 = new CriptoBase64();
								String path = criptoBase64.decodeBase64Path(data.getPathCode());
								List <String> rs = queryClass.selectAnnotationMethod(projectName, data.getClassName(), data.getName(), path);
								if (rs.isEmpty())
								{
									queryClass.insertAnnotationMethod(projectName, data.getClassName(), data.getName(), path, newValue);
									if (newValue.equals("None"))
										queryClass.updateBelongMethod(projectName, data.getClassName(), data.getName(), path, "None");
								}
								else
								{
									queryClass.updateAnnotationMethod(projectName, data.getClassName(), data.getName(), path, newValue);
									if (newValue.equals("None"))
										queryClass.updateBelongMethod(projectName, data.getClassName(), data.getName(), path, "None");
								}
								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else
						{
							if (data.getCodeType().equals("Variable"))
							{
								try {
									QueryClass queryClass = new QueryClass(MainView.getDatabaseUrl());
									String projectName = MainView.getDatabaseUrl().split("\\/")[MainView.getDatabaseUrl().split("\\/").length-1];
									
									CriptoBase64 criptoBase64 = new CriptoBase64();
									String path = criptoBase64.decodeBase64Path(data.getPathCode());
									List <String> rs = queryClass.selectAnnotationVariable(projectName, data.getClassName(), data.getMethodName(), data.getName(), path);
									if (rs.isEmpty())
									{
										queryClass.insertAnnotationVariable(projectName, data.getClassName(), data.getMethodName(), data.getName(), path, newValue);
										if (newValue.equals("None"))
											queryClass.updateBelongVariable(projectName, data.getClassName(), data.getMethodName(), data.getName(), path, "None");
									}
									else
									{
										queryClass.updateAnnotationVariable(projectName, data.getClassName(), data.getMethodName(), data.getName(), path, newValue);
										if (newValue.equals("None"))
											queryClass.updateBelongVariable(projectName, data.getClassName(), data.getMethodName(), data.getName(), path, "None");
									}
									
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else
							{
								if (data.getCodeType().equals("Package"))
								{
									try {
										QueryClass queryClass = new QueryClass(MainView.getDatabaseUrl());
										String projectName = MainView.getDatabaseUrl().split("\\/")[MainView.getDatabaseUrl().split("\\/").length-1];
										CriptoBase64 criptoBase64 = new CriptoBase64();
										String path = criptoBase64.decodeBase64Path(data.getPathCode());
										List <String> rs = queryClass.selectAnnotationPackage(projectName, data.getName(), path);
										if (rs.isEmpty())
										{
											queryClass.insertAnnotationPackage(projectName, data.getName(), path, newValue);
											if (newValue.equals("None"))
												queryClass.updateBelongPackage(projectName, data.getName(), path, "None");
										}
										else
										{
											queryClass.updateAnnotationPackage(projectName, data.getName(), path, newValue);
											if (newValue.equals("None"))
												queryClass.updateBelongPackage(projectName, data.getName(), path, "None");
											
											
										}
										
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
						}
					}
				}
			}
		}
	}
}