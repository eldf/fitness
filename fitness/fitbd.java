package fitness;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class fitbd {
	
	
	public  void almacenar(List<fitness> lfit) {
		
		Statement stmt = null;

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/fitnes", "postgres",
					"fitnes");
			stmt = connection.createStatement();
			
			//delete from fitnes2;
			stmt = connection.createStatement();
	         String sql1 = "DELETE from fitnes2 ";
	         stmt.executeUpdate(sql1);
	         //connection.commit();
			
			for (int i=0;i<lfit.size();i++) {
				
				String sql = "INSERT INTO fitnes2 (activity_category,distance,calories,start_date,last_updated) "
			            + "VALUES ('"+lfit.get(i).getActivity_category()+"', '"+lfit.get(i).getDistance()+"', '"+lfit.get(i).getCalories()+"','"+lfit.get(i).getStart_time()+"','"+lfit.get(i).getLast_updated()+"');";
				System.out.println(sql);     
				stmt.executeUpdate(sql);
				
			}
			
			/*String sql = "INSERT INTO fitnes2 (activity_category,distance,calories) "
		            + "VALUES ('a', '123', '555');";
		         stmt.executeUpdate(sql);
		       */  
		         stmt.close();
		         //connection.commit();
		         connection.close();
			

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
		
		
		
	

}
