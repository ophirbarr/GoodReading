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
public class SystemUser implements Serializable {
	public SystemUser() {
	}
	
	public static SystemUser loadSystemUserByORMID(int _uid) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadSystemUserByORMID(session, _uid);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SystemUser getSystemUserByORMID(int _uid) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return getSystemUserByORMID(session, _uid);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SystemUser loadSystemUserByORMID(int _uid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadSystemUserByORMID(session, _uid, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SystemUser getSystemUserByORMID(int _uid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return getSystemUserByORMID(session, _uid, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SystemUser loadSystemUserByORMID(PersistentSession session, int _uid) throws PersistentException {
		try {
			return (SystemUser) session.load(good_reading.SystemUser.class, new Integer(_uid));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SystemUser getSystemUserByORMID(PersistentSession session, int _uid) throws PersistentException {
		try {
			return (SystemUser) session.get(good_reading.SystemUser.class, new Integer(_uid));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SystemUser loadSystemUserByORMID(PersistentSession session, int _uid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (SystemUser) session.load(good_reading.SystemUser.class, new Integer(_uid), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SystemUser getSystemUserByORMID(PersistentSession session, int _uid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (SystemUser) session.get(good_reading.SystemUser.class, new Integer(_uid), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySystemUser(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return querySystemUser(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySystemUser(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return querySystemUser(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SystemUser[] listSystemUserByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return listSystemUserByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SystemUser[] listSystemUserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return listSystemUserByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySystemUser(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.SystemUser as SystemUser");
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
	
	public static List querySystemUser(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.SystemUser as SystemUser");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("SystemUser", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SystemUser[] listSystemUserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = querySystemUser(session, condition, orderBy);
			return (SystemUser[]) list.toArray(new SystemUser[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SystemUser[] listSystemUserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = querySystemUser(session, condition, orderBy, lockMode);
			return (SystemUser[]) list.toArray(new SystemUser[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SystemUser loadSystemUserByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadSystemUserByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SystemUser loadSystemUserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadSystemUserByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SystemUser loadSystemUserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		SystemUser[] systemUsers = listSystemUserByQuery(session, condition, orderBy);
		if (systemUsers != null && systemUsers.length > 0)
			return systemUsers[0];
		else
			return null;
	}
	
	public static SystemUser loadSystemUserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		SystemUser[] systemUsers = listSystemUserByQuery(session, condition, orderBy, lockMode);
		if (systemUsers != null && systemUsers.length > 0)
			return systemUsers[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateSystemUserByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return iterateSystemUserByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSystemUserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return iterateSystemUserByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSystemUserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.SystemUser as SystemUser");
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
	
	public static java.util.Iterator iterateSystemUserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.SystemUser as SystemUser");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("SystemUser", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static SystemUser loadSystemUserByCriteria(SystemUserCriteria systemUserCriteria) {
		SystemUser[] systemUsers = listSystemUserByCriteria(systemUserCriteria);
		if(systemUsers == null || systemUsers.length == 0) {
			return null;
		}
		return systemUsers[0];
	}
	
	public static SystemUser[] listSystemUserByCriteria(SystemUserCriteria systemUserCriteria) {
		return systemUserCriteria.listSystemUser();
	}
	
	public static SystemUser createSystemUser() {
		return new good_reading.SystemUser();
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
	
	public enum userStatus { DISCONNECTED, CONNECTED, WAITING, BLOCKED };
	
	private userStatus _userStatus;
	
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
	
	public void set_userStatus(userStatus value) {
		this._userStatus = value;
	}
	
	public userStatus get_userStatus() {
		return _userStatus;
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
			sb.append("SystemUser[ ");
			sb.append("_uid=").append(get_uid()).append(" ");
			sb.append("_firstName=").append(get_firstName()).append(" ");
			sb.append("_lastName=").append(get_lastName()).append(" ");
			sb.append("_userName=").append(get_userName()).append(" ");
			sb.append("_password=").append(get_password()).append(" ");
			sb.append("_userStatus=").append(get_userStatus()).append(" ");
			sb.append("]");
			return sb.toString();
		}
	}
	
}
