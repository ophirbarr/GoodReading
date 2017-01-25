package controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import client.ClientInterface;
import good_reading.Customer;
import good_reading.GoodReadingPersistentManager;
import good_reading.SystemUser;
import good_reading.Worker;

/**
 * 
 * @author Inna
 *Controller class, containing all the functions regarding a librarian
 */

public class LibrarianController {
	
	
	/**
	 * Return a list of users or customers by viewStatus
	 * @param viewStatus viewStatus to know which list to return 
	 * @return list of users or customers by viewStatus
	 */
	
public static SystemUser[] ViewUsersWithCondition(int viewStatus) {
	
		PersistentSession session = null;
		SystemUser[] users = null;
		Customer[] customers=null;
		ArrayList<SystemUser> usersOnly = new ArrayList<SystemUser>();
		SystemUser[]usersert=null;
		int j=0;
	

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
				
				for(int i=0; i<users.length;i++)
				{
					if(!((users[i])instanceof Worker))
					{
						usersOnly.add(users[i]);		
					}	
				}
				usersert=new SystemUser[usersOnly.size()];
				
				for(int i=0; i<usersOnly.size();i++)
				{
					usersert[i]=usersOnly.get(i);
				}
				session.close();
				
			} catch (PersistentException e) {
				e.printStackTrace();
				users = null;
			}
			return usersert;
		}	
		
		return null;
					
	}
	
	/**
	 * Function that gives the user permission,
	 * the librarian adds the user to the GoodReading by changing his _userstatus to disconnected
	 * @param user_id to know which user is selected
	 */

		
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
	
/**
 * Function that confirms the user to become a customer,
 * The librarian gives confirmation to the customer by changing its _accountStatus to ACCOUNT_FULL_PERMISSION
 * @param user_id to know which user is selected
 */

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

/**
 *Function that update user account
 *The function checks the validation account of the customer,
 *If the account is valid, then the function changes hid _accountType according to what requested(monthly or yearly) and update the _endDate. 
 * @param user_id to know which user is selected
 */

public static void EditCostumerAccount(int user_id){
	
	PersistentSession session = null;
	Customer user; 
	ClientInterface clientInterface = null;
	boolean result;
	int ChangeType;
	Calendar cal = null;
	Date dateM = null;
	Date dateY = null;
	
	try {
		session = GoodReadingPersistentManager.instance().getSession();
		PersistentTransaction t = session.beginTransaction();

		user=Customer.loadCustomerByQuery("_uid = '" + user_id +"'", null);
		result=CustomerController.ValidateAccount(clientInterface, user);
		
		
				if(result==true)
				{
					ChangeType=user.get_waitingForChangeType();
					
						if(ChangeType==common.Define.ACCOUNT_MONTHLY)
						{
							cal = Calendar.getInstance();
							dateM = cal.getTime();
							cal.setTime(dateM);
							cal.add(Calendar.MONTH, 1);
							dateM=cal.getTime();
							user.set_accountType(ChangeType);
							user.set_waitingForChangeType(common.Define.DO_NOT_CHANGE);
							user.set_endDate(dateM);
							
						}
						
						if(ChangeType==common.Define.ACCOUNT_YEARLY)
						{
							cal = Calendar.getInstance();
							dateY = cal.getTime();
							cal.setTime(dateY);
							cal.add(Calendar.YEAR, 1);
							dateY=cal.getTime();	
							user.set_accountType(ChangeType);
							user.set_waitingForChangeType(common.Define.DO_NOT_CHANGE);
							user.set_endDate(dateY);
							
						}
					
						session.update(user);
						t.commit();
						session.close();
			
				}
				
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		
}

/**
 * Function deletes the user from the system
 * @param user_id to know which user is selected
 */

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


