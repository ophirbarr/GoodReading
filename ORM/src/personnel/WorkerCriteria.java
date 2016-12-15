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
package personnel;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class WorkerCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression FirstName;
	public final StringExpression LastName;
	public final StringExpression Email;
	public final StringExpression Role;
	public final StringExpression Department;
	
	public WorkerCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		FirstName = new StringExpression("FirstName", this);
		LastName = new StringExpression("LastName", this);
		Email = new StringExpression("Email", this);
		Role = new StringExpression("Role", this);
		Department = new StringExpression("Department", this);
	}
	
	public WorkerCriteria(PersistentSession session) {
		this(session.createCriteria(Worker.class));
	}
	
	public WorkerCriteria() throws PersistentException {
		this(personnel.UntitledPersistentManager.instance().getSession());
	}
	
	public Worker uniqueWorker() {
		return (Worker) super.uniqueResult();
	}
	
	public Worker[] listWorker() {
		java.util.List list = super.list();
		return (Worker[]) list.toArray(new Worker[list.size()]);
	}
}

