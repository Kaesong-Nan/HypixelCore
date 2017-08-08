package me.Ikeetjeop.hypixel.utilities.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import me.Ikeetjeop.hypixel.HypixelCore;

public class MysqlInfo {
	protected Connection connection;
	protected String host, database, username, password;
	protected String table;
	protected int port;

	private static MysqlInfo instance;
	public MysqlInfo() {
		instance = this;
	}
	public static MysqlInfo getInstance() {
		return instance;
	}

	public static HypixelCore plugin = HypixelCore.getInstance();
	public void mysqlSetup(){
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
				setConnection(DriverManager.getConnection("jdbc:mysql://" + this.host + ":" 
						+ this.port + "/" + this.database, this.username, this.password));

				Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "MYSQL CONNETCTTETETET!!! :=DD");
				Mysqldata.getInstance().createTable();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection setConnection(Connection connection) {
		return connection;
	}

	public Connection getConnection() {
		return connection;
	}
}

