package io.github.mamifsidtect.warzonehub.listeners;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;


public class HungerListener implements Listener {

	@EventHandler
	public void playerFoodLevelChange(FoodLevelChangeEvent event) {
		HumanEntity e = event.getEntity();
		if (e instanceof Player) {
			event.setCancelled(true);
		} else {
			event.setCancelled(false);
		}
	}
}
