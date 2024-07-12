package auth;

import javax.servlet.http.HttpSession;

public class User {
	public final static String USERKEY = "USERTOKEN"; // nella sessione puoi salvare varie cose mettiamo un atrributo chiave con quale cerchi l'attributo
	private final int id;
	private String nome;
	private String cognome;
	private final String email;
	
	public User(int id, String n, String c, String e) {
		this.id = id;
		this.nome = n;
		this.cognome = c;
		this.email = e;
		
	}
	//set torna true ha fatto gia il logion
	//altrimenti non sei loggato
	public static boolean isLogged(HttpSession session) { //metodo booleano (true/false) 
		
		return getUser(session) != null;
	}
	//verifica data una chiave (USERKEY) che esiste nella sessione
	public static User getUser(HttpSession session) {
		// prendo l'Object dentro la sessionKey e verifico che sia di tipo User
		try {
			User u = (User)session.getAttribute(USERKEY);
			return u;
		}
		// se per qualche motivo l'oggetto che trovo nella sessionKey non è User -> FAIL
		catch(ClassCastException e) {
			return null;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

}
