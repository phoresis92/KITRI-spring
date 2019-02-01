package test2;

public class DBConn {

	private String dbType;

	public DBConn(String dbType) {
		this.dbType = dbType;
		System.out.println(dbType +"/ DB Connection Success");
	}

	public String getDbType() {
		return dbType;
	}
	
	
	
}
