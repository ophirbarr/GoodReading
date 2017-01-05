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
public class Subject implements Serializable {
	public Subject() {
	}
	
	public static Subject loadSubjectByORMID(int _sid) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadSubjectByORMID(session, _sid);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Subject getSubjectByORMID(int _sid) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return getSubjectByORMID(session, _sid);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Subject loadSubjectByORMID(int _sid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadSubjectByORMID(session, _sid, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Subject getSubjectByORMID(int _sid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return getSubjectByORMID(session, _sid, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Subject loadSubjectByORMID(PersistentSession session, int _sid) throws PersistentException {
		try {
			return (Subject) session.load(good_reading.Subject.class, new Integer(_sid));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Subject getSubjectByORMID(PersistentSession session, int _sid) throws PersistentException {
		try {
			return (Subject) session.get(good_reading.Subject.class, new Integer(_sid));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Subject loadSubjectByORMID(PersistentSession session, int _sid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Subject) session.load(good_reading.Subject.class, new Integer(_sid), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Subject getSubjectByORMID(PersistentSession session, int _sid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Subject) session.get(good_reading.Subject.class, new Integer(_sid), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySubject(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return querySubject(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySubject(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return querySubject(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Subject[] listSubjectByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return listSubjectByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Subject[] listSubjectByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return listSubjectByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySubject(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Subject as Subject");
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
	
	public static List querySubject(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Subject as Subject");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Subject", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Subject[] listSubjectByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = querySubject(session, condition, orderBy);
			return (Subject[]) list.toArray(new Subject[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Subject[] listSubjectByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = querySubject(session, condition, orderBy, lockMode);
			return (Subject[]) list.toArray(new Subject[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Subject loadSubjectByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadSubjectByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Subject loadSubjectByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadSubjectByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Subject loadSubjectByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Subject[] subjects = listSubjectByQuery(session, condition, orderBy);
		if (subjects != null && subjects.length > 0)
			return subjects[0];
		else
			return null;
	}
	
	public static Subject loadSubjectByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Subject[] subjects = listSubjectByQuery(session, condition, orderBy, lockMode);
		if (subjects != null && subjects.length > 0)
			return subjects[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateSubjectByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return iterateSubjectByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSubjectByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return iterateSubjectByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSubjectByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Subject as Subject");
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
	
	public static java.util.Iterator iterateSubjectByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Subject as Subject");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Subject", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Subject loadSubjectByCriteria(SubjectCriteria subjectCriteria) {
		Subject[] subjects = listSubjectByCriteria(subjectCriteria);
		if(subjects == null || subjects.length == 0) {
			return null;
		}
		return subjects[0];
	}
	
	public static Subject[] listSubjectByCriteria(SubjectCriteria subjectCriteria) {
		return subjectCriteria.listSubject();
	}
	
	public static Subject createSubject() {
		return new good_reading.Subject();
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
	
	private int _sid;
	
	private String _name;
	
	private int _did;
	
	public void set_sid(int value) {
		this._sid = value;
	}
	
	public int get_sid() {
		return _sid;
	}
	
	public int getORMID() {
		return get_sid();
	}
	
	public void set_name(String value) {
		this._name = value;
	}
	
	public String get_name() {
		return _name;
	}
	
	public void set_did(int value) {
		this._did = value;
	}
	
	public int get_did() {
		return _did;
	}
	
	public String toString() {
		return String.valueOf(get_sid());
	}
	
}
