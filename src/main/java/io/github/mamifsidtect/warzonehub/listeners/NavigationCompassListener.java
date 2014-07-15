package io.github.mamifsidtect.warzonehub.listeners;

import io.github.mamifsidtect.warzonehub.MCTheWarzoneHub;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class NavigationCompassListener implements Listener {

	public ItemStack compass = new ItemStack(Material.COMPASS); {
		ItemMeta cmeta = compass.getItemMeta();
		ArrayList<String> c = new ArrayList<String>();
		cmeta.setDisplayName(ChatColor.YELLOW + "Navigator");
		c.add("");
		c.add(ChatColor.GOLD + "Use this compass to navigate your way around the server");
		c.add(ChatColor.GOLD + "Never be lost again with it");
		cmeta.setLore(c);
		compass.setItemMeta(cmeta);
	}
	
	public ItemStack goldengun = new ItemStack(Material.GOLD_BARDING); {
		ItemMeta ggmeta = goldengun.getItemMeta();
		ArrayList<String> gg = new ArrayList<String>();
		ggmeta.setDisplayName(ChatColor.YELLOW + "Golden Gun");
		gg.add("");
		gg.add(ChatColor.GOLD + "If you want to play some GoldenGun...");
		gg.add(ChatColor.GOLD + "Click here");
		ggmeta.setLore(gg);
		goldengun.setItemMeta(ggmeta);
	}
	
	public ItemStack hub = new ItemStack(Material.BEACON); {
		ItemMeta hmeta = hub.getItemMeta();
		ArrayList<String> h = new ArrayList<String>();
		hmeta.setDisplayName(ChatColor.YELLOW + "The Hub");
		h.add("");
		h.add(ChatColor.YELLOW + "Where it all begins...");
		h.add(ChatColor.YELLOW + "The hub");
		hmeta.setLore(h);
		hub.setItemMeta(hmeta);
	}
	
	public ItemStack vault = new ItemStack(Material.ENDER_CHEST); {
		ItemMeta vmeta = vault.getItemMeta();
		ArrayList<String> v = new ArrayList<String>();
		vmeta.setDisplayName(ChatColor.YELLOW + "Gun Vault");
		v.add("");
		v.add(ChatColor.GOLD + "Come and take a look at all the guns we have to offer");
		v.add(ChatColor.GOLD + "There are a lot of them");
		vmeta.setLore(v);
		vault.setItemMeta(vmeta);
	}
	
	public Location goldengunloc = new Location(Bukkit.getWorld("Lobby"), -94.5, 100, 335.5, 270, 7);
	public Location hubloc = new Location(Bukkit.getWorld("Lobby"), -15.5, 110, 256.5, 0, 0);
	public Location vaultloc = new Location(Bukkit.getWorld("world"), -12.5, 45, 928.5, 0, 0);
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onPlayerCompassUse(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		Action a = event.getAction();
		if (p.getItemInHand().equals(compass)) {
			if (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
				p.openInventory(MCTheWarzoneHub.compassMenu);
			}
		}
	}
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onCompassMenuClick(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		ItemStack itemClicked = event.getCurrentItem();
		if (event.getInventory().equals(MCTheWarzoneHub.compassMenu)) {
			if (itemClicked.equals(goldengun)) {
				p.teleport(goldengunloc);
				event.setCancelled(true);
			} else if (itemClicked.equals(hub)) {
				p.teleport(hubloc);
				event.setCancelled(true);
			} else if (itemClicked.equals(vault)) {
				p.teleport(vaultloc);
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		p.getInventory().setItem(MCTheWarzoneHub.getPlugin().getConfig().getInt("Player Join Items.Navigator.Inventory Slot") - 1, new ItemStack(compass));
	}
}
