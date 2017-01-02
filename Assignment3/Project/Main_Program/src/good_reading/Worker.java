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
public class Worker implements Serializable {
	public Worker() {
	}
	
	public static Worker loadWorkerByORMID(int _uid) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadWorkerByORMID(session, _uid);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker getWorkerByORMID(int _uid) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return getWorkerByORMID(session, _uid);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker loadWorkerByORMID(int _uid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadWorkerByORMID(session, _uid, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker getWorkerByORMID(int _uid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return getWorkerByORMID(session, _uid, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker loadWorkerByORMID(PersistentSession session, int _uid) throws PersistentException {
		try {
			return (Worker) session.load(good_reading.Worker.class, new Integer(_uid));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker getWorkerByORMID(PersistentSession session, int _uid) throws PersistentException {
		try {
			return (Worker) session.get(good_reading.Worker.class, new Integer(_uid));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker loadWorkerByORMID(PersistentSession session, int _uid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Worker) session.load(good_reading.Worker.class, new Integer(_uid), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker getWorkerByORMID(PersistentSession session, int _uid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Worker) session.get(good_reading.Worker.class, new Integer(_uid), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryWorker(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return queryWorker(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryWorker(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return queryWorker(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker[] listWorkerByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return listWorkerByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker[] listWorkerByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return listWorkerByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryWorker(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Worker as Worker");
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
	
	public static List queryWorker(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Worker as Worker");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Worker", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker[] listWorkerByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryWorker(session, condition, orderBy);
			return (Worker[]) list.toArray(new Worker[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker[] listWorkerByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryWorker(session, condition, orderBy, lockMode);
			return (Worker[]) list.toArray(new Worker[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker loadWorkerByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadWorkerByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker loadWorkerByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadWorkerByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker loadWorkerByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Worker[] workers = listWorkerByQuery(session, condition, orderBy);
		if (workers != null && workers.length > 0)
			return workers[0];
		else
			return null;
	}
	
	public static Worker loadWorkerByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Worker[] workers = listWorkerByQuery(session, condition, orderBy, lockMode);
		if (workers != null && workers.length > 0)
			return workers[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateWorkerByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return iterateWorkerByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateWorkerByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return iterateWorkerByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateWorkerByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Worker as Worker");
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
	
	public static java.util.Iterator iterateWorkerByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Worker as Worker");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Worker", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker loadWorkerByCriteria(WorkerCriteria workerCriteria) {
		Worker[] workers = listWorkerByCriteria(workerCriteria);
		if(workers == null || workers.length == 0) {
			return null;
		}
		return workers[0];
	}
	
	public static Worker[] listWorkerByCriteria(WorkerCriteria workerCriteria) {
		return workerCriteria.listWorker();
	}
	
	public static Worker createWorker() {
		return new good_reading.Worker();
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
	
	private int _wid;
	
	private String _role;
	
	private String _email;
	
	private String _department;
	
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
	
	public void set_wid(int value) {
		this._wid = value;
	}
	
	public int get_wid() {
		return _wid;
	}
	
	public void set_role(String value) {
		this._role = value;
	}
	
	public String get_role() {
		return _role;
	}
	
	public void set_email(String value) {
		this._email = value;
	}
	
	public String get_email() {
		return _email;
	}
	
	public void set_department(String value) {
		this._department = value;
	}
	
	public String get_department() {
		return _department;
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
			sb.append("Worker[ ");
			sb.append("_uid=").append(get_uid()).append(" ");
			sb.append("_firstName=").append(get_firstName()).append(" ");
			sb.append("_lastName=").append(get_lastName()).append(" ");
			sb.append("_userName=").append(get_userName()).append(" ");
			sb.append("_password=").append(get_password()).append(" ");
			sb.append("_userStatus=").append(get_userStatus()).append(" ");
			sb.append("_wid=").append(get_wid()).append(" ");
			sb.append("_role=").append(get_role()).append(" ");
			sb.append("_email=").append(get_email()).append(" ");
			sb.append("_department=").append(get_department()).append(" ");
			sb.append("]");
			return sb.toString();
		}
	}
	
}
