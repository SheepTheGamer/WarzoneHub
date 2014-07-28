package io.github.mamifsidtect.warzonehub.listeners;

import io.github.mamifsidtect.warzonehub.MCTheWarzoneHub;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopStickListener implements Listener {

	public ItemStack shopemerald = new ItemStack(Material.DIAMOND); {
		ItemMeta semeta = shopemerald.getItemMeta();
		ArrayList<String> se = new ArrayList<String>();
		semeta.setDisplayName(ChatColor.GOLD + "Shop");
		se.add("");
		se.add(ChatColor.YELLOW + "Opens up the shop");
		semeta.setLore(se);
		shopemerald.setItemMeta(semeta);
	}
	
	@EventHandler
	public void onShopStickInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if (p.getItemInHand().equals(shopemerald)) {
			if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (MCTheWarzoneHub.perms.playerHas(p, "hub.shop.testing")) {
					p.openInventory(MCTheWarzoneHub.shopMenu);
				} else {
					p.sendMessage(ChatColor.RED + "The shop is still in development");
					p.sendMessage(ChatColor.RED + "Check back later, to see if it has changed");
				}
			}
		}
	}
	
	@EventHandler  (priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		p.getInventory().setItem(MCTheWarzoneHub.getPlugin().getConfig().getInt("Player Join Items.Shop Stick.Inventory Slot") - 1, new ItemStack(shopemerald));
	}
}
