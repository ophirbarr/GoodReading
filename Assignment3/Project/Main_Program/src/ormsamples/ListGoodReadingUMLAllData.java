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
		
		System.out.println("Listing Costumer...");
		good_reading.Costumer[] good_ReadingCostumers = good_reading.Costumer.listCostumerByQuery(null, null);
		length = Math.min(good_ReadingCostumers.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(good_ReadingCostumers[i]);
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
		
		System.out.println("Listing Costumer by Criteria...");
		good_reading.CostumerCriteria good_ReadingCostumerCriteria = new good_reading.CostumerCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//good_ReadingCostumerCriteria._uid.eq();
		good_ReadingCostumerCriteria.setMaxResults(ROW_COUNT);
		good_reading.Costumer[] good_ReadingCostumers = good_ReadingCostumerCriteria.listCostumer();
		length =good_ReadingCostumers== null ? 0 : Math.min(good_ReadingCostumers.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(good_ReadingCostumers[i]);
		}
		System.out.println(length + " Costumer record(s) retrieved."); 
		
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
