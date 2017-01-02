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
public class Costumer implements Serializable {
	public Costumer() {
	}
	
	public static Costumer loadCostumerByORMID(int _uid) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadCostumerByORMID(session, _uid);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Costumer getCostumerByORMID(int _uid) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return getCostumerByORMID(session, _uid);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Costumer loadCostumerByORMID(int _uid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadCostumerByORMID(session, _uid, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Costumer getCostumerByORMID(int _uid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return getCostumerByORMID(session, _uid, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Costumer loadCostumerByORMID(PersistentSession session, int _uid) throws PersistentException {
		try {
			return (Costumer) session.load(good_reading.Costumer.class, new Integer(_uid));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Costumer getCostumerByORMID(PersistentSession session, int _uid) throws PersistentException {
		try {
			return (Costumer) session.get(good_reading.Costumer.class, new Integer(_uid));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Costumer loadCostumerByORMID(PersistentSession session, int _uid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Costumer) session.load(good_reading.Costumer.class, new Integer(_uid), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Costumer getCostumerByORMID(PersistentSession session, int _uid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Costumer) session.get(good_reading.Costumer.class, new Integer(_uid), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCostumer(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return queryCostumer(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCostumer(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return queryCostumer(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Costumer[] listCostumerByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return listCostumerByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Costumer[] listCostumerByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return listCostumerByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCostumer(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Costumer as Costumer");
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
	
	public static List queryCostumer(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Costumer as Costumer");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Costumer", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Costumer[] listCostumerByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryCostumer(session, condition, orderBy);
			return (Costumer[]) list.toArray(new Costumer[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Costumer[] listCostumerByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryCostumer(session, condition, orderBy, lockMode);
			return (Costumer[]) list.toArray(new Costumer[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Costumer loadCostumerByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadCostumerByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Costumer loadCostumerByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadCostumerByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Costumer loadCostumerByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Costumer[] costumers = listCostumerByQuery(session, condition, orderBy);
		if (costumers != null && costumers.length > 0)
			return costumers[0];
		else
			return null;
	}
	
	public static Costumer loadCostumerByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Costumer[] costumers = listCostumerByQuery(session, condition, orderBy, lockMode);
		if (costumers != null && costumers.length > 0)
			return costumers[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCostumerByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return iterateCostumerByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCostumerByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return iterateCostumerByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCostumerByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Costumer as Costumer");
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
	
	public static java.util.Iterator iterateCostumerByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Costumer as Costumer");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Costumer", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Costumer loadCostumerByCriteria(CostumerCriteria costumerCriteria) {
		Costumer[] costumers = listCostumerByCriteria(costumerCriteria);
		if(costumers == null || costumers.length == 0) {
			return null;
		}
		return costumers[0];
	}
	
	public static Costumer[] listCostumerByCriteria(CostumerCriteria costumerCriteria) {
		return costumerCriteria.listCostumer();
	}
	
	public static Costumer createCostumer() {
		return new good_reading.Costumer();
	}
	
	public boolean save() throws PersistentException {
		try {
			good_reading.GoodReadingPersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete() throws PersistentException {
		try {
			good_reading.GoodReadingPersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh() throws PersistentException {
		try {
			good_reading.GoodReadingPersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict() throws PersistentException {
		try {
			good_reading.GoodReadingPersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	private int _uid;
	
	private String _firstName;
	
	private String _lastName;
	
	private String _userName;
	
	private String _password;
	
	private int _userStatus;
	
	private int _accountType;
	
	private java.util.Date _endDate;
	
	private boolean _accountStatus;
	
	private int _waitingForChangeType;
	
	public void set_uid(int value) {
		this._uid = value;
	}
	
	public int get_uid() {
		return _uid;
	}
	
	public int getORMID() {
		return get_uid();
	}
	
	public void set_firstName(String value) {
		this._firstName = value;
	}
	
	public String get_firstName() {
		return _firstName;
	}
	
	public void set_lastName(String value) {
		this._lastName = value;
	}
	
	public String get_lastName() {
		return _lastName;
	}
	
	public void set_userName(String value) {
		this._userName = value;
	}
	
	public String get_userName() {
		return _userName;
	}
	
	public void set_password(String value) {
		this._password = value;
	}
	
	public String get_password() {
		return _password;
	}
	
	public void set_userStatus(int value) {
		this._userStatus = value;
	}
	
	public int get_userStatus() {
		return _userStatus;
	}
	
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
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(get_uid());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("Costumer[ ");
			sb.append("_uid=").append(get_uid()).append(" ");
			sb.append("_firstName=").append(get_firstName()).append(" ");
			sb.append("_lastName=").append(get_lastName()).append(" ");
			sb.append("_userName=").append(get_userName()).append(" ");
			sb.append("_password=").append(get_password()).append(" ");
			sb.append("_userStatus=").append(get_userStatus()).append(" ");
			sb.append("_accountType=").append(get_accountType()).append(" ");
			sb.append("_endDate=").append(get_endDate()).append(" ");
			sb.append("_accountStatus=").append(get_accountStatus()).append(" ");
			sb.append("_waitingForChangeType=").append(get_waitingForChangeType()).append(" ");
			sb.append("]");
			return sb.toString();
		}
	}
	
}
