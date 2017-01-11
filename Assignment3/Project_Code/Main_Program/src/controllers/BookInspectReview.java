package controllers;

import org.dom4j.Branch;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import common.Message;
import good_reading.Book;
import good_reading.BookReview;
import good_reading.GoodReadingPersistentManager;
import good_reading.SystemUser;

public class BookInspectReview {
	
	public static Message getInspectReview() throws PersistentException{
		
		BookReview[] br = null;
		String[] name_books;
		Message msg = new Message("","");
		try {
			br = BookReview.listBookReviewByQuery("_approved = '0'", null);
			name_books = new String[br.length];
			for(int i=0;i<br.length;i++)
				name_books[i] = (Book.getBookByORMID(br[i].get_bid())).get_title();
			msg.add(br);
			msg.add(name_books);
		} catch (PersistentException e) {
			e.printStackTrace();	
		}
		
		return msg;
	}
	
	public static void EraseReview(int rid){
		try {
			PersistentSession session = GoodReadingPersistentManager.instance().getSession();
			PersistentTransaction t = session.beginTransaction();
			BookReview br = BookReview.getBookReviewByORMID(rid);
			session.delete(br);
			t.commit();
			session.close();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void Publish(int rid){
		BookReview br = null;
		PersistentSession session = null;
		
		try {
			br = BookReview.getBookReviewByORMID(rid);
			session = GoodReadingPersistentManager.instance().getSession();
			PersistentTransaction t = session.beginTransaction();
			br.set_approved(true);
			session.update(br);
			t.commit();
			session.close();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
