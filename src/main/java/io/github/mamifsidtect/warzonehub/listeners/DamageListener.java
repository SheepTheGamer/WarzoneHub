package io.github.mamifsidtect.warzonehub.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;


public class DamageListener implements Listener {
	
	@EventHandler
	public void onPlayerDamage(EntityDamageEvent event) {
		Entity e = event.getEntity();
		if (e instanceof Player) {
			if (event.getCause() != DamageCause.VOID || event.getCause() != DamageCause.SUICIDE) {
				event.setCancelled(true);
			} else {
				event.setCancelled(false);
			}
		}
	}
}
