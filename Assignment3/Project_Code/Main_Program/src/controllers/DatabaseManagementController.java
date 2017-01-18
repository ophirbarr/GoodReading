package controllers;

import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import common.Message;
import good_reading.Book;
import good_reading.Book_Author;
import good_reading.Book_Keywords;
import good_reading.Book_Subject;
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
			String condition = "";
			for (Book_Subject bs : book_subject)
				condition = condition + "_sid = '" + bs.get_sid() + "' OR ";
			condition = condition.substring(0, condition.length() - 4);
			subjects = Subject.listSubjectByQuery(condition, "_name");
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
	 * @return success or failure
	 */
	public static void RemoveBookAssociation(Message msg)
	{
		PersistentSession session;
		int parameter = (int) msg.getParameters().get(0);
		try {
			session = GoodReadingPersistentManager.instance().getSession();
			PersistentTransaction t = session.beginTransaction();

			if (parameter == 0)
			{
				Book_Author book_author = (Book_Author) msg.getParameters().get(1);
				session.delete(book_author);
			}
			else if (parameter == 1)
			{
				Subject subject = (Subject) msg.getParameters().get(1);
				int bid = (int) msg.getParameters().get(2);
				Book_Subject book_subject = Book_Subject.loadBook_SubjectByQuery("_bid = '" + bid + "' AND _sid = '" + subject.get_sid() + "'", null);
				session.delete(book_subject);
			}
			else if (parameter == 2)
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

}
