package me.Ikeetjeop.hypixel.configManagement;

import java.util.Set;

import me.Ikeetjeop.hypixel.HypixelCore;

public class RankConfig extends ConfigManager {

	public RankConfig(HypixelCore main) {
		super(main, "RankSystem.yml");
	}
	
	public void RegisterRank(){
		config.set("Hypixel.Ranks.OWNER.Chat", "&c[OWNER] {username}&f: ");
		config.set("Hypixel.Ranks.ADMIN.Chat", "&c[ADMIN] {username}&f: ");
		config.set("Hypixel.Ranks.MODERATOR.Chat", "&a[MOD] {username}&f: ");
		config.set("Hypixel.Ranks.HELPER.Chat", "&9[HELPER] {username}&f: ");
		config.set("Hypixel.Ranks.BUILDTEAM.Chat", "&2[BUILD TEAM] {username}&f: ");
		config.set("Hypixel.Ranks.SLOTH.Chat", "&c[SLOTH] {username}&f: ");
		config.set("Hypixel.Ranks.APPLE.Chat", "&6[APPLE] {username}&f: ");
		config.set("Hypixel.Ranks.BEAM.Chat", "&2[BEAM] {username}&f: ");
		config.set("Hypixel.Ranks.MOJANG.Chat", "&6[MOJANG] {username}&f: ");
		config.set("Hypixel.Ranks.YT.Chat", "&6[YT] {username}&f: ");
		config.set("Hypixel.Ranks.MVP+.Chat", "&b[MVP{Pluse}&b] {username}&f: ");
		config.set("Hypixel.Ranks.MVP.Chat", "&b[MVP] {username}&f: ");
		config.set("Hypixel.Ranks.VIP+.Chat", "&a[Vip&6+&a] {username}&f: ");
		config.set("Hypixel.Ranks.VIP.Chat", "&a[Vip] {username}&f: ");
		config.set("Hypixel.Ranks.DEFAULT.Chat", "&7{username}: ");
		save();
		
	}
	public String GetString(String string){
		return config.getString(string);
	}
	public Set<String> getConfigurationSection(String string){
		return config.getConfigurationSection(string).getKeys(false);
	}

}