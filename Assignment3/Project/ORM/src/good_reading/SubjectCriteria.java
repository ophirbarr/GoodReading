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

public class SubjectCriteria extends AbstractORMCriteria {
	public final IntegerExpression _sid;
	public final StringExpression _name;
	
	public SubjectCriteria(Criteria criteria) {
		super(criteria);
		_sid = new IntegerExpression("_sid", this);
		_name = new StringExpression("_name", this);
	}
	
	public SubjectCriteria(PersistentSession session) {
		this(session.createCriteria(Subject.class));
	}
	
	public SubjectCriteria() throws PersistentException {
		this(good_reading.GoodReadingPersistentManager.instance().getSession());
	}
	
	public Subject uniqueSubject() {
		return (Subject) super.uniqueResult();
	}
	
	public Subject[] listSubject() {
		java.util.List list = super.list();
		return (Subject[]) list.toArray(new Subject[list.size()]);
	}
}

