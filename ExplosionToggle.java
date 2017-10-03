package me.PlasmaFighter;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ExplosionToggle extends JavaPlugin {

	public Permission playerPermissionToggle = new Permission("breakExplosions.toggle");
	public Permission playerPermissionChance1 = new Permission("breakExplosions.explosionchance.1");
	public Permission playerPermissionChance2 = new Permission("breakExplosions.explosionchance.2");
	public Permission playerPermissionChance3 = new Permission("breakExplosions.explosionchance.3");
	public Permission playerPermissionChance4 = new Permission("breakExplosions.explosionchance.4");
	public Permission playerPermissionChance5 = new Permission("breakExplosions.explosionchance.5");
	public Permission playerPermissionChance6 = new Permission("breakExplosions.autoSmelt");
	public Permission playerPermissionConfigReload = new Permission("breakExplosions.config.reload");

	@Override
	public void onEnable() {
		new ListenerClass(this);
		PluginManager pm = getServer().getPluginManager();
		pm.addPermission(playerPermissionToggle);
		pm.addPermission(playerPermissionChance1);
		pm.addPermission(playerPermissionChance2);
		pm.addPermission(playerPermissionChance3);
		pm.addPermission(playerPermissionChance4);
		pm.addPermission(playerPermissionChance5);
		pm.addPermission(playerPermissionChance6);
		pm.addPermission(playerPermissionConfigReload);
	}

	@Override
	public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		FileConfiguration config = this.getConfig();

		if (cmd.getName().equalsIgnoreCase("explosiontoggle") && sender instanceof Player) {

			Player player = (Player) sender;

			if (player.hasPermission("breakExplosions.toggle")) {
				if (config.getInt("isEnabled." + player.getName().toLowerCase()) == 1) {
					config.set("isEnabled." + player.getName().toLowerCase(), 0);
					player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "Mining Explosions" + ChatColor.GRAY + "]" + ChatColor.RED + " Mining Explosions have been toggled off!");
					saveConfig();
				} else {
					config.set("isEnabled." + player.getName().toLowerCase(), 1);
					player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "Mining Explosions" + ChatColor.GRAY + "]" + ChatColor.GREEN + " Mining Explosions have been toggled on!");
					saveConfig();
				}
			}

			return true;

		}
		if (cmd.getName().equalsIgnoreCase("explosionstoggle") && sender instanceof Player) {

			Player player = (Player) sender;

			if (player.hasPermission("breakExplosions.toggle")) {
				if (config.getInt("isEnabled." + player.getName().toLowerCase()) == 1) {
					config.set("isEnabled." + player.getName().toLowerCase(), 0);
					player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "Mining Explosions" + ChatColor.GRAY + "]" + ChatColor.RED + " Mining Explosions have been toggled off!");
					saveConfig();
				} else {
					config.set("isEnabled." + player.getName().toLowerCase(), 1);
					player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "Mining Explosions" + ChatColor.GRAY + "]" + ChatColor.GREEN + " Mining Explosions have been toggled on!");
					saveConfig();
				}
			}

			return true;

		}
		if (cmd.getName().equalsIgnoreCase("toggleexplosions") && sender instanceof Player) {

			Player player = (Player) sender;

			if (player.hasPermission("breakExplosions.toggle")) {
				if (config.getInt("isEnabled." + player.getName().toLowerCase()) == 1) {
					config.set("isEnabled." + player.getName().toLowerCase(), 0);
					player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "Mining Explosions" + ChatColor.GRAY + "]" + ChatColor.RED + " Mining Explosions have been toggled off!");
					saveConfig();
				} else {
					config.set("isEnabled." + player.getName().toLowerCase(), 1);
					player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "Mining Explosions" + ChatColor.GRAY + "]" + ChatColor.GREEN + " Mining Explosions have been toggled on!");
					saveConfig();
				}
			}

			return true;

		}
		if (cmd.getName().equalsIgnoreCase("te") && sender instanceof Player) {

			Player player = (Player) sender;

			if (player.hasPermission("breakExplosions.toggle")) {
				if (config.getInt("isEnabled." + player.getName().toLowerCase()) == 1) {
					config.set("isEnabled." + player.getName().toLowerCase(), 0);
					player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "Mining Explosions" + ChatColor.GRAY + "]" + ChatColor.RED + " Mining Explosions have been toggled off!");
					saveConfig();
				} else {
					config.set("isEnabled." + player.getName().toLowerCase(), 1);
					player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "Mining Explosions" + ChatColor.GRAY + "]" + ChatColor.GREEN + " Mining Explosions have been toggled on!");
					saveConfig();
				}
			}

			return true;

		}

		if (cmd.getName().equalsIgnoreCase("as") && sender instanceof Player) {

			Player player = (Player) sender;

			if (player.hasPermission("breakExplosions.autoSmelt")) {
				if (config.getInt("asIsEnabled." + player.getName().toLowerCase()) == 1) {
					config.set("asIsEnabled." + player.getName().toLowerCase(), 0);
					player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "Mining Explosions" + ChatColor.GRAY + "]" + ChatColor.RED + " Auto smelt has been toggled off!");
					saveConfig();
				} else {
					config.set("asIsEnabled." + player.getName().toLowerCase(), 1);
					player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "Mining Explosions" + ChatColor.GRAY + "]" + ChatColor.GREEN + " Auto smelt has been toggled on!");
					saveConfig();
				}
			}

			return true;

		}

		if (cmd.getName().equalsIgnoreCase("autosmelt") && sender instanceof Player) {

			Player player = (Player) sender;

			if (player.hasPermission("breakExplosions.autoSmelt")) {
				if (config.getInt("asIsEnabled." + player.getName().toLowerCase()) == 1) {
					config.set("asIsEnabled." + player.getName().toLowerCase(), 0);
					player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "Mining Explosions" + ChatColor.GRAY + "]" + ChatColor.RED + " Auto smelt has been toggled off!");
					saveConfig();
				} else {
					config.set("asIsEnabled." + player.getName().toLowerCase(), 1);
					player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "Mining Explosions" + ChatColor.GRAY + "]" + ChatColor.GREEN + " Auto smelt has been toggled on!");
					saveConfig();
				}
			}

			return true;

		}

		if (cmd.getName().equalsIgnoreCase("meconfig") && sender instanceof Player) {

			Player player = (Player) sender;

			if (player.hasPermission(playerPermissionConfigReload)) {
				saveConfig();
				player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "Mining Explosions" + ChatColor.GRAY + "]" + ChatColor.GREEN + " Config has been reloaded.");
			} else {
				player.sendMessage(ChatColor.RED + "Insufficient permissions.");
			}

			return true;

		}

		return false;

	}
}
