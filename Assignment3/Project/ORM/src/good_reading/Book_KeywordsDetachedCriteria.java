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

public class Book_KeywordsDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression _bid;
	public final StringExpression _keyword;
	
	public Book_KeywordsDetachedCriteria() {
		super(good_reading.Book_Keywords.class, good_reading.Book_KeywordsCriteria.class);
		_bid = new IntegerExpression("_bid", this.getDetachedCriteria());
		_keyword = new StringExpression("_keyword", this.getDetachedCriteria());
	}
	
	public Book_KeywordsDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, good_reading.Book_KeywordsCriteria.class);
		_bid = new IntegerExpression("_bid", this.getDetachedCriteria());
		_keyword = new StringExpression("_keyword", this.getDetachedCriteria());
	}
	
	public Book_Keywords uniqueBook_Keywords(PersistentSession session) {
		return (Book_Keywords) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Book_Keywords[] listBook_Keywords(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Book_Keywords[]) list.toArray(new Book_Keywords[list.size()]);
	}
}

