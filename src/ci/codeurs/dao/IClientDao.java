package ci.codeurs.dao;

import java.util.List;

import ci.codeurs.domaine.Client;

public interface IClientDao extends IDao<Client, Integer> {
	
	public int nbreDeClient();
	
	public List<Client> derniersEnregistrement(int nbr);

}
