package com.strqtz.skyblockle.events;

import com.strqtz.skyblockle.items.ItemManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffectType;

public class RogueEvent implements Listener {

    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.RogueSword.getItemMeta())) {
                    Player player = event.getPlayer();
                    player.addPotionEffect(PotionEffectType.SPEED.createEffect(600, 4));
                }
            }
        }
    }

}
