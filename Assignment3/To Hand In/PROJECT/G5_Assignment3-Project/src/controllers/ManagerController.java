package controllers;

import java.util.ArrayList;

import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import common.Define;
import common.Message;
import good_reading.Book;
import good_reading.Book_Subject;
import good_reading.Customer;
import good_reading.Customer_Book;
import good_reading.GoodReadingPersistentManager;
import good_reading.SystemUser;

public class ManagerController {
	/**
	 * The function find out a list Book for all the books that appear in the catalog (_viewStatus == 1) and their author
	 * @return returns Message that containing the Book list and author list
	 */
	@SuppressWarnings("unused")
	public static Message ManageCatalog(){

		Book[] books = null;
		String authors =null;
		Message msg = new Message("","");
		try {
			books = Book.listBookByQuery("_viewStatus = '1'", null);
			for(int i=0;i<books.length;i++)
			//authors = Book_Author.loadBook_AuthorByQuery("_bid ", orderBy)
			msg.add(books);
		} catch (PersistentException e) {
			e.printStackTrace();	
		}
		
		return msg;
	}
	
	/**
	 * Function gets a number of book and adds him the catalog
	 * @param bid Book id
	 */
	public static void AddToCatalog(int bid){
		
		Book book;
		PersistentSession session = null;
		
		try {
			session = GoodReadingPersistentManager.instance().getSession();
			PersistentTransaction t = session.beginTransaction();
			book = Book.getBookByORMID(bid);
			book.set_viewStatus(true);      // viewStatus == true : book in catalog else viewStatus = false
			t.commit();
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
			
		}
	}
	/**
	 * Function gets number book and removes him from the catalog
	 * @param bid Book id
	 */
public static void RemoveFromCatalog(int bid){
		
		Book book;
		PersistentSession session = null;
		
		try {
			session = GoodReadingPersistentManager.instance().getSession();
			PersistentTransaction t = session.beginTransaction();
			book = Book.getBookByORMID(bid);
			book.set_viewStatus(false);     // viewStatus == true : book in catalog.  else: viewStatus = false
			t.commit();
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
			
		}
	}

/**
 * The function create 3 lists:  customers name, books name, id.
 * for each customer we save his name,id and the books name that he ordered. 
 * @return message with 3 lists
 */
public static Message CustomerOrders(){
	Customer_Book[] customerBook = null;
	ArrayList<String> customers_name = new ArrayList<String>();
	ArrayList<String> books_name = new ArrayList<String>();
	ArrayList<Integer> ssn = new ArrayList<Integer>();
	Message msg = new Message("","");
	
	try {
		customerBook = Customer_Book.listCustomer_BookByQuery(null,"_uid");  //list order by customer user id
		int tempID = -1;
		int j = -1;
		String temp,firstName,lastName,fullName = "";
		for(int i=0;i<customerBook.length;i++)  
		{
			if(tempID != customerBook[i].get_uid())  //If this client that have not we inserted
			{
				ssn.add(SystemUser.getSystemUserByORMID(customerBook[i].get_uid()).get_ssn());
				SystemUser[] su = SystemUser.listSystemUserByQuery("_ssn = '"+SystemUser.getSystemUserByORMID(customerBook[i].get_uid()).get_ssn()+"'", null);
				firstName = su[0].get_firstName();
				lastName = su[0].get_lastName();
				fullName = firstName+" "+lastName;
				customers_name.add(fullName);
				books_name.add(Book.getBookByORMID(customerBook[i].get_bid()).get_title());
				j++;
				tempID = customerBook[i].get_uid();
			}
			else{   //Already existing customer list so we add the new book title
				temp = books_name.get(j) +" , "+ Book.getBookByORMID(customerBook[i].get_bid()).get_title() ;
				books_name.set(j, temp);
			}
			
		}
		msg.add(customers_name);
		msg.add(ssn);
		msg.add(books_name);
		
	} catch (PersistentException e) {
		e.printStackTrace();
	}
	return msg;
	
}
/**
 * The function calculates the quantity of the book purchased all always
 * @return The quantity of the book purchased 
 */
public static int GetCounterBooksPurchased(){
	Book[] books;
	int counter=0;

		try {
			books = Book.listBookByQuery(null, null);
			for(int i = 0; i<books.length;i++)
				counter+=books[i].get_purchaseCount();
		} catch (PersistentException e) {
			e.printStackTrace();
		}

	return counter;
}
/**
 * The function calculates the quantity of the book purchased by subject all always according to a number of book she gets
 * @param bid Book id 
 * @return The quantity of the book purchased
 */
public static int GetCounterBooksBySubject(int bid){
	Book_Subject[] books;
	int counter=0;
		try {
			Book_Subject[] bs = Book_Subject.listBook_SubjectByQuery("_bid = '"+bid+"'", null);
			books = Book_Subject.listBook_SubjectByQuery("_sid = '"+bs[0].get_sid()+"'", null);
			for(int i = 0; i<books.length;i++)	
				counter+=Book.getBookByORMID(books[i].get_bid()).get_purchaseCount();
			
		} catch (PersistentException e) {
			e.printStackTrace();
		}

	return counter;
}
/**
 * The function finds and returns a list of all users on the system
 * @return list of all users
 */
public static SystemUser[] GetAllUsers(){
	
	SystemUser[] systemUsers = null;
	
	try {
		systemUsers = SystemUser.listSystemUserByQuery("_userStatus != '2'", "_firstName");
		
	} catch (PersistentException e) {
		e.printStackTrace();
	}
	return systemUsers;
}

/**
 * The function finds and returns a list of all customers on the system
 * @return list of all customers
 */
public static Customer[] GetAllCustomers(){
	
	Customer[] customers = null;
	
	try {
		customers = Customer.listCustomerByQuery("_waitingForChangeType != '3'", "_firstName");
		
	} catch (PersistentException e) {
		e.printStackTrace();
	}
	return customers;
}

/**
 * The function updates the user's status
 * @param index The new status: index = 0: Disconnected else index = 1: Block
 * @param uid user id
 */
public static void UpDateUserStatus(int index,int uid){
	
	PersistentSession session = null;
	
	try {
		session = GoodReadingPersistentManager.instance().getSession();
		PersistentTransaction t = session.beginTransaction();
		SystemUser systemUser = SystemUser.getSystemUserByORMID(uid);
		if(index == 0)systemUser.set_userStatus(Define.USER_DISCONNECTED);
		else if(index == 1)systemUser.set_userStatus(Define.USER_BLOCKED);
		t.commit();
		session.close();
	} catch (PersistentException e) {
		e.printStackTrace();
		
	}
	
	
}
/**
 * The function updates the account status
 * @param index The new status: index = 0: NO PERMISSION else index = 1: FULL PERMISSION
 * @param uid user's account
 */
public static void UpDateAccountStatus(int index,int uid){
	
	PersistentSession session = null;
	
	try {
		session = GoodReadingPersistentManager.instance().getSession();
		PersistentTransaction t = session.beginTransaction();
		Customer customer = Customer.getCustomerByORMID(uid);
		if(index == 0)customer.set_accountStatus(Define.ACCOUNT_NO_PERMISSION);
		else if(index == 1)customer.set_accountStatus(Define.ACCOUNT_FULL_PERMISSION);
		t.commit();
		session.close();
	} catch (PersistentException e) {
		e.printStackTrace();
		
	}
	
	
}
}
