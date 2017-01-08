
package controllers;

import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

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
	
	
	/*
	public static boolean SignUp(){
		
	}
	public static void SearchBook(){
		
	}
	*/
	
	
	

}
