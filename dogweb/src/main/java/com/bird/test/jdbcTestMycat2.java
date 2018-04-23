package com.bird.test;

import java.sql.*;
import java.util.UUID;

/**
 * author: 牛虻.
 * time:2017/11/21
 * email:pettygadfly@gmail.com
 * doc:
 */
public class jdbcTestMycat2 {

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        PreparedStatement statement2 = null;
        ResultSet rs = null;
        try {
            String url = "jdbc:mysql://10.0.20.144:8066/TESTDB";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "root");
            conn.setAutoCommit(false);
            statement2 = conn.prepareStatement("insert into sync_user (id,name,password) VALUES (?,?,?)");
            for (int i = 0; i < 2; i++) {//测试是否随机分配到多个实例上写
                statement2.setInt(1, UUID.randomUUID().toString().hashCode());
                statement2.setString(2, "你好");
                statement2.setInt(3, "HELLO".hashCode());
                statement2.execute();
            }
            conn.setAutoCommit(true);
            System.out.println("双主备份写入");

            statement2 = conn.prepareStatement("SELECT * from sync_user");
            rs = statement2.executeQuery();
            while (rs.next()){
                System.out.println(rs.getLong(1));
            }
            System.out.println("双主备份读.关闭一台在测试");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs,statement2,conn);
        }
    }

    public static void closeAll(ResultSet resultSet,Statement st,Connection connection){
        try {
            if (resultSet!=null)
                resultSet.close();
            if (st!=null)
                st.close();
            if (connection!=null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
