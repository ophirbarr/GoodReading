package controllers;

import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import common.Message;
import good_reading.Book;
import good_reading.BookReview;
import good_reading.Book_Author;
import good_reading.GoodReadingPersistentManager;

public class ManagerController {
	/**
	 * The function find out a list Book for all the books that appear in the catalog (_viewStatus == 1) and their author
	 * @return returns Message that containing the Book list and author list
	 */
	public static Message ManageCatalog(){

		Book[] books = null;
		String authors =null;
		Message msg = new Message("","");
		try {
			books = Book.listBookByQuery("_viewStatus = '1'", null);
			for(int i=0;i<books.length;i++)
			//authors = Book_Author.loadBook_AuthorByQuery("_bid ", orderBy)
			msg.add(books);
		} catch (PersistentException e) {
			e.printStackTrace();	
		}
		
		return msg;
	}
	
	
	public static void AddToCatalog(int bid){
		
		Book book;
		PersistentSession session = null;
		
		try {
			session = GoodReadingPersistentManager.instance().getSession();
			PersistentTransaction t = session.beginTransaction();
			book = Book.getBookByORMID(bid);
			book.set_viewStatus(true);
			t.commit();
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
			
		}
	}
	
public static void RemoveFromCatalog(int bid){
		
		Book book;
		PersistentSession session = null;
		
		try {
			session = GoodReadingPersistentManager.instance().getSession();
			PersistentTransaction t = session.beginTransaction();
			book = Book.getBookByORMID(bid);
			book.set_viewStatus(false);
			t.commit();
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
			
		}
	}

}
