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

public class Book_SubjectCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression _bid;
	public final IntegerExpression _sid;
	
	public Book_SubjectCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_bid = new IntegerExpression("_bid", this);
		_sid = new IntegerExpression("_sid", this);
	}
	
	public Book_SubjectCriteria(PersistentSession session) {
		this(session.createCriteria(Book_Subject.class));
	}
	
	public Book_SubjectCriteria() throws PersistentException {
		this(good_reading.GoodReadingPersistentManager.instance().getSession());
	}
	
	public Book_Subject uniqueBook_Subject() {
		return (Book_Subject) super.uniqueResult();
	}
	
	public Book_Subject[] listBook_Subject() {
		java.util.List list = super.list();
		return (Book_Subject[]) list.toArray(new Book_Subject[list.size()]);
	}
}

