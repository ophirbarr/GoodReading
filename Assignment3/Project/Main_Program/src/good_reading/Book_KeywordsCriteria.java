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

public class Book_KeywordsCriteria extends AbstractORMCriteria {
	public final IntegerExpression _bid;
	public final StringExpression _keyword;
	
	public Book_KeywordsCriteria(Criteria criteria) {
		super(criteria);
		_bid = new IntegerExpression("_bid", this);
		_keyword = new StringExpression("_keyword", this);
	}
	
	public Book_KeywordsCriteria(PersistentSession session) {
		this(session.createCriteria(Book_Keywords.class));
	}
	
	public Book_KeywordsCriteria() throws PersistentException {
		this(good_reading.GoodReadingPersistentManager.instance().getSession());
	}
	
	public Book_Keywords uniqueBook_Keywords() {
		return (Book_Keywords) super.uniqueResult();
	}
	
	public Book_Keywords[] listBook_Keywords() {
		java.util.List list = super.list();
		return (Book_Keywords[]) list.toArray(new Book_Keywords[list.size()]);
	}
}

