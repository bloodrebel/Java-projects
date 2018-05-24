package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;

public class Base extends Konekcija {
	
	private Statement iskaz;
	
	public Base() {
		super();
	}
	
	public static final Base db = new Base();
	
	public ResultSet select(String sql) {
		
		try {
			iskaz=connection.createStatement();
			return iskaz.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Greska u select iskazu");
			return null;
		}
		
	}
	
	public PreparedStatement prepare(String sql) {
		try {
			return connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("greska u preparestatement");
			return null;
		}
		
	}

}
