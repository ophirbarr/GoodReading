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

public class SystemUserDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression _uid;
	public final StringExpression _firstName;
	public final StringExpression _lastName;
	public final StringExpression _userName;
	public final StringExpression _password;
	public final IntegerExpression _userStatus;
	
	public SystemUserDetachedCriteria() {
		super(good_reading.SystemUser.class, good_reading.SystemUserCriteria.class);
		_uid = new IntegerExpression("_uid", this.getDetachedCriteria());
		_firstName = new StringExpression("_firstName", this.getDetachedCriteria());
		_lastName = new StringExpression("_lastName", this.getDetachedCriteria());
		_userName = new StringExpression("_userName", this.getDetachedCriteria());
		_password = new StringExpression("_password", this.getDetachedCriteria());
		_userStatus = new IntegerExpression("_userStatus", this.getDetachedCriteria());
	}
	
	public SystemUserDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, good_reading.SystemUserCriteria.class);
		_uid = new IntegerExpression("_uid", this.getDetachedCriteria());
		_firstName = new StringExpression("_firstName", this.getDetachedCriteria());
		_lastName = new StringExpression("_lastName", this.getDetachedCriteria());
		_userName = new StringExpression("_userName", this.getDetachedCriteria());
		_password = new StringExpression("_password", this.getDetachedCriteria());
		_userStatus = new IntegerExpression("_userStatus", this.getDetachedCriteria());
	}
	
	public SystemUser uniqueSystemUser(PersistentSession session) {
		return (SystemUser) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public SystemUser[] listSystemUser(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (SystemUser[]) list.toArray(new SystemUser[list.size()]);
	}
}

