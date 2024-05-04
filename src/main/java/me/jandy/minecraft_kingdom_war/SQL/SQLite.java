package me.jandy.minecraft_kingdom_war.SQL;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLite {
    private static Connection connection;

    public static void say(String s){
        CommandSender sender = Bukkit.getConsoleSender();
        sender.sendMessage("[王国战争]"+s);
    }

    public static void connectToDatabase() {
        try {
            String url = "jdbc:sqlite:/data.db";
            connection = DriverManager.getConnection(url);
            say("成功连接到 SQLite 数据库");
        } catch (SQLException e) {
            say("连接到 SQLite 数据库失败");
            e.printStackTrace();
        }
    }

    public static void disconnectFromDatabase() {
        if (connection != null) {
            try {
                connection.close();
                say("已断开与 SQLite 数据库的连接");
            } catch (SQLException e) {
                say("关闭数据库连接时出现错误");
                e.printStackTrace();
            }
        }
    }
}
