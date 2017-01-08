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

public class SubjectDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression _sid;
	public final StringExpression _name;
	public final IntegerExpression _did;
	
	public SubjectDetachedCriteria() {
		super(good_reading.Subject.class, good_reading.SubjectCriteria.class);
		_sid = new IntegerExpression("_sid", this.getDetachedCriteria());
		_name = new StringExpression("_name", this.getDetachedCriteria());
		_did = new IntegerExpression("_did", this.getDetachedCriteria());
	}
	
	public SubjectDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, good_reading.SubjectCriteria.class);
		_sid = new IntegerExpression("_sid", this.getDetachedCriteria());
		_name = new StringExpression("_name", this.getDetachedCriteria());
		_did = new IntegerExpression("_did", this.getDetachedCriteria());
	}
	
	public Subject uniqueSubject(PersistentSession session) {
		return (Subject) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Subject[] listSubject(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Subject[]) list.toArray(new Subject[list.size()]);
	}
}

