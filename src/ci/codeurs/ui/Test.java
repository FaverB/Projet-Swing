package ci.codeurs.ui;

import ci.codeurs.dao.IClientDao;
import ci.codeurs.dao.impl.ClientDao;
import ci.codeurs.domaine.Client;
import ci.codeurs.service.IClientService;
import ci.codeurs.service.impl.ClientService;

public class Test {

	public static void main(String[] args) {

		Client client = new Client("KEIPO", "LEKODE", "88 55 22 00", "COMMERÇANT", "MALE");
        IClientDao clientDao = new ClientDao();
        //clientDao.save(client);
        //System.out.println(clientDao.readOne(2));
        //System.out.println(clientDao.readAll());
        System.out.println("***************test service****************************");
        //System.out.println(clientDao.derniersEnregistrement(2));
       
        IClientService clientService = new ClientService();
        
        System.out.println(clientService.lireTous());
	}
}
