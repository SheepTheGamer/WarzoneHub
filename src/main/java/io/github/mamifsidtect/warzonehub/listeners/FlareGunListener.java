package io.github.mamifsidtect.warzonehub.listeners;

import io.github.mamifsidtect.warzonehub.MCTheWarzoneHub;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class FlareGunListener implements Listener {
	
	public void firework(Player player) {
		Firework fw = (Firework) player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
		FireworkMeta fwmeta = fw.getFireworkMeta();
		FireworkEffect.Builder builder = FireworkEffect.builder();
		builder.withTrail();
		builder.withColor(Color.RED);
		builder.withFade(Color.ORANGE);
		builder.with(FireworkEffect.Type.BALL_LARGE);
		fwmeta.addEffects(new FireworkEffect[] {builder.build()});
		fwmeta.setPower(2);
		fw.setFireworkMeta(fwmeta);
	}
	
	public ItemStack flaregun = new ItemStack(Material.GHAST_TEAR); {
		ItemMeta fgmeta = flaregun.getItemMeta();
		ArrayList<String> fg = new ArrayList<String>();
		fgmeta.setDisplayName(ChatColor.GOLD + "Flare Gun " + ChatColor.RESET + "(Right-Click)");
		fg.add("");
		fg.add(ChatColor.YELLOW + "Do you need help?");
		fg.add(ChatColor.YELLOW + "Send a flare!");
		fgmeta.setLore(fg);
		flaregun.setItemMeta(fgmeta);
	}
	
	public ArrayList<String> flaregunCooldown = new ArrayList<String>();
	
	@EventHandler
	public void onFlareGunRightClick(PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (p.getItemInHand().equals(flaregun)) {
			if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (!flaregunCooldown.contains(p.getName())) {
					firework(p);
					flaregunCooldown.add(p.getName());
					Bukkit.getScheduler().scheduleSyncDelayedTask(MCTheWarzoneHub.getPlugin(), new Runnable() {
						public void run() {
							flaregunCooldown.remove(p.getName());
						}
					}, 300);
				} else {
					p.sendMessage(ChatColor.RED + "You must wait before using the flare gun again!");
				}
			}
		}
	}
	
	@EventHandler  (priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		if (MCTheWarzoneHub.getPlugin().getConfig().getBoolean("Player Join Items.Flare Gun.Enabled") == true) {
			p.getInventory().setItem(MCTheWarzoneHub.getPlugin().getConfig().getInt("Player Join Items.Flare Gun.Inventory Slot") - 1, new ItemStack(flaregun));
		}
	}
}
