package me.jandy.minecraft_kingdom_war;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

//import org.bstats.bukkit.Metrics;
import me.jandy.minecraft_kingdom_war.bStats.Metrics;
import me.clip.placeholderapi.PlaceholderAPI;

import me.jandy.minecraft_kingdom_war.SQL.SQLite;

public final class Minecraft_Kingdom_War extends JavaPlugin implements CommandExecutor {

    public void say(String s){
        CommandSender sender = Bukkit.getConsoleSender();
        sender.sendMessage("[王国战争]"+s);
    }

    public String colour(String str){
        return str.replace('&', '§');
    }

    public void help(CommandSender sender){
        sender.sendMessage("-----[王国战争帮助]-----");
        sender.sendMessage("/kw help ---- 显示帮助菜单");
    }
    @Override
    public void onEnable() {
        // Plugin startup logic

        //bStats
        Metrics metrics = new Metrics(this, 21718);

        say("插件加载成功");
        SQLite.connectToDatabase();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        say("插件已卸载");
        SQLite.disconnectFromDatabase();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
        //CommandSender：输入指令的玩家
        //Command：执行的命令
        //label：被执行命令的别名
        //args：命令参数，如/ping s，s就是参数，args[0]就是s
        say(sender.getName());
        if(label.equalsIgnoreCase("kw")){
            if (args.length < 2){
                sender.sendMessage("使用/kw help查看帮助");
                return true;
            }

            if(args[0].equals("help")){
                help(sender);
            }

            else if (args[0].equals("add")) {
                if(args.length < 3){
                    help(sender);
                }
                else{
                    sender.sendMessage("正在创建王国 "+colour(args[1]));
                    if("等待更改".equals("等待更改1")){

                    }
                }
            }
        }
        return true;
    }

}
