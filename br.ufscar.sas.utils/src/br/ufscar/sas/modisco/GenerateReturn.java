package br.ufscar.sas.modisco;
import java.sql.SQLException;
import java.util.ArrayList;

import org.basex.core.BaseXException;
import org.basex.query.QueryException;

public class GenerateReturn {

	
	public GenerateReturn(){
		
	}
	
	public void generator(String path, String file, String dbName)
	{
		Manager baseXManager=null;
		
		try {
			baseXManager = new Manager(path, file, dbName);
		} catch (BaseXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			baseXManager.openDB();
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<String> arrayListReturnPath = null;
		try {
			arrayListReturnPath = baseXManager.getPropertyName();
		} catch (BaseXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (QueryException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (String propertyName : arrayListReturnPath){
			
			boolean check = false;
			try {
				check = baseXManager.checkPropertyBelongToClass(propertyName);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (QueryException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (check)
			{
				String pathProperty = null;
				try {
					pathProperty = baseXManager.createModiscoPath(propertyName,"getPathOfProperty");
				} catch (QueryException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//Search for its getter
				String methodName = null;
				try {
					methodName = baseXManager.getMethodName(propertyName);
				} catch (BaseXException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (QueryException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String pathReturn = null;
				try {
					pathReturn = baseXManager.createModiscoPath(methodName,"getPathOfReturn");
				} catch (QueryException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				boolean checkActionRelation = false;
				try {
					checkActionRelation = baseXManager.checkActionRelationReturn(methodName);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (QueryException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (!checkActionRelation)
				{
					try {
						baseXManager.createNode(methodName);
					} catch (SQLException | QueryException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						baseXManager.createAttributeOfNode(methodName, "from", pathReturn);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (QueryException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						baseXManager.createAttributeOfNode(methodName, "to", pathProperty);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (QueryException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						baseXManager.createAttributeOfNode(methodName, "xsi:type", "action:Reads");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (QueryException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}	
		}
		try {
			baseXManager.exportDB();
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baseXManager.closeDB();
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
