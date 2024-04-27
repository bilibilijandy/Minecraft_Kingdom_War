package org.jandy.minecraft_kingdom_war.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLite {
    private static Connection connection;

    public static void connectToDatabase() {
        try {
            String url = "jdbc:sqlite:/data.db";
            connection = DriverManager.getConnection(url);
            System.out.println("成功连接到 SQLite 数据库");
        } catch (SQLException e) {
            System.out.println("连接到 SQLite 数据库失败");
            e.printStackTrace();
        }
    }

    public static void disconnectFromDatabase() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("已断开与 SQLite 数据库的连接");
            } catch (SQLException e) {
                System.out.println("关闭数据库连接时出现错误");
                e.printStackTrace();
            }
        }
    }
}
