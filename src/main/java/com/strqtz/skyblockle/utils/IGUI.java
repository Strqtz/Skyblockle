package com.strqtz.skyblockle.utils;

import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public interface IGUI extends InventoryHolder {
    public void onGUIClick(Player whoClicked, int slot, ItemStack clickedItem);
}
