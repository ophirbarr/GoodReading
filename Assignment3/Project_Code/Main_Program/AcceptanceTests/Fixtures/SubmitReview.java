package Fixtures;

import fit.ActionFixture;
import good_reading.Book;
import good_reading.BookReview;


public class SubmitReview extends ActionFixture{

	public void Initialize()
	{
		Book book = new Book();
		
		book.set_title("book title");
		BookReview review = new BookReview();
		
		review.set_bid(book.get_bid());
		review.set_review("review text");
		review.set_costumerName("");
		review.set_approved(false);
	}
	
}
