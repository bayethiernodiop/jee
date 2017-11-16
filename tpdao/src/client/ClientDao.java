package client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ClientDao {

	private DataSource dataSource;

	public ClientDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(Client client) {

		String sql = "INSERT INTO CLIENT (NOM, PRENOM, ADRESSE, DATESOUSCRIPTION) VALUES (?, ?, ?, ?) ";
		try {
			PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, client.getNom());
			preparedStatement.setString(2, client.getPrenom());
			preparedStatement.setString(3, client.getAdresse());
			preparedStatement.setTimestamp(4, new Timestamp(client.getDateSouscription().getTime()));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Client client) {

		String sql = "DELETE FROM CLIENT WHERE id = ? ";
		try {
			PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, client.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Client> listClient() {

		String sql = "SELECT * FROM CLIENT;";

		try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			List<Client> clients = new ArrayList<Client>();
			while (resultSet.next()) {
				clients.add(new Client(resultSet.getInt("ID"), resultSet.getString("NOM"), resultSet.getString("PRENOM"),
						resultSet.getString("ADRESSE"), resultSet.getDate("DATESOUSCRIPTION")));
			}
			return clients;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
