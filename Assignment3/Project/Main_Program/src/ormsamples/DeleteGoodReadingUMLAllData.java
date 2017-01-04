/**
 * Licensee: Ort Braude College
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteGoodReadingUMLAllData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = good_reading.GoodReadingPersistentManager.instance().getSession().beginTransaction();
		try {
			good_reading.BookReview good_ReadingBookReview = good_reading.BookReview.loadBookReviewByQuery(null, null);
			good_ReadingBookReview.delete();
			good_reading.Domain good_ReadingDomain = good_reading.Domain.loadDomainByQuery(null, null);
			good_ReadingDomain.delete();
			good_reading.SystemUser good_ReadingSystemUser = good_reading.SystemUser.loadSystemUserByQuery(null, null);
			good_ReadingSystemUser.delete();
			good_reading.Customer good_ReadingCustomer = good_reading.Customer.loadCustomerByQuery(null, null);
			good_ReadingCustomer.delete();
			good_reading.Book good_ReadingBook = good_reading.Book.loadBookByQuery(null, null);
			good_ReadingBook.delete();
			good_reading.Subject good_ReadingSubject = good_reading.Subject.loadSubjectByQuery(null, null);
			good_ReadingSubject.delete();
			good_reading.Worker good_ReadingWorker = good_reading.Worker.loadWorkerByQuery(null, null);
			good_ReadingWorker.delete();
			good_reading.Book_Subject good_ReadingBook_Subject = good_reading.Book_Subject.loadBook_SubjectByQuery(null, null);
			good_ReadingBook_Subject.delete();
			good_reading.Customer_Book good_ReadingCustomer_Book = good_reading.Customer_Book.loadCustomer_BookByQuery(null, null);
			good_ReadingCustomer_Book.delete();
			good_reading.Book_Author good_ReadingBook_Author = good_reading.Book_Author.loadBook_AuthorByQuery(null, null);
			good_ReadingBook_Author.delete();
			good_reading.Book_Keywords good_ReadingBook_Keywords = good_reading.Book_Keywords.loadBook_KeywordsByQuery(null, null);
			good_ReadingBook_Keywords.delete();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteGoodReadingUMLAllData deleteGoodReadingUMLAllData = new DeleteGoodReadingUMLAllData();
			try {
				deleteGoodReadingUMLAllData.deleteTestData();
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
