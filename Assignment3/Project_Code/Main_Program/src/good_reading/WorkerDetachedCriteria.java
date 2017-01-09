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

public class WorkerDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression _uid;
	public final StringExpression _firstName;
	public final StringExpression _lastName;
	public final StringExpression _userName;
	public final StringExpression _password;
	public final IntegerExpression _userStatus;
	public final IntegerExpression _ssn;
	public final IntegerExpression _wid;
	public final StringExpression _role;
	public final StringExpression _email;
	public final StringExpression _department;
	
	public WorkerDetachedCriteria() {
		super(good_reading.Worker.class, good_reading.WorkerCriteria.class);
		_uid = new IntegerExpression("_uid", this.getDetachedCriteria());
		_firstName = new StringExpression("_firstName", this.getDetachedCriteria());
		_lastName = new StringExpression("_lastName", this.getDetachedCriteria());
		_userName = new StringExpression("_userName", this.getDetachedCriteria());
		_password = new StringExpression("_password", this.getDetachedCriteria());
		_userStatus = new IntegerExpression("_userStatus", this.getDetachedCriteria());
		_ssn = new IntegerExpression("_ssn", this.getDetachedCriteria());
		_wid = new IntegerExpression("_wid", this.getDetachedCriteria());
		_role = new StringExpression("_role", this.getDetachedCriteria());
		_email = new StringExpression("_email", this.getDetachedCriteria());
		_department = new StringExpression("_department", this.getDetachedCriteria());
	}
	
	public WorkerDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, good_reading.WorkerCriteria.class);
		_uid = new IntegerExpression("_uid", this.getDetachedCriteria());
		_firstName = new StringExpression("_firstName", this.getDetachedCriteria());
		_lastName = new StringExpression("_lastName", this.getDetachedCriteria());
		_userName = new StringExpression("_userName", this.getDetachedCriteria());
		_password = new StringExpression("_password", this.getDetachedCriteria());
		_userStatus = new IntegerExpression("_userStatus", this.getDetachedCriteria());
		_ssn = new IntegerExpression("_ssn", this.getDetachedCriteria());
		_wid = new IntegerExpression("_wid", this.getDetachedCriteria());
		_role = new StringExpression("_role", this.getDetachedCriteria());
		_email = new StringExpression("_email", this.getDetachedCriteria());
		_department = new StringExpression("_department", this.getDetachedCriteria());
	}
	
	public Worker uniqueWorker(PersistentSession session) {
		return (Worker) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Worker[] listWorker(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Worker[]) list.toArray(new Worker[list.size()]);
	}
}

