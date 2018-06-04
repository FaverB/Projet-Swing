package ci.codeurs.service.impl;

import java.util.List;

import ci.codeurs.dao.IClientDao;
import ci.codeurs.dao.impl.ClientDao;
import ci.codeurs.domaine.Client;
import ci.codeurs.service.IClientService;

public class ClientService implements IClientService {
	
	IClientDao clientDao = new ClientDao();

	@Override
	public boolean ajouter(Client t) {
		if ((!"".equals(t.getNom()) && (!"".equals(t.getPrenom())))) {
			clientDao.save(t);
			return true;
		}
		return false;
	}

	@Override
	public boolean suprimer(Integer pk) {
		if (clientDao.readOne(pk) != null) {
			clientDao.delete(pk);
			return true;
		}
		return false;
	}

	@Override
	public boolean modifier(Client t) {
		if (clientDao.readOne(t.getId()) != null) {
			clientDao.update(t);
			return true;
		}
		return false;
	}

	@Override
	public Client lireUn(Integer pk) {
		return clientDao.readOne(pk);
	}

	@Override
	public List<Client> lireTous() {
		return clientDao.readAll();
	}

	@Override
	public int totalClient() {
		return clientDao.nbreDeClient();
	}

	@Override
	public List<Client> dernieresInsertions(int nbr) {
		if (nbr > 0) {
			return clientDao.derniersEnregistrement(nbr);
		}
		return null;
	}

}
