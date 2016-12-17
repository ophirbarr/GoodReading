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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class WorkerDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression FirstName;
	public final StringExpression LastName;
	public final StringExpression Email;
	public final StringExpression Role;
	public final StringExpression Department;
	
	public WorkerDetachedCriteria() {
		super(personnel.Worker.class, personnel.WorkerCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		FirstName = new StringExpression("FirstName", this.getDetachedCriteria());
		LastName = new StringExpression("LastName", this.getDetachedCriteria());
		Email = new StringExpression("Email", this.getDetachedCriteria());
		Role = new StringExpression("Role", this.getDetachedCriteria());
		Department = new StringExpression("Department", this.getDetachedCriteria());
	}
	
	public WorkerDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, personnel.WorkerCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		FirstName = new StringExpression("FirstName", this.getDetachedCriteria());
		LastName = new StringExpression("LastName", this.getDetachedCriteria());
		Email = new StringExpression("Email", this.getDetachedCriteria());
		Role = new StringExpression("Role", this.getDetachedCriteria());
		Department = new StringExpression("Department", this.getDetachedCriteria());
	}
	
	public Worker uniqueWorker(PersistentSession session) {
		return (Worker) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Worker[] listWorker(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Worker[]) list.toArray(new Worker[list.size()]);
	}
}

