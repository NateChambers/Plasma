package me.PlasmaFighter;

import java.util.Random;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.*;;

public class ListenerClass implements Listener {

	ExplosionToggle plugin;
	FileConfiguration config;
	Location breakBlock;
	Player player;

	public ListenerClass(ExplosionToggle plugin) {

		plugin.getServer().getPluginManager().registerEvents(this, plugin);

		this.plugin = plugin;
		config = plugin.getConfig();

	}

	@SuppressWarnings("deprecation")
	public void addItemFunction() {
		if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("stone")
				&& !(config.getInt("asIsEnabled." + player.getName().toLowerCase()) == 1)) {
			player.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 1));
			player.updateInventory();
		} else if (config.getInt("asIsEnabled." + player.getName().toLowerCase()) == 1) {
			if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("stone")) {
				player.getInventory().addItem(new ItemStack(
						Material.getMaterial(String.valueOf(breakBlock.getBlock().getType())), 1));
				player.updateInventory();

			} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("emerald_ore")) {
				player.getInventory().addItem(new ItemStack(Material.EMERALD, 1));
				player.updateInventory();
			} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("gold_ore")) {
				player.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 1));
				player.updateInventory();
			} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("iron_ore")) {
				player.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 1));
				player.updateInventory();
			} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("coal_ore")) {
				player.getInventory().addItem(new ItemStack(Material.COAL, 1));
				player.updateInventory();
			} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("grass")) {
				player.getInventory().addItem(new ItemStack(Material.GRASS, 1));
				player.updateInventory();
			} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("redstone_ore")) {
				player.getInventory().addItem(new ItemStack(Material.REDSTONE, 5));
				player.updateInventory();
			} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("diamond_ore")) {
				player.getInventory().addItem(new ItemStack(Material.DIAMOND, 1));
				player.updateInventory();
			} else if (breakBlock.getBlock().getType().toString().equalsIgnoreCase("lapis_ore")) {
				player.getInventory().addItem(new ItemStack(351, 3, (short) 4));
				player.updateInventory();
			} else if (breakBlock.getBlock().getType().toString().equalsIgnoreCase("sand")) {
				player.getInventory().addItem(new ItemStack(Material.GLASS, 1));
				player.updateInventory();
			} else if (breakBlock.getBlock().getType().toString().equalsIgnoreCase("glowstone")) {
				player.getInventory().addItem(new ItemStack(Material.GLOWSTONE, 1));
				player.updateInventory();
			} else {
				player.getInventory().addItem(new ItemStack(
						Material.getMaterial(String.valueOf(breakBlock.getBlock().getType())), 1));
				player.updateInventory();
			}
		} else {
			player.getInventory().addItem(
					new ItemStack(Material.getMaterial(String.valueOf(breakBlock.getBlock().getType())), 1));
			player.updateInventory();
		}
	}

	@EventHandler
	public void onEvent(BlockBreakEvent e) {

		player = e.getPlayer();

		if (config.getInt("isEnabled." + player.getName().toLowerCase()) == 1) {
			
			

			breakBlock = e.getBlock().getLocation();
			
			addItemFunction();
			
			e.setCancelled(true);
			breakBlock.getBlock().setTypeId(0);

			/*
			if (e.getBlock().getType().toString().equalsIgnoreCase("stone")) {
				e.getBlock().getDrops().remove(4);
			} else if (e.getBlock().getType().toString().equalsIgnoreCase("iron_ore")) {
				e.getBlock().getDrops().remove("iron_ore");
			} else if (e.getBlock().getType().toString().equalsIgnoreCase("gold_ore")) {
				e.getBlock().getDrops().remove("gold_ore");
			} else if (e.getBlock().getType().toString().equalsIgnoreCase("emerald_ore")) {
				e.getBlock().getDrops().remove("emerald_ore");
			} else {
				e.getBlock().getDrops().remove(e.getBlock().getDrops());
			}
			*/

			Random rn = new Random();

			if (player.hasPermission("breakExplosions.explosionchance.1")
					&& player.hasPermission("breakExplosions.explosionchance.2")
					&& player.hasPermission("breakExplosions.explosionchance.3")
					&& player.hasPermission("breakExplosions.explosionchance.4")
					&& player.hasPermission("breakExplosions.explosionchance.5")) {

				breakBlock.setY(e.getBlock().getY() - 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				breakBlock.setX(e.getBlock().getX());
				breakBlock.setZ(e.getBlock().getZ());

				breakBlock.setX(e.getBlock().getX() - 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				breakBlock.setX(e.getBlock().getX() + 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				breakBlock.setX(e.getBlock().getX());
				breakBlock.setZ(e.getBlock().getZ() - 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				breakBlock.setZ(e.getBlock().getZ() + 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				// Line Breaker
				breakBlock.setX(e.getBlock().getX() - 1);
				breakBlock.setZ(e.getBlock().getZ() - 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				breakBlock.setX(e.getBlock().getX() - 1);
				breakBlock.setZ(e.getBlock().getZ() + 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				breakBlock.setX(e.getBlock().getX() + 1);
				breakBlock.setZ(e.getBlock().getZ() - 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				breakBlock.setX(e.getBlock().getX() + 1);
				breakBlock.setZ(e.getBlock().getZ() + 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				breakBlock.setY(e.getBlock().getY());
				breakBlock.setX(e.getBlock().getX());
				breakBlock.setZ(e.getBlock().getZ());

				breakBlock.setZ(e.getBlock().getZ() + 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				breakBlock.setZ(e.getBlock().getZ() - 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				breakBlock.setZ(e.getBlock().getZ());
				breakBlock.setX(e.getBlock().getX() + 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				breakBlock.setX(e.getBlock().getX() - 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				// Line Breaker
				breakBlock.setX(e.getBlock().getX() - 1);
				breakBlock.setZ(e.getBlock().getZ() - 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				breakBlock.setX(e.getBlock().getX() - 1);
				breakBlock.setZ(e.getBlock().getZ() + 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				breakBlock.setX(e.getBlock().getX() + 1);
				breakBlock.setZ(e.getBlock().getZ() - 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				breakBlock.setX(e.getBlock().getX() + 1);
				breakBlock.setZ(e.getBlock().getZ() + 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}

				breakBlock.setX(e.getBlock().getX());
				breakBlock.setZ(e.getBlock().getZ());
				breakBlock.setY(e.getBlock().getY() + 1);
				if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("stone")
						&& !(config.getInt("asIsEnabled." + player.getName().toLowerCase()) == 1)) {
					player.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 1));
					player.updateInventory();
				} else if (config.getInt("asIsEnabled." + player.getName().toLowerCase()) == 1) {
					if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("stone")) {
						player.getInventory().addItem(new ItemStack(
								Material.getMaterial(String.valueOf(breakBlock.getBlock().getType())), 1));
						player.updateInventory();

					} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("emerald_ore")) {
						player.getInventory().addItem(new ItemStack(Material.EMERALD, 1));
						player.updateInventory();
					} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("gold_ore")) {
						player.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 1));
						player.updateInventory();
					} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("iron_ore")) {
						player.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 1));
						player.updateInventory();
					} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("coal_ore")) {
						player.getInventory().addItem(new ItemStack(Material.COAL, 1));
						player.updateInventory();
					} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("grass")) {
						player.getInventory().addItem(new ItemStack(Material.GRASS, 1));
						player.updateInventory();
					} else {
						player.getInventory().addItem(new ItemStack(
								Material.getMaterial(String.valueOf(breakBlock.getBlock().getType())), 1));
						player.updateInventory();
					}
				} else {
					player.getInventory().addItem(
							new ItemStack(Material.getMaterial(String.valueOf(breakBlock.getBlock().getType())), 1));
					player.updateInventory();
				}
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}

				breakBlock.setZ(e.getBlock().getZ() + 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				breakBlock.setZ(e.getBlock().getZ() - 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				breakBlock.setZ(e.getBlock().getZ());
				breakBlock.setX(e.getBlock().getX() + 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				breakBlock.setX(e.getBlock().getX() - 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				// Line Breaker
				breakBlock.setX(e.getBlock().getX() - 1);
				breakBlock.setZ(e.getBlock().getZ() - 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				breakBlock.setX(e.getBlock().getX() - 1);
				breakBlock.setZ(e.getBlock().getZ() + 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				breakBlock.setX(e.getBlock().getX() + 1);
				breakBlock.setZ(e.getBlock().getZ() - 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
				breakBlock.setX(e.getBlock().getX() + 1);
				breakBlock.setZ(e.getBlock().getZ() + 1);
				addItemFunction();
				if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
					breakBlock.getBlock().setTypeId(0);
				}
			} else if (player.hasPermission("breakExplosions.explosionchance.1")) {
				if ((rn.nextInt() + 1) < 2) {
					breakBlock.setY(e.getBlock().getY() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX());
					breakBlock.setZ(e.getBlock().getZ());

					breakBlock.setX(e.getBlock().getX() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX());
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					// Line Breaker
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setY(e.getBlock().getY());
					breakBlock.setX(e.getBlock().getX());
					breakBlock.setZ(e.getBlock().getZ());

					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ());
					breakBlock.setX(e.getBlock().getX() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					// Line Breaker
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}

					breakBlock.setX(e.getBlock().getX());
					breakBlock.setZ(e.getBlock().getZ());
					breakBlock.setY(e.getBlock().getY() + 1);
					if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("stone")
							&& !(config.getInt("asIsEnabled." + player.getName().toLowerCase()) == 1)) {
						player.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 1));
						player.updateInventory();
					} else if (config.getInt("asIsEnabled." + player.getName().toLowerCase()) == 1) {
						if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("stone")) {
							player.getInventory().addItem(new ItemStack(
									Material.getMaterial(String.valueOf(breakBlock.getBlock().getType())), 1));
							player.updateInventory();

						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("emerald_ore")) {
							player.getInventory().addItem(new ItemStack(Material.EMERALD, 1));
							player.updateInventory();
						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("gold_ore")) {
							player.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 1));
							player.updateInventory();
						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("iron_ore")) {
							player.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 1));
							player.updateInventory();
						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("coal_ore")) {
							player.getInventory().addItem(new ItemStack(Material.COAL, 1));
							player.updateInventory();
						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("grass")) {
							player.getInventory().addItem(new ItemStack(Material.GRASS, 1));
							player.updateInventory();
						} else {
							player.getInventory().addItem(new ItemStack(
									Material.getMaterial(String.valueOf(breakBlock.getBlock().getType())), 1));
							player.updateInventory();
						}
					} else {
						player.getInventory().addItem(
								new ItemStack(Material.getMaterial(String.valueOf(breakBlock.getBlock().getType())), 1));
						player.updateInventory();
					}
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}

					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ());
					breakBlock.setX(e.getBlock().getX() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					// Line Breaker
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
				}
			} else if (player.hasPermission("breakExplosions.explosionchance.2")) {
				if ((rn.nextInt(5) + 1) < 3) {
					breakBlock.setY(e.getBlock().getY() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX());
					breakBlock.setZ(e.getBlock().getZ());

					breakBlock.setX(e.getBlock().getX() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX());
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					// Line Breaker
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setY(e.getBlock().getY());
					breakBlock.setX(e.getBlock().getX());
					breakBlock.setZ(e.getBlock().getZ());

					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ());
					breakBlock.setX(e.getBlock().getX() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					// Line Breaker
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}

					breakBlock.setX(e.getBlock().getX());
					breakBlock.setZ(e.getBlock().getZ());
					breakBlock.setY(e.getBlock().getY() + 1);
					if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("stone")
							&& !(config.getInt("asIsEnabled." + player.getName().toLowerCase()) == 1)) {
						player.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 1));
						player.updateInventory();
					} else if (config.getInt("asIsEnabled." + player.getName().toLowerCase()) == 1) {
						if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("stone")) {
							player.getInventory().addItem(new ItemStack(
									Material.getMaterial(String.valueOf(breakBlock.getBlock().getType())), 1));
							player.updateInventory();

						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("emerald_ore")) {
							player.getInventory().addItem(new ItemStack(Material.EMERALD, 1));
							player.updateInventory();
						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("gold_ore")) {
							player.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 1));
							player.updateInventory();
						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("iron_ore")) {
							player.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 1));
							player.updateInventory();
						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("coal_ore")) {
							player.getInventory().addItem(new ItemStack(Material.COAL, 1));
							player.updateInventory();
						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("grass")) {
							player.getInventory().addItem(new ItemStack(Material.GRASS, 1));
							player.updateInventory();
						} else {
							player.getInventory().addItem(new ItemStack(
									Material.getMaterial(String.valueOf(breakBlock.getBlock().getType())), 1));
							player.updateInventory();
						}
					} else {
						player.getInventory().addItem(
								new ItemStack(Material.getMaterial(String.valueOf(breakBlock.getBlock().getType())), 1));
						player.updateInventory();
					}
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}

					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ());
					breakBlock.setX(e.getBlock().getX() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					// Line Breaker
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
				}
			} else if (player.hasPermission("breakExplosions.explosionchance.3")) {
				if ((rn.nextInt(5) + 1) < 4) {
					breakBlock.setY(e.getBlock().getY() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX());
					breakBlock.setZ(e.getBlock().getZ());

					breakBlock.setX(e.getBlock().getX() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX());
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					// Line Breaker
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setY(e.getBlock().getY());
					breakBlock.setX(e.getBlock().getX());
					breakBlock.setZ(e.getBlock().getZ());

					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ());
					breakBlock.setX(e.getBlock().getX() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					// Line Breaker
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}

					breakBlock.setX(e.getBlock().getX());
					breakBlock.setZ(e.getBlock().getZ());
					breakBlock.setY(e.getBlock().getY() + 1);
					if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("stone")
							&& !(config.getInt("asIsEnabled." + player.getName().toLowerCase()) == 1)) {
						player.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 1));
						player.updateInventory();
					} else if (config.getInt("asIsEnabled." + player.getName().toLowerCase()) == 1) {
						if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("stone")) {
							player.getInventory().addItem(new ItemStack(
									Material.getMaterial(String.valueOf(breakBlock.getBlock().getType())), 1));
							player.updateInventory();

						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("emerald_ore")) {
							player.getInventory().addItem(new ItemStack(Material.EMERALD, 1));
							player.updateInventory();
						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("gold_ore")) {
							player.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 1));
							player.updateInventory();
						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("iron_ore")) {
							player.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 1));
							player.updateInventory();
						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("coal_ore")) {
							player.getInventory().addItem(new ItemStack(Material.COAL, 1));
							player.updateInventory();
						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("grass")) {
							player.getInventory().addItem(new ItemStack(Material.GRASS, 1));
							player.updateInventory();
						} else {
							player.getInventory().addItem(new ItemStack(
									Material.getMaterial(String.valueOf(breakBlock.getBlock().getType())), 1));
							player.updateInventory();
						}
					} else {
						player.getInventory().addItem(
								new ItemStack(Material.getMaterial(String.valueOf(breakBlock.getBlock().getType())), 1));
						player.updateInventory();
					}
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}

					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ());
					breakBlock.setX(e.getBlock().getX() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					// Line Breaker
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
				}
			} else if (player.hasPermission("breakExplosions.explosionchance.4")) {
				if ((rn.nextInt(5) + 1) < 5) {
					breakBlock.setY(e.getBlock().getY() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX());
					breakBlock.setZ(e.getBlock().getZ());

					breakBlock.setX(e.getBlock().getX() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX());
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					// Line Breaker
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setY(e.getBlock().getY());
					breakBlock.setX(e.getBlock().getX());
					breakBlock.setZ(e.getBlock().getZ());

					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ());
					breakBlock.setX(e.getBlock().getX() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					// Line Breaker
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}

					breakBlock.setX(e.getBlock().getX());
					breakBlock.setZ(e.getBlock().getZ());
					breakBlock.setY(e.getBlock().getY() + 1);
					if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("stone")
							&& !(config.getInt("asIsEnabled." + player.getName().toLowerCase()) == 1)) {
						player.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 1));
						player.updateInventory();
					} else if (config.getInt("asIsEnabled." + player.getName().toLowerCase()) == 1) {
						if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("stone")) {
							player.getInventory().addItem(new ItemStack(
									Material.getMaterial(String.valueOf(breakBlock.getBlock().getType())), 1));
							player.updateInventory();

						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("emerald_ore")) {
							player.getInventory().addItem(new ItemStack(Material.EMERALD, 1));
							player.updateInventory();
						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("gold_ore")) {
							player.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 1));
							player.updateInventory();
						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("iron_ore")) {
							player.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 1));
							player.updateInventory();
						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("coal_ore")) {
							player.getInventory().addItem(new ItemStack(Material.COAL, 1));
							player.updateInventory();
						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("grass")) {
							player.getInventory().addItem(new ItemStack(Material.GRASS, 1));
							player.updateInventory();
						} else {
							player.getInventory().addItem(new ItemStack(
									Material.getMaterial(String.valueOf(breakBlock.getBlock().getType())), 1));
							player.updateInventory();
						}
					} else {
						player.getInventory().addItem(
								new ItemStack(Material.getMaterial(String.valueOf(breakBlock.getBlock().getType())), 1));
						player.updateInventory();
					}
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}

					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ());
					breakBlock.setX(e.getBlock().getX() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					// Line Breaker
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
				}
			} else if (player.hasPermission("breakExplosions.explosionchance.5")) {
				if ((rn.nextInt(5) + 1) < 6) {
					breakBlock.setY(e.getBlock().getY() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX());
					breakBlock.setZ(e.getBlock().getZ());

					breakBlock.setX(e.getBlock().getX() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX());
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					// Line Breaker
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setY(e.getBlock().getY());
					breakBlock.setX(e.getBlock().getX());
					breakBlock.setZ(e.getBlock().getZ());

					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ());
					breakBlock.setX(e.getBlock().getX() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					// Line Breaker
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}

					breakBlock.setX(e.getBlock().getX());
					breakBlock.setZ(e.getBlock().getZ());
					breakBlock.setY(e.getBlock().getY() + 1);
					if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("stone")
							&& !(config.getInt("asIsEnabled." + player.getName().toLowerCase()) == 1)) {
						player.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 1));
						player.updateInventory();
					} else if (config.getInt("asIsEnabled." + player.getName().toLowerCase()) == 1) {
						if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("stone")) {
							player.getInventory().addItem(new ItemStack(
									Material.getMaterial(String.valueOf(breakBlock.getBlock().getType())), 1));
							player.updateInventory();

						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("emerald_ore")) {
							player.getInventory().addItem(new ItemStack(Material.EMERALD, 1));
							player.updateInventory();
						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("gold_ore")) {
							player.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 1));
							player.updateInventory();
						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("iron_ore")) {
							player.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 1));
							player.updateInventory();
						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("coal_ore")) {
							player.getInventory().addItem(new ItemStack(Material.COAL, 1));
							player.updateInventory();
						} else if (String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("grass")) {
							player.getInventory().addItem(new ItemStack(Material.GRASS, 1));
							player.updateInventory();
						} else {
							player.getInventory().addItem(new ItemStack(
									Material.getMaterial(String.valueOf(breakBlock.getBlock().getType())), 1));
							player.updateInventory();
						}
					} else {
						player.getInventory().addItem(
								new ItemStack(Material.getMaterial(String.valueOf(breakBlock.getBlock().getType())), 1));
						player.updateInventory();
					}
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}

					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setZ(e.getBlock().getZ());
					breakBlock.setX(e.getBlock().getX() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					// Line Breaker
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() - 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() - 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
					breakBlock.setX(e.getBlock().getX() + 1);
					breakBlock.setZ(e.getBlock().getZ() + 1);
					addItemFunction();
					if (!String.valueOf(breakBlock.getBlock().getType()).equalsIgnoreCase("bedrock")) {
						breakBlock.getBlock().setTypeId(0);
					}
				}
			}
		} else if (config.getInt("asIsEnabled." + player.getName().toLowerCase()) == 1) {
			breakBlock = e.getBlock().getLocation();
			addItemFunction();
		}
	}

}
