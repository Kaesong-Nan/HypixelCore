package me.Ikeetjeop.hypixel;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

import me.Ikeetjeop.hypixel.Listener.Chat.ChatListener;
import me.Ikeetjeop.hypixel.Listener.OnJoin.OnJoin;
import me.Ikeetjeop.hypixel.commands.Fly.FlyCMD;
import me.Ikeetjeop.hypixel.commands.Spawn.SetSpawn;
import me.Ikeetjeop.hypixel.commands.Spawn.SpawnCMD;
import me.Ikeetjeop.hypixel.commands.UpdateRank.RankCMD;
import me.Ikeetjeop.hypixel.configManagement.Messages;
import me.Ikeetjeop.hypixel.configManagement.RankConfig;

public class HypixelCore extends JavaPlugin{
	private static HypixelCore instance;
	public HypixelCore() {
		instance = this;
	}
	public Scoreboard s = Bukkit.getScoreboardManager().getMainScoreboard();

	public void onEnable(){
		RegisterConfigs();
		RegisterCommands();
		RegisterListener();
		registerRankTag();
	}
	public void onDisable(){
	}
	public void RegisterCommands(){
		getCommand("setlobby").setExecutor(new SetSpawn(this));
		getCommand("spawn").setExecutor(new SpawnCMD(this));
		getCommand("fly").setExecutor(new FlyCMD());
		getCommand("rank").setExecutor(new RankCMD());

	}
	private Messages messages;
	private RankConfig RankConfig;

	public void RegisterConfigs(){
		if(!getDataFolder().exists()){
			getDataFolder().mkdirs();
		}
		this.RankConfig = new RankConfig(this);
		this.messages = new Messages(this);

		RankConfig.RegisterRank();
		messages.registerMessages();
		getConfig().addDefault("Hypixel.Messages.Server.Prefix", "&6[HP]");
		getConfig().options().copyDefaults(true);
		saveConfig();

	}
	public void RegisterListener(){
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new ChatListener(this), this);
		pm.registerEvents(new OnJoin(), this);

	}
	public void MessageStartUp(){
		ConsoleCommandSender s = Bukkit.getConsoleSender();

		s.sendMessage(ChatColor.GOLD + "");
	}
	public static HypixelCore getInstance() {
		return instance;
	}
	public void registerRankTag(){
		if(s.getTeam("Ranks") != null){
			s.getTeam("Ranks").unregister();
		}
		if(s.getTeam("Non") != null){
			s.getTeam("Non").unregister();
		}
	}

}
