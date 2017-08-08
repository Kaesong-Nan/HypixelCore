package me.Ikeetjeop.hypixel.utilities;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.Ikeetjeop.hypixel.HypixelCore;

public enum Rank
{
	//STAFF
	OWNER("Owner", "[OWNER]", 200, ChatColor.RED),
	ADMIN("Admin", "[ADMIN]", 190, ChatColor.RED),
	MODERATOR("Mod", "[MOD]", 180, ChatColor.GREEN),
	HELPER("Helper", "[HELPER]", 170, ChatColor.BLUE),
	BUILDTEAM("Build team", "[BUILD TEAM]", 160, ChatColor.DARK_GREEN),
	//unless ranks
	SLOTH("Sloth", "[SLOTH]", 150, ChatColor.RED),
	APPLE("Apple", "[APPLE]", 140, ChatColor.GOLD),
	BEAM("Beam", "[BEAM]", 130, ChatColor.DARK_GREEN),
	//Jobs
	MOJANG("Mojang", "[MOJANG]", 120, ChatColor.GOLD),
	YT("YT", "[YT]", 110, ChatColor.GOLD),
	//DODODODODONATORRSS //0 - 100 Donators
	MVPP("MVP+", "[MVP{Mpluse}]", 100, ChatColor.AQUA),
	MVP("Mvp", "[MVP]", 80, ChatColor.AQUA),
	VIPP("Vip+", "[VIP{Vpluse}]", 60, ChatColor.GREEN),
	VIP("Vip", "[VIP]", 40,ChatColor.GREEN),
	DEFAULT("Default", "", 20, ChatColor.GRAY);

	public String Name;
	public String Prefix;
	public int piority;
	public ChatColor Color;
	public boolean IsStaff;
	public boolean IsDonator;
	public boolean IsOp;

	private Rank(String name, String Prefix, int piority, ChatColor color)
	{
		this.Name = name;
		this.Prefix = Prefix;
		this.piority = piority;
		this.Color = color;
	}
	private static FileConfiguration config = HypixelCore.getInstance().getConfig();

	public String GetName() {
		return this.Name;
	}
	public String GetPrefix() {
		return this.Prefix;
	}
	public ChatColor getColor() {
		return this.Color;
	}

	public static Rank getRank(Player player) {
		String val = config.getString("Ranks." + player.getUniqueId());
		return (val == null ? Rank.DEFAULT : Rank.valueOf(val));
	}

	public static boolean hasRank(Player player, Rank rank) {
		return (Rank.getRank(player).compareTo(rank) <= 0);
	}

	public static void setRank(OfflinePlayer target, Rank rank) {
		config.set("Ranks." + target.getUniqueId(), rank.toString());
		HypixelCore.getInstance().saveConfig();
		System.out.println("[Debug] Player: " + target.getName() + " has now rank: " + rank.GetName());
	}

	public static void get(Player player, Rank rank) {
		config.set("Ranks." + player.getUniqueId(), rank.toString());
		HypixelCore.getInstance().saveConfig();
	}
	public int getPiority() {
		return piority;
	}
	public void setPiority(int piority) {
		this.piority = piority;
	}
}