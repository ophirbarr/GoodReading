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
	
public static Message ViewUsersWithCondition(int status) throws PersistentException{
	
	
		SystemUser[] users = null;
		Message msg = new Message("","");
		
		if(status==1)
		{
				try {
					users=SystemUser.listSystemUserByQuery("_userStatus= '2'", null);
					msg.add(users);	
				} catch (PersistentException e) {
					e.printStackTrace();	
				}
		}
		return msg;
			
	}
	
	

		
/*public static void AddNewUser(SystemUser user){
	
	PersistentSession session = null;
	int i;
	SystemUser[] users; 
	
	try {
		session = GoodReadingPersistentManager.instance().getSession();
		PersistentTransaction t = session.beginTransaction();

		users=SystemUser.listSystemUserByQuery("FROM systemuser WHERE _userStatus= '2'", null);

		for(i=0;i<users.length;i++)
		{
			if(users[i].equals(user))
				users[i].set_userStatus(0);	
				user.set_userStatus(0);
				t.commit();
				session.close();
		}
		
		
	} catch (PersistentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}*/
	
public static void FromUserToCostumer(){}

public static void EditCostumerAccount(){}

public static void EraseUser(){}


}


