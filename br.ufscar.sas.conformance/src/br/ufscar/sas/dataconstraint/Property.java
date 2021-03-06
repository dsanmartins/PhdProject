package br.ufscar.sas.dataconstraint;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class Property {

	private static final String propFileName = "configuration.properties";
	private static Properties props;

	public static Properties getQueries() throws SQLException {
		
		InputStream is = Property.class.getClassLoader().getResourceAsStream(propFileName);
		if (is == null){
	
			is = Property.class.getClassLoader().getResourceAsStream(propFileName);
		}
		//singleton
		if(props == null)
		{
			props = new Properties();
			try 
			{
				props.load(is);
			} catch (IOException e) 
			{
				throw new SQLException("Unable to load property file: " + propFileName + "\n" + e.getMessage());
			}
			finally 
			{
			    if (null != is)
			    {
			        try
			        {
			        	is.close();
			        }
			        catch (Exception e)
			        {
			            e.printStackTrace();
			        }
			    }
			}
		}
		return props;
	}

	public static String getProperty(String query) throws SQLException{
		return getQueries().getProperty(query);
	}

}


