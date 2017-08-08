package me.Ikeetjeop.hypixel.configManagement;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import me.Ikeetjeop.hypixel.HypixelCore;
import me.Ikeetjeop.hypixel.utilities.Rank;

public class SpawnData extends ConfigManager{

	public SpawnData(HypixelCore main) {
		super(main, "SpawnData.yml");
	}
	public boolean spawnSet(Player player){
		if(Rank.hasRank(player, Rank.OWNER) || Rank.hasRank(player, Rank.OWNER)){
			config.set("Hypixel.lobby.world", player.getWorld().getName());
			config.set("Hypixel.lobby.x", player.getLocation().getBlock().getLocation().getX() + 0.5);
			config.set("Hypixel.lobby.y", player.getLocation().getBlock().getLocation().getY() + 0.5);
			config.set("Hypixel.lobby.z", player.getLocation().getBlock().getLocation().getZ() + 0.5);
			config.set("Hypixel.lobby.yaw", player.getLocation().getYaw());
			config.set("Hypixel.lobby.pitch", player.getLocation().getPitch());
			save();
			player.sendMessage("§aSpawn has been set at your location");
			return true;
		} else {
			player.sendMessage("Console cannot use '/setspawn' at the moment...");
			return true;
		}
	}
	public Location spawnGo(Player player){
		try{
		World world = Bukkit.getWorld(config.getString("Hypixel.lobby.world"));
		double x = config.getDouble("Hypixel.lobby.x");
		double y = config.getDouble("Hypixel.lobby.y");
		double z = config.getDouble("Hypixel.lobby.z");
		long yaw = config.getLong("Hypixel.lobby.yaw");
		long pitch = config.getLong("Hypixel.lobby.pitch");
		player.teleport(new Location(world, x, y, z, yaw, pitch));
		return new Location(world, x, y, z, yaw, pitch);
		}catch (Exception e) {
			Bukkit.getConsoleSender().sendMessage(">> Pleas set your SpawnPoint! <<<");
			Bukkit.getConsoleSender().sendMessage(">> Pleas set your SpawnPoint! <<<");
			Bukkit.getConsoleSender().sendMessage(">> Pleas set your SpawnPoint! <<<");
			player.sendMessage("Ask a admin for set spawnpoint!");
		}
		return spawnGo(player);
	}
}