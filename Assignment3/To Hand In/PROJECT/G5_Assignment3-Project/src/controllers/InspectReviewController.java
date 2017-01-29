package controllers;

import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import common.Message;
import good_reading.Book;
import good_reading.BookReview;
import good_reading.GoodReadingPersistentManager;

public class InspectReviewController {
	/**
	 * The function find out a list BookReview for all awaiting approval review (_approved == 0)
	 * @return  returns Message that containing the list
	 * @throws PersistentException extends PersistentException class
	 */
	public static Message InspectReviews() throws PersistentException{
		
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
	/**
	 * The function erases the review form database
	 * @param rid Review id
	 */
	public static void RejectReview(int rid){
		
		BookReview br = null;
		PersistentSession session = null;
		
		try {
			session = GoodReadingPersistentManager.instance().getSession();
			PersistentTransaction t = session.beginTransaction();
			br = BookReview.getBookReviewByORMID(rid);
			session.delete(br);
			t.commit();
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
			
		}
	}
	/**
	 * The function publishes the review
	 * @param rid Review id
	 * @param textReview String of Review
	 */
	public static void PublishReview(int rid,String textReview){
		BookReview br = null;
		PersistentSession session = null;
		
		try {
			session = GoodReadingPersistentManager.instance().getSession();
			PersistentTransaction t = session.beginTransaction();
			br = BookReview.getBookReviewByORMID(rid);
			br.set_review(textReview);
			br.set_approved(true);
			session.update(br);
			t.commit();
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		
	}
	
	
		
	
}
