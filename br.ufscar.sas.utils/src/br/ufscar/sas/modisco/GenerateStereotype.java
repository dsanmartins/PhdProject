package br.ufscar.sas.modisco;

import java.io.File;
import java.sql.SQLException;

import org.basex.core.BaseXException;
import org.basex.query.QueryException;

public class GenerateStereotype {

	public void createModel(File path, String file, String dbName)
	{
		Manager baseXManager=null;

		try {
			baseXManager = new Manager(path.getPath()+ "/", file, dbName);
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

		try {
			baseXManager.generateStereotype();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
