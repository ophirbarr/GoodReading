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
public class Book_Author implements Serializable {
	public Book_Author() {
	}
	
	public static Book_Author loadBook_AuthorByORMID(int _bid) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadBook_AuthorByORMID(session, _bid);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book_Author getBook_AuthorByORMID(int _bid) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return getBook_AuthorByORMID(session, _bid);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book_Author loadBook_AuthorByORMID(int _bid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadBook_AuthorByORMID(session, _bid, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book_Author getBook_AuthorByORMID(int _bid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return getBook_AuthorByORMID(session, _bid, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book_Author loadBook_AuthorByORMID(PersistentSession session, int _bid) throws PersistentException {
		try {
			return (Book_Author) session.load(good_reading.Book_Author.class, new Integer(_bid));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book_Author getBook_AuthorByORMID(PersistentSession session, int _bid) throws PersistentException {
		try {
			return (Book_Author) session.get(good_reading.Book_Author.class, new Integer(_bid));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book_Author loadBook_AuthorByORMID(PersistentSession session, int _bid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Book_Author) session.load(good_reading.Book_Author.class, new Integer(_bid), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book_Author getBook_AuthorByORMID(PersistentSession session, int _bid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Book_Author) session.get(good_reading.Book_Author.class, new Integer(_bid), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBook_Author(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return queryBook_Author(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBook_Author(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return queryBook_Author(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book_Author[] listBook_AuthorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return listBook_AuthorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book_Author[] listBook_AuthorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return listBook_AuthorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBook_Author(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Book_Author as Book_Author");
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
	
	public static List queryBook_Author(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Book_Author as Book_Author");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Book_Author", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book_Author[] listBook_AuthorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryBook_Author(session, condition, orderBy);
			return (Book_Author[]) list.toArray(new Book_Author[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book_Author[] listBook_AuthorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryBook_Author(session, condition, orderBy, lockMode);
			return (Book_Author[]) list.toArray(new Book_Author[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book_Author loadBook_AuthorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadBook_AuthorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book_Author loadBook_AuthorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadBook_AuthorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book_Author loadBook_AuthorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Book_Author[] book_Authors = listBook_AuthorByQuery(session, condition, orderBy);
		if (book_Authors != null && book_Authors.length > 0)
			return book_Authors[0];
		else
			return null;
	}
	
	public static Book_Author loadBook_AuthorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Book_Author[] book_Authors = listBook_AuthorByQuery(session, condition, orderBy, lockMode);
		if (book_Authors != null && book_Authors.length > 0)
			return book_Authors[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateBook_AuthorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return iterateBook_AuthorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBook_AuthorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return iterateBook_AuthorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBook_AuthorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Book_Author as Book_Author");
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
	
	public static java.util.Iterator iterateBook_AuthorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Book_Author as Book_Author");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Book_Author", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book_Author loadBook_AuthorByCriteria(Book_AuthorCriteria book_AuthorCriteria) {
		Book_Author[] book_Authors = listBook_AuthorByCriteria(book_AuthorCriteria);
		if(book_Authors == null || book_Authors.length == 0) {
			return null;
		}
		return book_Authors[0];
	}
	
	public static Book_Author[] listBook_AuthorByCriteria(Book_AuthorCriteria book_AuthorCriteria) {
		return book_AuthorCriteria.listBook_Author();
	}
	
	public static Book_Author createBook_Author() {
		return new good_reading.Book_Author();
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
	
	private int _bid;
	
	private String _author;
	
	public void set_bid(int value) {
		this._bid = value;
	}
	
	public int get_bid() {
		return _bid;
	}
	
	public int getORMID() {
		return get_bid();
	}
	
	public void set_author(String value) {
		this._author = value;
	}
	
	public String get_author() {
		return _author;
	}
	
	public String toString() {
		return String.valueOf(get_bid());
	}
	
}
