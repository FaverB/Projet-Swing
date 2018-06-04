package ci.codeurs.service;

import java.util.List;

import ci.codeurs.domaine.Client;

public interface IClientService extends IService<Client, Integer>{
	
	public int totalClient();
	public List<Client> dernieresInsertions(int nbr);
	

}
