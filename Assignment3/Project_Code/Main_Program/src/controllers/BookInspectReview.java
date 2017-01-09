package controllers;

import org.orm.PersistentSession;

import good_reading.BookReview;

public class BookInspectReview {
	
	public static BookReview[] getInspectReview(){
		
		PersistentSession session = null;
		BookReview[] br;
		
		br = BookReview.listBookReviewByQuery(condition, orderBy);
	}
}
