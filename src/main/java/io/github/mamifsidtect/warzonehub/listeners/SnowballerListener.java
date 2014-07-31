package io.github.mamifsidtect.warzonehub.listeners;

import io.github.mamifsidtect.warzonehub.MCTheWarzoneHub;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SnowballerListener implements Listener {

	public ItemStack snowballer = new ItemStack(Material.WOOD_SPADE); {
		ItemMeta smeta = snowballer.getItemMeta();
		ArrayList<String> s = new ArrayList<String>();
		smeta.setDisplayName("Snowball Launcher (Right-Click)");
		s.add("");
		s.add(ChatColor.GOLD + "Launches Snowballs....duh");
		smeta.setLore(s);
		snowballer.setItemMeta(smeta);
	}
	
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (p.getItemInHand().equals(snowballer)) {
				Snowball ball = p.getWorld().spawn(p.getEyeLocation(), Snowball.class);
				ball.setShooter(p);
				ball.setVelocity(p.getLocation().getDirection().multiply(1.25));
				p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1, 2);
			}
		}
	}
	
	@EventHandler  (priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		
		event.setJoinMessage(null);
		p.teleport(new Location(Bukkit.getWorld("Lobby"), -15.5, 110, 256.5, 0, 0));
		p.getInventory().clear();
		p.setHealth(20);
		p.setFoodLevel(20);
		
		if (MCTheWarzoneHub.getPlugin().getConfig().getBoolean("Player Join Items.Snowballer.Enabled") == true) {
			p.getInventory().setItem(MCTheWarzoneHub.getPlugin().getConfig().getInt("Player Join Items.Snowballer.Inventory Slot") - 1, new ItemStack(snowballer));
		}
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		event.setQuitMessage(null);
	}
}
