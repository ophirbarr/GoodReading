
package controllers;

import java.util.Set;
import java.util.TreeSet;

import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import good_reading.Book;
import good_reading.Book_Author;
import good_reading.GoodReadingPersistentManager;
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
	 * @param chckbx indicated which categories were selected for search
	 * @return result of search
	 */
	public static Book[] SearchBooks(String searchString, boolean[] chckbx)
	{
	    Set<Book> bookSet = new TreeSet<Book>();
		Book[] result0, result3, result4, result5 = null;
		String condition = new String("_viewStatus = '1' AND (");
		
		if (chckbx[0] == true)
			condition = condition + "_title = '" + searchString + "' OR ";
		if (chckbx[1] == true)
			condition = condition + "_language = '" + searchString + "' OR ";
		if (chckbx[2] == true)
			condition = condition + "_price = '" + searchString + "' OR ";
		condition = condition.substring(0, condition.length() - 4);
		condition = condition + ")";
		
		try {
			result0 = Book.listBookByQuery(condition, "_title");
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		
		if (chckbx[3] == true) // search by Authors
		{
			try {
				Book_Author[] book_author = Book_Author.listBook_AuthorByQuery("_author = '" + searchString + "'", null);
				condition = "_viewStatus = '1' AND (";
				for (int i = 0; i < book_author.length; i++)
					condition = condition + "_bid = '" + book_author[i].get_bid() + "' OR ";
				condition = condition.substring(0, condition.length() - 4);
				condition = condition + ")";
				result3 = Book.listBookByQuery(condition, "_title");
				
			} catch (PersistentException e) {
				e.printStackTrace();
			}
		}
		
		/*
		 
		 Collection<HealthMessage> collection = new ArrayList<HealthMessage>();
		collection.addAll(Arrays.asList(healthMessages1));
		collection.addAll(Arrays.asList(healthMessages2));

		HealthMessage[] healthMessagesAll = collection.toArray(new HealthMessage[] {});
		 
		 
		 
		 */
		
		
		return null;
	}
	
	
	/*
	public static boolean SignUp(){
		
	}
	public static void SearchBook(){
		
	}
	*/
	
	
	

}
