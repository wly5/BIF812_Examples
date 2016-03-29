import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JDBC_Example {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		//use the class loader to import the JDBC driver
		//don't forget to import this JAR into your project FIRST - see notes!
		Class.forName("com.mysql.jdbc.Driver");
		//connect to your database
		String username = "bif";
		String password = "java";
		/*
		*this example connects to a database on a localshost
		*for you guys replace localhost with zenit.senecac.on.ca 
		*and replace biftest with the name of your database if you have more than one
		**/
		String databaseURL = "jdbc:mysql://localhost/biftest";
		//note you can compose strings dynamically instead of hard coding them (left as an exercise...)
		String query1 = "SELECT id, name, address FROM patients";
		String insertQuery = "INSERT INTO patients VALUES (NULL, 'Marek', '1 Seneca Way')";
		String updateQuery = "UPDATE patients SET address = 'a van down by the river' WHERE name in('Marek')";
		String deleteQuery = "DELETE FROM patients WHERE name = 'Marek'";
		//drop a table
		//String dropTable = "DROP TABLE patients";
		//create a table
		//String createTable = "CREATE TABLE patients (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), address VARCHAR(30))"; 
		//the above two queries would use executeUpdate not executeQuery
		Connection conn = null;
		Statement stmt = null;
		ResultSet records = null;
		System.out.println("attempting to connect to database: " + databaseURL + " with username: " + username + " and password: " + password);
		try {
			conn  = DriverManager.getConnection(databaseURL, username, password);
			System.out.println("Database connection established!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(conn != null){
			//get an instance of Statement to interact with the database
			try {
				stmt = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(stmt != null)
			{
				//do stuff!
				System.out.println("requesting records from the database");
				try {
					records = stmt.executeQuery(query1);
					while(records.next()){
						int id = records.getInt("id");
						String name = records.getString("name");
						String address = records.getString("address");
						System.out.println("ID: " + id + " name: " + name + " address: " + address);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("insert a record");
				try{
					stmt.executeUpdate(insertQuery);
					System.out.println("the updated table is: ");
					records = stmt.executeQuery(query1);
					while(records.next()){
						int id = records.getInt("id");
						String name = records.getString("name");
						String address = records.getString("address");
						System.out.println("ID: " + id + " name: " + name + " address: " + address);
					}
				} catch (SQLException e){
					e.printStackTrace();
				}
				//updating records
				System.out.println("update a record");
				try{
					stmt.executeUpdate(updateQuery);
					System.out.println("the updated table is: ");
					records = stmt.executeQuery(query1);
					while(records.next()){
						int id = records.getInt("id");
						String name = records.getString("name");
						String address = records.getString("address");
						System.out.println("ID: " + id + " name: " + name + " address: " + address);
					}
				} catch (SQLException e){
					e.printStackTrace();
				}
				//delete records
				System.out.println("delete one or more records");
				try{
					stmt.executeUpdate(deleteQuery);
					System.out.println("the updated table is: ");
					records = stmt.executeQuery(query1);
					while(records.next()){
						int id = records.getInt("id");
						String name = records.getString("name");
						String address = records.getString("address");
						System.out.println("ID: " + id + " name: " + name + " address: " + address);
					}
				} catch (SQLException e){
					e.printStackTrace();
				}
				
			}
		}
	}

}