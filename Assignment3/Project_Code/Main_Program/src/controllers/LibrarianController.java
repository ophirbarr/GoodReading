package controllers;

import java.util.Calendar;
import java.util.Date;

import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import client.ClientInterface;
import good_reading.Customer;
import good_reading.GoodReadingPersistentManager;
import good_reading.SystemUser;

public class LibrarianController {
	
	private static Calendar cal = Calendar.getInstance();
	private static Date date = cal.getTime();
	
public static SystemUser[] ViewUsersWithCondition(int viewStatus) {
	
		PersistentSession session = null;
		SystemUser[] users = null;
		Customer[] customers=null;
		
		
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
				return users;
		}	
			
		if(viewStatus==2)
		{
				try {
					session = GoodReadingPersistentManager.instance().getSession();
					customers = Customer.listCustomerByQuery("_waitingForChangeType = '3'", null);
					session.close();
				} catch (PersistentException e) {
					e.printStackTrace();
					customers = null;
				}
				return customers;
		}
		
		if(viewStatus==3)
		{
				try {
					session = GoodReadingPersistentManager.instance().getSession();
					customers = Customer.listCustomerByQuery("_waitingForChangeType = '1' or _waitingForChangeType = '2'"  , null);
					session.close();
				} catch (PersistentException e) {
					e.printStackTrace();
					customers = null;
				}
				return customers;
		}
		
		if(viewStatus==4)
		{
			try {
				session = GoodReadingPersistentManager.instance().getSession();
				users = SystemUser.listSystemUserByQuery(null, "_uid");
				session.close();
			} catch (PersistentException e) {
				e.printStackTrace();
				users = null;
			}
			return users;
		}	
		
		return null;
					
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
			e.printStackTrace();
		}
}
	
public static void FromUserToCostumer(int user_id){
	
	PersistentSession session = null;
	Customer user; 
	
	try {
		session = GoodReadingPersistentManager.instance().getSession();
		PersistentTransaction t = session.beginTransaction();

		user=Customer.loadCustomerByQuery("_uid = '" + user_id +"'", null);
		
				user.set_accountStatus(common.Define.ACCOUNT_FULL_PERMISSION);
				user.set_waitingForChangeType(common.Define.DO_NOT_CHANGE);
				session.update(user);
				t.commit();
				session.close();
		
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	
}

public static void EditCostumerAccount(int user_id){
	
	PersistentSession session = null;
	Customer user; 
	ClientInterface clientInterface = null;
	boolean result;
	int ChangeType;
	

	try {
		session = GoodReadingPersistentManager.instance().getSession();
		PersistentTransaction t = session.beginTransaction();

		user=Customer.loadCustomerByQuery("_uid = '" + user_id +"'", null);
		result=CustomerController.ValidateAccount(clientInterface, user);
		
		
				if(result==true)
				{
					ChangeType=user.get_waitingForChangeType();
					user.set_accountType(ChangeType);
					user.set_waitingForChangeType(common.Define.DO_NOT_CHANGE);
					user.set_endDate(date);
					session.update(user);
					t.commit();
					session.close();
					
					/*if(ChangeType==1)
					{
						user.loadCustomerByQuery("SELECT DATE_ADD(date, INTERVAL 1 MONTH)", null);
						
					}*/

				}
				
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		
}

public static void EraseUser(int user_id){
	
	PersistentSession session = null;
	SystemUser user; 
	
		try {
				session = GoodReadingPersistentManager.instance().getSession();
				PersistentTransaction t = session.beginTransaction();
		
				user=SystemUser.loadSystemUserByQuery("_uid = '" + user_id +"'", null);
				user.delete();
				
				session.update(user);
				t.commit();
				session.close();
		
		} catch (PersistentException e) {
			e.printStackTrace();
	
	
}

}
}


