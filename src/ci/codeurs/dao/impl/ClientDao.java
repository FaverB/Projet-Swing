package ci.codeurs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import ci.codeurs.dao.IClientDao;
import ci.codeurs.domaine.Client;

public class ClientDao implements IClientDao {

	private final String SAVEQuery = "INSERT INTO client(nom, prenom, contact, fonction, sexe) VALUES(?,?,?,?,?)";
	private final String UPDATEQuery = "UPDATE client SET nom=?, prenom=?, contact=?, fonction=?, sexe=? WHERE id=?";
	private final String DELETEQuery = "DELETE FROM client WHERE id=?";
	private final String READONEQuery = "SELECT * FROM client WHERE id=?";
	private final String READALLQuery = "SELECT * FROM client";
	private final String NBRClientQuery = "SELECT COUNT(*) FROM client";
	private final String DERNIERSEnrgQuery = "SELECT * FROM client ORDER BY id DESC LIMIT ?";
	Connection conn = Singleton.getConnection();
	PreparedStatement ps;

	@Override
	public boolean save(Client t) {
		int retour = -1;
		try {
			ps = conn.prepareStatement(SAVEQuery);
			ps.setString(1, t.getNom());
			ps.setString(2, t.getPrenom());
			ps.setString(3, t.getContact());
			ps.setString(4, t.getFonction());
			ps.setString(5, t.getSexe());
			retour = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retour > 0;
	}

	@Override
	public boolean update(Client t) {
		int retour = -1;
		try {
			ps = conn.prepareStatement(UPDATEQuery);
			ps.setString(1, t.getNom());
			ps.setString(2, t.getPrenom());
			ps.setString(3, t.getContact());
			ps.setString(4, t.getFonction());
			ps.setString(5, t.getSexe());
			ps.setInt(6, t.getId());
			retour = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return retour > 0;
	}

	@Override
	public boolean delete(Integer id) {
		int retour = -1;
		try {
			ps = conn.prepareStatement(DELETEQuery);
			ps.setInt(1, id);
			retour = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retour > 0;
	}

	@Override
	public Client readOne(Integer id) {
		Client client = new Client();
		try {
			ps = conn.prepareStatement(READONEQuery);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				client.setId(rs.getInt("id"));
				client.setNom(rs.getString("nom"));
				client.setPrenom(rs.getString("prenom"));
				client.setContact(rs.getString("contact"));
				client.setFonction(rs.getString("fonction"));
				client.setSexe(rs.getString("sexe"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return client;
	}

	@Override
	public List<Client> readAll() {
		List<Client> listClients = new LinkedList<>();
		Client client = null;
		try {
			ps = conn.prepareStatement(READALLQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				client = new Client();
				client.setId(rs.getInt("id"));
				client.setNom(rs.getString("nom"));
				client.setPrenom(rs.getString("prenom"));
				client.setContact(rs.getString("contact"));
				client.setFonction(rs.getString("fonction"));
				client.setSexe(rs.getString("sexe"));
				listClients.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listClients;
	}

	@Override
	public int nbreDeClient() {
		int record = 0;
		try {
			ps = conn.prepareStatement(NBRClientQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				record = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return record;
	}

	@Override
	public List<Client> derniersEnregistrement(int nbr) {
		List<Client> listClients = new LinkedList<>();
		Client client= null;
		try {
			ps = conn.prepareStatement(DERNIERSEnrgQuery);
			ps.setInt(1, nbr);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				client = new Client();
				client.setId(rs.getInt("id"));
				client.setNom(rs.getString("nom"));
				client.setPrenom(rs.getString("prenom"));
				client.setContact(rs.getString("contact"));
				client.setFonction(rs.getString("fonction"));
				client.setSexe(rs.getString("sexe"));
				listClients.add(client);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listClients;
	}

}
