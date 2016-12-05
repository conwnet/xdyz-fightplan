package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Person extends Database {
	private int id;
	private String name, icon, town, village, home, relation_with_host, health_status, culture_status, tel_number, political_status, poor_property, poor_reason, remark, labor_export, house_reform;

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

	public String getRelation_with_host() {
		return relation_with_host;
	}

	public void setRelation_with_host(String relation_with_host) {
		this.relation_with_host = relation_with_host;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getHealth_status() {
		return health_status;
	}

	public void setHealth_status(String health_status) {
		this.health_status = health_status;
	}

	public String getCulture_status() {
		return culture_status;
	}

	public void setCulture_status(String culture_status) {
		this.culture_status = culture_status;
	}

	public String getTel_number() {
		return tel_number;
	}

	public void setTel_number(String tel_number) {
		this.tel_number = tel_number;
	}

	public String getPolitical_status() {
		return political_status;
	}

	public void setPolitical_status(String political_status) {
		this.political_status = political_status;
	}

	public String getPoor_property() {
		return poor_property;
	}

	public void setPoor_property(String poor_property) {
		this.poor_property = poor_property;
	}

	public String getPoor_reason() {
		return poor_reason;
	}

	public void setPoor_reason(String poor_reason) {
		this.poor_reason = poor_reason;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getLabor_export() {
		return labor_export;
	}

	public void setLabor_export(String labor_export) {
		this.labor_export = labor_export;
	}

	public String getHouse_reform() {
		return house_reform;
	}

	public void setHouse_reform(String house_reform) {
		this.house_reform = house_reform;
	}

	public boolean add() {
		StringBuffer buffer = new StringBuffer("insert into `person` (`name`, `icon`, `town`, `village`, `home`, `relation_with_host`, `health_status`, `culture_status`, `tel_number`, `political_status`, `poor_property`, `poor_reason`, `remark`, `labor_export`, `house_reform`) values (");
		buffer.append("'" + name + "', ");
		buffer.append("'" + icon + "', ");
		buffer.append("'" + town + "', ");
		buffer.append("'" + village + "', ");
		buffer.append("'" + home + "', ");
		buffer.append("'" + relation_with_host + "', ");
		buffer.append("'" + health_status + "', ");
		buffer.append("'" + culture_status + "', ");
		buffer.append("'" + tel_number + "', ");
		buffer.append("'" + political_status + "', ");
		buffer.append("'" + poor_property + "', ");
		buffer.append("'" + poor_reason + "', ");
		buffer.append("'" + remark + "', ");
		buffer.append("'" + labor_export + "', ");
		buffer.append("'" + house_reform + "')");
		return execute(buffer.toString());
	}
	
	public boolean save() {
		StringBuffer buffer = new StringBuffer("update `person` set ");
		buffer.append("`name`='" + name + "', ");
		buffer.append("`icon`='" + icon + "', ");
		buffer.append("`town`='" + town + "', ");
		buffer.append("`village`='" + village + "', ");
		buffer.append("`home`='" + home + "', ");
		buffer.append("`relation_with_host`='" + relation_with_host + "', ");
		buffer.append("`health_status`='" + health_status + "', ");
		buffer.append("`culture_status`='" + culture_status + "', ");
		buffer.append("`tel_number`='" + tel_number + "', ");
		buffer.append("`political_status`='" + political_status + "', ");
		buffer.append("`poor_property`='" + poor_property + "', ");
		buffer.append("`poor_reason`='" + poor_reason + "', ");
		buffer.append("`remark`='" + remark + "', ");
		buffer.append("`labor_export`='" + labor_export + "', ");
		buffer.append("`house_reform`='" + house_reform + "' ");
		buffer.append("where `id`=" + id);
		return execute(buffer.toString());
	}
	
	public Person() {
		
	}
	
	public static Person getPerson(int id) {
		Connection connection = getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet =  statement.executeQuery("select * from `person` where `id`='" + id + "'");
			if(resultSet.next()) {
				Person person = new Person();
				person.setId(id);
				person.setName(resultSet.getString("name"));
				person.setRelation_with_host(resultSet.getString("relation_with_host"));
				person.setHealth_status(resultSet.getString("health_status"));
				person.setCulture_status(resultSet.getString("culture_status"));
				person.setTel_number(resultSet.getString("tel_number"));
				person.setPolitical_status(resultSet.getString("political_status"));
				person.setPoor_property(resultSet.getString("poor_property"));
				person.setPoor_reason(resultSet.getString("poor_reason"));
				person.setHome(resultSet.getString("home"));
				person.setTown(resultSet.getString("town"));
				person.setVillage(resultSet.getString("village"));
				person.setRemark(resultSet.getString("remark"));
				person.setVillage(resultSet.getString("labor_export"));
				person.setHouse_reform(resultSet.getString("house_reform"));
				return person;
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
	
	public static List<Person> getPersons(String sql) {
		Connection connection = getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet =  statement.executeQuery(sql);
			List<Person> persons = new LinkedList<Person>();
			while(resultSet.next()) {
				Person person = new Person();
				person.setId(resultSet.getInt("id"));
				person.setName(resultSet.getString("name"));
				person.setRelation_with_host(resultSet.getString("relation_with_host"));
				person.setHealth_status(resultSet.getString("health_status"));
				person.setCulture_status(resultSet.getString("culture_status"));
				person.setTel_number(resultSet.getString("tel_number"));
				person.setPolitical_status(resultSet.getString("political_status"));
				person.setPoor_property(resultSet.getString("poor_property"));
				person.setPoor_reason(resultSet.getString("poor_reason"));
				person.setHome(resultSet.getString("home"));
				person.setTown(resultSet.getString("town"));
				person.setVillage(resultSet.getString("village"));
				person.setRemark(resultSet.getString("remark"));
				person.setLabor_export(resultSet.getString("labor_export"));
				person.setHouse_reform(resultSet.getString("house_reform"));
				persons.add(person);
			}
			return persons;
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
		// TODO Auto-generated method stub
		return getName();
	}
	
}







