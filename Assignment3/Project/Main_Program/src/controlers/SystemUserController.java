
package controlers;

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
	public static SystemUser LogIn(String userName, String password){
		

		
		PersistentSession session = null;
		SystemUser user;
		try {
			session = GoodReadingPersistentManager.instance().getSession();
			user = SystemUser.loadSystemUserByQuery("_password="+password+" AND _userName="+userName, "_uid");
			session.close();
			
		} catch (PersistentException e) {
			user = null;
			e.printStackTrace();
		}
		
		if (user.get_userStatus() == 0)
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
	
	
	public static boolean LogOut(){
		
	}
	
	public static boolean SignUp(){
		
	}
	public static void SearchBook(){
		
	}
	
	
	
	

}
