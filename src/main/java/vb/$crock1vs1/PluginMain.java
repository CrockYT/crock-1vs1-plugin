package vb.$crock1vs1;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.event.*;
import org.bukkit.plugin.java.*;

public class PluginMain extends JavaPlugin implements Listener {

	private static PluginMain instance;

	@Override
	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(GUIManager.getInstance(), this);
		GUIManager.getInstance().register("pvp_main", guiPlayer -> {
			try {
				org.bukkit.inventory.Inventory guiInventory = Bukkit.createInventory(new GUIIdentifier("pvp_main"),
						((int) (27d)),
						ChatColor.translateAlternateColorCodes('&', "&cCrock's 1vs1 &aplugin main menu!!"));
				guiInventory.setItem(((int) (10d)),
						PluginMain.getNamedItemWithLore(((org.bukkit.Material) org.bukkit.Material.BOOK),
								ChatColor.translateAlternateColorCodes('&', "&6normal pvp"),
								new ArrayList(Arrays.asList(ChatColor.translateAlternateColorCodes('&',
										"&a\u30AF\u30EA\u30C3\u30AF\u3067set up")))));
				guiInventory.setItem(((int) (13d)),
						PluginMain.getNamedItemWithLore(((org.bukkit.Material) org.bukkit.Material.BOOK),
								ChatColor.translateAlternateColorCodes('&', "&6only 1vs1"),
								new ArrayList(Arrays.asList(ChatColor.translateAlternateColorCodes('&',
										"&a\u30AF\u30EA\u30C3\u30AF\u3067set up")))));
				guiInventory.setItem(((int) (16d)),
						PluginMain.getNamedItemWithLore(((org.bukkit.Material) org.bukkit.Material.BOOK),
								ChatColor.translateAlternateColorCodes('&', "&6404"),
								new ArrayList(Arrays.asList(ChatColor.translateAlternateColorCodes('&',
										"&a\u30AF\u30EA\u30C3\u30AF\u3067set up")))));
				guiInventory.setItem(((int) (18d)),
						PluginMain.getNamedItemWithLore(((org.bukkit.Material) org.bukkit.Material.BARRIER),
								ChatColor.translateAlternateColorCodes('&', "&c\u9589\u3058\u308B"),
								new ArrayList(Arrays.asList(ChatColor.translateAlternateColorCodes('&',
										"&4\u30AF\u30EA\u30C3\u30AF\u3067\u9589\u3058\u307E\u3059")))));
				return guiInventory;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}, true);
	}

	@Override
	public void onDisable() {
	}

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] commandArgs) {
		if (command.getName().equalsIgnoreCase("chelp")) {
			try {
				org.bukkit.Bukkit.broadcastMessage(
						ChatColor.translateAlternateColorCodes('&', "&c==========&aCrock's 1vs1 plugin&c=========="));
				org.bukkit.Bukkit.broadcastMessage("");
				org.bukkit.Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7 - &a/c1v1 <arg1>"));
				org.bukkit.Bukkit.broadcastMessage(
						ChatColor.translateAlternateColorCodes('&', "          &7arg list- &a[help|start|stop]"));
				org.bukkit.Bukkit.broadcastMessage(
						ChatColor.translateAlternateColorCodes('&', "               &7helparg list- &a[start|stop]"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		if (command.getName().equalsIgnoreCase("c1v1")) {
			try {
				if (!((commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null) == null)) {
					if (PluginMain.checkEquals((commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null),
							"help")) {
						if (!((commandArgs.length > ((int) (1d)) ? commandArgs[((int) (1d))] : null) == null)) {
							if (PluginMain.checkEquals(
									(commandArgs.length > ((int) (1d)) ? commandArgs[((int) (1d))] : null), "start")) {
								org.bukkit.Bukkit.broadcastMessage("start command\u306E\u30D8\u30EB\u30D7\u3060\u3088");
							}
							if (PluginMain.checkEquals(
									(commandArgs.length > ((int) (1d)) ? commandArgs[((int) (1d))] : null), "stop")) {
								org.bukkit.Bukkit.broadcastMessage("stop commadn\u306E\u30D8\u30EB\u30D7\u3060\u3088");
							}
						} else {
							org.bukkit.Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
									"&c==========&aCrock's 1vs1 plugin&c=========="));
							org.bukkit.Bukkit.broadcastMessage("");
							org.bukkit.Bukkit.broadcastMessage(
									ChatColor.translateAlternateColorCodes('&', "&7 - &a/c1v1 <arg1>"));
							org.bukkit.Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
									"          &7arg list- &a[help|start|stop|gui]"));
							org.bukkit.Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
									"               &7helparg list- &a[start|stop]"));
						}
					}
					if (PluginMain.checkEquals((commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null),
							"start")) {
						org.bukkit.Bukkit.broadcastMessage("pvp\u3092\u958B\u59CB\u3059\u308B\u3088");
					}
					if (PluginMain.checkEquals((commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null),
							"stop")) {
						org.bukkit.Bukkit.broadcastMessage("\u5F37\u5236\u7D42\u4E86\uFF01\uFF01");
					}
					if (PluginMain.checkEquals((commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null),
							"gui")) {
						GUIManager.getInstance().open("pvp_main", ((org.bukkit.entity.Player) (Object) commandSender));
					}
					if (!(((PluginMain
							.checkEquals((commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null), "help")
							^ PluginMain.checkEquals(
									(commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null), "start"))
							^ PluginMain.checkEquals(
									(commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null), "stop"))
							^ PluginMain.checkEquals(
									(commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null), "gui"))) {
						org.bukkit.Bukkit.broadcastMessage("hmm.......?????????????");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		return true;
	}

	public static void procedure(String procedure, List procedureArgs) throws Exception {
	}

	public static Object function(String function, List functionArgs) throws Exception {
		return null;
	}

	public static List createList(Object obj) {
		if (obj instanceof List) {
			return (List) obj;
		}
		List list = new ArrayList<>();
		if (obj.getClass().isArray()) {
			int length = java.lang.reflect.Array.getLength(obj);
			for (int i = 0; i < length; i++) {
				list.add(java.lang.reflect.Array.get(obj, i));
			}
		} else if (obj instanceof Collection<?>) {
			list.addAll((Collection<?>) obj);
		} else if (obj instanceof Iterator) {
			((Iterator<?>) obj).forEachRemaining(list::add);
		} else {
			list.add(obj);
		}
		return list;
	}

	public static void createResourceFile(String path) {
		Path file = getInstance().getDataFolder().toPath().resolve(path);
		if (Files.notExists(file)) {
			try (InputStream inputStream = PluginMain.class.getResourceAsStream("/" + path)) {
				Files.createDirectories(file.getParent());
				Files.copy(inputStream, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static PluginMain getInstance() {
		return instance;
	}

	@EventHandler
	public void onGUIClick(GUIClickEvent event) throws Exception {
		if (event.getID().equalsIgnoreCase("pvp_main")) {
			if (PluginMain.checkEquals(((java.lang.Object) (Object) event.getSlot()), "18")) {
				((org.bukkit.entity.Player) event.getWhoClicked()).playSound(
						((org.bukkit.entity.Entity) (Object) ((org.bukkit.event.block.Action) org.bukkit.event.block.Action.LEFT_CLICK_AIR)),
						((org.bukkit.Sound) org.bukkit.Sound.BLOCK_NOTE_BLOCK_BELL), ((float) (30d)), ((float) (5d)));
			}
			return;
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void event1(org.bukkit.event.server.TabCompleteEvent event) throws Exception {
		if (PluginMain.checkEquals(((java.lang.String) event.getBuffer()), "/c1v1 ")) {
			event.setCompletions(new ArrayList(Arrays.asList("help", "start", "stop", "gui")));
		}
		if (PluginMain.checkEquals(((java.lang.String) event.getBuffer()), "/c1v1 help ")) {
			event.setCompletions(new ArrayList(Arrays.asList("start", "stop")));
		}
	}

	public static org.bukkit.inventory.ItemStack getNamedItemWithLore(Material material, String name,
			List<String> lore) {
		org.bukkit.inventory.ItemStack item = new org.bukkit.inventory.ItemStack(material);
		org.bukkit.inventory.meta.ItemMeta itemMeta = item.getItemMeta();
		if (itemMeta != null) {
			itemMeta.setDisplayName(name);
			itemMeta.setLore(lore);
			item.setItemMeta(itemMeta);
		}
		return item;
	}

	public static boolean checkEquals(Object o1, Object o2) {
		if (o1 == null || o2 == null) {
			return false;
		}
		return o1 instanceof Number && o2 instanceof Number
				? ((Number) o1).doubleValue() == ((Number) o2).doubleValue()
				: o1.equals(o2);
	}
}
