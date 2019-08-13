package br.ufscar.sas.dataconstraint;

public class SqliteDb extends Db
{
	public SqliteDb(String sDriverKey, String sUrlKey) throws Exception
	{
		init(sDriverKey, sUrlKey);

		if(conn != null)
		{
			//System.out.println("Connected OK using " + sDriverKey + " to " + sUrlKey);
		}
		else
		{
			System.out.println("Connection failed");
		}
	}
	
}
