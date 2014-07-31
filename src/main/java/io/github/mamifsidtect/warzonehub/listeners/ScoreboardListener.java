package io.github.mamifsidtect.warzonehub.listeners;

import io.github.mamifsidtect.warzonehub.MCTheWarzoneHub;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ScoreboardListener implements Listener {
	
	public void sendScoreboardToPlayer(Player p) {
				
		@SuppressWarnings("deprecation")
		Double playerMoney = MCTheWarzoneHub.econ.getBalance(p.getName());
		String playerRank = MCTheWarzoneHub.perms.getPrimaryGroup(p);
		String playerName = p.getName();
			
		SimpleScoreboard ss = new SimpleScoreboard(ChatColor.GOLD + "MCTheWarzone");
			
		ss.add(ChatColor.GOLD + ">=+=+=+<=>+=+=+=<");
		ss.blankLine();
			
		ss.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Welcome:"); 
		ss.add("" + playerName);
		ss.blankLine();
		
		ss.add(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Rank:"); 
		ss.add("" + playerRank);
		ss.blankLine();
		
		ss.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Dogtags:");
		ss.add("" + playerMoney);
		ss.blankLine();
			
		ss.add(ChatColor.GOLD + ">=+=+=+<=>+=+=+=<");
		
		ss.build();
		ss.send(p);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		sendScoreboardToPlayer(p);
	}
}
