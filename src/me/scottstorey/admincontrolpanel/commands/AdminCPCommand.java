package me.scottstorey.admincontrolpanel.commands;

import me.scottstorey.admincontrolpanel.Main;
import me.scottstorey.admincontrolpanel.ui.AdminCP;
import me.scottstorey.admincontrolpanel.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminCPCommand implements CommandExecutor {

    private Main plugin;
    public AdminCPCommand(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("cp").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(sender instanceof Player) {
          Player p = (Player) sender;

          if(p.hasPermission("admincp.open")) {
              p.openInventory(AdminCP.GUI(p));
          } else {
              p.sendMessage(Utils.chat("&4Insufficient Permission"));
          }

        } else {
            sender.sendMessage(Utils.chat("&4You are not a player!"));
        }

        return false;
    }

}
