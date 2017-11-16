package client;
import java.util.Date;

public class Client {
	private String nom;
	private String prenom;
	private String adresse;
	private Date dateSouscription;
	private int id;
	
	public Client(){}
	
	public Client(int id,String nom,String prenom,String adresse,Date dateSouscription){
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateSouscription = dateSouscription;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDateSouscription() {
		return dateSouscription;
	}

	public void setDateSouscription(Date dateSouscription) {
		this.dateSouscription = dateSouscription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
