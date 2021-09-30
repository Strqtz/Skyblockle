package com.strqtz.skyblockle.utils;

import com.strqtz.skyblockle.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GiveGuiPages implements IGUI{
    private int _currentPage = 1;

    public FileConfiguration customConfig;

    @Override
    public Inventory getInventory() {

        Inventory GUI = Bukkit.createInventory(this, 54, "Give Menu Page: " + _currentPage);

        for(int slot=1;slot<=10;slot++) {

        }

        if(_currentPage == 1) {

            GUI.setItem(4, new ItemStack(Material.BARRIER));
            GUI.setItem(0, new ItemStack(Material.ARROW));
            GUI.setItem(8, new ItemStack(Material.ARROW));
            if (customConfig.getBoolean("item.AspectOfTheEnd", true)) {
                GUI.setItem(10, ItemManager.AspectEnd);
            }else if (customConfig.getBoolean("item.aspectOfTheEnd", false)) {
                GUI.setItem(10, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
            }
        }
        else if(_currentPage == 2) {
            GUI.setItem(4, new ItemStack(Material.BARRIER));
        }
        return GUI;
    }

    @Override
    public void onGUIClick(Player whoClicked, int slot, ItemStack clickedItem) {
        if(clickedItem == null || clickedItem.getType().equals(Material.AIR))
            return;

        if(_currentPage == 1 && slot == 8) {
            whoClicked.openInventory(this.setPage(this.getPage() + 1).getInventory());
        }
        else if(_currentPage == 1 && slot == 10) {
            whoClicked.getInventory().addItem(ItemManager.AspectEnd);
        }
        else if(_currentPage == 1 && slot == 4) {
            whoClicked.closeInventory();
        }
        else if(_currentPage == 2 && slot == 4) {
            whoClicked.closeInventory();
        }
    }

    public GiveGuiPages setPage(int page) {
        if(page < 1)
            _currentPage = 1;
        else if(page > 2)
            _currentPage = 2;
        else
            _currentPage = page;
        return this;
    }

    public int getPage() {
        return _currentPage;
    }
}
