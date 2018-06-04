package ci.codeurs.domaine;

public class Client {
	private int id;
	private String nom;
	private String prenom;
	private String contact;
	private String fonction;
	private String sexe;
	
   public Client() {
	// TODO Auto-generated constructor stub
}

public Client(String nom, String prenom, String contact, String fonction, String sexe) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.contact = contact;
	this.fonction = fonction;
	this.sexe = sexe;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getContact() {
	return contact;
}

public void setContact(String contact) {
	this.contact = contact;
}

public String getFonction() {
	return fonction;
}

public void setFonction(String fonction) {
	this.fonction = fonction;
}

public String getSexe() {
	return sexe;
}

public void setSexe(String sexe) {
	this.sexe = sexe;
}

@Override
public String toString() {
	return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", contact=" + contact + ", fonction="
			+ fonction + ", sexe=" + sexe + "]\n";
}
   
   
}
