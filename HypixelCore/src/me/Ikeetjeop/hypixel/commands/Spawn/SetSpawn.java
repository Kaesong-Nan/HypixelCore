package me.Ikeetjeop.hypixel.commands.Spawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Ikeetjeop.hypixel.HypixelCore;
import me.Ikeetjeop.hypixel.ConfigManagement.SpawnData;
import me.Ikeetjeop.hypixel.JavaShit.Rank;
import me.Ikeetjeop.hypixel.JavaShit.Text;
import me.Ikeetjeop.hypixel.JavaShit.Text.text;

public class SetSpawn implements CommandExecutor{
	private HypixelCore plugin;

	public SetSpawn(HypixelCore plugin){
		this.plugin = plugin;
	}
	private SpawnData spawn;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			Rank ranks = Rank.getRank(p);
			if(ranks.piority >= 190){
				this.spawn = new SpawnData(plugin);
				if(cmd.getName().equalsIgnoreCase("setlobby")){
					spawn.spawnSet(p);
				}
			}else{
				Text.message(p, text.Noaccess);
			}
		}
		return false;
	}


}