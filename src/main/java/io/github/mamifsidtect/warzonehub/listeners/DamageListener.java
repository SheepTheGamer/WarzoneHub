package io.github.mamifsidtect.warzonehub.listeners;

import io.github.mamifsidtect.goldengun.managers.ArenaManager;

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
			Player p = (Player) event.getEntity();
			
			//GoldenGun checking (for future games)
			if (ArenaManager.getInstance().getArena(p) == null) {
				if (event.getCause() == DamageCause.VOID || event.getCause() == DamageCause.SUICIDE) {
					event.setCancelled(false);
				} else {
					event.setCancelled(true);
				}
			}
		}
	}
}
