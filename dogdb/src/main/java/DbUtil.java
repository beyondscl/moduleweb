import org.junit.Test;

import java.sql.*;

/**
 * author: 牛虻.
 * time:2018/1/30
 * email:pettygadfly@gmail.com
 * doc:
 * 先针对mysql吧
 */
public class DbUtil {


    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //忽略ssl链接警告
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/world?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "mysql";

    public static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConn(Connection conn, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    @Test
    public void getConnTest() {
        getConnection();
    }
}
