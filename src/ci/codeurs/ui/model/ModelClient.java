package ci.codeurs.ui.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import ci.codeurs.domaine.Client;
import ci.codeurs.service.IClientService;
import ci.codeurs.service.impl.ClientService;

public class ModelClient extends AbstractTableModel{
	
	IClientService clientService;
	
	// la liste initial des clients au depart
	List<Client> listClient;
	String[] entete = {"NOM", "PRENOM", "CONTACT", "FONCTION", "SEXE"};
	
	public ModelClient (){
		clientService = new ClientService();
		this.listClient = clientService.lireTous();
	}
	
	@Override
	public String getColumnName(int colonne) {
		// TODO Auto-generated method stub
		return entete[colonne];
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return entete.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listClient.size();
	}

	@Override
	public Object getValueAt(int ligne, int colonne) {
		switch(colonne) {
		
		case 0:
			return listClient.get(ligne).getNom();
		case 1:
			return listClient.get(ligne).getPrenom();
		case 2:
			return listClient.get(ligne).getContact();
		case 3:
			return listClient.get(ligne).getFonction();
		case 4:
			return listClient.get(ligne).getSexe();
		default:
		return null;
		}
		
	}
	
	public boolean ajouterClient(Client c) {
		if(clientService.ajouter(c)) {
			int nbrElementsAjoutes = clientService.totalClient() -  listClient.size();
			listClient.addAll(clientService.dernieresInsertions(nbrElementsAjoutes));
			this.fireTableRowsInserted( (listClient.size() - nbrElementsAjoutes), listClient.size());
			return true;
		}
		return false;
	}

}
