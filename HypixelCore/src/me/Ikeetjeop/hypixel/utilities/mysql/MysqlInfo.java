package me.Ikeetjeop.hypixel.utilities.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import me.Ikeetjeop.hypixel.HypixelCore;

public class MysqlInfo {
	public static Connection connection;
	public static String host, database, username, password;
	public static String table;
	public static int port;

	public static HypixelCore plugin = HypixelCore.getInstance();
	public static void mysqlSetup(){
		host = plugin.getConfig().getString("MysqlConnection.host");
		port = plugin.getConfig().getInt("MysqlConnection.port");
		username = plugin.getConfig().getString("MysqlConnection.username");
		database = plugin.getConfig().getString("MysqlConnection.database");
		password = plugin.getConfig().getString("MysqlConnection.password");
		table = plugin.getConfig().getString("MysqlConnection.table");

		try{
			synchronized (HypixelCore.getInstance().getClass()){
				if(getConnection() != null && !getConnection().isClosed()){
					return;
				}

				Class.forName("com.mysql.jdbc.Driver");
				setConnection(DriverManager.getConnection("jdbc:mysql://" + MysqlInfo.host + ":" 
						+ MysqlInfo.port + "/" + MysqlInfo.database, MysqlInfo.username, MysqlInfo.password));

				Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "MYSQL CONNETCTTETETET!!! :=DD");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static Connection setConnection(Connection connection) {
		return connection;
	}

	public static Connection getConnection() {
		return connection;
	}

}
