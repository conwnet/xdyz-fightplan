package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Village extends Database {
	private int id;
	private String name, description, team, remark;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getTeam() {
		return team;
	}
	
	public void setTeam(String team) {
		this.team = team;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public static Village getVillage(int id) {
		Connection connection = getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet =  statement.executeQuery("select * from `village` where `id`='" + id + "'");
			if(resultSet.next()) {
				Village village = new Village();
				village.setId(id);
				village.setName(resultSet.getString("name"));
				village.setDescription(resultSet.getString("description"));
				village.setTeam(resultSet.getString("team"));
				village.setRemark(resultSet.getString("remark"));
				return village;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(statement != null)
					statement.close();
				if(connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		return null;
	}
	
	public static List<Village> getVillages(String sql) {
		Connection connection = getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet =  statement.executeQuery(sql);
			List<Village> villages = new LinkedList<Village>();
			while(resultSet.next()) {
				Village village = new Village();
				village.setId(resultSet.getInt("id"));
				village.setName(resultSet.getString("name"));
				village.setDescription(resultSet.getString("description"));
				village.setTeam(resultSet.getString("team"));
				village.setRemark(resultSet.getString("remark"));
				villages.add(village);
			}
			return villages;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(statement != null)
					statement.close();
				if(connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		return null;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}








