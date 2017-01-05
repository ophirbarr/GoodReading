/**
 * Licensee: Ort Braude College
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListGoodReadingUMLAllData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing BookReview...");
		good_reading.BookReview[] good_ReadingBookReviews = good_reading.BookReview.listBookReviewByQuery(null, null);
		int length = Math.min(good_ReadingBookReviews.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(good_ReadingBookReviews[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Domain...");
		good_reading.Domain[] good_ReadingDomains = good_reading.Domain.listDomainByQuery(null, null);
		length = Math.min(good_ReadingDomains.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(good_ReadingDomains[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing SystemUser...");
		good_reading.SystemUser[] good_ReadingSystemUsers = good_reading.SystemUser.listSystemUserByQuery(null, null);
		length = Math.min(good_ReadingSystemUsers.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(good_ReadingSystemUsers[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Customer...");
		good_reading.Customer[] good_ReadingCustomers = good_reading.Customer.listCustomerByQuery(null, null);
		length = Math.min(good_ReadingCustomers.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(good_ReadingCustomers[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Book...");
		good_reading.Book[] good_ReadingBooks = good_reading.Book.listBookByQuery(null, null);
		length = Math.min(good_ReadingBooks.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(good_ReadingBooks[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Subject...");
		good_reading.Subject[] good_ReadingSubjects = good_reading.Subject.listSubjectByQuery(null, null);
		length = Math.min(good_ReadingSubjects.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(good_ReadingSubjects[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Worker...");
		good_reading.Worker[] good_ReadingWorkers = good_reading.Worker.listWorkerByQuery(null, null);
		length = Math.min(good_ReadingWorkers.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(good_ReadingWorkers[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Book_Subject...");
		good_reading.Book_Subject[] good_ReadingBook_Subjects = good_reading.Book_Subject.listBook_SubjectByQuery(null, null);
		length = Math.min(good_ReadingBook_Subjects.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(good_ReadingBook_Subjects[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Customer_Book...");
		good_reading.Customer_Book[] good_ReadingCustomer_Books = good_reading.Customer_Book.listCustomer_BookByQuery(null, null);
		length = Math.min(good_ReadingCustomer_Books.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(good_ReadingCustomer_Books[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Book_Author...");
		good_reading.Book_Author[] good_ReadingBook_Authors = good_reading.Book_Author.listBook_AuthorByQuery(null, null);
		length = Math.min(good_ReadingBook_Authors.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(good_ReadingBook_Authors[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Book_Keywords...");
		good_reading.Book_Keywords[] good_ReadingBook_Keywordses = good_reading.Book_Keywords.listBook_KeywordsByQuery(null, null);
		length = Math.min(good_ReadingBook_Keywordses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(good_ReadingBook_Keywordses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing BookReview by Criteria...");
		good_reading.BookReviewCriteria good_ReadingBookReviewCriteria = new good_reading.BookReviewCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//good_ReadingBookReviewCriteria._rid.eq();
		good_ReadingBookReviewCriteria.setMaxResults(ROW_COUNT);
		good_reading.BookReview[] good_ReadingBookReviews = good_ReadingBookReviewCriteria.listBookReview();
		int length =good_ReadingBookReviews== null ? 0 : Math.min(good_ReadingBookReviews.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(good_ReadingBookReviews[i]);
		}
		System.out.println(length + " BookReview record(s) retrieved."); 
		
		System.out.println("Listing Domain by Criteria...");
		good_reading.DomainCriteria good_ReadingDomainCriteria = new good_reading.DomainCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//good_ReadingDomainCriteria._did.eq();
		good_ReadingDomainCriteria.setMaxResults(ROW_COUNT);
		good_reading.Domain[] good_ReadingDomains = good_ReadingDomainCriteria.listDomain();
		length =good_ReadingDomains== null ? 0 : Math.min(good_ReadingDomains.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(good_ReadingDomains[i]);
		}
		System.out.println(length + " Domain record(s) retrieved."); 
		
		System.out.println("Listing SystemUser by Criteria...");
		good_reading.SystemUserCriteria good_ReadingSystemUserCriteria = new good_reading.SystemUserCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//good_ReadingSystemUserCriteria._uid.eq();
		good_ReadingSystemUserCriteria.setMaxResults(ROW_COUNT);
		good_reading.SystemUser[] good_ReadingSystemUsers = good_ReadingSystemUserCriteria.listSystemUser();
		length =good_ReadingSystemUsers== null ? 0 : Math.min(good_ReadingSystemUsers.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(good_ReadingSystemUsers[i]);
		}
		System.out.println(length + " SystemUser record(s) retrieved."); 
		
		System.out.println("Listing Customer by Criteria...");
		good_reading.CustomerCriteria good_ReadingCustomerCriteria = new good_reading.CustomerCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//good_ReadingCustomerCriteria._uid.eq();
		good_ReadingCustomerCriteria.setMaxResults(ROW_COUNT);
		good_reading.Customer[] good_ReadingCustomers = good_ReadingCustomerCriteria.listCustomer();
		length =good_ReadingCustomers== null ? 0 : Math.min(good_ReadingCustomers.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(good_ReadingCustomers[i]);
		}
		System.out.println(length + " Customer record(s) retrieved."); 
		
		System.out.println("Listing Book by Criteria...");
		good_reading.BookCriteria good_ReadingBookCriteria = new good_reading.BookCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//good_ReadingBookCriteria._bid.eq();
		good_ReadingBookCriteria.setMaxResults(ROW_COUNT);
		good_reading.Book[] good_ReadingBooks = good_ReadingBookCriteria.listBook();
		length =good_ReadingBooks== null ? 0 : Math.min(good_ReadingBooks.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(good_ReadingBooks[i]);
		}
		System.out.println(length + " Book record(s) retrieved."); 
		
		System.out.println("Listing Subject by Criteria...");
		good_reading.SubjectCriteria good_ReadingSubjectCriteria = new good_reading.SubjectCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//good_ReadingSubjectCriteria._sid.eq();
		good_ReadingSubjectCriteria.setMaxResults(ROW_COUNT);
		good_reading.Subject[] good_ReadingSubjects = good_ReadingSubjectCriteria.listSubject();
		length =good_ReadingSubjects== null ? 0 : Math.min(good_ReadingSubjects.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(good_ReadingSubjects[i]);
		}
		System.out.println(length + " Subject record(s) retrieved."); 
		
		System.out.println("Listing Worker by Criteria...");
		good_reading.WorkerCriteria good_ReadingWorkerCriteria = new good_reading.WorkerCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//good_ReadingWorkerCriteria._uid.eq();
		good_ReadingWorkerCriteria.setMaxResults(ROW_COUNT);
		good_reading.Worker[] good_ReadingWorkers = good_ReadingWorkerCriteria.listWorker();
		length =good_ReadingWorkers== null ? 0 : Math.min(good_ReadingWorkers.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(good_ReadingWorkers[i]);
		}
		System.out.println(length + " Worker record(s) retrieved."); 
		
		System.out.println("Listing Book_Subject by Criteria...");
		good_reading.Book_SubjectCriteria good_ReadingBook_SubjectCriteria = new good_reading.Book_SubjectCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//good_ReadingBook_SubjectCriteria._bid.eq();
		good_ReadingBook_SubjectCriteria.setMaxResults(ROW_COUNT);
		good_reading.Book_Subject[] good_ReadingBook_Subjects = good_ReadingBook_SubjectCriteria.listBook_Subject();
		length =good_ReadingBook_Subjects== null ? 0 : Math.min(good_ReadingBook_Subjects.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(good_ReadingBook_Subjects[i]);
		}
		System.out.println(length + " Book_Subject record(s) retrieved."); 
		
		System.out.println("Listing Customer_Book by Criteria...");
		good_reading.Customer_BookCriteria good_ReadingCustomer_BookCriteria = new good_reading.Customer_BookCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//good_ReadingCustomer_BookCriteria._uid.eq();
		good_ReadingCustomer_BookCriteria.setMaxResults(ROW_COUNT);
		good_reading.Customer_Book[] good_ReadingCustomer_Books = good_ReadingCustomer_BookCriteria.listCustomer_Book();
		length =good_ReadingCustomer_Books== null ? 0 : Math.min(good_ReadingCustomer_Books.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(good_ReadingCustomer_Books[i]);
		}
		System.out.println(length + " Customer_Book record(s) retrieved."); 
		
		System.out.println("Listing Book_Author by Criteria...");
		good_reading.Book_AuthorCriteria good_ReadingBook_AuthorCriteria = new good_reading.Book_AuthorCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//good_ReadingBook_AuthorCriteria._bid.eq();
		good_ReadingBook_AuthorCriteria.setMaxResults(ROW_COUNT);
		good_reading.Book_Author[] good_ReadingBook_Authors = good_ReadingBook_AuthorCriteria.listBook_Author();
		length =good_ReadingBook_Authors== null ? 0 : Math.min(good_ReadingBook_Authors.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(good_ReadingBook_Authors[i]);
		}
		System.out.println(length + " Book_Author record(s) retrieved."); 
		
		System.out.println("Listing Book_Keywords by Criteria...");
		good_reading.Book_KeywordsCriteria good_ReadingBook_KeywordsCriteria = new good_reading.Book_KeywordsCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//good_ReadingBook_KeywordsCriteria._bid.eq();
		good_ReadingBook_KeywordsCriteria.setMaxResults(ROW_COUNT);
		good_reading.Book_Keywords[] good_ReadingBook_Keywordses = good_ReadingBook_KeywordsCriteria.listBook_Keywords();
		length =good_ReadingBook_Keywordses== null ? 0 : Math.min(good_ReadingBook_Keywordses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(good_ReadingBook_Keywordses[i]);
		}
		System.out.println(length + " Book_Keywords record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListGoodReadingUMLAllData listGoodReadingUMLAllData = new ListGoodReadingUMLAllData();
			try {
				listGoodReadingUMLAllData.listTestData();
				//listGoodReadingUMLAllData.listByCriteria();
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
