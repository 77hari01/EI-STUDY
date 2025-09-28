package Type4;

class DatabaseConnectionDCL {
    private static volatile DatabaseConnectionDCL instance;

    private DatabaseConnectionDCL() {
        System.out.println("DCL: Database Connected!");
    }
    public static DatabaseConnectionDCL getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnectionDCL.class) {
                if (instance == null) {
                    instance = new DatabaseConnectionDCL();
                }
            }
        }
        return instance;
    }
    public void query(String sql) {
        System.out.println("DCL: Executing query: " + sql);
    }
}
public class Lockingtype {
    public static void main(String[] args) {
        DatabaseConnectionDCL db1 = DatabaseConnectionDCL.getInstance();
        db1.query("DELETE FROM logs WHERE id=5");

        DatabaseConnectionDCL db2 = DatabaseConnectionDCL.getInstance();
        System.out.println("DCL: Same object? " + (db1 == db2));
    }
}
