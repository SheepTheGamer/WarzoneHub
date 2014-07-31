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
		bmeta.addPage("");
		
		//page 1
		bmeta.setPage(1, "§lWelcome to"
				+ "§r§6 MCTheWarzoneHub! §0§lWe"
				+ "§r§l are a brand new"
				+ "§r§l gun-based minigame"
				+ "§r§l server! We hope"
				+ "§r§l you enjoy your"
				+ "§r§l stay and please"
				+ "§r§l leave any"
				+ "§r§l feedback on our"
				+ "§r§l forums!");
		
		//page 2
		bmeta.setPage(2, "§4Rules"
				+ "§r"
				+ "§l1.) No unapproved"
				+ "§r§lmods."
				+ "§r"
				+ "§r§l2.) No advertising"
				+ "§r"
				+ "§r§l3.) Do not abuse"
				+ "§r§lor exploit bugs"
				+ "§r§land glitches"
				+ "§r"
				+ "§r§l4.) Respect all"
				+ "§r§lstaff and players");
		
		//page 3
		bmeta.setPage(3, "§4Links"
				+ "§r"
				+ "§r§5Website and Forums:"
				+ "§rhttp://mcthewarzone.com");
		
		bmeta.setPage(4, "§b§lThank you once"
				+ "§r§b§lagain for joining"
				+ "§r§b§lus on §r§6MCTheWarzone"
				+ "§r§b§land we hope you"
				+ "§r§b§lenjoy your stay!"
				+ "§r§lIf you enjoy the"
				+ "§r§lserver, be sure to"
				+ "§r§lpurhcase a §r§aRANK"
				+ "§r§lto support us at"
				+ "§r"
				+ "§rhttp://mcthewarzone.com");
		
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
