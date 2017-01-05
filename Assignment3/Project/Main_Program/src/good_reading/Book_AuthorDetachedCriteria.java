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

public class Book_AuthorDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression _bid;
	public final StringExpression _author;
	
	public Book_AuthorDetachedCriteria() {
		super(good_reading.Book_Author.class, good_reading.Book_AuthorCriteria.class);
		_bid = new IntegerExpression("_bid", this.getDetachedCriteria());
		_author = new StringExpression("_author", this.getDetachedCriteria());
	}
	
	public Book_AuthorDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, good_reading.Book_AuthorCriteria.class);
		_bid = new IntegerExpression("_bid", this.getDetachedCriteria());
		_author = new StringExpression("_author", this.getDetachedCriteria());
	}
	
	public Book_Author uniqueBook_Author(PersistentSession session) {
		return (Book_Author) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Book_Author[] listBook_Author(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Book_Author[]) list.toArray(new Book_Author[list.size()]);
	}
}

