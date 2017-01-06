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

public class Book_SubjectDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression _bid;
	public final IntegerExpression _sid;
	
	public Book_SubjectDetachedCriteria() {
		super(good_reading.Book_Subject.class, good_reading.Book_SubjectCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_bid = new IntegerExpression("_bid", this.getDetachedCriteria());
		_sid = new IntegerExpression("_sid", this.getDetachedCriteria());
	}
	
	public Book_SubjectDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, good_reading.Book_SubjectCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_bid = new IntegerExpression("_bid", this.getDetachedCriteria());
		_sid = new IntegerExpression("_sid", this.getDetachedCriteria());
	}
	
	public Book_Subject uniqueBook_Subject(PersistentSession session) {
		return (Book_Subject) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Book_Subject[] listBook_Subject(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Book_Subject[]) list.toArray(new Book_Subject[list.size()]);
	}
}

