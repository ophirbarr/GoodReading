package controllers;

import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import common.Message;
import good_reading.Book;
import good_reading.BookReview;
import good_reading.GoodReadingPersistentManager;
import good_reading.SystemUser;

public class LibrarianController {
	
public static SystemUser[] ViewUsersWithCondition(int viewStatus) {
	
		PersistentSession session = null;
		SystemUser[] users = null;
		
		if(viewStatus==1)
		{
			try {
				session = GoodReadingPersistentManager.instance().getSession();
				users = SystemUser.listSystemUserByQuery("_userStatus = '2'", null);
				session.close();
			} catch (PersistentException e) {
				e.printStackTrace();
				users = null;
			}
		}
		
			return users;
				
	}
	
	

		
public static void AddNewUser(int user_id){
	
	PersistentSession session = null;
	SystemUser user; 
	
	try {
		session = GoodReadingPersistentManager.instance().getSession();
		PersistentTransaction t = session.beginTransaction();

		user=SystemUser.loadSystemUserByQuery("_uid = '" + user_id +"'", null);
		
				user.set_userStatus(common.Define.USER_DISCONNECTED);
				session.update(user);
				t.commit();
				session.close();
		
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
public static void FromUserToCostumer(){}

public static void EditCostumerAccount(){}

public static void EraseUser(){}


}


