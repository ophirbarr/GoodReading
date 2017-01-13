
package controllers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import common.Message;
import good_reading.Book;
import good_reading.Book_Author;
import good_reading.Book_Keywords;
import good_reading.Book_Subject;
import good_reading.GoodReadingPersistentManager;
import good_reading.Subject;
import good_reading.SystemUser;

public class SystemUserController {
	
	/**
	 * User is attempting to log in. If successful, the instance of SystemUser will be returned from the database and his login status updated.
	 * @param userName User Name of the person logging in
	 * @param password Password of the person logging in
	 * @return instance of SystemUser if success, or null if failed to login
	 */
	public static SystemUser LogIn(String userName, String password)
	{
		PersistentSession session = null;
		SystemUser user;
		try {
			//session = GoodReadingPersistentManager.instance().getSession();
			user = SystemUser.loadSystemUserByQuery("_password = '" + password + "' AND _userName = '" + userName +"'", null);
			//session.close();
			
		} catch (PersistentException e) {
			e.printStackTrace();
			user = null;
		}
		
		if (user != null && user.get_userStatus() == 0)
		{
			try {
				session = GoodReadingPersistentManager.instance().getSession();
				PersistentTransaction t = session.beginTransaction();
				user.set_userStatus(1);
				session.update(user);
				t.commit();
				session.close();
			} catch (PersistentException e) {
				e.printStackTrace();
			}
			return user;
		}
		return null;
	}
	
	/**
	 * Instance of SystemUser is retrieved from DB, and the login status is then updated to DISCONNECTED.
	 * @param userName UserName of the person logging out
	 */
	public static void LogOut(String userName)
	{
		PersistentSession session = null;
		SystemUser user;
		try {
			session = GoodReadingPersistentManager.instance().getSession();
			user = SystemUser.loadSystemUserByQuery("_userName = '" + userName +"'", null);
			PersistentTransaction t = session.beginTransaction();
			user.set_userStatus(0);
			session.update(user);
			t.commit();
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * SystemUser is attempting to search for books.
	 * @param searchString the string input written in the search bar
	 * @param chckbx indicates which categories were selected for search
	 * @return result of search
	 */
	public static Book[] SearchBooks(boolean[] chckbx, String[] searchString)
	{
		Collection<Book> collection = new ArrayList<Book>();
		boolean isSetEmpty = true;
		Book[] result0 = null, result3 = null, result4 = null, result5 = null;
		String condition;
		
		if (chckbx[0] || chckbx[1] || chckbx[2])
		{
			condition = "_viewStatus = '1' AND ";
			if (chckbx[0] == true)
				condition = condition + "_title like '%%" + searchString[0] + "%%' AND ";
			if (chckbx[1] == true)
				condition = condition + "_language like '%%" + searchString[1] + "%%' AND ";
			if (chckbx[2] == true)
				condition = condition + "_price BETWEEN " + (Double.parseDouble(searchString[2]) - 0.001) + " AND " + (Double.parseDouble(searchString[2]) + 0.001) + " AND ";
			condition = condition.substring(0, condition.length() - 5);	
			try {
				result0 = Book.listBookByQuery(condition, "_title");
			} catch (PersistentException e) {
				e.printStackTrace();
			}
		}
		
		if (chckbx[3] == true) // search by Author
		{
			try {
				Book_Author[] book_author = Book_Author.listBook_AuthorByQuery("_author like '%%" + searchString[3] + "%%'", null);
				if (book_author.length > 0)
				{
					condition = "_viewStatus = '1' AND (";
					for (int i = 0; i < book_author.length; i++)
						condition = condition + "_bid = '" + book_author[i].get_bid() + "' OR ";
					condition = condition.substring(0, condition.length() - 4);
					condition = condition + ")";
					result3 = Book.listBookByQuery(condition, "_title");
				}
				else result3 = new Book[0];
			} catch (PersistentException e) {
				e.printStackTrace();
			}
		}
		if (chckbx[4] == true) // search by Keyword
		{
			try {
				Book_Keywords[] book_keywords = Book_Keywords.listBook_KeywordsByQuery("_keyword = '" + searchString[4] + "'", null);
				if (book_keywords.length > 0)
				{
					condition = "_viewStatus = '1' AND (";
					for (int i = 0; i < book_keywords.length; i++)
						condition = condition + "_bid = '" + book_keywords[i].get_bid() + "' OR ";
					condition = condition.substring(0, condition.length() - 4);
					condition = condition + ")";

					result4 = Book.listBookByQuery(condition, "_title");
				}
				else result4 = new Book[0];
			} catch (PersistentException e) {
				e.printStackTrace();
			}
		}
		if (chckbx[5] == true) // search by Subject
		{
			try {
				Subject subject = Subject.loadSubjectByQuery("_name = '" + searchString[5] + "'", null);
				if (subject != null)
				{
					int sid = subject.get_sid();
					Book_Subject[] book_subject = Book_Subject.listBook_SubjectByQuery("_sid = '" + sid + "'", null);
					if (book_subject.length > 0)
					{
						condition = "_viewStatus = '1' AND (";
						for (int i = 0; i < book_subject.length; i++)
							condition = condition + "_bid = '" + book_subject[i].get_bid() + "' OR ";
						condition = condition.substring(0, condition.length() - 4);
						condition = condition + ")";

						result5 = Book.listBookByQuery(condition, "_title");
					}
					else result5 = new Book[0];
				}
				else result5 = new Book[0];
			} catch (PersistentException e) {
				e.printStackTrace();
			}
		}
			
		
		if (chckbx[0] || chckbx[1] || chckbx[2])
		{
			collection.addAll(Arrays.asList(result0));
			isSetEmpty = false;
		}
		if (chckbx[3] && isSetEmpty)
		{
			collection.addAll(Arrays.asList(result3));
			isSetEmpty = false;
		}
		else if (chckbx[3]) collection.retainAll(Arrays.asList(result3));
		if (chckbx[4] && isSetEmpty)
		{
			collection.addAll(Arrays.asList(result4));
			isSetEmpty = false;
		}
		else if (chckbx[4]) collection.retainAll(Arrays.asList(result4));
		if (chckbx[5] && isSetEmpty)
		{
			collection.addAll(Arrays.asList(result5));
			isSetEmpty = false;
		}
		else if (chckbx[5]) collection.retainAll(Arrays.asList(result5));
		
		Book[] result = collection.toArray(new Book[] {});
		
		return result;
	}
	
	/**
	 * Get a list of all books available in the catalog
	 * @return full list of books
	 */
	public static Book[] GetAllBooks()
	{
		try {
			return Book.listBookByQuery("_viewStatus = '1'", "_Title");
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * Sign-up request. if successful, a new SystemUser will be added to database
	 * @return success or failure
	 */
	public static boolean SignUp(ArrayList<Object> peremeters)
	{
		SystemUser user = null;
		String username = (String)peremeters.get(0);
		int ssn = (Integer)peremeters.get(4);
		try {
			user = SystemUser.loadSystemUserByQuery("_username = '" + username + "' OR _SSN = '" + ssn + "'", null);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		if (user != null)
			return false;
		
		try {
			PersistentSession session = GoodReadingPersistentManager.instance().getSession();
			
			user = SystemUser.createSystemUser();
			user.set_userName(username);
			user.set_password((String)peremeters.get(1));
			user.set_firstName((String)peremeters.get(2));
			user.set_lastName((String)peremeters.get(3));
			user.set_ssn(ssn);
			user.set_userStatus(2);
			
			PersistentTransaction t = session.beginTransaction();
			session.save(user);
			t.commit();

			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	
	

}
