package test2;

public class DaoImplOracle implements Dao {
	
	private DBConn conn;
	private String dbType;
	
/*	public DaoImplOracle(String dbType) {
		this.conn = new DBConn(dbType);
		this.dbType = dbType;
	}*/
	
	public void setConn(DBConn conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert() {
		System.out.println(conn.getDbType()+"/ insert");
	}

	@Override
	public void select() {
		System.out.println(conn.getDbType()+"/ select");

	}

	@Override
	public void update() {
		System.out.println(conn.getDbType()+"/ update");

	}

	@Override
	public void delete() {
		System.out.println(conn.getDbType()+"/ delete");

	}

}
