package sdg.demo.java;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

class MysqlCon {
	Connection con;
	private PreparedStatement preparedStatement = null;
	
	public MysqlCon() {
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
 
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			String user = prop.getProperty("dbusr");
			String password = prop.getProperty("dbpassword");
			String dburl = prop.getProperty("dburl");
			
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dburl, user, password);
		} catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public String searchEmpTitle(String name) {
		try {
			preparedStatement = con.prepareStatement("select * from emp where emp.name= ?");
			preparedStatement.setString(1, name);        
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next())
				return rs.getString(3);
			return "Not Exist";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}