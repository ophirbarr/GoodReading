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
			good_reading.Costumer good_ReadingCostumer = good_reading.Costumer.loadCostumerByQuery(null, null);
			// Update the properties of the persistent object
			good_ReadingCostumer.save();
			good_reading.Book good_ReadingBook = good_reading.Book.loadBookByQuery(null, null);
			// Update the properties of the persistent object
			good_ReadingBook.save();
			good_reading.Subject good_ReadingSubject = good_reading.Subject.loadSubjectByQuery(null, null);
			// Update the properties of the persistent object
			good_ReadingSubject.save();
			good_reading.Worker good_ReadingWorker = good_reading.Worker.loadWorkerByQuery(null, null);
			// Update the properties of the persistent object
			good_ReadingWorker.save();
			good_reading.Book_Subject good_ReadingBook_Subject = good_reading.Book_Subject.loadBook_SubjectByQuery(null, null);
			// Update the properties of the persistent object
			good_ReadingBook_Subject.save();
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
		
		System.out.println("Retrieving Costumer by CostumerCriteria");
		good_reading.CostumerCriteria good_ReadingCostumerCriteria = new good_reading.CostumerCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//good_ReadingCostumerCriteria._uid.eq();
		System.out.println(good_ReadingCostumerCriteria.uniqueCostumer());
		
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
		
		System.out.println("Retrieving Book_Subject by Book_SubjectCriteria");
		good_reading.Book_SubjectCriteria good_ReadingBook_SubjectCriteria = new good_reading.Book_SubjectCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//good_ReadingBook_SubjectCriteria._bid.eq();
		System.out.println(good_ReadingBook_SubjectCriteria.uniqueBook_Subject());
		
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
