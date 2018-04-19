package com.bird.test;

import java.sql.*;

/**
 * author: 牛虻.
 * time:2017/11/21
 * email:pettygadfly@gmail.com
 * doc:
 */
public class jdbcTestMycat1 {

    public static void main(String[] args) throws Exception {
        long userId = 1L;
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            String url = "jdbc:mysql://10.0.20.144:8066/TESTDB";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "root");
            statement = conn.createStatement();
            statement.execute("SELECT count(1) FROM t_user");
            rs = statement.getResultSet();
            while (rs.next()){
                System.out.println(rs.getLong(1));
            }


            statement.execute("DELETE FROM t_user");


            conn.setAutoCommit(false);
            Statement statement1 = conn.prepareStatement("");
            for (int i=0;i<2000;i++){
                statement1.addBatch(getInsertSql(i));
                if (i%100==0){
                    statement1.executeBatch();
                    conn.commit();
                    statement1.clearBatch();
                }
            }
            statement1.executeBatch();
            conn.commit();

            statement.execute("SELECT count(1) FROM t_user");
            rs = statement.getResultSet();
            while (rs.next()){
                System.out.println(rs.getLong(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            statement.close();
            conn.close();
        }
    }
    public static String getInsertSql(long id){
        return "INSERT INTO t_user (user_id, receive_address,create_time,province_code) " +
                "VALUES ("+id+", '广州市越秀区广州大道中599号', '2014-07-17 10:53:15', 'GD')";
    }
}
