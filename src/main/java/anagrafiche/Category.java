package anagrafiche;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DB;

public class Category {
	
	private int id;
	private String nome;
	
	 
	public Category (String n) {
		this.nome = n;
	}
	public Category(int id, String n) {
		this(n);
		this.id = id; 
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}
	
	public static Category getCategoryById(int id) throws Exception{
		PreparedStatement stmtCategorie = DB.getPreparedStmt("SELECT * FROM category WHERE id= ?");
		stmtCategorie.setInt(1, id);
		
		ResultSet rsCategorie = stmtCategorie.executeQuery(); 
		if(rsCategorie.next()) {
			return new Category( rsCategorie.getInt("id"),rsCategorie.getString("name")
			);
			
		};
		return null; 
	}
	
	public static ArrayList<Category> getAll() throws Exception { 
		//connessione al db
		//inviare uno statement
		PreparedStatement stmtCat = DB.getPreparedStmt("SELECT * FROM category"); 
		//recuperare il recordset / resultSet
		ResultSet rsCat = stmtCat.executeQuery(); 
		//impacchettarlo dentro una lista
		ArrayList<Category> categorie = new ArrayList<>();
		while(rsCat.next()) {
			//ad ogni giro di while ho un autore
			categorie.add(new Category(
					rsCat.getInt("id"),
					rsCat.getString("name")
				));
		}
		
		//restituirlo
		return categorie;
		 
	}
	
	

}
