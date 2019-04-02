package challenge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection createConnection() throws SQLException {
		try {
			return DriverManager.getConnection(
					"jdbc:sqlite:./src/main/resources/database.sqlite");
		} catch (SQLException e) {
			System.out.println("Falha ao conectar ao banco.");
			throw new RuntimeException(e);
		}
	}

}
