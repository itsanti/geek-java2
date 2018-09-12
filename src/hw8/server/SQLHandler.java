

package hw8.server;
import java.sql.*;

public class SQLHandler {
    
    private static Connection connection;
    private static Statement stmt;
    private static final String CONN_STRING = System.getProperty("user.dir") + "\\src\\hw8\\server\\database.db";
    
    public static void connect()
    {
        try//нунжо "вытолкнуть" наверх
        {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + CONN_STRING);
            System.out.println("Подключились");
            stmt = connection.createStatement();
        }
        catch(Exception ex)
        {
            ex.getStackTrace();
            System.out.println("Не подключились");
        }
    }//connect()
    
    
    public static String getNickByLogPass(String login, String password)
    {
        try {

            ResultSet rs = stmt.executeQuery("SELECT nickname FROM users WHERE login='" + login + "' AND password='" + password + "';");
        
            if(rs.next())//если в наборе есть данные, ...
            {
               return rs.getString("nickname");//вернуть строку из набора
            }
        
        
        } catch (SQLException ex) {
            ex.getStackTrace();
        }

       return null;//нет такого клиента 
    }
    
    
    public static void disconnect()
    {
        try
        {
            connection.close();//осовбодить ресурсы подключения
        }
        catch(Exception ex)
        {
            ex.getStackTrace();
        }
    }//disconnect()
}//public class SQLHandler
