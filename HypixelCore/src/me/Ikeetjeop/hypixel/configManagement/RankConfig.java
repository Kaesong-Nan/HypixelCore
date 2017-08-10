package me.Ikeetjeop.hypixel.configManagement;

import java.util.Set;

import me.Ikeetjeop.hypixel.HypixelCore;

public class RankConfig extends ConfigManager {

	public RankConfig(HypixelCore main) {
		super(main, "RankSystem.yml");
	}
	
	public void RegisterRank(){
		config.addDefault("Hypixel.Ranks.OWNER.Chat", "&c[OWNER] {username}&f: ");
		config.addDefault("Hypixel.Ranks.ADMIN.Chat", "&c[ADMIN] {username}&f: ");
		config.addDefault("Hypixel.Ranks.MODERATOR.Chat", "&a[MOD] {username}&f: ");
		config.addDefault("Hypixel.Ranks.HELPER.Chat", "&9[HELPER] {username}&f: ");
		config.addDefault("Hypixel.Ranks.BUILDTEAM.Chat", "&2[BUILD TEAM] {username}&f: ");
		config.addDefault("Hypixel.Ranks.SLOTH.Chat", "&c[SLOTH] {username}&f: ");
		config.addDefault("Hypixel.Ranks.APPLE.Chat", "&6[APPLE] {username}&f: ");
		config.addDefault("Hypixel.Ranks.BEAM.Chat", "&2[BEAM] {username}&f: ");
		config.addDefault("Hypixel.Ranks.MOJANG.Chat", "&6[MOJANG] {username}&f: ");
		config.addDefault("Hypixel.Ranks.YT.Chat", "&6[YT] {username}&f: ");
		config.addDefault("Hypixel.Ranks.MVPP.Chat", "&b[MVP{Pluse}&b] {username}&f: ");
		config.addDefault("Hypixel.Ranks.MVP.Chat", "&b[MVP] {username}&f: ");
		config.addDefault("Hypixel.Ranks.VIPP.Chat", "&a[Vip&6+&a] {username}&f: ");
		config.addDefault("Hypixel.Ranks.VIP.Chat", "&a[Vip] {username}&f: ");
		config.addDefault("Hypixel.Ranks.DEFAULT.Chat", "&7{username}: ");
		config.options().copyDefaults(true);
		save();
		
	}
	public String GetString(String string){
		return config.getString(string);
	}
	public Set<String> getConfigurationSection(String string){
		return config.getConfigurationSection(string).getKeys(false);
	}

}