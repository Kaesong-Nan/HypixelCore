package me.Ikeetjeop.hypixel.commands.Spawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Ikeetjeop.hypixel.HypixelCore;
import me.Ikeetjeop.hypixel.ConfigManagement.SpawnData;

public class Spawncmd implements CommandExecutor{
	private HypixelCore plugin;

	public Spawncmd(HypixelCore plugin){
		this.plugin = plugin;
	}
	private SpawnData spawn;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(sender instanceof Player){
			this.spawn = new SpawnData(plugin);
			Player player = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("spawn")){
				spawn.spawnGo(player);
			}
		}
		return false;
	}
}
