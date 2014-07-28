package io.github.mamifsidtect.warzonehub.listeners;

import io.github.mamifsidtect.warzonehub.MCTheWarzoneHub;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class KitShopInventoryListener implements Listener {
	
	public static ScoreboardListener sl = new ScoreboardListener();
	
	public ItemStack slugger = new ItemStack(Material.STONE_SPADE); {
		ItemMeta smeta = slugger.getItemMeta();
		ArrayList<String> s = new ArrayList<String>();
		smeta.setDisplayName(ChatColor.YELLOW + "Slugger Kit");
		s.add("");
		s.add(ChatColor.GOLD + "Primary Weapon: M26");
		s.add(ChatColor.GOLD + "Secondary Weapon: Handcannon");
		s.add(ChatColor.GOLD + "Tactical Grenade: 1 Shock Charge");
		s.add(ChatColor.GOLD + "Lethal Grenade: 1 Grenade");
		smeta.setLore(s);
		slugger.setItemMeta(smeta);
	}
	
	public ItemStack heavy = new ItemStack(Material.IRON_HOE); {
		ItemMeta hmeta = heavy.getItemMeta();
		ArrayList<String> h = new ArrayList<String>();
		hmeta.setDisplayName(ChatColor.YELLOW + "Heavy Kit");
		h.add("");
		h.add(ChatColor.GOLD + "Primary Weapon: Minigun");
		h.add(ChatColor.GOLD + "Secondary Weapon: M1911");
		h.add(ChatColor.GOLD + "Tactical Grenade: 2 Shock Charges");
		h.add(ChatColor.GOLD + "Lethal Grenade: 2 Grenades");
		hmeta.setLore(h);
		heavy.setItemMeta(hmeta);
	}
	
	public void givePermission(Player p, String permission) {
		MCTheWarzoneHub.perms.playerAdd(p, permission);
	}
	
	@SuppressWarnings("deprecation")
	public void takeMoney(Player p, Double money) {
		MCTheWarzoneHub.econ.withdrawPlayer(p.getName(), money);
	}
	
	@SuppressWarnings("deprecation")
	public boolean playerHasEnoughMoney(Player p, Double money) {
		if (MCTheWarzoneHub.econ.getBalance(p.getName()) >= money) {
			return true;
		}
		
		return false;
	}
	
	public boolean playerHasPermission(Player p, String permission) {
		if (MCTheWarzoneHub.perms.playerHas(p, permission)) {
			return true;
		}
		
		return false;
	}
	
	@EventHandler
	public void onSluggerBuy(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		if (event.getInventory().equals(MCTheWarzoneHub.kitShopMenu)) {
			if (event.getCurrentItem().equals(slugger)) {
				if (!playerHasPermission(p, "goldengun.kits.slugger")) {
					if (playerHasEnoughMoney(p, (double) 150)) {
						event.setCancelled(true);
						takeMoney(p, (double) 150);
						givePermission(p, "goldengun.kits.slugger");
						sl.sendScoreboardToPlayer(p);
						p.sendMessage(ChatColor.GREEN + "You have successfully bought the Slugger kit!");
					} else {
						event.setCancelled(true);
						p.sendMessage(ChatColor.RED + "You do not have enough money for this kit!");
					}
				} else {
					p.sendMessage(ChatColor.YELLOW + "You already have this kit!");
					event.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void onHeavyBuy(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		if (event.getInventory().equals(MCTheWarzoneHub.kitShopMenu)) {
			if (event.getCurrentItem().equals(heavy)) {
				if (!playerHasPermission(p, "goldengun.kits.heavy")) {
					if (playerHasEnoughMoney(p, (double) 150)) {
						event.setCancelled(true);
						takeMoney(p, (double) 150);
						givePermission(p, "goldengun.kits.heavy");
						sl.sendScoreboardToPlayer(p);
						p.sendMessage(ChatColor.GREEN + "You have successfully bought the Heavy kit!");
					} else {
						event.setCancelled(true);
						p.sendMessage(ChatColor.RED + "You do not have enough money for this kit!");
					}
				} else {
					p.sendMessage(ChatColor.YELLOW + "You already have this kit!");
					event.setCancelled(true);
				}
			}
		}
	}
}
