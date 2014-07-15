package io.github.mamifsidtect.warzonehub.listeners;

import io.github.mamifsidtect.warzonehub.MCTheWarzoneHub;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BarkerListener implements Listener {

	public ItemStack barker = new ItemStack(Material.BONE); {
		ItemMeta brmeta = barker.getItemMeta();
		ArrayList<String> b = new ArrayList<String>();
		brmeta.setDisplayName(ChatColor.DARK_AQUA + "Barker" + ChatColor.RESET + " (Right-Click)");
		b.add("");
		b.add(ChatColor.GOLD + "Bark, bark");
		b.add(ChatColor.GOLD + "Goes the dog");
		brmeta.setLore(b);
		barker.setItemMeta(brmeta);
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (p.getItemInHand().equals(barker)) {
				p.playSound(p.getLocation(), Sound.WOLF_BARK, 1, 1);
			}
		}
	}
	
	@EventHandler  (priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		if (MCTheWarzoneHub.getPlugin().getConfig().getBoolean("Player Join Items.Barker.Enabled") == true) {
			p.getInventory().setItem(MCTheWarzoneHub.getPlugin().getConfig().getInt("Player Join Items.Barker.Inventory Slot") - 1, new ItemStack(barker));
		}
	}
}
