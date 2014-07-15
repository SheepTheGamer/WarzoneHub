package io.github.mamifsidtect.warzonehub.listeners;

import io.github.mamifsidtect.warzonehub.MCTheWarzoneHub;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

public class JumperListener implements Listener {
	
	public ItemStack jumper = new ItemStack(Material.FEATHER); {
		ItemMeta jmeta = jumper.getItemMeta();
		ArrayList<String> j = new ArrayList<String>();
		jmeta.setDisplayName(ChatColor.AQUA + "Jumper" + ChatColor.RESET + " (Right-Click)");
		j.add("");
		j.add(ChatColor.GOLD + "Fly High!");
		jmeta.setLore(j);
		jumper.setItemMeta(jmeta);
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if (p.getItemInHand().equals(jumper)) {
			if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (p.getLocation().subtract(0, 0.25, 0).getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR) {
					p.setVelocity(p.getLocation().getDirection().multiply(4));
					p.setVelocity(new Vector(p.getVelocity().getX(), 1.5D, p.getVelocity().getZ()));
				}
			}
		}
	}
	
	@EventHandler  (priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		if (MCTheWarzoneHub.getPlugin().getConfig().getBoolean("Player Join Items.Jumper.Enabled") == true) {
			p.getInventory().setItem(MCTheWarzoneHub.getPlugin().getConfig().getInt("Player Join Items.Jumper.Inventory Slot") - 1, new ItemStack(jumper));
		}
	}
}
