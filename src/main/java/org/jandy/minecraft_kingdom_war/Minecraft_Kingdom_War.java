package org.jandy.minecraft_kingdom_war;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jandy.minecraft_kingdom_war.SQL.SQLite;

public final class Minecraft_Kingdom_War extends JavaPlugin implements CommandExecutor {

    public void say(String s){
        CommandSender sender = Bukkit.getConsoleSender();
        sender.sendMessage("[王国战争]"+s);
    }

    public void help(CommandSender sender){
        sender.sendMessage("-----[王国战争帮助]-----");
        sender.sendMessage("/kw help ---- 显示帮助菜单");
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        say("插件加载成功");
        SQLite.run();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        say("插件已卸载");

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
        //CommandSender：输入指令的玩家
        //Command：执行的命令
        //label：被执行命令的别名
        //args：命令参数，如/ping s，s就是参数，args[0]就是s
        if(label.equalsIgnoreCase("kw")){
            if(args[0].equals("help")){
                help(sender);
            }

            else if (args[0].equals("add")) {
                if(args[1].length() < 0){
                    help(sender);
                }
            }

            else{
                sender.sendMessage("使用/kw help查看帮助");
            }
        }
        return true;
    }

}
