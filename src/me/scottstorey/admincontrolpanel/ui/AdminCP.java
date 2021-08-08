package me.scottstorey.admincontrolpanel.ui;

import me.scottstorey.admincontrolpanel.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class AdminCP {

    public static Inventory inv;
    public static String inventory_name;
    public static int rows = 2;
    public static int inv_rows = rows * 9;

    public static void initialize() {
        inventory_name = Utils.chat("&6&lAdmin Control Panel");

        inv = Bukkit.createInventory(null, inv_rows);
    }

    public static Inventory GUI (Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows, inventory_name);

        Utils.createItem(inv, Material.RED_WOOL, 1, 5, "&4&lTime Settings");
        Utils.createItem(inv, Material.DIAMOND_SWORD, 1, 3, "&4&lAdmin Tools");
        Utils.createItem(inv, Material.BARRIER, 1, 18, "&4&lReturn");

        toReturn.setContents(inv.getContents());
        return toReturn;
    }

    public static void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&4&lTime Settings"))){
            p.openInventory(TimeSettings.GUI(p));
        }
        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&4&lAdmin Tools"))){
            p.openInventory(AdminTools.GUI(p));
        }
        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&4&lReturn"))){
            p.closeInventory();
        }
    }

}
