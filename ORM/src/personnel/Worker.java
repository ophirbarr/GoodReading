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
package personnel;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class Worker {
	public Worker() {
	}
	
	public static Worker loadWorkerByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = personnel.UntitledPersistentManager.instance().getSession();
			return loadWorkerByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker getWorkerByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = personnel.UntitledPersistentManager.instance().getSession();
			return getWorkerByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker loadWorkerByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = personnel.UntitledPersistentManager.instance().getSession();
			return loadWorkerByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker getWorkerByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = personnel.UntitledPersistentManager.instance().getSession();
			return getWorkerByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker loadWorkerByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Worker) session.load(personnel.Worker.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker getWorkerByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Worker) session.get(personnel.Worker.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker loadWorkerByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Worker) session.load(personnel.Worker.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker getWorkerByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Worker) session.get(personnel.Worker.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryWorker(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = personnel.UntitledPersistentManager.instance().getSession();
			return queryWorker(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryWorker(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = personnel.UntitledPersistentManager.instance().getSession();
			return queryWorker(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker[] listWorkerByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = personnel.UntitledPersistentManager.instance().getSession();
			return listWorkerByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker[] listWorkerByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = personnel.UntitledPersistentManager.instance().getSession();
			return listWorkerByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryWorker(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From personnel.Worker as Worker");
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
		StringBuffer sb = new StringBuffer("From personnel.Worker as Worker");
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
			PersistentSession session = personnel.UntitledPersistentManager.instance().getSession();
			return loadWorkerByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Worker loadWorkerByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = personnel.UntitledPersistentManager.instance().getSession();
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
			PersistentSession session = personnel.UntitledPersistentManager.instance().getSession();
			return iterateWorkerByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateWorkerByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = personnel.UntitledPersistentManager.instance().getSession();
			return iterateWorkerByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateWorkerByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From personnel.Worker as Worker");
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
		StringBuffer sb = new StringBuffer("From personnel.Worker as Worker");
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
		return new personnel.Worker();
	}
	
	public boolean save() throws PersistentException {
		try {
			personnel.UntitledPersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete() throws PersistentException {
		try {
			personnel.UntitledPersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh() throws PersistentException {
		try {
			personnel.UntitledPersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict() throws PersistentException {
		try {
			personnel.UntitledPersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	private int ID;
	
	private String FirstName;
	
	private String LastName;
	
	private String Email;
	
	private String Role;
	
	private String Department;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setFirstName(String value) {
		this.FirstName = value;
	}
	
	public String getFirstName() {
		return FirstName;
	}
	
	public void setLastName(String value) {
		this.LastName = value;
	}
	
	public String getLastName() {
		return LastName;
	}
	
	public void setEmail(String value) {
		this.Email = value;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setRole(String value) {
		this.Role = value;
	}
	
	public String getRole() {
		return Role;
	}
	
	public void setDepartment(String value) {
		this.Department = value;
	}
	
	public String getDepartment() {
		return Department;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
