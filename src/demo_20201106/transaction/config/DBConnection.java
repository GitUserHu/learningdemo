package demo_20201106.transaction.config;

public class DBConnection {
	private static DBConnection instance;
	private DBConnection() {}
	public static DBConnection getInstance() {
		if (instance == null) {
			synchronized (DBProperty.class) {
				if (instance == null) {
					instance = new DBConnection();
				}
			}
		}
		return instance;
	}
	
	public void connect(DBProperty dbProperty) {
		System.out.println(dbProperty.getUsername()+": "+dbProperty.getPassword());
	}
}
