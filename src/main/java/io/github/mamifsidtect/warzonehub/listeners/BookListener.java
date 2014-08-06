package io.github.mamifsidtect.warzonehub.listeners;

import io.github.mamifsidtect.warzonehub.MCTheWarzoneHub;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
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
		bmeta.setPage(1, "§lWelcome to"
				+ "§r§6 MCTheWarzone! §0§lWe"
				+ "§r§l are a brand new"
				+ "§r§l gun-based minigame"
				+ "§r§l server! We hope"
				+ "§r§l you enjoy your"
				+ "§r§l stay and please"
				+ "§r§l leave any"
				+ "§r§l feedback on our"
				+ "§r§l forums!");
		
		//page 2
		bmeta.setPage(2, "§4Rules§0"
				+ "§r "
				+ "§r "
				+ "§r§l 1.) No unapproved"
				+ "§r§l mods."
				+ "§r "
				+ "§r "
				+ "§r§l 2.) No advertising"
				+ "§r "
				+ "§r "
				+ "§r "
				+ "§r§l 3.) Do not abuse"
				+ "§r§l or exploit bugs and"
				+ "§r§l glitches"
				+ "§r "
				+ "§r "
				+ "§r§l 4.) Respect all"
				+ "§r§l staff and players");
				
		//page 3
		bmeta.setPage(3, "§b§lThank you once"
				+ "§b§l again for joining"
				+ "§b§l us on §6MCTheWarzone"
				+ "§b§l and we hope you"
				+ "§b§l enjoy your stay!"
				+ "§r§l "
				+ "§r§l If you enjoy the"
				+ "§r§l server, be sure to"
				+ "§r§l purhcase a §aRANK"
				+ "§r§l to support us at"
				+ "§r "
				+ "§r http://mcthewarzone.com");
		
		bmeta.setAuthor("MCTheWarzone");
		bmeta.setDisplayName(ChatColor.GOLD + "Welcome to MCTheWarzone!");
		bmeta.setLore(blore);
		book.setItemMeta(bmeta);
	}

	@EventHandler (priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.getPlayer().getInventory().setItem(MCTheWarzoneHub.getPlugin().getConfig().getInt("Player Join Items.Welcome Book.Inventory Slot") - 1, new ItemStack(book));	
	}
}
