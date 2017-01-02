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
public class Book implements Serializable {
	public Book() {
	}
	
	public static Book loadBookByORMID(int _bid) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadBookByORMID(session, _bid);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book getBookByORMID(int _bid) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return getBookByORMID(session, _bid);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book loadBookByORMID(int _bid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadBookByORMID(session, _bid, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book getBookByORMID(int _bid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return getBookByORMID(session, _bid, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book loadBookByORMID(PersistentSession session, int _bid) throws PersistentException {
		try {
			return (Book) session.load(good_reading.Book.class, new Integer(_bid));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book getBookByORMID(PersistentSession session, int _bid) throws PersistentException {
		try {
			return (Book) session.get(good_reading.Book.class, new Integer(_bid));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book loadBookByORMID(PersistentSession session, int _bid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Book) session.load(good_reading.Book.class, new Integer(_bid), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book getBookByORMID(PersistentSession session, int _bid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Book) session.get(good_reading.Book.class, new Integer(_bid), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBook(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return queryBook(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBook(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return queryBook(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book[] listBookByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return listBookByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book[] listBookByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return listBookByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBook(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Book as Book");
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
	
	public static List queryBook(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Book as Book");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Book", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book[] listBookByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryBook(session, condition, orderBy);
			return (Book[]) list.toArray(new Book[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book[] listBookByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryBook(session, condition, orderBy, lockMode);
			return (Book[]) list.toArray(new Book[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book loadBookByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadBookByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book loadBookByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadBookByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book loadBookByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Book[] books = listBookByQuery(session, condition, orderBy);
		if (books != null && books.length > 0)
			return books[0];
		else
			return null;
	}
	
	public static Book loadBookByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Book[] books = listBookByQuery(session, condition, orderBy, lockMode);
		if (books != null && books.length > 0)
			return books[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateBookByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return iterateBookByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBookByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return iterateBookByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBookByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Book as Book");
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
	
	public static java.util.Iterator iterateBookByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.Book as Book");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Book", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Book loadBookByCriteria(BookCriteria bookCriteria) {
		Book[] books = listBookByCriteria(bookCriteria);
		if(books == null || books.length == 0) {
			return null;
		}
		return books[0];
	}
	
	public static Book[] listBookByCriteria(BookCriteria bookCriteria) {
		return bookCriteria.listBook();
	}
	
	public static Book createBook() {
		return new good_reading.Book();
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
	
	private String _title;
	
	private String _language;
	
	private String _summary;
	
	private String _TableOfContents;
	
	private Boolean _viewStatus;
	
	private double _price;
	
	private String _searchLog;
	
	private String _purchaseLog;
	
	private int _purchaseCount;
	
	private String _author;
	
	private String _keywords;
	
	private String _bookFormat;
	
	public void set_bid(int value) {
		this._bid = value;
	}
	
	public int get_bid() {
		return _bid;
	}
	
	public int getORMID() {
		return get_bid();
	}
	
	public void set_title(String value) {
		this._title = value;
	}
	
	public String get_title() {
		return _title;
	}
	
	public void set_author(String value) {
		this._author = value;
	}
	
	public String get_author() {
		return _author;
	}
	
	public void set_language(String value) {
		this._language = value;
	}
	
	public String get_language() {
		return _language;
	}
	
	public void set_summary(String value) {
		this._summary = value;
	}
	
	public String get_summary() {
		return _summary;
	}
	
	public void set_TableOfContents(String value) {
		this._TableOfContents = value;
	}
	
	public String get_TableOfContents() {
		return _TableOfContents;
	}
	
	public void set_keywords(String value) {
		this._keywords = value;
	}
	
	public String get_keywords() {
		return _keywords;
	}
	
	public void set_viewStatus(boolean value) {
		set_viewStatus(new Boolean(value));
	}
	
	public void set_viewStatus(Boolean value) {
		this._viewStatus = value;
	}
	
	public Boolean get_viewStatus() {
		return _viewStatus;
	}
	
	public void set_price(double value) {
		this._price = value;
	}
	
	public double get_price() {
		return _price;
	}
	
	public void set_searchLog(String value) {
		this._searchLog = value;
	}
	
	public String get_searchLog() {
		return _searchLog;
	}
	
	public void set_purchaseLog(String value) {
		this._purchaseLog = value;
	}
	
	public String get_purchaseLog() {
		return _purchaseLog;
	}
	
	public void set_purchaseCount(int value) {
		this._purchaseCount = value;
	}
	
	public int get_purchaseCount() {
		return _purchaseCount;
	}
	
	public void set_bookFormat(String value) {
		this._bookFormat = value;
	}
	
	public String get_bookFormat() {
		return _bookFormat;
	}
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(get_bid());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("Book[ ");
			sb.append("_bid=").append(get_bid()).append(" ");
			sb.append("_title=").append(get_title()).append(" ");
			sb.append("_language=").append(get_language()).append(" ");
			sb.append("_summary=").append(get_summary()).append(" ");
			sb.append("_TableOfContents=").append(get_TableOfContents()).append(" ");
			sb.append("_viewStatus=").append(get_viewStatus()).append(" ");
			sb.append("_price=").append(get_price()).append(" ");
			sb.append("_searchLog=").append(get_searchLog()).append(" ");
			sb.append("_purchaseLog=").append(get_purchaseLog()).append(" ");
			sb.append("_purchaseCount=").append(get_purchaseCount()).append(" ");
			sb.append("_author=").append(get_author()).append(" ");
			sb.append("_keywords=").append(get_keywords()).append(" ");
			sb.append("_bookFormat=").append(get_bookFormat()).append(" ");
			sb.append("]");
			return sb.toString();
		}
	}
	
}
