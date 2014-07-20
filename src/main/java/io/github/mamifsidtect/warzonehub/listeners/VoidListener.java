package io.github.mamifsidtect.warzonehub.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class VoidListener implements Listener {
	
	@EventHandler
	public void playerVoidFall(PlayerMoveEvent event) {
		Player p = event.getPlayer();
		if (p.getWorld().getName().equalsIgnoreCase("lobby")) {
			if (p.getLocation().getY() <= 18) {
				p.teleport(NavigationCompassListener.getInstance().hubloc);
			}
		}
	}
}
