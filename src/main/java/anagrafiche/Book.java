package anagrafiche;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DB;

public class Book {
	
	private Author autore;
	private Category categoria;
	private int id;
	private String title;
	private float price;
	
	public Book(Author aut, Category cat, String tit, float pr) {
		this.autore = aut;
		this.categoria = cat;
		this.title = tit;
		this.price = pr;
	}
	
	public Book(int id, Author aut, Category cat, String tit, float pr) {
		this( aut, cat, tit, pr);
		this.id = id; 
	}
	
	public Author getAutore() {
		return autore;
	}
	public void setAutore(Author autore) {
		this.autore = autore;
	}
	public Category getCategoria() {
		return categoria;
	}
	public void setCategoria(Category categoria) {
		this.categoria = categoria;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public float getPrice() {
		return this.price;
	}
	
	public static Book getBookById(int idBook) throws Exception {
		
		//collego al db
		//invio lo statement
		PreparedStatement stmBook = DB.getPreparedStmt("SELECT book.id as idBook, title, price, author.id as idAuthor, author.name, author.lastname, category.id as idCategory, category.name as 'category' FROM `book` INNER JOIN author ON book.author_id = author.id INNER JOIN category on book.category_id = category.id WHERE book.id = ? ");
		//recupero il resultSet
		stmBook.setInt(1,idBook); 
		ResultSet rsB = stmBook.executeQuery();
		//popolo il libro recuoperato (se esiste)
		if(rsB.next()) {
			//Category(int id, String n)
			//Category cat = new Category(rsB.getInt("idCategory"),rsB.getString("category"));
			//Author(int id, String n, String c)
			//Author aut   = new Author(rsB.getInt("idAuthor"),rsB.getString("name"), rsB.getString("lastname"));
			//Book(int id, Author aut, Category cat, String tit, float pr)
			Book libro   = new Book(
								rsB.getInt("idBook"),
								new Author(rsB.getInt("idAuthor"),rsB.getString("name"), rsB.getString("lastname")),
								new Category(rsB.getInt("idCategory"),rsB.getString("category")),
								rsB.getString("title"), rsB.getFloat("price"));
			return libro;
		}
		
		//return del libro
		return null;
		
	}
	
	public static ArrayList<Book> getAll() throws Exception { 
		//connessione al db
		//inviare uno statement 
		PreparedStatement stmtB = DB.getPreparedStmt("SELECT book.id, title, price, author.name, author.lastname, category.name as 'category' FROM `book` INNER JOIN author ON book.author_id = author.id INNER JOIN category on book.category_id = category.id"); 
		//recuperare il recordset / resultSet
		ResultSet rsB = stmtB.executeQuery(); 
		//impacchettarlo dentro una lista COME ?
		ArrayList<Book> libri = new ArrayList<>();
		while(rsB.next()) {
			//ad ogni giro di while ho un libro
			//Book(int id, Author aut, Category cat, String tit, float pr)
			libri.add(new Book(
					rsB.getInt("id"),
					new Author(rsB.getString("name"), rsB.getString("lastname")),
					new Category(rsB.getString("category")),
					rsB.getString("title"),
					rsB.getFloat("price")));
		}
		
		//restituirlo
		return libri;
		 
	}
	
	

}
