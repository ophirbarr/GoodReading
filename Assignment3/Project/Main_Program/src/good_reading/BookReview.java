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
public class BookReview implements Serializable {
	public BookReview() {
	}
	
	public static BookReview loadBookReviewByORMID(int _rid) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadBookReviewByORMID(session, _rid);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BookReview getBookReviewByORMID(int _rid) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return getBookReviewByORMID(session, _rid);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BookReview loadBookReviewByORMID(int _rid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadBookReviewByORMID(session, _rid, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BookReview getBookReviewByORMID(int _rid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return getBookReviewByORMID(session, _rid, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BookReview loadBookReviewByORMID(PersistentSession session, int _rid) throws PersistentException {
		try {
			return (BookReview) session.load(good_reading.BookReview.class, new Integer(_rid));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BookReview getBookReviewByORMID(PersistentSession session, int _rid) throws PersistentException {
		try {
			return (BookReview) session.get(good_reading.BookReview.class, new Integer(_rid));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BookReview loadBookReviewByORMID(PersistentSession session, int _rid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (BookReview) session.load(good_reading.BookReview.class, new Integer(_rid), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BookReview getBookReviewByORMID(PersistentSession session, int _rid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (BookReview) session.get(good_reading.BookReview.class, new Integer(_rid), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBookReview(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return queryBookReview(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBookReview(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return queryBookReview(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BookReview[] listBookReviewByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return listBookReviewByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BookReview[] listBookReviewByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return listBookReviewByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBookReview(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.BookReview as BookReview");
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
	
	public static List queryBookReview(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.BookReview as BookReview");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("BookReview", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BookReview[] listBookReviewByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryBookReview(session, condition, orderBy);
			return (BookReview[]) list.toArray(new BookReview[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BookReview[] listBookReviewByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryBookReview(session, condition, orderBy, lockMode);
			return (BookReview[]) list.toArray(new BookReview[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BookReview loadBookReviewByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadBookReviewByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BookReview loadBookReviewByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return loadBookReviewByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BookReview loadBookReviewByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		BookReview[] bookReviews = listBookReviewByQuery(session, condition, orderBy);
		if (bookReviews != null && bookReviews.length > 0)
			return bookReviews[0];
		else
			return null;
	}
	
	public static BookReview loadBookReviewByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		BookReview[] bookReviews = listBookReviewByQuery(session, condition, orderBy, lockMode);
		if (bookReviews != null && bookReviews.length > 0)
			return bookReviews[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateBookReviewByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return iterateBookReviewByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBookReviewByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = good_reading.GoodReadingPersistentManager.instance().getSession();
			return iterateBookReviewByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBookReviewByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.BookReview as BookReview");
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
	
	public static java.util.Iterator iterateBookReviewByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From good_reading.BookReview as BookReview");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("BookReview", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BookReview loadBookReviewByCriteria(BookReviewCriteria bookReviewCriteria) {
		BookReview[] bookReviews = listBookReviewByCriteria(bookReviewCriteria);
		if(bookReviews == null || bookReviews.length == 0) {
			return null;
		}
		return bookReviews[0];
	}
	
	public static BookReview[] listBookReviewByCriteria(BookReviewCriteria bookReviewCriteria) {
		return bookReviewCriteria.listBookReview();
	}
	
	public static BookReview createBookReview() {
		return new good_reading.BookReview();
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
	
	private int _rid;
	
	private int _bid;
	
	private String _review;
	
	private String _costumerName;
	
	private boolean _approved;
	
	public void set_rid(int value) {
		this._rid = value;
	}
	
	public int get_rid() {
		return _rid;
	}
	
	public int getORMID() {
		return get_rid();
	}
	
	public void set_bid(int value) {
		this._bid = value;
	}
	
	public int get_bid() {
		return _bid;
	}
	
	public void set_review(String value) {
		this._review = value;
	}
	
	public String get_review() {
		return _review;
	}
	
	public void set_costumerName(String value) {
		this._costumerName = value;
	}
	
	public String get_costumerName() {
		return _costumerName;
	}
	
	public void set_approved(boolean value) {
		this._approved = value;
	}
	
	public boolean get_approved() {
		return _approved;
	}
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(get_rid());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("BookReview[ ");
			sb.append("_rid=").append(get_rid()).append(" ");
			sb.append("_bid=").append(get_bid()).append(" ");
			sb.append("_review=").append(get_review()).append(" ");
			sb.append("_costumerName=").append(get_costumerName()).append(" ");
			sb.append("_approved=").append(get_approved()).append(" ");
			sb.append("]");
			return sb.toString();
		}
	}
	
}
