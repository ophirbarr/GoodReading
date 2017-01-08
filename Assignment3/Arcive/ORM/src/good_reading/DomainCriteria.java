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

public class DomainCriteria extends AbstractORMCriteria {
	public final IntegerExpression _did;
	public final StringExpression _name;
	
	public DomainCriteria(Criteria criteria) {
		super(criteria);
		_did = new IntegerExpression("_did", this);
		_name = new StringExpression("_name", this);
	}
	
	public DomainCriteria(PersistentSession session) {
		this(session.createCriteria(Domain.class));
	}
	
	public DomainCriteria() throws PersistentException {
		this(good_reading.GoodReadingPersistentManager.instance().getSession());
	}
	
	public Domain uniqueDomain() {
		return (Domain) super.uniqueResult();
	}
	
	public Domain[] listDomain() {
		java.util.List list = super.list();
		return (Domain[]) list.toArray(new Domain[list.size()]);
	}
}

