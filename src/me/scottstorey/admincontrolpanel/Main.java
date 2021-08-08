package me.scottstorey.admincontrolpanel;

import me.scottstorey.admincontrolpanel.commands.AdminCPCommand;
import me.scottstorey.admincontrolpanel.listeners.InventoryClickListener;
import me.scottstorey.admincontrolpanel.ui.AdminCP;
import me.scottstorey.admincontrolpanel.ui.AdminTools;
import me.scottstorey.admincontrolpanel.ui.TimeSettings;
import me.scottstorey.admincontrolpanel.utils.Utils;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        getServer().getConsoleSender().sendMessage(Utils.chat("&4&lAdminControlPanel enabled!"));

        new AdminCPCommand(this);
        new InventoryClickListener(this);

        AdminCP.initialize();
        TimeSettings.initialize();
        AdminTools.initialize();
    }

    public void onDisable() {}

}
