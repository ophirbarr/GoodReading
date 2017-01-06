/**
 * Licensee: Ort Braude College
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateGoodReadingUMLAllData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = good_reading.GoodReadingPersistentManager.instance().getSession().beginTransaction();
		try {
			good_reading.BookReview good_ReadingBookReview = good_reading.BookReview.loadBookReviewByQuery(null, null);
			// Update the properties of the persistent object
			good_ReadingBookReview.save();
			good_reading.Domain good_ReadingDomain = good_reading.Domain.loadDomainByQuery(null, null);
			// Update the properties of the persistent object
			good_ReadingDomain.save();
			good_reading.SystemUser good_ReadingSystemUser = good_reading.SystemUser.loadSystemUserByQuery(null, null);
			// Update the properties of the persistent object
			good_ReadingSystemUser.save();
			good_reading.Customer good_ReadingCustomer = good_reading.Customer.loadCustomerByQuery(null, null);
			// Update the properties of the persistent object
			good_ReadingCustomer.save();
			good_reading.Book good_ReadingBook = good_reading.Book.loadBookByQuery(null, null);
			// Update the properties of the persistent object
			good_ReadingBook.save();
			good_reading.Subject good_ReadingSubject = good_reading.Subject.loadSubjectByQuery(null, null);
			// Update the properties of the persistent object
			good_ReadingSubject.save();
			good_reading.Worker good_ReadingWorker = good_reading.Worker.loadWorkerByQuery(null, null);
			// Update the properties of the persistent object
			good_ReadingWorker.save();
			good_reading.Customer_Book good_ReadingCustomer_Book = good_reading.Customer_Book.loadCustomer_BookByQuery(null, null);
			// Update the properties of the persistent object
			good_ReadingCustomer_Book.save();
			good_reading.Book_Author good_ReadingBook_Author = good_reading.Book_Author.loadBook_AuthorByQuery(null, null);
			// Update the properties of the persistent object
			good_ReadingBook_Author.save();
			good_reading.Book_Subject good_ReadingBook_Subject = good_reading.Book_Subject.loadBook_SubjectByQuery(null, null);
			// Update the properties of the persistent object
			good_ReadingBook_Subject.save();
			good_reading.Book_Keywords good_ReadingBook_Keywords = good_reading.Book_Keywords.loadBook_KeywordsByQuery(null, null);
			// Update the properties of the persistent object
			good_ReadingBook_Keywords.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving BookReview by BookReviewCriteria");
		good_reading.BookReviewCriteria good_ReadingBookReviewCriteria = new good_reading.BookReviewCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//good_ReadingBookReviewCriteria._rid.eq();
		System.out.println(good_ReadingBookReviewCriteria.uniqueBookReview());
		
		System.out.println("Retrieving Domain by DomainCriteria");
		good_reading.DomainCriteria good_ReadingDomainCriteria = new good_reading.DomainCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//good_ReadingDomainCriteria._did.eq();
		System.out.println(good_ReadingDomainCriteria.uniqueDomain());
		
		System.out.println("Retrieving SystemUser by SystemUserCriteria");
		good_reading.SystemUserCriteria good_ReadingSystemUserCriteria = new good_reading.SystemUserCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//good_ReadingSystemUserCriteria._uid.eq();
		System.out.println(good_ReadingSystemUserCriteria.uniqueSystemUser());
		
		System.out.println("Retrieving Customer by CustomerCriteria");
		good_reading.CustomerCriteria good_ReadingCustomerCriteria = new good_reading.CustomerCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//good_ReadingCustomerCriteria._uid.eq();
		System.out.println(good_ReadingCustomerCriteria.uniqueCustomer());
		
		System.out.println("Retrieving Book by BookCriteria");
		good_reading.BookCriteria good_ReadingBookCriteria = new good_reading.BookCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//good_ReadingBookCriteria._bid.eq();
		System.out.println(good_ReadingBookCriteria.uniqueBook());
		
		System.out.println("Retrieving Subject by SubjectCriteria");
		good_reading.SubjectCriteria good_ReadingSubjectCriteria = new good_reading.SubjectCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//good_ReadingSubjectCriteria._sid.eq();
		System.out.println(good_ReadingSubjectCriteria.uniqueSubject());
		
		System.out.println("Retrieving Worker by WorkerCriteria");
		good_reading.WorkerCriteria good_ReadingWorkerCriteria = new good_reading.WorkerCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//good_ReadingWorkerCriteria._uid.eq();
		System.out.println(good_ReadingWorkerCriteria.uniqueWorker());
		
		System.out.println("Retrieving Customer_Book by Customer_BookCriteria");
		good_reading.Customer_BookCriteria good_ReadingCustomer_BookCriteria = new good_reading.Customer_BookCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//good_ReadingCustomer_BookCriteria.ID.eq();
		System.out.println(good_ReadingCustomer_BookCriteria.uniqueCustomer_Book());
		
		System.out.println("Retrieving Book_Author by Book_AuthorCriteria");
		good_reading.Book_AuthorCriteria good_ReadingBook_AuthorCriteria = new good_reading.Book_AuthorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//good_ReadingBook_AuthorCriteria.ID.eq();
		System.out.println(good_ReadingBook_AuthorCriteria.uniqueBook_Author());
		
		System.out.println("Retrieving Book_Subject by Book_SubjectCriteria");
		good_reading.Book_SubjectCriteria good_ReadingBook_SubjectCriteria = new good_reading.Book_SubjectCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//good_ReadingBook_SubjectCriteria.ID.eq();
		System.out.println(good_ReadingBook_SubjectCriteria.uniqueBook_Subject());
		
		System.out.println("Retrieving Book_Keywords by Book_KeywordsCriteria");
		good_reading.Book_KeywordsCriteria good_ReadingBook_KeywordsCriteria = new good_reading.Book_KeywordsCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//good_ReadingBook_KeywordsCriteria.ID.eq();
		System.out.println(good_ReadingBook_KeywordsCriteria.uniqueBook_Keywords());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateGoodReadingUMLAllData retrieveAndUpdateGoodReadingUMLAllData = new RetrieveAndUpdateGoodReadingUMLAllData();
			try {
				retrieveAndUpdateGoodReadingUMLAllData.retrieveAndUpdateTestData();
				//retrieveAndUpdateGoodReadingUMLAllData.retrieveByCriteria();
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
