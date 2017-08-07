package me.Ikeetjeop.hypixel.JavaShit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.Ikeetjeop.hypixel.HypixelCore;

public enum Rank
{
	//STAFF
	OWNER("Owner", "[OWNER]", 200, ChatColor.RED, true, false, true),
	ADMIN("Admin", "[ADMIN]", 190, ChatColor.RED, true, false, true),
	MODERATOR("Mod", "[MOD]", 180, ChatColor.GREEN, true, false, false),
	HELPER("Helper", "[HELPER]", 170, ChatColor.BLUE, true, false, false),
	BUILDTEAM("Build team", "[BUILD TEAM]", 160, ChatColor.DARK_GREEN, true, false, false),
	//unless ranks
	SLOTH("Sloth", "[SLOTH]", 150, ChatColor.RED, true, false, false),
	APPLE("Apple", "[APPLE]", 140, ChatColor.GOLD, false, false, false),
	BEAM("Beam", "[BEAM]", 130, ChatColor.DARK_GREEN, false, false, false),
	//Jobs
	MOJANG("Mojang", "[MOJANG]", 120, ChatColor.GOLD, false, false, false),
	YT("YT", "[YT]", 110, ChatColor.GOLD, false, true, false),
	//DODODODODONATORRSS //0 - 100 Donators
	MVPP("MVP+", "[MVP+]", 100, ChatColor.AQUA, false, true, false),
	MVP("Mvp", "[MVP]", 80, ChatColor.AQUA , false, true, false),
	VIPP("Vip+", "[VIP+]", 60, ChatColor.GREEN, false, true, false),
	VIP("Vip", "[VIP]", 40,ChatColor.GREEN, false, true, false),
	DEFAULT("Default", "", 20, ChatColor.GRAY, false, false, false);

	public String Name;
	public String Prefix;
	public int piority;
	public ChatColor Color;
	public boolean IsStaff;
	public boolean IsDonator;
	public boolean IsOp;

	private Rank(String name, String Prefix, int piority, ChatColor color, Boolean IsStaff, boolean isDonator, boolean IsOp)
	{
		this.Name = name;
		this.Prefix = Prefix;
		this.piority = piority;
		this.Color = color;
		this.IsStaff = IsStaff;
		this.IsDonator = isDonator;
		this.IsOp = IsOp;
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
	public boolean IsStaff(Rank rank){
		return this.IsStaff(rank);
	}
	public boolean IsDonator(Rank rank){
		return this.IsDonator(rank);
	}
	public boolean IsOp(Rank rank){
		return this.IsOp(rank);
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