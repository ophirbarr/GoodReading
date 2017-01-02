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

public class DomainDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression _did;
	public final StringExpression _name;
	
	public DomainDetachedCriteria() {
		super(good_reading.Domain.class, good_reading.DomainCriteria.class);
		_did = new IntegerExpression("_did", this.getDetachedCriteria());
		_name = new StringExpression("_name", this.getDetachedCriteria());
	}
	
	public DomainDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, good_reading.DomainCriteria.class);
		_did = new IntegerExpression("_did", this.getDetachedCriteria());
		_name = new StringExpression("_name", this.getDetachedCriteria());
	}
	
	public Domain uniqueDomain(PersistentSession session) {
		return (Domain) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Domain[] listDomain(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Domain[]) list.toArray(new Domain[list.size()]);
	}
}

