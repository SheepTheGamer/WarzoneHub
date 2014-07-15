package io.github.mamifsidtect.warzonehub.listeners;

import io.github.mamifsidtect.warzonehub.MCTheWarzoneHub;

import java.util.ArrayList;

import org.bukkit.Bukkit;
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

public class LightningRodListener implements Listener {

	public ItemStack lightningrod = new ItemStack(Material.BLAZE_ROD); {
		ItemMeta lrmeta = lightningrod.getItemMeta();
		ArrayList<String> lr = new ArrayList<String>();
		lrmeta.setDisplayName(ChatColor.DARK_GRAY + "Lightning Rod " + ChatColor.RESET + "(Right-Click)");
		lr.add("");
		lr.add(ChatColor.GOLD + "Makes Lightning");
		lrmeta.setLore(lr);
		lightningrod.setItemMeta(lrmeta);
	}
	
	public ArrayList<String> lrodCooldown = new ArrayList<String>();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (p.getItemInHand().equals(lightningrod)) {
				if (!lrodCooldown.contains(p.getName())) {
					p.getWorld().strikeLightning(p.getTargetBlock(null, 200).getLocation());
					lrodCooldown.add(p.getName());
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MCTheWarzoneHub.getPlugin(), new Runnable() {
						public void run() {
							lrodCooldown.remove(p.getName());
						}
					}, 100);
				} else {
					p.sendMessage(ChatColor.RED + "You must wait until you can use the lightning rod again!");
				}
			}
		}
	}
	
	@EventHandler  (priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		if (MCTheWarzoneHub.getPlugin().getConfig().getBoolean("Player Join Items.Lightning Rod.Enabled") == true) {
			p.getInventory().setItem(MCTheWarzoneHub.getPlugin().getConfig().getInt("Player Join Items.Lightning Rod.Inventory Slot") - 1, new ItemStack(lightningrod));
		}
	}
}
