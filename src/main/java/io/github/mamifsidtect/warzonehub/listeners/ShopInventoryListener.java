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

public class ShopInventoryListener implements Listener {
	
	public final ItemStack trails = new ItemStack(Material.GOLD_BOOTS); {
		ItemMeta trmeta = trails.getItemMeta();
		ArrayList<String> tr = new ArrayList<String>();
		trmeta.setDisplayName(ChatColor.GOLD + "Trail Shop");
		tr.add("");
		tr.add(ChatColor.YELLOW + "Buy your trails here! And get to trail blazin'");
		tr.add(ChatColor.YELLOW + "(Sorry, I had to)");
		trmeta.setLore(tr);
		trails.setItemMeta(trmeta);
	}
	
	public final ItemStack pets = new ItemStack(Material.MONSTER_EGG); {
		ItemMeta pmeta = pets.getItemMeta();
		ArrayList<String> p = new ArrayList<String>();
		pmeta.setDisplayName(ChatColor.GOLD + "Pet Shop");
		p.add("");
		p.add(ChatColor.YELLOW + "Ever asked mom or dad for a pet?");
		p.add(ChatColor.YELLOW + "If you have, and they said no, you can finally own one!");
		pmeta.setLore(p);
		pets.setItemMeta(pmeta);
	}
	
	public final ItemStack maps = new ItemStack(Material.EMPTY_MAP); {
		ItemMeta mmeta = maps.getItemMeta();
		ArrayList<String> m = new ArrayList<String>();
		mmeta.setDisplayName(ChatColor.GOLD + "GoldenGun Map Shop");
		m.add("");
		m.add(ChatColor.YELLOW + "Buy some maps here!*");
		m.add(ChatColor.YELLOW + "*(Map writing tools not included)");
		mmeta.setLore(m);
		maps.setItemMeta(mmeta);
	}
	
	public final ItemStack kits = new ItemStack(Material.GOLD_AXE); {
		ItemMeta kmeta = kits.getItemMeta();
		ArrayList<String> k = new ArrayList<String>();
		kmeta.setDisplayName(ChatColor.GOLD + "Kit Shop");
		k.add("");
		k.add(ChatColor.YELLOW + "Destroy people with new kits!");
		k.add(ChatColor.YELLOW + "Or just brag that you own them...");
		kmeta.setLore(k);
		kits.setItemMeta(kmeta);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerShopInventoryClick(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		ItemStack clickedItem = event.getCurrentItem();
		if (clickedItem.equals(kits)) {
			if (event.getInventory().equals(MCTheWarzoneHub.shopMenu)) {
				p.openInventory(MCTheWarzoneHub.kitShopMenu);
				event.setCancelled(true);
				p.updateInventory();
			}
		} else if (clickedItem.equals(maps)) {
			if (event.getInventory().equals(MCTheWarzoneHub.shopMenu)) {
				p.openInventory(MCTheWarzoneHub.mapShopMenu);
				event.setCancelled(true);
				p.updateInventory();
			}
		} else if (clickedItem.equals(pets)) {
			if (event.getInventory().equals(MCTheWarzoneHub.shopMenu)) {
				p.openInventory(MCTheWarzoneHub.petShopMenu);
				event.setCancelled(true);
				p.updateInventory();
			}
		} else if (clickedItem.equals(trails)) {
			if (event.getInventory().equals(MCTheWarzoneHub.shopMenu)) {
				p.openInventory(MCTheWarzoneHub.trailShopMenu);
				event.setCancelled(true);
				p.updateInventory();
			}
		}
	}
}
