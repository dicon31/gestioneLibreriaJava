package anagrafiche;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DB;

public class Author {
	
	private String nome;
	private String cognome;
	private int id;
	
	public Author(String n, String c) {
		this.cognome = c;
		this.nome = n;
	}
	
	public Author(int id, String n, String c) {
		this(n,c);
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getId() {
		return this.id;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public static Author getAuthorById(int id) throws Exception{
		PreparedStatement stmtAutori = DB.getPreparedStmt("SELECT * FROM author WHERE id= ?");
		stmtAutori.setInt(1, id);
		ResultSet rsAutori = stmtAutori.executeQuery(); 
		if(rsAutori.next()) {
			return new Author( rsAutori.getInt("id"),rsAutori.getString("name"),rsAutori.getString("lastname"));
			
		};
		return null;		
		
	}
	
	public static ArrayList<Author> getAll() throws Exception { 
		//connessione al db
		//inviare uno statement
		PreparedStatement stmtAutori = DB.getPreparedStmt("SELECT * FROM author ORDER BY name"); 
		//recuperare il recordset / resultSet
		ResultSet rsAutori = stmtAutori.executeQuery(); 
		//impacchettarlo dentro una lista
		ArrayList<Author> autori = new ArrayList<>();
		while(rsAutori.next()) {
			//ad ogni giro di while ho un autore
			autori.add(new Author(
							rsAutori.getInt("id"),
							rsAutori.getString("name"),
							rsAutori.getString("lastname")
					));
		}
		
		//restituirlo
		return autori;
		 
	}
	


}
