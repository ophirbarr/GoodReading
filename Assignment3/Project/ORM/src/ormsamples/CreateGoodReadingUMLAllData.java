/**
 * Licensee: Ort Braude College
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateGoodReadingUMLAllData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = good_reading.GoodReadingPersistentManager.instance().getSession().beginTransaction();
		try {
			good_reading.BookReview good_ReadingBookReview = good_reading.BookReview.createBookReview();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _approved, _bid
			good_ReadingBookReview.save();
			good_reading.Domain good_ReadingDomain = good_reading.Domain.createDomain();
			// Initialize the properties of the persistent object here
			good_ReadingDomain.save();
			good_reading.SystemUser good_ReadingSystemUser = good_reading.SystemUser.createSystemUser();
			// Initialize the properties of the persistent object here
			good_ReadingSystemUser.save();
			good_reading.Costumer good_ReadingCostumer = good_reading.Costumer.createCostumer();
			// Initialize the properties of the persistent object here
			good_ReadingCostumer.save();
			good_reading.Book good_ReadingBook = good_reading.Book.createBook();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _purchaseCount, _price
			good_ReadingBook.save();
			good_reading.Subject good_ReadingSubject = good_reading.Subject.createSubject();
			// Initialize the properties of the persistent object here
			good_ReadingSubject.save();
			good_reading.Worker good_ReadingWorker = good_reading.Worker.createWorker();
			// Initialize the properties of the persistent object here
			good_ReadingWorker.save();
			good_reading.Book_Subject good_ReadingBook_Subject = good_reading.Book_Subject.createBook_Subject();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _sid
			good_ReadingBook_Subject.save();
			good_reading.Customer_Book good_ReadingCustomer_Book = good_reading.Customer_Book.createCustomer_Book();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _bid
			good_ReadingCustomer_Book.save();
			good_reading.Book_Author good_ReadingBook_Author = good_reading.Book_Author.createBook_Author();
			// Initialize the properties of the persistent object here
			good_ReadingBook_Author.save();
			good_reading.Book_Keywords good_ReadingBook_Keywords = good_reading.Book_Keywords.createBook_Keywords();
			// Initialize the properties of the persistent object here
			good_ReadingBook_Keywords.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateGoodReadingUMLAllData createGoodReadingUMLAllData = new CreateGoodReadingUMLAllData();
			try {
				createGoodReadingUMLAllData.createTestData();
			}
			finally {
				good_reading.GoodReadingPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
