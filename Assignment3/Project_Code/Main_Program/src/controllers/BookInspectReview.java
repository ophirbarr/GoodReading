package controllers;

import org.orm.PersistentException;
import org.orm.PersistentSession;

import good_reading.BookReview;
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
}
