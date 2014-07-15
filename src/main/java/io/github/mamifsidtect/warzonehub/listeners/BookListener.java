package io.github.mamifsidtect.warzonehub.listeners;

import io.github.mamifsidtect.warzonehub.MCTheWarzoneHub;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class BookListener implements Listener {

	public ItemStack book = new ItemStack(Material.WRITTEN_BOOK); {
		BookMeta bmeta = (BookMeta) book.getItemMeta();
		ArrayList<String> blore = new ArrayList<String>();
		blore.add(ChatColor.YELLOW + "Everything you need to know about the server");
		blore.add(ChatColor.YELLOW + "All contained in this one book");
		
		bmeta.addPage("");
		bmeta.addPage("");
		bmeta.addPage("");
		
		//page 1
		bmeta.setPage(1, ChatColor.BOLD + "Welcome to " + ChatColor.RESET + "" 
						+ ChatColor.GOLD + "MCTheWarzone! " + ChatColor.BOLD + "" + 
						ChatColor.BLACK + "We are a brand new gun-based minigame server! "
						+ " We hope you enjoy your stay and please leave any"
						+ " feedback on the forums!");
		
		//page 2
		bmeta.setPage(2, ChatColor.DARK_RED + "Rules                        "
				+ "                           "
				+ ChatColor.BLACK + "" + ChatColor.BOLD + "1.) No unapproved mods.                      "
				+ "                 2.) No advertising"
				+ "                        3.) Do not abuse or exploit bugs or glitches"
				+ "                                  4.) Respect all staff and players");
		
		bmeta.setAuthor("MCTheWarzone");
		bmeta.setDisplayName(ChatColor.GOLD + "Welcome to MCTheWarzone!");
		bmeta.setLore(blore);
		book.setItemMeta(bmeta);
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.getPlayer().getInventory().setItem(MCTheWarzoneHub.getPlugin().getConfig().getInt("Player Join Items.Welcome Book.Inventory Slot") - 1, new ItemStack(book));	
	}
}
