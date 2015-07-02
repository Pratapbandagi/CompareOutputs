package Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;


public class DBconnection {
	
	
	private final Set<TagBean> tagBeans = new HashSet<TagBean>();
	private final Set<RelationshipBean> relationshipBeans = new HashSet<RelationshipBean>();
	
	/**
	 * @author Pratap
	 * @param Query
	 * Pass Query which gives basetag and child tag as output
	 * @throws IOException
	 */	
	public TagInput extractTagsFromDataBase(String ExecQuery) throws IOException {
		getTags(ExecQuery);
		TagInput tagBean = new TagInput(tagBeans,relationshipBeans);
		return tagBean;
	}
	
/**
 * @author Pratap
 * @param Query
 * Pass Query which gives basetag and child tag as output
 * @throws IOException
 */
	@SuppressWarnings("unused")
	public void getTags(String Query) throws IOException {
        
		File file = new File("resources//config.properties");
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		
 
		if (fileInput != null) {
			prop.load(fileInput);
		} else {
			throw new FileNotFoundException("property file '" + fileInput + "' not found in the classpath");
		}
		
		String Hostname = prop.getProperty("hostname");
		String port = prop.getProperty("port");
		String SID = prop.getProperty("SID");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
 
		ResultSet results;
		TagBean tagBean1 = null;
		TagBean tagBean2 = null;
		System.out.println("-------- Oracle JDBC Connection Testing ------");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
		}
		System.out.println("Oracle JDBC Driver Registered!");
		Connection connection = null;
		try {
			  String Connection1 = "jdbc:oracle:thin:@"+Hostname+":"+port+":"+SID;
			  connection = DriverManager.getConnection(Connection1,username,password);
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		if (connection != null) {
			System.out.println("Connected sucessfull to Database");
			try {
				PreparedStatement statement = connection.prepareStatement(Query);
				results = statement.executeQuery();
				while (results.next()) {
					String baseTag = results.getString("BASE_TAG");
					String ChildTag = results.getString("CHILD_TAG");
					tagBean1 = new TagBean(baseTag);
					tagBean2 = new TagBean(ChildTag);
					tagBeans.add(tagBean1);
					tagBeans.add(tagBean2);
					RelationshipBean relationshipBean = new RelationshipBean(tagBean1, tagBean2);
					relationshipBeans.add(relationshipBean);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Failed to make connection!");
		}
		System.out.println("Tags fom DB : "+tagBeans.size());
	}
	
	
	public void getChildTags(String Query) {
		TagBean tagBean1 = null;
		ResultSet results;
		System.out.println("-------- Oracle JDBC Connection Testing ------");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
		}
		System.out.println("Oracle JDBC Driver Registered!");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.3:1521:ORCL11G", "SPIREDBATOS1032",
					"SPIREDBATOS1032");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			try {
				PreparedStatement statement = connection.prepareStatement(Query);
				results = statement.executeQuery();
				while (results.next()) {
					String Tag = results.getString("CHILD_TAG");
					tagBean1 = new TagBean(Tag);
					tagBeans.add(tagBean1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Failed to make connection!");
		}
	
		
	}

	}