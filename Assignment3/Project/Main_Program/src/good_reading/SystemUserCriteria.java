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

public class SystemUserCriteria extends AbstractORMCriteria {
	public final IntegerExpression _uid;
	public final StringExpression _firstName;
	public final StringExpression _lastName;
	public final StringExpression _userName;
	public final StringExpression _password;
	public final IntegerExpression _userStatus;
	
	public SystemUserCriteria(Criteria criteria) {
		super(criteria);
		_uid = new IntegerExpression("_uid", this);
		_firstName = new StringExpression("_firstName", this);
		_lastName = new StringExpression("_lastName", this);
		_userName = new StringExpression("_userName", this);
		_password = new StringExpression("_password", this);
		_userStatus = new IntegerExpression("_userStatus", this);
	}
	
	public SystemUserCriteria(PersistentSession session) {
		this(session.createCriteria(SystemUser.class));
	}
	
	public SystemUserCriteria() throws PersistentException {
		this(good_reading.GoodReadingPersistentManager.instance().getSession());
	}
	
	public SystemUser uniqueSystemUser() {
		return (SystemUser) super.uniqueResult();
	}
	
	public SystemUser[] listSystemUser() {
		java.util.List list = super.list();
		return (SystemUser[]) list.toArray(new SystemUser[list.size()]);
	}
}

