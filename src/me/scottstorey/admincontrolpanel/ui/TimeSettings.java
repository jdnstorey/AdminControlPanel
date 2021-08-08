package me.scottstorey.admincontrolpanel.ui;

import me.scottstorey.admincontrolpanel.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TimeSettings {

    public static Inventory inv;
    public static String inventory_name;
    public static int rows = 1;
    public static int inv_rows = rows * 9;

    public static void initialize() {
        inventory_name = Utils.chat("&6&lTime Settings");

        inv = Bukkit.createInventory(null, inv_rows);
    }

    public static Inventory GUI (Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows, inventory_name);

        Utils.createItem(inv, Material.BLACK_WOOL, 1, 3, "&4&lNight");
        Utils.createItem(inv, Material.PURPLE_WOOL, 1, 4, "&4&lMorning");
        Utils.createItem(inv, Material.YELLOW_WOOL, 1, 5, "&4&lDay");
        Utils.createItem(inv, Material.ORANGE_WOOL, 1, 6, "&4&lAfternoon");
        Utils.createItem(inv, Material.RED_WOOL, 1, 7, "&4&lEvening");
        Utils.createItem(inv, Material.BARRIER, 1, 9, "&4&lReturn");

        toReturn.setContents(inv.getContents());
        return toReturn;
    }

    public static void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&4&lNight"))){
            p.sendMessage(Utils.chat("&8Time set to &2Night"));
            p.getWorld().setTime(18000);
            p.closeInventory();
        }
        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&4&lMorning"))){
            p.sendMessage(Utils.chat("&8Time set to &2Morning"));
            p.getWorld().setTime(0);
            p.closeInventory();
        }
        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&4&lDay"))){
            p.sendMessage(Utils.chat("&8Time set to &2Day"));
            p.getWorld().setTime(6000);
            p.closeInventory();
        }
        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&4&lAfternoon"))){
            p.sendMessage(Utils.chat("&8Time set to &2Afternoon"));
            p.getWorld().setTime(9000);
            p.closeInventory();
        }
        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&4&lEvening"))){
            p.sendMessage(Utils.chat("&8Time set to &2Evening"));
            p.getWorld().setTime(12000);
            p.closeInventory();
        }
        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&4&lReturn"))){
            p.openInventory(AdminCP.GUI(p));
        }
    }

}


