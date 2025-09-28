package Type2;

class DatabaseConnectionLazy {
    private static DatabaseConnectionLazy instance;

    private DatabaseConnectionLazy() {
        System.out.println("Lazy: Database Connected!");
    }
    public static DatabaseConnectionLazy getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionLazy();
        }
        return instance;
    }
    public void query(String sql) {
        System.out.println("Lazy: Executing query: " + sql);
    }
}
public class Lazytype {
    public static void main(String[] args) {
        DatabaseConnectionLazy db1 = DatabaseConnectionLazy.getInstance();
        db1.query("SELECT * FROM users");

        DatabaseConnectionLazy db2 = DatabaseConnectionLazy.getInstance();
        System.out.println("Lazy: Same object? " + (db1 == db2));
    }
}
