package controllers;

import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import common.Message;
import good_reading.Book;
import good_reading.BookReview;
import good_reading.Book_Author;
import good_reading.Book_Keywords;
import good_reading.Book_Subject;
import good_reading.Customer_Book;
import good_reading.Domain;
import good_reading.GoodReadingPersistentManager;
import good_reading.Subject;

public class DatabaseManagementController 
{
	
	/**
	 * Return a list of subjects by name
	 * @param name name of subject
	 * @return list of subjects by name
	 */
	public static Subject[] GetSubjects(String name)
	{
		Subject[] subjects = null;
		try {
			PersistentSession session = GoodReadingPersistentManager.instance().getSession();
			subjects = Subject.listSubjectByQuery("_name LIKE '%%" + name + "%%'", "_name");
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return subjects;
	}
	
	/**
	 * Return a list of ALL subjects
	 * @return list of subjects by name
	 */
	public static Subject[] GetAllSubjects()
	{
		Subject[] subjects = null;
		try {
			PersistentSession session = GoodReadingPersistentManager.instance().getSession();
			subjects = Subject.listSubjectByQuery(null, null);
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return subjects;
	}
	
	/**
	 * Return a list of domains by name
	 * @param name name of domain
	 * @return list of domains by name
	 */
	public static Domain[] GetDomains(String name)
	{
		Domain[] domains = null;
		try {
			PersistentSession session = GoodReadingPersistentManager.instance().getSession();
			domains = Domain.listDomainByQuery("_name LIKE '%%" + name + "%%'", "_name");
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return domains;
	}
	
	/**
	 * Return a list of ALL domains
	 * @return list of domains by name
	 */
	public static Domain[] GetAllDomains()
	{
		Domain[] domains = null;
		try {
			PersistentSession session = GoodReadingPersistentManager.instance().getSession();
			domains = Domain.listDomainByQuery(null, null);
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return domains;
	}
	
	/**
	 * Return a message to client containing all information about a certain book
	 * @param bid ID of certain book
	 * @return message containing all information about a certain book
	 */
	public static Message GetBookDetails(int bid)
	{
		Message msg = new Message(null, null);
		Book_Author[] book_author = null;
		Book_Subject[] book_subject = null; // no need
		Book_Keywords[] book_keyword = null;
		Subject[] subjects = null;
		try {
			PersistentSession session = GoodReadingPersistentManager.instance().getSession();
			book_author = Book_Author.listBook_AuthorByQuery("_bid = '" + bid + "'", "_author");
			book_keyword = Book_Keywords.listBook_KeywordsByQuery("_bid = '" + bid + "'", "_keyword");
			book_subject = Book_Subject.listBook_SubjectByQuery("_bid = '" + bid + "'", "_sid");
			if (book_subject.length > 0)
			{
				String condition = "";
				for (Book_Subject bs : book_subject)
					condition = condition + "_sid = '" + bs.get_sid() + "' OR ";
				condition = condition.substring(0, condition.length() - 4);
				subjects = Subject.listSubjectByQuery(condition, "_name");
			} else subjects = new Subject[0];
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}

		msg.add(book_author);
		msg.add(subjects);
		msg.add(book_keyword);
		
		return msg;
	}
	
	/**
	 * Edit the contents of a book
	 * @param book book target to be edited
	 * @return success or failure
	 */
	public static boolean EditBook(Book book)
	{
		try {
			PersistentSession session = GoodReadingPersistentManager.instance().getSession();
			PersistentTransaction t = session.beginTransaction();
			session.update(book);
			t.commit();
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * Remove a book association such as book-author(0), book-subject(1), book-keyword(2).
	 * @param msg message containing indication parameter and the relevant association
	 */
	public static void RemoveBookAssociation(Message msg)
	{
		PersistentSession session;
		int parameter = (int) msg.getParameters().get(0);
		try {
			session = GoodReadingPersistentManager.instance().getSession();
			PersistentTransaction t = session.beginTransaction();

			if (parameter == 0)  // remove author
			{
				Book_Author book_author = (Book_Author) msg.getParameters().get(1);
				session.delete(book_author);
			}
			else if (parameter == 1) // remove subject
			{
				Subject subject = (Subject) msg.getParameters().get(1);
				int bid = (int) msg.getParameters().get(2);
				Book_Subject book_subject = Book_Subject.loadBook_SubjectByQuery("_bid = '" + bid + "' AND _sid = '" + subject.get_sid() + "'", null);
				session.delete(book_subject);
			}
			else if (parameter == 2) // remove keyword
			{
				Book_Keywords book_keyword = (Book_Keywords) msg.getParameters().get(1);
				session.delete(book_keyword);
			}
			
			t.commit();
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Add a book association such as book-author(0), book-subject(1), book-keyword(2).
	 * @param msg message containing indication parameter and the relevant association
	 */
	public static void AddBookAssociation(Message msg)
	{
		PersistentSession session;
		int parameter = (int) msg.getParameters().get(0);
		try {
			session = GoodReadingPersistentManager.instance().getSession();
			PersistentTransaction t = session.beginTransaction();

			if (parameter == 0)  // add author
			{
				Book_Author book_author = Book_Author.createBook_Author();
				book_author.set_bid((int) msg.getParameters().get(2));
				book_author.set_author((String) msg.getParameters().get(1));
				session.save(book_author);
			}
			else if (parameter == 1) // add subject
			{
				Subject subject = Subject.loadSubjectByQuery("_name = '" + msg.getParameters().get(1) + "'", null);
				if (subject != null)
				{
					Book_Subject book_subject = Book_Subject.createBook_Subject();
					book_subject.set_sid(subject.get_sid());
					book_subject.set_bid((int) msg.getParameters().get(2));
					session.save(book_subject);
				}
			}
			else if (parameter == 2) // add keyword
			{
				Book_Keywords book_keyword = Book_Keywords.createBook_Keywords();
				book_keyword.set_bid((int) msg.getParameters().get(2));
				book_keyword.set_keyword((String) msg.getParameters().get(1));
				session.save(book_keyword);
			}			
			t.commit();
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Edit subject(0) or domain(1) fields
	 * @param msg message including parameters
	 */
	public static void EditSubjectDomain(Message msg)
	{
		if ((int)msg.getParameters().get(0) == 0)  // EDIT SUBJECT
		{
			int sid = (int) msg.getParameters().get(1);
			int did = (int) msg.getParameters().get(2);
			String name = (String) msg.getParameters().get(3);
			
			try {
				PersistentSession session = GoodReadingPersistentManager.instance().getSession();
				Subject subject = Subject.loadSubjectByQuery("_sid = '" + sid + "'", null);
				subject.set_name(name);
				subject.set_did(did);
				PersistentTransaction t = session.beginTransaction();
				session.update(subject);
				t.commit();
				session.close();
			} catch (PersistentException e) {
				e.printStackTrace();
			}

		}
		
		else if ((int)msg.getParameters().get(0) == 1)  // EDIT DOMAIN
		{
			int did = (int) msg.getParameters().get(1);
			String name = (String) msg.getParameters().get(2);
			
			try {
				PersistentSession session = GoodReadingPersistentManager.instance().getSession();
				Domain domain = Domain.loadDomainByQuery("_did = '" + did + "'", null);
				domain.set_name(name);
				PersistentTransaction t = session.beginTransaction();
				session.update(domain);
				t.commit();
				session.close();
			} catch (PersistentException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Delete either a book(0), subject(1) or domain(2) and all associations from DB, if possible 
	 * @param msg message containing parameters
	 * @return success of failure
	 */
	public static boolean DeleteItem(Message msg)
	{
		int id = (int) msg.getParameters().get(1);
		try {
			PersistentSession session = GoodReadingPersistentManager.instance().getSession();
			PersistentTransaction t = session.beginTransaction();
			if ((int)msg.getParameters().get(0) == 0) // DELETE BOOK
			{
				Book book = Book.loadBookByQuery("_bid = '" + id + "'", null);
				Book_Author[] book_author = Book_Author.listBook_AuthorByQuery("_bid = '" + id + "'", null);
				Book_Subject[] book_subject = Book_Subject.listBook_SubjectByQuery("_bid = '" + id + "'", null);
				Book_Keywords[] book_keywords = Book_Keywords.listBook_KeywordsByQuery("_bid = '" + id + "'", null);
				BookReview[] book_review = BookReview.listBookReviewByQuery("_bid = '" + id + "'", null);
				Customer_Book[] customer_book = Customer_Book.listCustomer_BookByQuery("_bid = '" + id + "'", null);
				session.delete(book);
				for (Book_Author del_obj : book_author) session.delete(del_obj);
				for (Book_Subject del_obj : book_subject) session.delete(del_obj);
				for (Book_Keywords del_obj : book_keywords) session.delete(del_obj);
				for (BookReview del_obj : book_review) session.delete(del_obj);
				for (Customer_Book del_obj : customer_book) session.delete(del_obj);
			}
			if ((int)msg.getParameters().get(0) == 1) // DELETE SUBJECT
			{
				Book_Subject[] book_subject = Book_Subject.listBook_SubjectByQuery("_sid = '" + id + "'", null);
				if (book_subject != null && book_subject.length > 0) return false;
				else
				{
					Subject subject = Subject.loadSubjectByQuery("_sid = '" + id + "'", null);
					session.delete(subject);
				}
			}
			if ((int)msg.getParameters().get(0) == 2) // DELETE DOMAIN
			{
				Subject[] subject = Subject.listSubjectByQuery("_did = '" + id + "'", null);
				if (subject != null && subject.length > 0) return false;
				else
				{
					Domain domain = Domain.loadDomainByQuery("_did = '" + id + "'", null);
					session.delete(domain);
				}
			}
			t.commit();
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * Create and add a new empty book to database.
	 * @return instance of new book
	 */
	public static Book AddBook()
	{
		PersistentSession session;
		Book book = null;
		try {
			session = GoodReadingPersistentManager.instance().getSession();
			book = Book.createBook();
			book.set_price(0);
			book.set_viewStatus(true);
			book.set_purchaseCount(0);
			PersistentTransaction t = session.beginTransaction();
			session.save(book);
			t.commit();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	/**
	 * Add a new subject(0) or domain(1) to the DB
	 * @param msg message containing parameters
	 */
	public static void AddSubjectDomain(Message msg)
	{
		try {
			PersistentSession session = GoodReadingPersistentManager.instance().getSession();
			PersistentTransaction t = session.beginTransaction();
			if ((int)msg.getParameters().get(0) == 0) // ADD SUBJECT
			{
				Subject subject = Subject.createSubject();
				subject.set_did((int) msg.getParameters().get(1));
				subject.set_name((String) msg.getParameters().get(2));
				session.save(subject);
			}
			else if ((int)msg.getParameters().get(0) == 1) // ADD DOMAIN
			{
				Domain domain = Domain.createDomain();
				domain.set_name((String) msg.getParameters().get(1));
				session.save(domain);
			}
			t.commit();
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}	
	}
	
}
