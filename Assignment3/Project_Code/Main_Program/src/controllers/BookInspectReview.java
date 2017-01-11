package controllers;

import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import good_reading.BookReview;
import good_reading.GoodReadingPersistentManager;
import good_reading.SystemUser;

public class BookInspectReview {
	
	public static BookReview[] getInspectReview() throws PersistentException{
		
		BookReview[] br = null;
		
		try {
			br = BookReview.listBookReviewByQuery("_approved = '0'", null);
		} catch (PersistentException e) {
			e.printStackTrace();	
		}
		
		return br;
	}
	
	public static void EraseReview(int rid){
		try {
			String Review_num = ""+rid;
			PersistentSession session = GoodReadingPersistentManager.instance().getSession();
			PersistentTransaction t = session.beginTransaction();
			session.createQuery("DELETE FROM bookreview WHERE _rid = "+Review_num);
			t.commit();
			session.close();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void Publish(int rid){
		BookReview br = null;
		try {
			br = BookReview.getBookReviewByORMID(rid);
			br.set_approved(true);
			PersistentSession session = GoodReadingPersistentManager.instance().getSession();
			PersistentTransaction t = session.beginTransaction();
			session.update(br);
			t.commit();
			session.close();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
