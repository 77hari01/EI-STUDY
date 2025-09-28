package Type1;
class databaseconnection{
    private static databaseconnection instance=new databaseconnection();
    private databaseconnection(){
        System.out.println("database connected");
    }
    public static databaseconnection getInstance(){
        return instance;
    }
    public void query(String sql){
        System.out.println("executing query "+sql);
    }
}
public class Eagertype {
    public static void main(String[] args) {
        databaseconnection db1=databaseconnection.getInstance();
        db1.query("Select * from employee");
        databaseconnection db2=databaseconnection.getInstance();
        System.out.println("same object "+(db1==db2));
    }
}
