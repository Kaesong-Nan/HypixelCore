package me.Ikeetjeop.hypixel;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.Ikeetjeop.hypixel.ConfigManagement.RankConfig;
import me.Ikeetjeop.hypixel.ConfigManagement.SpawnData;
import me.Ikeetjeop.hypixel.Listener.Chat.ChatListener;
import me.Ikeetjeop.hypixel.commands.Fly.Flycmd;
import me.Ikeetjeop.hypixel.commands.Spawn.SetSpawn;
import me.Ikeetjeop.hypixel.commands.Spawn.Spawncmd;
import me.Ikeetjeop.hypixel.commands.UpdateRank.RankCMD;

public class HypixelCore extends JavaPlugin{
	private static HypixelCore instance;
	public HypixelCore() {
		instance = this;
	}

	public void onEnable(){
		RegisterConfigs();
		MessageStartUp();
		RegisterCommands();
		RegisterListener();
	}
	public void onDisable(){
	}
	public void RegisterCommands(){
		getCommand("setlobby").setExecutor(new SetSpawn(this));
		getCommand("spawn").setExecutor(new Spawncmd(this));
		getCommand("fly").setExecutor(new Flycmd());
		getCommand("rank").setExecutor(new RankCMD());

	}
	@SuppressWarnings("unused")
	private SpawnData SpawnData;
	private RankConfig RankConfig;
	public void RegisterConfigs(){
			if(!getDataFolder().exists()){
				getDataFolder().mkdirs();
			}
		this.RankConfig = new RankConfig(this);
		this.SpawnData = new SpawnData(this);
		RankConfig.RegisterRank();
		getConfig().addDefault("Hypixel.Messages.Server.Prefix", "&6[HP]");
		getConfig().options().copyDefaults(true);
		saveConfig();

	}
	public void RegisterListener(){
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new ChatListener(this), this);

	}
	public void MessageStartUp(){
		ConsoleCommandSender s = Bukkit.getConsoleSender();
		
		s.sendMessage(ChatColor.GOLD + "");
	}
    public static HypixelCore getInstance() {
        return instance;
    }

}
