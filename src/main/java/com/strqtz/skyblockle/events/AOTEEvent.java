package com.strqtz.skyblockle.events;

import com.strqtz.skyblockle.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class AOTEEvent implements Listener {

    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.AspectEnd.getItemMeta())) {
                        Player player = event.getPlayer();
                        Location location = player.getLocation();
                        Vector direction = location.getDirection();
                        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getClickedBlock().getType() == (Material.WATER) || event.getClickedBlock().getType() == (Material.LAVA)) {
                                direction.normalize();
                                direction.multiply(8);
                                location.add(direction);
                                player.teleport(location);
                                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 10, 1);
                        } else {
                            player.sendMessage(ChatColor.RED + "Can't teleport through solid blocks");
                        }

                }
            }
        }
    }

}
