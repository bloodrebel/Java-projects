package database;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class Konekcija {
	
	private String host;
	private String dbusername;
	private String dbpassword;
	private String base;
	
	protected Connection connection ;
	
	public Konekcija() {
		host = "localhost";
		dbusername = "root";
		dbpassword = "";
		base = "knjiznica";
		connect();
	}
	
	public void connect () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connection = DriverManager.getConnection(
						"jdbc:mysql://"+ host +"/"
								+base 
								+"?user="+ dbusername
								+"&password="+dbpassword
						
						
						);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("greska s korisnickim podatcima");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Greska u konekciji");
		}
		
	}
	
	public void disconnect() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("greska u odspajanju");
		}
		
	}

}
