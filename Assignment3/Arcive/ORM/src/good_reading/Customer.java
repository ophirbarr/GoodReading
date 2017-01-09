/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Ort Braude College
 * License Type: Academic
 */
package good_reading;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

import java.io.Serializable;
public class Customer extends good_reading.SystemUser implements Serializable {
	public Customer() {
	}
	
	public static Customer loadCustomerByORMID(int _uid) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadCustomerByORMID(session, _uid);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Customer getCustomerByORMID(int _uid) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return getCustomerByORMID(session, _uid);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Customer loadCustomerByORMID(int _uid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadCustomerByORMID(session, _uid, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Customer getCustomerByORMID(int _uid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return getCustomerByORMID(session, _uid, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Customer loadCustomerByORMID(PersistentSession session, int _uid) throws PersistentException {
		try {
			return (Customer) session.load(good_reading.Customer.class, new Integer(_uid));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Customer getCustomerByORMID(PersistentSession session, int _uid) throws PersistentException {
		try {
			return (Customer) session.get(good_reading.Customer.class, new Integer(_uid));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Customer loadCustomerByORMID(PersistentSession session, int _uid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Customer) session.load(good_reading.Customer.class, new Integer(_uid), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Customer getCustomerByORMID(PersistentSession session, int _uid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Customer) session.get(good_reading.Customer.class, new Integer(_uid), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCustomer(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return queryCustomer(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCustomer(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return queryCustomer(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Customer[] listCustomerByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return listCustomerByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Customer[] listCustomerByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return listCustomerByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCustomer(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Customer as Customer");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCustomer(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Customer as Customer");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Customer", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Customer[] listCustomerByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryCustomer(session, condition, orderBy);
			return (Customer[]) list.toArray(new Customer[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Customer[] listCustomerByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryCustomer(session, condition, orderBy, lockMode);
			return (Customer[]) list.toArray(new Customer[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Customer loadCustomerByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadCustomerByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Customer loadCustomerByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadCustomerByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Customer loadCustomerByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Customer[] customers = listCustomerByQuery(session, condition, orderBy);
		if (customers != null && customers.length > 0)
			return customers[0];
		else
			return null;
	}
	
	public static Customer loadCustomerByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Customer[] customers = listCustomerByQuery(session, condition, orderBy, lockMode);
		if (customers != null && customers.length > 0)
			return customers[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCustomerByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return iterateCustomerByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCustomerByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return iterateCustomerByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCustomerByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Customer as Customer");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCustomerByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Customer as Customer");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Customer", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Customer loadCustomerByCriteria(CustomerCriteria customerCriteria) {
		Customer[] customers = listCustomerByCriteria(customerCriteria);
		if(customers == null || customers.length == 0) {
			return null;
		}
		return customers[0];
	}
	
	public static Customer[] listCustomerByCriteria(CustomerCriteria customerCriteria) {
		return customerCriteria.listCustomer();
	}
	
	public static Customer createCustomer() {
		return new good_reading.Customer();
	}
	
	private int _accountType;
	
	private java.util.Date _endDate;
	
	private boolean _accountStatus;
	
	private int _waitingForChangeType;
	
	public void set_accountType(int value) {
		this._accountType = value;
	}
	
	public int get_accountType() {
		return _accountType;
	}
	
	public void set_endDate(java.util.Date value) {
		this._endDate = value;
	}
	
	public java.util.Date get_endDate() {
		return _endDate;
	}
	
	public void set_accountStatus(boolean value) {
		this._accountStatus = value;
	}
	
	public boolean get_accountStatus() {
		return _accountStatus;
	}
	
	public void set_waitingForChangeType(int value) {
		this._waitingForChangeType = value;
	}
	
	public int get_waitingForChangeType() {
		return _waitingForChangeType;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
