package com.strqtz.skyblockle.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GiveGui implements IGUI{

    @Override
    public Inventory getInventory() {
        Inventory GUI = Bukkit.createInventory(this, 9, "Give GUI");
        GUI.setItem(4, new ItemStack(Material.BARRIER));
        return GUI;
    }

    @Override
    public void onGUIClick(Player whoClicked, int slot, ItemStack clickedItem) {

        if(clickedItem == null || clickedItem.getType().equals(Material.AIR))
            return;

        if(slot == 1) {
            whoClicked.closeInventory();
        }
    }
}
