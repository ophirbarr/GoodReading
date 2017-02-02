
package Fixtures;
import fit.ActionFixture;
import good_reading.Book;
import controllers.DatabaseManagementController;


public class AddNewBook extends ActionFixture {
	
	Book book;
	float bookPrice;
	boolean bookViewStatus;
	int bookPurchaseCount;
	DatabaseManagementController book1;
	int bookID;
	
	float NewbookPrice;
	boolean NewbookViewStatus;
	int NewbookPurchaseCount;
	int NewbookID;


	
	public void Initialize(){
		
		bookPrice=0;
		bookViewStatus=true;
		bookPurchaseCount=0;
		book=DatabaseManagementController.AddBook();
		bookID=book.get_bid();
	}


	public float getBookPrice() {
		return book.get_price();
	}


	public boolean isBookViewStatus() {
		return book.get_viewStatus();
	}

	

	public int getBookPurchaseCount() {
		return book.get_purchaseCount();
	}

	public int getbookID() {
		return book.get_bid();
	}


	public void setNewbookPrice(float _newbookPrice) {
		NewbookPrice = _newbookPrice;
	}



	public void setNewbookViewStatus(boolean _newbookViewStatus) {
		NewbookViewStatus = _newbookViewStatus;
	}



	public void setNewbookPurchaseCount(int _newbookPurchaseCount) {
		NewbookPurchaseCount = _newbookPurchaseCount;
	}


	public void setNewbookID(int _newbookID) {
		NewbookID = _newbookID;
	}
	
	public void UpdateSamePrice(float price)
	{
		book.set_price(price);
	}


	

	

	
	

}
