package ci.codeurs.domaine;

public class Produit {
	private int id;
	private String designation;
	private double prix;
	private boolean etat;
	
	public Produit() {
		// TODO Auto-generated constructor stub
	}

	public Produit(String designation, double prix, boolean etat) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.etat = etat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", designation=" + designation + ", prix=" + prix + ", etat=" + etat + "]";
	}
	
	

}
