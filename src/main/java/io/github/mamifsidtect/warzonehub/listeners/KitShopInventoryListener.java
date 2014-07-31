package io.github.mamifsidtect.warzonehub.listeners;

import io.github.mamifsidtect.warzonehub.MCTheWarzoneHub;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class KitShopInventoryListener implements Listener {
	
	public static ScoreboardListener sl = new ScoreboardListener();
	
	public final ItemStack marksman = new ItemStack(Material.GOLD_HOE);{
		ItemMeta marksmanmeta = marksman.getItemMeta();
		ArrayList<String> mn = new ArrayList<String>();
		marksmanmeta.setDisplayName(ChatColor.GRAY + "Marksman Loadout");
		mn.add("");
		mn.add(ChatColor.GOLD + "Primary Weapon: SV98");
		mn.add(ChatColor.GOLD + "Secondary Weapon: Python");
		mn.add(ChatColor.GOLD + "Tactical Grenade: 1 Flashbang");
		mn.add(ChatColor.GOLD + "Lethal Grenade: 1 Putty");
		marksmanmeta.setLore(mn);
		marksman.setItemMeta(marksmanmeta);
	}
	
	public final ItemStack predator = new ItemStack(Material.IRON_AXE);{
		ItemMeta predatormeta = predator.getItemMeta();
		ArrayList<String> pr = new ArrayList<String>();
		predatormeta.setDisplayName(ChatColor.GRAY + "Predator Loadout");
		pr.add("");
		pr.add(ChatColor.GOLD + "Primary Weapon: SPAS12");
		pr.add(ChatColor.GOLD + "Secondary Weapon: Desert Eagle");
		pr.add(ChatColor.GOLD + "Tactical Grenade: 1 Shock Charge");
		pr.add(ChatColor.GOLD + "Lethal Grenades: 2 Grenade");
		predatormeta.setLore(pr);
		predator.setItemMeta(predatormeta);
	}
	
	public final ItemStack tactical = new ItemStack(Material.GOLD_SPADE);{
		ItemMeta tacmeta = tactical.getItemMeta();
		ArrayList<String> gr = new ArrayList<String>();
		tacmeta.setDisplayName(ChatColor.GRAY + "Tactical Loadout");
		gr.add("");
		gr.add(ChatColor.GOLD + "Primary Weapon: M16");
		gr.add(ChatColor.GOLD + "Secondary Weapon: Desert Eagle");
		gr.add(ChatColor.GOLD + "Lethal Grenade: 1 Grenade");
		gr.add(ChatColor.GOLD + "Tactical Grenades: 2 Shock Charges, 2 Flashbangs");
		tacmeta.setLore(gr);
		tactical.setItemMeta(tacmeta);
	}
	
	public final ItemStack assassin = new ItemStack(Material.DIAMOND_HOE);{
		ItemMeta assassinmeta = assassin.getItemMeta();
		ArrayList<String> an = new ArrayList<String>();
		assassinmeta.setDisplayName(ChatColor.GREEN + "Assassin Loadout");
		an.add("");
		an.add(ChatColor.GOLD + "Primary Weapon: XM500");
		an.add(ChatColor.GOLD + "Secondary Weapon: Python");
		an.add(ChatColor.GOLD + "Tactical Grenades: 2 Flashbangs, 1 Shock Charge");
		an.add(ChatColor.GOLD + "Lethal Grenade: 1 Grenade");
		assassinmeta.setLore(an);
		assassin.setItemMeta(assassinmeta);
	}
	
	public final ItemStack stalker = new ItemStack(Material.DIAMOND_AXE);{
		ItemMeta stalkermeta = stalker.getItemMeta();
		ArrayList<String> sr = new ArrayList<String>();
		stalkermeta.setDisplayName(ChatColor.GREEN + "Stalker Loadout");
		sr.add("");
		sr.add(ChatColor.GOLD + "Primary Weapon: Olympia");
		sr.add(ChatColor.GOLD + "Secondary Weapon: Python");
		sr.add(ChatColor.GOLD + "Tactical Grenades: 1 Flashbang, 1 Shock Charge");
		sr.add(ChatColor.GOLD + "Lethal Grenades: 2 Grenades");
		stalkermeta.setLore(sr);
		stalker.setItemMeta(stalkermeta);
	}
	
	public final ItemStack soldier = new ItemStack(Material.DIAMOND_SPADE);{
		ItemMeta soldiermeta = soldier.getItemMeta();
		ArrayList<String> sor = new ArrayList<String>();
		soldiermeta.setDisplayName(ChatColor.GREEN + "Soldier Loadout");
		sor.add("");
		sor.add(ChatColor.GOLD + "Primary Weapon: AK47");
		sor.add(ChatColor.GOLD + "Secondary Weapon: Python");
		sor.add(ChatColor.GOLD + "Tactical Grenades: 1 Flashbang, 2 Shock Charges");
		sor.add(ChatColor.GOLD + "Lethal Grenade: 1 Putty");
		soldiermeta.setLore(sor);
		soldier.setItemMeta(soldiermeta);
	}
	
	public final ItemStack grenadier = new ItemStack(Material.DIAMOND_BARDING); {
		ItemMeta gmeta = grenadier.getItemMeta();
		ArrayList<String> g = new ArrayList<String>();
		gmeta.setDisplayName(ChatColor.GREEN + "Grenadier Loadout");
		g.add("");
		g.add(ChatColor.GOLD + "Primary Weapon: Grenade Launcher");
		g.add(ChatColor.GOLD + "Secondary Weapon: M1911");
		g.add(ChatColor.GOLD + "Tactical Grenades: 2 Flashbangs, 2 Shock Charges");
		gmeta.setLore(g);
		grenadier.setItemMeta(gmeta);
	}
	
	public ItemStack slugger = new ItemStack(Material.STONE_SPADE); {
		ItemMeta smeta = slugger.getItemMeta();
		ArrayList<String> s = new ArrayList<String>();
		smeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Slugger Loadout");
		s.add("");
		s.add(ChatColor.GOLD + "Primary Weapon: M26");
		s.add(ChatColor.GOLD + "Secondary Weapon: Handcannon");
		s.add(ChatColor.GOLD + "Tactical Grenades: 1 Shock Charge, 1 Flashbang");
		s.add(ChatColor.GOLD + "Lethal Grenades: 2 Grenades");
		smeta.setLore(s);
		slugger.setItemMeta(smeta);
	}
	
	public ItemStack heavy = new ItemStack(Material.IRON_HOE); {
		ItemMeta hmeta = heavy.getItemMeta();
		ArrayList<String> h = new ArrayList<String>();
		hmeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Heavy Loadout");
		h.add("");
		h.add(ChatColor.GOLD + "Primary Weapon: Minigun");
		h.add(ChatColor.GOLD + "Secondary Weapon: M1911");
		h.add(ChatColor.GOLD + "Tactical Grenade: 2 Shock Charges");
		h.add(ChatColor.GOLD + "Lethal Grenade: 2 Grenades");
		hmeta.setLore(h);
		heavy.setItemMeta(hmeta);
	}
	
	public final ItemStack iingot = new ItemStack(Material.IRON_INGOT, 1);{
		ItemMeta iimeta = iingot.getItemMeta();
		ArrayList<String> i = new ArrayList<String>();
		iimeta.setDisplayName(ChatColor.AQUA + "Plus Loadouts");
		i.add("");
		i.add(ChatColor.GOLD + "If you do not have any of these loadouts");
		i.add(ChatColor.GOLD + "you can purchase them in the dogtag shop");
		i.add(ChatColor.GOLD + "or unlock it immediately by purchasing a rank");
		i.add(ChatColor.GOLD + "at http://mcthewarzone.com/shop");
		iimeta.setLore(i);
		iingot.setItemMeta(iimeta);
	}
	
	public final ItemStack gingot = new ItemStack(Material.GOLD_INGOT, 1);{
		ItemMeta gimeta = gingot.getItemMeta();
		ArrayList<String> g = new ArrayList<String>();
		gimeta.setDisplayName(ChatColor.GREEN + "Premium Loadouts");
		g.add("");
		g.add(ChatColor.GOLD + "If you do not have any of these loadouts");
		g.add(ChatColor.GOLD + "you can purchase them in the dogtag shop");
		g.add(ChatColor.GOLD + "or unlock it immediately by purchasing a rank");
		g.add(ChatColor.GOLD + "at http://mcthewarzone.com/shop");
		gimeta.setLore(g);
		gingot.setItemMeta(gimeta);
	}
	
	public final ItemStack dogtags = new ItemStack(Material.NAME_TAG, 1); {
		ItemMeta dtmeta = dogtags.getItemMeta();
		ArrayList<String> dt = new ArrayList<String>();
		dtmeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Dogtag Loadouts");
		dt.add("");
		dt.add(ChatColor.GOLD + "If you do not have any of these loadouts");
		dt.add(ChatColor.GOLD + "Purchase them in the Dogtag Shop");
		dtmeta.setLore(dt);
		dogtags.setItemMeta(dtmeta);
	}
	
	@SuppressWarnings("deprecation")
	public void givePermission(String world, Player p, String permission) {
		MCTheWarzoneHub.perms.playerAdd(Bukkit.getServer().getWorld(world), p.getName(), permission);
	}
	
	@SuppressWarnings("deprecation")
	public void takeMoney(Player p, Double money) {
		MCTheWarzoneHub.econ.withdrawPlayer(p.getName(), money);
	}
	
	@SuppressWarnings("deprecation")
	public boolean playerHasEnoughMoney(Player p, Double money) {
		if (MCTheWarzoneHub.econ.getBalance(p.getName()) >= money) {
			return true;
		}
		
		return false;
	}
	
	public boolean playerHasPermission(Player p, String permission) {
		if (MCTheWarzoneHub.perms.playerHas(p, permission)) {
			return true;
		}
		
		return false;
	}
	
	@EventHandler
	public void onPlusMenuOpenerClick(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		if (event.getInventory().equals(MCTheWarzoneHub.kitShopMenu)) {
			if (event.getCurrentItem().equals(iingot)) {
				event.setCancelled(true);
				p.openInventory(MCTheWarzoneHub.chiefKits);
			}
		}
	}
	
	@EventHandler
	public void onPremiumMenuOpenerClick(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		if (event.getInventory().equals(MCTheWarzoneHub.kitShopMenu)) {
			if (event.getCurrentItem().equals(gingot)) {
				event.setCancelled(true);
				p.openInventory(MCTheWarzoneHub.captainKits);
			}
		}
	}
	
	@EventHandler
	public void onDogtagMenuOpenerClick(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		if (event.getInventory().equals(MCTheWarzoneHub.kitShopMenu)) {
			if (event.getCurrentItem().equals(dogtags)) {
				event.setCancelled(true);
				p.openInventory(MCTheWarzoneHub.dogtagKits);
			}
		}
	}
	
	@EventHandler
	public void onMarksmanBuy(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		if (event.getInventory().equals(MCTheWarzoneHub.chiefKits)) {
			if (event.getCurrentItem().equals(marksman)) {
				if (!playerHasPermission(p, "goldengun.kits.marksman")) {
					if (playerHasEnoughMoney(p, (double) 350)) {
						event.setCancelled(true);
						takeMoney(p, (double) 350);
						givePermission("world", p, "goldengun.kits.marksman");
						sl.sendScoreboardToPlayer(p);
						p.sendMessage(ChatColor.GREEN + "You have successfully bought the Marksman kit!");
					} else {
						event.setCancelled(true);
						p.sendMessage(ChatColor.RED + "You do not have enough money for this kit!");
					}
				} else {
					p.sendMessage(ChatColor.YELLOW + "You already have this kit!");
					event.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void onPredatorBuy(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		if (event.getInventory().equals(MCTheWarzoneHub.chiefKits)) {
			if (event.getCurrentItem().equals(predator)) {
				if (!playerHasPermission(p, "goldengun.kits.predator")) {
					if (playerHasEnoughMoney(p, (double) 400)) {
						event.setCancelled(true);
						takeMoney(p, (double) 400);
						givePermission("world", p, "goldengun.kits.predator");
						sl.sendScoreboardToPlayer(p);
						p.sendMessage(ChatColor.GREEN + "You have successfully bought the Predator kit!");
					} else {
						event.setCancelled(true);
						p.sendMessage(ChatColor.RED + "You do not have enough money for this kit!");
					}
				} else {
					p.sendMessage(ChatColor.YELLOW + "You already have this kit!");
					event.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void onTacticalBuy(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		if (event.getInventory().equals(MCTheWarzoneHub.chiefKits)) {
			if (event.getCurrentItem().equals(tactical)) {
				if (!playerHasPermission(p, "goldengun.kits.tactical")) {
					if (playerHasEnoughMoney(p, (double) 550)) {
						event.setCancelled(true);
						takeMoney(p, (double) 550);
						givePermission("world", p, "goldengun.kits.tactical");
						sl.sendScoreboardToPlayer(p);
						p.sendMessage(ChatColor.GREEN + "You have successfully bought the Tactical kit!");
					} else {
						event.setCancelled(true);
						p.sendMessage(ChatColor.RED + "You do not have enough money for this kit!");
					}
				} else {
					p.sendMessage(ChatColor.YELLOW + "You already have this kit!");
					event.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void onAssassinBuy(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		if (event.getInventory().equals(MCTheWarzoneHub.captainKits)) {
			if (event.getCurrentItem().equals(assassin)) {
				if (!playerHasPermission(p, "goldengun.kits.assassin")) {
					if (playerHasEnoughMoney(p, (double) 800)) {
						event.setCancelled(true);
						takeMoney(p, (double) 800);
						givePermission("world", p, "goldengun.kits.assassin");
						sl.sendScoreboardToPlayer(p);
						p.sendMessage(ChatColor.GREEN + "You have successfully bought the Assassin kit!");
					} else {
						event.setCancelled(true);
						p.sendMessage(ChatColor.RED + "You do not have enough money for this kit!");
					}
				} else {
					p.sendMessage(ChatColor.YELLOW + "You already have this kit!");
					event.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void onStalkerBuy(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		if (event.getInventory().equals(MCTheWarzoneHub.captainKits)) {
			if (event.getCurrentItem().equals(stalker)) {
				if (!playerHasPermission(p, "goldengun.kits.stalker")) {
					if (playerHasEnoughMoney(p, (double) 1000)) {
						event.setCancelled(true);
						takeMoney(p, (double) 1000);
						givePermission("world", p, "goldengun.kits.stalker");
						sl.sendScoreboardToPlayer(p);
						p.sendMessage(ChatColor.GREEN + "You have successfully bought the Stalker kit!");
					} else {
						event.setCancelled(true);
						p.sendMessage(ChatColor.RED + "You do not have enough money for this kit!");
					}
				} else {
					p.sendMessage(ChatColor.YELLOW + "You already have this kit!");
					event.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void onSoldierBuy(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		if (event.getInventory().equals(MCTheWarzoneHub.captainKits)) {
			if (event.getCurrentItem().equals(soldier)) {
				if (!playerHasPermission(p, "goldengun.kits.soldier")) {
					if (playerHasEnoughMoney(p, (double) 850)) {
						event.setCancelled(true);
						takeMoney(p, (double) 850);
						givePermission("world", p, "goldengun.kits.soldier");
						sl.sendScoreboardToPlayer(p);
						p.sendMessage(ChatColor.GREEN + "You have successfully bought the Soldier kit!");
					} else {
						event.setCancelled(true);
						p.sendMessage(ChatColor.RED + "You do not have enough money for this kit!");
					}
				} else {
					p.sendMessage(ChatColor.YELLOW + "You already have this kit!");
					event.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void onGrenadierBuy(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		if (event.getInventory().equals(MCTheWarzoneHub.captainKits)) {
			if (event.getCurrentItem().equals(grenadier)) {
				if (!playerHasPermission(p, "goldengun.kits.grenadier")) {
					if (playerHasEnoughMoney(p, (double) 900)) {
						event.setCancelled(true);
						takeMoney(p, (double) 900);
						givePermission("world", p, "goldengun.kits.grenadier");
						sl.sendScoreboardToPlayer(p);
						p.sendMessage(ChatColor.GREEN + "You have successfully bought the Grenadier kit!");
					} else {
						event.setCancelled(true);
						p.sendMessage(ChatColor.RED + "You do not have enough money for this kit!");
					}
				} else {
					p.sendMessage(ChatColor.YELLOW + "You already have this kit!");
					event.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void onSluggerBuy(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		if (event.getInventory().equals(MCTheWarzoneHub.dogtagKits)) {
			if (event.getCurrentItem().equals(slugger)) {
				if (!playerHasPermission(p, "goldengun.kits.slugger")) {
					if (playerHasEnoughMoney(p, (double) 150)) {
						event.setCancelled(true);
						takeMoney(p, (double) 150);
						givePermission("world", p, "goldengun.kits.slugger");
						sl.sendScoreboardToPlayer(p);
						p.sendMessage(ChatColor.GREEN + "You have successfully bought the Slugger kit!");
					} else {
						event.setCancelled(true);
						p.sendMessage(ChatColor.RED + "You do not have enough money for this kit!");
					}
				} else {
					p.sendMessage(ChatColor.YELLOW + "You already have this kit!");
					event.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void onHeavyBuy(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		if (event.getInventory().equals(MCTheWarzoneHub.dogtagKits)) {
			if (event.getCurrentItem().equals(heavy)) {
				if (!playerHasPermission(p, "goldengun.kits.heavy")) {
					if (playerHasEnoughMoney(p, (double) 150)) {
						event.setCancelled(true);
						takeMoney(p, (double) 150);
						givePermission("world", p, "goldengun.kits.heavy");
						sl.sendScoreboardToPlayer(p);
						p.sendMessage(ChatColor.GREEN + "You have successfully bought the Heavy kit!");
					} else {
						event.setCancelled(true);
						p.sendMessage(ChatColor.RED + "You do not have enough money for this kit!");
					}
				} else {
					p.sendMessage(ChatColor.YELLOW + "You already have this kit!");
					event.setCancelled(true);
				}
			}
		}
	}
}
