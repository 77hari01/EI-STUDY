package Type3;

class DatabaseConnectionSync {
    private static DatabaseConnectionSync instance;

    private DatabaseConnectionSync() {
        System.out.println("Sync: Database Connected!");
    }
    public static synchronized DatabaseConnectionSync getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionSync();
        }
        return instance;
    }
    public void query(String sql) {
        System.out.println("Sync: Executing query: " + sql);
    }
}
public class Sychronizedtype {
    public static void main(String[] args) {
        DatabaseConnectionSync db1 = DatabaseConnectionSync.getInstance();
        db1.query("UPDATE products SET price=100 WHERE id=1");

        DatabaseConnectionSync db2 = DatabaseConnectionSync.getInstance();
        System.out.println("Sync: Same object? " + (db1 == db2));
    }
}
