package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Database {
	public static Connection getConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:data.db");
			Statement statement = connection.createStatement();
			//statement.executeQuery("create table if not exists `person` (`id` integer primary key autoincrement, `name` text, `town` text, `village` text, `home` text, `relation_with_host` text, `health_status` text, `culture_status` text, `tel_number` text, `political_status` text, `poor_property` text, `poor_reason` text, `remark` text)");
			statement.close();
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean execute(String sql) {
		System.out.println(sql);
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
			statement.close();
			connection.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean init() {
		Database.execute("drop table `person`");
		Database.execute("drop table `village`");
		Database.execute("create table `person` (`id` integer primary key autoincrement, `name` text, `icon` text, `town` text, `village` text, `home` text, `relation_with_host` text, `health_status` text, `culture_status` text, `tel_number` text, `political_status` text, `poor_property` text, `poor_reason` text, `remark` text, `labor_export` text, `house_reform` text)");
		Database.execute("create table `village` (`id` integer primary key autoincrement, `name` text, `description` text, `team` text, `remark` text)");
		Database.execute("insert into `village` (`name`, `description`, `team`, `remark`) values ('新立屯村', '', '', ''), ('双榆树村', '', '', ''), ('一间楼村', '', '', ''), ('贾家屯村', '', '', ''), ('腰营子村', '', '', ''), ('大石桥村', '', '', ''), ('莲花山村', '', '', ''), ('公立亨村', '', '', ''), ('东大门村', '', '', ''), ('冷家店村', '', '', '')");
		return true;
	}
}
















