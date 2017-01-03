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

public class Book_AuthorCriteria extends AbstractORMCriteria {
	public final IntegerExpression _bid;
	public final StringExpression _author;
	
	public Book_AuthorCriteria(Criteria criteria) {
		super(criteria);
		_bid = new IntegerExpression("_bid", this);
		_author = new StringExpression("_author", this);
	}
	
	public Book_AuthorCriteria(PersistentSession session) {
		this(session.createCriteria(Book_Author.class));
	}
	
	public Book_AuthorCriteria() throws PersistentException {
		this(good_reading.GoodReadingPersistentManager.instance().getSession());
	}
	
	public Book_Author uniqueBook_Author() {
		return (Book_Author) super.uniqueResult();
	}
	
	public Book_Author[] listBook_Author() {
		java.util.List list = super.list();
		return (Book_Author[]) list.toArray(new Book_Author[list.size()]);
	}
}

