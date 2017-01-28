package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;
import good_reading.Book;
import good_reading.BookReview;
import good_reading.Book_Author;
import good_reading.Book_Keywords;
import good_reading.Book_Subject;
import good_reading.Customer;
import good_reading.Domain;
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
			session = GoodReadingPersistentManager.instance().getSession();
			user = SystemUser.loadSystemUserByQuery("_password = '" + password + "' AND _userName = '" + userName +"'", null);
			session.close();
			
		} catch (PersistentException e) {
			e.printStackTrace();
			user = null;
		}
		
		if (user != null && user.get_userStatus() == 0)
		{
			try {
				session = GoodReadingPersistentManager.instance().getSession();
				PersistentTransaction t = session.beginTransaction();
				user.set_userStatus(common.Define.USER_CONNECTED);
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
			user.set_userStatus(common.Define.USER_DISCONNECTED);
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
	 * @param catalog Whether we search in entire DB (false), or just in catalog (true)
	 * @return result of search
	 */
	public static Book[] SearchBooks(boolean[] chckbx, String[] searchString, boolean catalog)
	{
		PersistentSession session = null;
		Collection<Book> collection = new ArrayList<Book>();
		boolean isSetEmpty = true;
		Book[] result0 = null, result3 = null, result4 = null, result5 = null, result6 = null;
		String condition = "";
		
		try {
			session = GoodReadingPersistentManager.instance().getSession();
		} catch (PersistentException e1) {
			e1.printStackTrace();
		}
		
		if (chckbx[0] || chckbx[1] || chckbx[2])
		{
			if (catalog) condition = "_viewStatus = '1' AND "; else condition = "";
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
					if (catalog) condition = "_viewStatus = '1' AND ("; else condition = "";
					for (int i = 0; i < book_author.length; i++)
						condition = condition + "_bid = '" + book_author[i].get_bid() + "' OR ";
					condition = condition.substring(0, condition.length() - 4);
					if (catalog) condition = condition + ")";
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
					if (catalog) condition = "_viewStatus = '1' AND ("; else condition = "";
					for (int i = 0; i < book_keywords.length; i++)
						condition = condition + "_bid = '" + book_keywords[i].get_bid() + "' OR ";
					condition = condition.substring(0, condition.length() - 4);
					if (catalog) condition = condition + ")";

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
				Subject subject = Subject.loadSubjectByQuery("_name like '%%" + searchString[5] + "%%'", null);
				if (subject != null)
				{
					int sid = subject.get_sid();
					Book_Subject[] book_subject = Book_Subject.listBook_SubjectByQuery("_sid = '" + sid + "'", null);
					if (book_subject.length > 0)
					{
						if (catalog) condition = "_viewStatus = '1' AND ("; else condition = "";
						for (int i = 0; i < book_subject.length; i++)
							condition = condition + "_bid = '" + book_subject[i].get_bid() + "' OR ";
						condition = condition.substring(0, condition.length() - 4);
						if (catalog) condition = condition + ")";

						result5 = Book.listBookByQuery(condition, "_title");
					}
					else result5 = new Book[0];
				}
				else result5 = new Book[0];
			} catch (PersistentException e) {
				e.printStackTrace();
			}
		}
		if (chckbx[6] == true) // search by Domain
		{
			try {
				Domain domain = Domain.loadDomainByQuery("_name like '%%" + searchString[6] + "%%'", null);
				Subject[] subject;
				Book_Subject[] book_subject;
				if (domain != null)
				{
					subject = Subject.listSubjectByQuery("_did = '" + domain.get_did() + "'", "_name");
					if (subject.length > 0)
					{
						// get book_subject's
						condition = "";
						for (int i = 0; i < subject.length; i++)
							condition = condition + "_sid = '" + subject[i].get_sid() + "' OR ";
						condition = condition.substring(0, condition.length() - 4);
						book_subject = Book_Subject.listBook_SubjectByQuery(condition, null);
						
						// get books
						if (catalog) condition = "_viewStatus = '1' AND ("; else condition = "";
						for (int i = 0; i < book_subject.length; i++)
							condition = condition + "_bid = '" + book_subject[i].get_bid() + "' OR ";
						condition = condition.substring(0, condition.length() - 4);
						if (catalog) condition = condition + ")";

						result6 = Book.listBookByQuery(condition, "_title");
					}
					else result6 = new Book[0];
				}
				else result6 = new Book[0];
				
			} catch (PersistentException e) {
				e.printStackTrace();
			}
		}
		
		try {
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
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
		if (chckbx[6] && isSetEmpty)
		{
			collection.addAll(Arrays.asList(result6));
			isSetEmpty = false;
		}
		else if (chckbx[6]) collection.retainAll(Arrays.asList(result6));
		
		Book[] result = collection.toArray(new Book[] {});
		return result;
	}
	
	/**
	 * Get a list of all books available in the catalog
	 * @param catalog Whether we search in entire DB or only in catalog
	 * @return full list of books
	 */
	public static Book[] GetAllBooks(boolean catalog)
	{
		PersistentSession session = null;
		Book[] result = null;
		try {
			session = GoodReadingPersistentManager.instance().getSession();
			if (catalog) result = Book.listBookByQuery("_viewStatus = '1'", "_Title");
			else result = Book.listBookByQuery(null, "_Title");
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
			result = null;
		}
		return result;
	}
	
	
	/**
	 * Sign-up request. if successful, a new SystemUser will be added to database
	 * @param parameters signup input
	 * @return success or failure
	 */
	public static boolean SignUp(ArrayList<Object> peremeters)
	{
		SystemUser user = null;
		String username = (String)peremeters.get(0);
		int ssn = (Integer)peremeters.get(4);
		try {
			PersistentSession session = GoodReadingPersistentManager.instance().getSession();
			user = SystemUser.loadSystemUserByQuery("_username = '" + username + "' OR _SSN = '" + ssn + "'", null);
			session.close();
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
			user.set_userStatus(common.Define.USER_WAITING);
			
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
	
	/**
	 * Create a locked(=cannot purchase) Customer and replace it with given SystemUser in DB.
	 * @param user the user wanting to open an account
	 * @return an instance of the new Customer, or null if failure
	 */
	public static Customer OpenAccount(SystemUser user)
	{
		Customer customer = Customer.createCustomer();
		customer.set_ssn(user.get_ssn());
		customer.set_firstName(user.get_firstName());
		customer.set_lastName(user.get_lastName());
		customer.set_userName(user.get_userName());
		customer.set_password(user.get_password());
		customer.set_userStatus(user.get_userStatus());
		
		customer.set_accountType(common.Define.ACCOUNT_PER_BOOK);
		customer.set_accountStatus(false);;    // cannot make purchases
		customer.set_waitingForChangeType(common.Define.FROM_USER_TO_CUSTOMER);  // awaiting approval

		
		PersistentSession session;
		try {
			session = GoodReadingPersistentManager.instance().getSession();
			PersistentTransaction t = session.beginTransaction();
			session.delete(user);
			t.commit();
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
			return null;
		}
		try {
			session = GoodReadingPersistentManager.instance().getSession();
			PersistentTransaction t = session.beginTransaction();
			session.save(customer);
			t.commit();
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
			return null;
		}
		
		return customer;
	}
	
	/**
	 * Return approved reviews for a requested book.
	 * @param bid Book ID
	 * @return An array of book reviews in BID
	 */
	public static BookReview[] ReadReviews(int bid)
	{
		BookReview[] result = null;
		try {
			PersistentSession session = GoodReadingPersistentManager.instance().getSession();
			result = BookReview.listBookReviewByQuery("_bid = '" + bid + "' AND _approved = '1'", null);
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * A new SystemUser instance is returned. Used when a change is expected and user needs to be updated.
	 * @param id ID of current user
	 * @return up to date instance of current user
	 */
	public static SystemUser RefreshUser(int id)
	{
		SystemUser user = null;
		try {
			PersistentSession session = GoodReadingPersistentManager.instance().getSession();
			user = SystemUser.getSystemUserByORMID(id);
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return user;
	}
}
