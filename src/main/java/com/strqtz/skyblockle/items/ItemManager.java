package com.strqtz.skyblockle.items;

import net.minecraft.server.v1_16_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack AspectEnd;
    public static ItemStack RogueSword;

    public static void aoteinit() {
        createAspectEnd();
    }
    public static void rogueSwordinit() {
        createRogueSword();
    }

    private static void createAspectEnd() {

        String name = "Aspect of the End";

        ItemStack itemaote = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = itemaote.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + name);
        List<String> lore = new ArrayList<>();
        lore.add("§6Harness the Power of Endermen");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        itemaote.setItemMeta(meta);
        net.minecraft.server.v1_16_R3.ItemStack nmsaote = CraftItemStack.asNMSCopy(itemaote);
        NBTTagCompound compound = (nmsaote.hasTag()) ? nmsaote.getTag() : new NBTTagCompound();

        NBTTagList modifiers = new NBTTagList();

        NBTTagCompound aoteCompound = new NBTTagCompound();

        aoteCompound.set("AttributeName", NBTTagString.a("tuners"));
        aoteCompound.set("Name", NBTTagString.a("tuners"));
        aoteCompound.set("Amount", NBTTagInt.a(1));
        aoteCompound.set("Operation", NBTTagInt.a(0));
        aoteCompound.set("UUIDLeast", NBTTagInt.a(894654));
        aoteCompound.set("UUIDMost", NBTTagInt.a(2872));
        modifiers.add(aoteCompound);

        compound.set("AttributeModifiers", modifiers);
        nmsaote.setTag(compound);

        AspectEnd = itemaote;

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("aspectend"), itemaote);
        sr.shape(" E ",
                 " E ",
                 " S ");
        sr.setIngredient('E', Material.ENDER_PEARL);
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createRogueSword() {
        ItemStack itemroguesword = new ItemStack(Material.GOLDEN_SWORD);
        ItemMeta meta = itemroguesword.getItemMeta();
        meta.setDisplayName("§aRogue Sword");
        List<String> lore = new ArrayList<>();
        lore.add("Right Click");
        lore.add("§6to Increase your speed by 10% each right click");
        lore.add("§6for 30 seconds!");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        itemroguesword.setItemMeta(meta);
        RogueSword = itemroguesword;
    }

}


