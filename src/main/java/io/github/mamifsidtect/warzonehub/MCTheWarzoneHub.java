package io.github.mamifsidtect.warzonehub;

import io.github.mamifsidtect.warzonehub.listeners.BarkerListener;
import io.github.mamifsidtect.warzonehub.listeners.BookListener;
import io.github.mamifsidtect.warzonehub.listeners.DamageListener;
import io.github.mamifsidtect.warzonehub.listeners.EquipmentMenuListener;
import io.github.mamifsidtect.warzonehub.listeners.FlareGunListener;
import io.github.mamifsidtect.warzonehub.listeners.HungerListener;
import io.github.mamifsidtect.warzonehub.listeners.JumperListener;
import io.github.mamifsidtect.warzonehub.listeners.KitShopInventoryListener;
import io.github.mamifsidtect.warzonehub.listeners.LightningRodListener;
import io.github.mamifsidtect.warzonehub.listeners.MapShopInventoryListener;
import io.github.mamifsidtect.warzonehub.listeners.NavigationCompassListener;
import io.github.mamifsidtect.warzonehub.listeners.PetShopInventoryListener;
import io.github.mamifsidtect.warzonehub.listeners.ScoreboardListener;
import io.github.mamifsidtect.warzonehub.listeners.ShopInventoryListener;
import io.github.mamifsidtect.warzonehub.listeners.ShopStickListener;
import io.github.mamifsidtect.warzonehub.listeners.SnowballerListener;
import io.github.mamifsidtect.warzonehub.listeners.TrailShopInventoryListener;
import io.github.mamifsidtect.warzonehub.listeners.WeatherChangeListener;

import java.util.logging.Logger;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.dsh105.echopet.api.EchoPetAPI;

public class MCTheWarzoneHub extends JavaPlugin {
	
	//Public variables and such...
	public static Economy econ = null;
	public static Permission perms = null;
	
	public static Inventory kitShopMenu;
	public static Inventory mapShopMenu;
	public static Inventory petShopMenu;
	public static Inventory shopMenu;
	public static Inventory trailShopMenu;
	public static Inventory equipMenu;
	public static Inventory compassMenu;
	public static Inventory chiefKits, captainKits, dogtagKits;
	
	public final ShopInventoryListener sil = new ShopInventoryListener();
	public final PetShopInventoryListener psil = new PetShopInventoryListener();
	public final TrailShopInventoryListener tsil = new TrailShopInventoryListener();
	public final NavigationCompassListener ncl = new NavigationCompassListener();
	public final KitShopInventoryListener ksil = new KitShopInventoryListener();
	public final BookListener bl = new BookListener();
	
	Logger logger = Logger.getLogger("Minecraft");
	
	//Private variables and such...
	
	@Override
	public void onEnable() {
		PluginDescriptionFile pdf = this.getDescription();
		FileConfiguration configuration = this.getConfig();
		PluginManager pm = Bukkit.getServer().getPluginManager();
		
		logger.info("WarzoneHub " + pdf.getVersion() + " has been enabled!");
		
		//Config Stuff
		if (!Bukkit.getServer().getPluginManager().getPlugin("WarzoneHub").getDataFolder().exists()) {
			saveResource("config.yml", true);
		} else {
			logger.info("Using previous config!");
		}
		//End
		
		equipMenu = Bukkit.createInventory(null, configuration.getInt("Inventories.Equipment Menu Screen.Size", 9), ChatColor.BLUE + "Equipment Menu"); {
			
		}
		
		kitShopMenu = Bukkit.createInventory(null, configuration.getInt("Inventories.Kit Shop Screen.Size", 9), ChatColor.BLUE + "Kit Shop"); {
			kitShopMenu.setItem(configuration.getInt("Inventories.Kit Shop Screen.Items.Plus") - 1, new ItemStack(ksil.iingot));
			kitShopMenu.setItem(configuration.getInt("Inventories.Kit Shop Screen.Items.Premium") - 1, new ItemStack(ksil.gingot));
			kitShopMenu.setItem(configuration.getInt("Inventories.Kit Shop Screen.Items.Dogtags") - 1, new ItemStack(ksil.dogtags));
		}		
		mapShopMenu = Bukkit.createInventory(null, configuration.getInt("Inventories.Map Shop Screen.Size", 9), ChatColor.BLUE + "Map Shop"); {
			
		}
		petShopMenu = Bukkit.createInventory(null, configuration.getInt("Inventories.Pet Shop Screen.Size", 36), ChatColor.BLUE + "Pet Shop"); {
			
		}
		shopMenu = Bukkit.createInventory(null, configuration.getInt("Inventories.Main Shop Screen.Size", 9), ChatColor.BLUE + "Main Shop"); {
			shopMenu.setItem(configuration.getInt("Inventories.Main Shop Screen.Items.Pet Shop") - 1, new ItemStack(sil.pets));
			shopMenu.setItem(configuration.getInt("Inventories.Main Shop Screen.Items.Map Shop") - 1, new ItemStack(sil.maps));
			shopMenu.setItem(configuration.getInt("Inventories.Main Shop Screen.Items.Trail Shop") - 1, new ItemStack(sil.trails));
			shopMenu.setItem(configuration.getInt("Inventories.Main Shop Screen.Items.Kit Shop") - 1, new ItemStack(sil.kits));
		}
		
		chiefKits = Bukkit.createInventory(null, configuration.getInt("Inventories.Plus Loadout Menu.Size", 9), ChatColor.BLUE + "Plus Loadout Shop"); {
			chiefKits.setItem(configuration.getInt("Inventories.Plus Loadout Menu.Items.Marksman") - 1, new ItemStack(ksil.marksman));
			chiefKits.setItem(configuration.getInt("Inventories.Plus Loadout Menu.Items.Predator") - 1, new ItemStack(ksil.predator));
			chiefKits.setItem(configuration.getInt("Inventories.Plus Loadout Menu.Items.Tactical") - 1, new ItemStack(ksil.tactical));
		}
		
		captainKits = Bukkit.createInventory(null, configuration.getInt("Inventories.Premium Loadout Menu.Size", 9), ChatColor.BLUE + "Premium Loadout Shop"); {
			captainKits.setItem(configuration.getInt("Inventories.Premium Loadout Menu.Items.Assassin") - 1, new ItemStack(ksil.assassin));
			captainKits.setItem(configuration.getInt("Inventories.Premium Loadout Menu.Items.Stalker") - 1, new ItemStack(ksil.stalker));
			captainKits.setItem(configuration.getInt("Inventories.Premium Loadout Menu.Items.Soldier") - 1, new ItemStack(ksil.soldier));
			captainKits.setItem(configuration.getInt("Inventories.Premium Loadout Menu.Items.Grenadier") - 1, new ItemStack(ksil.grenadier));
		}
		
		dogtagKits = Bukkit.createInventory(null, configuration.getInt("Inventories.Dogtag Loadout Menu.Size", 9), ChatColor.BLUE + "Dogtag Loadout Shop"); {
			dogtagKits.setItem(configuration.getInt("Inventories.Dogtag Loadout Menu.Items.Slugger") - 1, new ItemStack(ksil.slugger));
			dogtagKits.setItem(configuration.getInt("Inventories.Dogtag Loadout Menu.Items.Heavy") - 1, new ItemStack(ksil.heavy));
		}
		
		trailShopMenu = Bukkit.createInventory(null, configuration.getInt("Inventories.Trail Shop Screen.Size", 36), ChatColor.BLUE + "Trail Shop"); {
			
		}
		
		compassMenu = Bukkit.createInventory(null, configuration.getInt("Inventories.Compass Menu.Size"), ChatColor.BLUE + "Navigation Menu"); {
			compassMenu.setItem(2, new ItemStack(ncl.goldengun));
			compassMenu.setItem(6, new ItemStack(ncl.hub));
		}
		
		pm.registerEvents(new SnowballerListener(), this);
		pm.registerEvents(new BookListener(), this);
		pm.registerEvents(new BarkerListener(), this);
		pm.registerEvents(new DamageListener(), this);
		pm.registerEvents(new HungerListener(), this);
		pm.registerEvents(new LightningRodListener(), this);
		pm.registerEvents(new JumperListener(), this);
		pm.registerEvents(new FlareGunListener(), this);
		pm.registerEvents(new ShopStickListener(), this);
		pm.registerEvents(new ShopInventoryListener(), this);
		pm.registerEvents(new PetShopInventoryListener(), this);
		pm.registerEvents(new MapShopInventoryListener(), this);
		pm.registerEvents(new KitShopInventoryListener(), this);
		pm.registerEvents(new TrailShopInventoryListener(), this);
		pm.registerEvents(new EquipmentMenuListener(), this);
		//pm.registerEvents(new VoidListener(), this);
		pm.registerEvents(new NavigationCompassListener(), this);
		pm.registerEvents(new ScoreboardListener(), this);
		pm.registerEvents(new WeatherChangeListener(), this);
		
		setupPermissions();
		setupEconomy();
	}
	
	@Override
	public void onDisable() {
		saveResource("config.yml", false);
	}
	
	//test command
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("booktest")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You cannot use this command if you are not a player!");
				return true;
			} else {
				Player p = (Player) sender;
				p.getInventory().setItem(8, new ItemStack(bl.book));
			}
		}
		return false;
	}
	
	public static Plugin getPlugin() {
		return Bukkit.getServer().getPluginManager().getPlugin("WarzoneHub");
	}
	
    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }
    
    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
    
    public EchoPetAPI getPetAPI() {
    	return EchoPetAPI.getAPI();
    }
	
	public Permission getPermissions() {
		return perms;
	}
	
	public Economy getEconomy() {
		return econ;
	}
}
