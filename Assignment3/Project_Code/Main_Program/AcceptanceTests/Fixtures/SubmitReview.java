/**
 * Generated by FITpro Fixture Generator
 */
package Fixtures;

import org.orm.PersistentException;

import controllers.CustomerController;
import fit.ActionFixture;
import good_reading.BookReview;
import good_reading.Customer;
import good_reading.SystemUser;

/*
 * TODO: modify class to match the FIT test - edit and add methods as required.
 */
public class SubmitReview extends ActionFixture {

	BookReview review;
	BookReview check_review;
	SystemUser user;

    
	public void initialize() {
		review = new BookReview();
		check_review = new BookReview();
		user = new Customer();
		
		review.set_approved(false);
		review.set_bid(1);
		review.set_costumerName("temp");
		review.set_review("this is the review");
	}
  
	
	public boolean SubmitReview()
	{
		if(IsCustomer())
		{
			if(CustomerController.SubmitReview(review))
				return true;
		}
		return false;
	}
	
	
	public boolean CheckIfSubmited()
	{
		try {
			check_review = BookReview.getBookReviewByORMID(review.get_rid());
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		
		if(check_review.get_approved().equals(review.get_approved()) &&
				check_review.get_bid() == review.get_bid() &&
				check_review.get_costumerName().equals(review.get_costumerName()) &&
				check_review.get_review().equals(review.get_review()) &&
				check_review.get_rid() == review.get_rid())
			return true;
		
		return false; 
	}
	
	
	public boolean IsCustomer()
	{
		return (user instanceof Customer);
	}
	
	
	public void SetReviewText(String text)
	{
		review.set_review(text);
	}
	
	
	public void SetUser()
	{
		if(user instanceof Customer)
			user = new SystemUser();
		else if(user instanceof SystemUser)
			user = new Customer();
	}
}

