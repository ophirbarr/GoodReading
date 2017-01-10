
package controllers;

import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import good_reading.Book;
import good_reading.GoodReadingPersistentManager;
import good_reading.SystemUser;

public class SystemUserController {
	
	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
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
	
	
	public static Book[] SearchBooks(String searchString, boolean[] chckbx)
	{
		Book[] result = null;
		String condition = new String("");
		
		if (chckbx[0] == true)
			condition = condition + "_title = '" + searchString + "' AND";
		if (chckbx[1] == true)
			condition = condition + "_language = '" + searchString + "' AND";
		if (chckbx[2] == true)
			condition = condition + "_price = '" + searchString + "' AND";
		
		Book book1 = new Book();
		book1.set_bid(1);
		Book book2 = new Book();
		book2.set_bid(1);
		if (book1.equals(book2)) System.out.println("equals = 1");
		else System.out.println("equals = 0");
		
		
		return result;
	}
	
	
	/*
	public static boolean SignUp(){
		
	}
	public static void SearchBook(){
		
	}
	*/
	
	
	

}
