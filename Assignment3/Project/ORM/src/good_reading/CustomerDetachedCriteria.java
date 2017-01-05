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

public class CustomerDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression _uid;
	public final StringExpression _firstName;
	public final StringExpression _lastName;
	public final StringExpression _userName;
	public final StringExpression _password;
	public final IntegerExpression _userStatus;
	public final IntegerExpression _accountType;
	public final DateExpression _endDate;
	public final BooleanExpression _accountStatus;
	public final IntegerExpression _waitingForChangeType;
	
	public CustomerDetachedCriteria() {
		super(good_reading.Customer.class, good_reading.CustomerCriteria.class);
		_uid = new IntegerExpression("_uid", this.getDetachedCriteria());
		_firstName = new StringExpression("_firstName", this.getDetachedCriteria());
		_lastName = new StringExpression("_lastName", this.getDetachedCriteria());
		_userName = new StringExpression("_userName", this.getDetachedCriteria());
		_password = new StringExpression("_password", this.getDetachedCriteria());
		_userStatus = new IntegerExpression("_userStatus", this.getDetachedCriteria());
		_accountType = new IntegerExpression("_accountType", this.getDetachedCriteria());
		_endDate = new DateExpression("_endDate", this.getDetachedCriteria());
		_accountStatus = new BooleanExpression("_accountStatus", this.getDetachedCriteria());
		_waitingForChangeType = new IntegerExpression("_waitingForChangeType", this.getDetachedCriteria());
	}
	
	public CustomerDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, good_reading.CustomerCriteria.class);
		_uid = new IntegerExpression("_uid", this.getDetachedCriteria());
		_firstName = new StringExpression("_firstName", this.getDetachedCriteria());
		_lastName = new StringExpression("_lastName", this.getDetachedCriteria());
		_userName = new StringExpression("_userName", this.getDetachedCriteria());
		_password = new StringExpression("_password", this.getDetachedCriteria());
		_userStatus = new IntegerExpression("_userStatus", this.getDetachedCriteria());
		_accountType = new IntegerExpression("_accountType", this.getDetachedCriteria());
		_endDate = new DateExpression("_endDate", this.getDetachedCriteria());
		_accountStatus = new BooleanExpression("_accountStatus", this.getDetachedCriteria());
		_waitingForChangeType = new IntegerExpression("_waitingForChangeType", this.getDetachedCriteria());
	}
	
	public Customer uniqueCustomer(PersistentSession session) {
		return (Customer) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Customer[] listCustomer(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Customer[]) list.toArray(new Customer[list.size()]);
	}
}

