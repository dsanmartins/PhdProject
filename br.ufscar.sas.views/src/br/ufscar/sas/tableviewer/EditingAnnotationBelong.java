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

public class EditingAnnotationBelong extends EditingSupport {

	private ComboBoxViewerCellEditor cellEditor = null;

	public EditingAnnotationBelong(ColumnViewer viewer) {
		super(viewer);
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
			return data.getBelong();
		}
		return null;
	}

	@Override
	protected void setValue(Object element, Object value) {
		if (element instanceof Data && value instanceof String) {
			Data data = (Data) element;
			String newValue = (String) value;
			/* only set new value if it differs from old one */
			if (!data.getBelong().equals(newValue)) {
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
							MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Info", "Please select an Instance before this operation! ");
							cellEditor.getViewer().getCCombo().setText("None");
							data.setBelong("None");
							this.getViewer().update(element, null);
						}
						else
						{
							String annotation = rs.get(0).split(Pattern.quote("|"))[0];
							if (annotation.equals("None"))
							{
								MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Info", "Please select an Instance before this operation! ");
								cellEditor.getViewer().getCCombo().setText("None");
								queryClass.updateBelongClass(projectName, data.getName(), path, "None");
							}
							else
							{
								if (annotation.equals(newValue))
								{
									MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Info", "Belong to can not have the same Instance value!");
									cellEditor.getViewer().getCCombo().setText("None");
									data.setBelong("None");
									this.getViewer().update(element, null);
								}
								else
								{
									queryClass.updateBelongClass(projectName, data.getName(), path, newValue);
									data.setBelong(newValue);
									this.getViewer().update(element, null);
								}
							}
								
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
								MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Info", "Please select an Instance before this operation! ");
								cellEditor.getViewer().getCCombo().setText("None");
								data.setBelong("None");
								this.getViewer().update(element, null);
							}
							else
							{
								String annotation = rs.get(0).split(Pattern.quote("|"))[0];
								if (annotation.equals("None"))
								{
									MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Info", "Please select an Instance before this operation! ");
									cellEditor.getViewer().getCCombo().setText("None");
									queryClass.updateBelongFieldClass(projectName, data.getClassName(), data.getName(), path, newValue);
								}
								else
								{
									if (annotation.equals(newValue))
									{
										MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Info", "Belong to can not have the same Instance value!");
										cellEditor.getViewer().getCCombo().setText("None");
										data.setBelong("None");
										this.getViewer().update(element, null);
									}
									else
									{
										queryClass.updateBelongFieldClass(projectName, data.getClassName(), data.getName(), path, newValue);
										queryClass.updateBelongMethod(projectName, data.getClassName(), data.getName(), path, newValue);
										data.setBelong(newValue);
										this.getViewer().update(element, null);
									}
								}
									
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
									MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Info", "Please select an Instance before this operation! ");
									cellEditor.getViewer().getCCombo().setText("None");
									data.setBelong("None");
									this.getViewer().update(element, null);
									
								}
								else
								{
									String annotation = rs.get(0).split(Pattern.quote("|"))[0];
									if (annotation.equals("None"))
									{
										MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Info", "Please select an Instance before this operation! ");
										cellEditor.getViewer().getCCombo().setText("None");
										queryClass.updateBelongMethod(projectName, data.getClassName(), data.getName(), path, newValue);
									}
									else
									{
										if (annotation.equals(newValue))
										{
											MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Info", "Belong to can not have the same Instance value!");
											cellEditor.getViewer().getCCombo().setText("None");
											data.setBelong("None");
											this.getViewer().update(element, null);
										}
										else
										{
											queryClass.updateBelongMethod(projectName, data.getClassName(), data.getName(), path, newValue);
											data.setBelong(newValue);
											this.getViewer().update(element, null);
										}
									}
										
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
										MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Info", "Please select an Instance before this operation! ");
										cellEditor.getViewer().getCCombo().setText("None");
										data.setBelong("None");
										this.getViewer().update(element, null);
									}
									else
									{
										String annotation = rs.get(0).split(Pattern.quote("|"))[0];
										if (annotation.equals("None"))
										{
											cellEditor.getViewer().getCCombo().setText("None");
											MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Info", "Please select an Instance before this operation! ");
											queryClass.updateBelongVariable(projectName, data.getClassName(), data.getMethodName(), data.getName(), path, newValue);
										}
										else
										{
											if (annotation.equals(newValue))
											{
												MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Info", "Belong to can not have the same Instance value!");
												cellEditor.getViewer().getCCombo().setText("None");
												data.setBelong("None");
												this.getViewer().update(element, null);
											}
											else
											{
												queryClass.updateBelongVariable(projectName, data.getClassName(), data.getMethodName(), data.getName(), path, newValue);
												data.setBelong(newValue);
												this.getViewer().update(element, null);
											}
										}
											
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
											MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Info", "Please select an Instance before this operation! ");
											cellEditor.getViewer().getCCombo().setText("None");
											data.setBelong("None");
											this.getViewer().update(element, null);
										}
										else
										{
											String annotation = rs.get(0).split(Pattern.quote("|"))[0];
											if (annotation.equals("None"))
											{
												MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Info", "Please select an Instance before this operation! ");
												queryClass.updateBelongPackage(projectName, data.getName(), path, "None");
												cellEditor.getViewer().getCCombo().setText("None");
												data.setBelong("None");
												this.getViewer().update(element, null);
												
											}
											else
											{
												if (annotation.equals(newValue) && !annotation.equals("None"))
												{
													MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Info", "Belong to can not have the same Instance value!");
													cellEditor.getViewer().getCCombo().setText("None");
													data.setBelong("None");
													this.getViewer().update(element, null);
												}
												else
												{
													queryClass.updateBelongPackage(projectName, data.getName(), path, newValue);
													data.setBelong(newValue);
													this.getViewer().update(element, null);
												}
											}
												
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