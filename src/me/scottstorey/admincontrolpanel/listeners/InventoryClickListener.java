package me.scottstorey.admincontrolpanel.listeners;

import me.scottstorey.admincontrolpanel.Main;
import me.scottstorey.admincontrolpanel.ui.AdminCP;
import me.scottstorey.admincontrolpanel.ui.AdminTools;
import me.scottstorey.admincontrolpanel.ui.TimeSettings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    private Main plugin;
    public InventoryClickListener(Main plugin){
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        String title = e.getView().getTitle();
        if (title.equals(AdminCP.inventory_name)) {
            e.setCancelled(true);
            if(e.getCurrentItem() == null){
                return;
            }
            if(title.equals(AdminCP.inventory_name)){
                AdminCP.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
            }
        }
        if (title.equals(TimeSettings.inventory_name)) {
            e.setCancelled(true);
            if(e.getCurrentItem() == null){
                return;
            }
            if(title.equals(TimeSettings.inventory_name)){
                TimeSettings.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
            }
        }
        if (title.equals(AdminTools.inventory_name)) {
            e.setCancelled(true);
            if(e.getCurrentItem() == null){
                return;
            }
            if(title.equals(AdminTools.inventory_name)){
                AdminTools.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
            }
        }

    }
}
