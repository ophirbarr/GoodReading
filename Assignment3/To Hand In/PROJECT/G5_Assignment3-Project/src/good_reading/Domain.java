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
public class Domain implements Serializable {
	public Domain() {
	}
	
	public static Domain loadDomainByORMID(int _did) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadDomainByORMID(session, _did);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Domain getDomainByORMID(int _did) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return getDomainByORMID(session, _did);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Domain loadDomainByORMID(int _did, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadDomainByORMID(session, _did, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Domain getDomainByORMID(int _did, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return getDomainByORMID(session, _did, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Domain loadDomainByORMID(PersistentSession session, int _did) throws PersistentException {
		try {
			return (Domain) session.load(good_reading.Domain.class, new Integer(_did));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Domain getDomainByORMID(PersistentSession session, int _did) throws PersistentException {
		try {
			return (Domain) session.get(good_reading.Domain.class, new Integer(_did));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Domain loadDomainByORMID(PersistentSession session, int _did, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Domain) session.load(good_reading.Domain.class, new Integer(_did), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Domain getDomainByORMID(PersistentSession session, int _did, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Domain) session.get(good_reading.Domain.class, new Integer(_did), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDomain(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return queryDomain(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDomain(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return queryDomain(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Domain[] listDomainByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return listDomainByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Domain[] listDomainByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return listDomainByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDomain(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Domain as Domain");
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
	
	public static List queryDomain(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Domain as Domain");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Domain", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Domain[] listDomainByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryDomain(session, condition, orderBy);
			return (Domain[]) list.toArray(new Domain[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Domain[] listDomainByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryDomain(session, condition, orderBy, lockMode);
			return (Domain[]) list.toArray(new Domain[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Domain loadDomainByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadDomainByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Domain loadDomainByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadDomainByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Domain loadDomainByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Domain[] domains = listDomainByQuery(session, condition, orderBy);
		if (domains != null && domains.length > 0)
			return domains[0];
		else
			return null;
	}
	
	public static Domain loadDomainByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Domain[] domains = listDomainByQuery(session, condition, orderBy, lockMode);
		if (domains != null && domains.length > 0)
			return domains[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDomainByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return iterateDomainByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDomainByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return iterateDomainByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDomainByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Domain as Domain");
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
	
	public static java.util.Iterator iterateDomainByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Domain as Domain");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Domain", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Domain loadDomainByCriteria(DomainCriteria domainCriteria) {
		Domain[] domains = listDomainByCriteria(domainCriteria);
		if(domains == null || domains.length == 0) {
			return null;
		}
		return domains[0];
	}
	
	public static Domain[] listDomainByCriteria(DomainCriteria domainCriteria) {
		return domainCriteria.listDomain();
	}
	
	public static Domain createDomain() {
		return new good_reading.Domain();
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
	
	private int _did;
	
	private String _name;
	
	public void set_did(int value) {
		this._did = value;
	}
	
	public int get_did() {
		return _did;
	}
	
	public int getORMID() {
		return get_did();
	}
	
	public void set_name(String value) {
		this._name = value;
	}
	
	public String get_name() {
		return _name;
	}
	
	public String toString() {
		return String.valueOf(get_did());
	}
	
}
