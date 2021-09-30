package com.strqtz.skyblockle.commands;

import com.strqtz.skyblockle.items.ItemManager;
import com.strqtz.skyblockle.utils.GiveGui;
import com.strqtz.skyblockle.utils.GiveGuiPages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SkyblockGiveCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command!");
            return true;
        }
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("sbgive")) {
            GiveGuiPages gui = new GiveGuiPages();
            player.openInventory(gui.getInventory());
        }
        return true;
    }
}
