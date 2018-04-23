package com.bird.test;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.Calendar;
import java.util.Random;
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
            statement2 = conn.prepareStatement("insert into sync_user (id,name,password,title) VALUES (?,?,?,?)");
            long index = Calendar.getInstance().getTimeInMillis();
            for (int i = 0; i < 1000000; i++) {//测试是否随机分配到多个实例上写
                statement2.setLong(1, index+i);
                statement2.setString(2, "你好");
                statement2.setInt(3, "HELLO".hashCode());
                statement2.setString(4, doGetRandomChar());
                statement2.addBatch();
                if (i%1000==0){
                    statement2.executeBatch();
                    statement2.clearBatch();
                    conn.commit();
                }
            }
            statement2.executeBatch();
            statement2.clearBatch();
            conn.setAutoCommit(true);
            System.out.println("双主备份写入");

            statement2 = conn.prepareStatement("SELECT COUNT(1) from sync_user");
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
    //随机生成常见汉字
    public static String doGetRandomChar() {
        String s = "";
        for (int i=0;i<80;i++)
            s+=getRandomChar();
        return s;
    }
    public static String getRandomChar() {
        String str = "";
        int highCode;
        int lowCode;

        Random random = new Random();

        highCode = (176 + Math.abs(random.nextInt(39))); //B0 + 0~39(16~55) 一级汉字所占区
        lowCode = (161 + Math.abs(random.nextInt(93))); //A1 + 0~93 每区有94个汉字

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(highCode)).byteValue();
        b[1] = (Integer.valueOf(lowCode)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

}
