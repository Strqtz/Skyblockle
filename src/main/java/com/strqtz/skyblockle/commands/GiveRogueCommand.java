package com.strqtz.skyblockle.commands;

import com.strqtz.skyblockle.items.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveRogueCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command!");
            return true;
        }
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("giverogue")) {
            player.getInventory().addItem(ItemManager.RogueSword);
            sender.sendMessage("§6Gave You §11 §6Rogue Sword");
        }

        return true;
    }

}
