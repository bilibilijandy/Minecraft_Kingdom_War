package org.jandy.minecraft_kingdom_war.SQL;

import java.sql.*;

public class SQLite {
    public static void run(){
        Connection connection = null;
        try {
            // 加载 SQLite JDBC 驱动程序
            Class.forName("org.sqlite.JDBC");

            // 创建数据库连接
            String url = "jdbc:sqlite:/path/to/your/database.db";
            connection = DriverManager.getConnection(url);

            // 连接成功，可以执行其他操作

            System.out.println("成功连接到 SQLite 数据库");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到 SQLite JDBC 驱动程序");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("连接到 SQLite 数据库失败");
            e.printStackTrace();
        } finally {
            // 关闭数据库连接
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("关闭数据库连接时出现错误");
                    e.printStackTrace();
                }
            }
        }
    }
}
