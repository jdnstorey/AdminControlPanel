package me.scottstorey.admincontrolpanel.ui;

import me.scottstorey.admincontrolpanel.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class AdminTools {

    public static Inventory inv;
    public static String inventory_name;
    public static int rows = 2;
    public static int inv_rows = rows * 9;

    public static ArrayList<Player> flying = new ArrayList<>();
    public static ArrayList<Player> god = new ArrayList<>();

    public static void initialize() {
        inventory_name = Utils.chat("&6&lTime Settings");

        inv = Bukkit.createInventory(null, inv_rows);
    }

    public static Inventory GUI (Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows, inventory_name);

        Utils.createItem(inv, Material.FEATHER, 1, 2, "&4&lFly");
        Utils.createItem(inv, Material.ENCHANTED_GOLDEN_APPLE, 1, 4, "&4&lHeal");
        Utils.createItem(inv, Material.COOKED_BEEF, 1, 6, "&4&lFeed");
        Utils.createItem(inv, Material.GOLD_INGOT, 1, 8, "&4&lGod Mode");

        Utils.createItem(inv, Material.BARRIER, 1, 14, "&4&lReturn");

        toReturn.setContents(inv.getContents());
        return toReturn;
    }

    public static void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&4&lFly"))){
            if(!flying.contains(p)) {
                p.sendMessage(Utils.chat("&8Enabled flight for &2" + p.getName()));
                p.setAllowFlight(true);
                flying.add(p);
            } else {
                p.sendMessage(Utils.chat("&8Disabled flight for &2" + p.getName()));
                p.setAllowFlight(false);
                flying.remove(p);
            }
            p.closeInventory();
        }
        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&4&lGod Mode"))){
            if(!god.contains(p)) {
                p.sendMessage(Utils.chat("&8Enabled god mode for &2" + p.getName()));
                p.setInvulnerable(true);
                god.add(p);
            } else {
                p.sendMessage(Utils.chat("&8Disabled god mode for &2" + p.getName()));
                p.setInvulnerable(false);
                god.remove(p);
            }
            p.closeInventory();
        }
        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&4&lHeal"))){
            p.sendMessage(Utils.chat("&8Healed &2" + p.getName()));
            p.setHealth(20);
            p.closeInventory();
        }
        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&4&lFeed"))){
            p.sendMessage(Utils.chat("&8Fed &2" + p.getName()));
            p.setFoodLevel(20);
            p.closeInventory();
        }

        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&4&lReturn"))){
            p.openInventory(AdminCP.GUI(p));
        }
    }

}


