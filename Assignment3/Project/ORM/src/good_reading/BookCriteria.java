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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class BookCriteria extends AbstractORMCriteria {
	public final IntegerExpression _bid;
	public final StringExpression _title;
	public final StringExpression _language;
	public final StringExpression _summary;
	public final StringExpression _TableOfContents;
	public final BooleanExpression _viewStatus;
	public final FloatExpression _price;
	public final StringExpression _searchLog;
	public final StringExpression _purchaseLog;
	public final IntegerExpression _purchaseCount;
	public final StringExpression _bookFormat;
	
	public BookCriteria(Criteria criteria) {
		super(criteria);
		_bid = new IntegerExpression("_bid", this);
		_title = new StringExpression("_title", this);
		_language = new StringExpression("_language", this);
		_summary = new StringExpression("_summary", this);
		_TableOfContents = new StringExpression("_TableOfContents", this);
		_viewStatus = new BooleanExpression("_viewStatus", this);
		_price = new FloatExpression("_price", this);
		_searchLog = new StringExpression("_searchLog", this);
		_purchaseLog = new StringExpression("_purchaseLog", this);
		_purchaseCount = new IntegerExpression("_purchaseCount", this);
		_bookFormat = new StringExpression("_bookFormat", this);
	}
	
	public BookCriteria(PersistentSession session) {
		this(session.createCriteria(Book.class));
	}
	
	public BookCriteria() throws PersistentException {
		this(good_reading.GoodReadingPersistentManager.instance().getSession());
	}
	
	public Book uniqueBook() {
		return (Book) super.uniqueResult();
	}
	
	public Book[] listBook() {
		java.util.List list = super.list();
		return (Book[]) list.toArray(new Book[list.size()]);
	}
}

