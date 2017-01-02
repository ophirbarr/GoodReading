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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class BookDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression _bid;
	public final StringExpression _title;
	public final StringExpression _language;
	public final StringExpression _summary;
	public final StringExpression _TableOfContents;
	public final BooleanExpression _viewStatus;
	public final DoubleExpression _price;
	public final StringExpression _searchLog;
	public final StringExpression _purchaseLog;
	public final IntegerExpression _purchaseCount;
	public final StringExpression _author;
	public final StringExpression _keywords;
	public final StringExpression _bookFormat;
	
	public BookDetachedCriteria() {
		super(good_reading.Book.class, good_reading.BookCriteria.class);
		_bid = new IntegerExpression("_bid", this.getDetachedCriteria());
		_title = new StringExpression("_title", this.getDetachedCriteria());
		_language = new StringExpression("_language", this.getDetachedCriteria());
		_summary = new StringExpression("_summary", this.getDetachedCriteria());
		_TableOfContents = new StringExpression("_TableOfContents", this.getDetachedCriteria());
		_viewStatus = new BooleanExpression("_viewStatus", this.getDetachedCriteria());
		_price = new DoubleExpression("_price", this.getDetachedCriteria());
		_searchLog = new StringExpression("_searchLog", this.getDetachedCriteria());
		_purchaseLog = new StringExpression("_purchaseLog", this.getDetachedCriteria());
		_purchaseCount = new IntegerExpression("_purchaseCount", this.getDetachedCriteria());
		_author = new StringExpression("_author", this.getDetachedCriteria());
		_keywords = new StringExpression("_keywords", this.getDetachedCriteria());
		_bookFormat = new StringExpression("_bookFormat", this.getDetachedCriteria());
	}
	
	public BookDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, good_reading.BookCriteria.class);
		_bid = new IntegerExpression("_bid", this.getDetachedCriteria());
		_title = new StringExpression("_title", this.getDetachedCriteria());
		_language = new StringExpression("_language", this.getDetachedCriteria());
		_summary = new StringExpression("_summary", this.getDetachedCriteria());
		_TableOfContents = new StringExpression("_TableOfContents", this.getDetachedCriteria());
		_viewStatus = new BooleanExpression("_viewStatus", this.getDetachedCriteria());
		_price = new DoubleExpression("_price", this.getDetachedCriteria());
		_searchLog = new StringExpression("_searchLog", this.getDetachedCriteria());
		_purchaseLog = new StringExpression("_purchaseLog", this.getDetachedCriteria());
		_purchaseCount = new IntegerExpression("_purchaseCount", this.getDetachedCriteria());
		_author = new StringExpression("_author", this.getDetachedCriteria());
		_keywords = new StringExpression("_keywords", this.getDetachedCriteria());
		_bookFormat = new StringExpression("_bookFormat", this.getDetachedCriteria());
	}
	
	public Book uniqueBook(PersistentSession session) {
		return (Book) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Book[] listBook(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Book[]) list.toArray(new Book[list.size()]);
	}
}

