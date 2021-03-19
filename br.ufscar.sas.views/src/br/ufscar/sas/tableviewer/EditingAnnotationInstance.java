package br.ufscar.sas.tableviewer;

import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import br.ufscar.sas.cripto.CriptoBase64;
import br.ufscar.sas.database.QueryClass;
import br.ufscar.sas.view.MainView;

public class EditingAnnotationInstance extends EditingSupport {

	private ComboBoxViewerCellEditor cellEditor = null;
	private ColumnViewer viewer = null;

	public EditingAnnotationInstance(ColumnViewer viewer, int op) {
		super(viewer);
		this.viewer = viewer;
		cellEditor = new ComboBoxViewerCellEditor((Composite) getViewer().getControl(), SWT.READ_ONLY);
		cellEditor.setLabelProvider(new LabelProvider());
		cellEditor.setContentProvider(new ArrayContentProvider());

		List<String> rs = null;

		try 
		{	
			QueryClass queryClass = new QueryClass(MainView.getDatabaseUrl());
			if (op == 1)
				rs = queryClass.selectInstance(2);
			else
				if (op == 2)
					rs = queryClass.selectGenericInstance();

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
				if (data.getCodeType().equals("Class"))
				{
					try {
						QueryClass queryClass = new QueryClass(MainView.getDatabaseUrl());
						String projectName = MainView.getDatabaseUrl().split("\\/")[MainView.getDatabaseUrl().split("\\/").length-1];
						CriptoBase64 criptoBase64 = new CriptoBase64();
						String path = criptoBase64.decodeBase64Path(data.getPathCode());
						List <String> rs = queryClass.selectAnnotationClass(projectName, data.getName(), path);
						int inner = queryClass.getInnerAnnotationClass(data.getClassName(), data.getName(), path, newValue);

						if (inner == 0) {

							if (rs.isEmpty())
							{

								queryClass.insertAnnotationClass(projectName, data.getClassName(), data.getName(), path, newValue);
								if (newValue.equals("None"))
									queryClass.updateBelongClass(projectName,  data.getClassName(), data.getName(), path, "None");
							}
							else
							{

								queryClass.updateAnnotationClass(projectName,  data.getClassName(), data.getName(), path, newValue);
								if (newValue.equals("None"))
									queryClass.updateBelongClass(projectName,  data.getClassName(), data.getName(), path, "None");
							}
						}
						else
							MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Information", "It is forbidden compose annotations with the same name.");


					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				else
				{
					if (data.getCodeType().equals("Field"))
					{
						try {
							QueryClass queryClass = new QueryClass(MainView.getDatabaseUrl());
							String projectName = MainView.getDatabaseUrl().split("\\/")[MainView.getDatabaseUrl().split("\\/").length-1];

							CriptoBase64 criptoBase64 = new CriptoBase64();
							String path = criptoBase64.decodeBase64Path(data.getPathCode());
							List <String> rs = queryClass.selectAnnotationFieldClass(projectName, data.getClassName(), data.getName(), path);

							String realPathList[] = path.split(Pattern.quote("/"));
							String newRealPath = "/";
							for (int z=0; z< realPathList.length-1; z++)
								newRealPath = newRealPath + realPathList[z] + "/" ;

							newRealPath = newRealPath.substring(1);
							int inner = queryClass.getInnerAnnotationField(data.getClassName(), data.getName(), newRealPath, path, newValue);

							if (inner == 0) {

								if (rs.isEmpty())
								{
									//Check if annotation is not the same as the parent
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
							}
							else
								MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Information", "It is forbidden compose annotations with the same name.");

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

								String realPathList[] = path.split(Pattern.quote("/"));
								String newRealPath = "/";
								for (int z=0; z< realPathList.length-1; z++)
									newRealPath = newRealPath + realPathList[z] + "/" ;

								newRealPath = newRealPath.substring(1);


								int inner = queryClass.getInnerAnnotationMethod(data.getClassName(), data.getName(), newRealPath, path, newValue);

								if (inner == 0) {

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

								}
								else
									MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Information", "It is forbidden compose annotations with the same name.");

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

									String realPathList[] = path.split(Pattern.quote("/"));
									String newRealPath = "/";
									for (int z=0; z< realPathList.length-1; z++)
										newRealPath = newRealPath + realPathList[z] + "/" ;

									newRealPath = newRealPath.substring(1);


									int inner = queryClass.getInnerAnnotationVariable(data.getClassName(), data.getMethodName(), data.getName(), newRealPath, path, newValue);

									if (inner == 0) {

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

									}
									else
										MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Information", "It is forbidden compose annotations with the same name.");

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

										String realPathList[] = path.split(Pattern.quote("/"));
										String newRealPath = "/";
										for (int z=0; z< realPathList.length-1; z++)
											newRealPath = newRealPath + realPathList[z] + "/" ;

										newRealPath = newRealPath.substring(1);

										int inner = queryClass.getInnerAnnotationPackage(data.getName(), newValue);

										if (inner == 0) {

											List <String> rs = queryClass.selectAnnotationPackage(projectName, data.getName(), newRealPath);
											if (rs.isEmpty())
											{
												queryClass.insertAnnotationPackage(projectName, data.getName(), newRealPath, newValue);
												if (newValue.equals("None"))
													queryClass.updateBelongPackage(projectName, data.getName(), newRealPath, "None");
											}
											else
											{
												queryClass.updateAnnotationPackage(projectName, data.getName(), newRealPath, newValue);
												if (newValue.equals("None"))
													queryClass.updateBelongPackage(projectName, data.getName(), newRealPath, "None");

											}
										}
										else
											MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Information", "It is forbidden compose annotations with the same name.");

									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								else
								{
									if (data.getCodeType().equals("Interface"))
									{
										try {
											QueryClass queryClass = new QueryClass(MainView.getDatabaseUrl());
											String projectName = MainView.getDatabaseUrl().split("\\/")[MainView.getDatabaseUrl().split("\\/").length-1];
											CriptoBase64 criptoBase64 = new CriptoBase64();
											String path = criptoBase64.decodeBase64Path(data.getPathCode());
											List <String> rs = queryClass.selectAnnotationInterface(projectName, data.getName(), path);
											int inner = queryClass.getInnerAnnotationInterface(data.getClassName(), data.getName(), path, newValue);

											if (inner == 0) {

												if (rs.isEmpty())
												{

													queryClass.insertAnnotationInterface(projectName, data.getClassName(), data.getName(), path, newValue);
													if (newValue.equals("None"))
														queryClass.updateBelongInterface(projectName,  data.getClassName(), data.getName(), path, "None");
												}
												else
												{

													queryClass.updateAnnotationInterface(projectName,  data.getClassName(), data.getName(), path, newValue);
													if (newValue.equals("None"))
														queryClass.updateBelongInterface(projectName,  data.getClassName(), data.getName(), path, "None");
												}
											}
											else
												MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Information", "It is forbidden compose annotations with the same name.");


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
}