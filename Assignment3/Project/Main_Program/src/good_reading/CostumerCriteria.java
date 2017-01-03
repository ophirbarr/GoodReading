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

public class CostumerCriteria extends AbstractORMCriteria {
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
	
	public CostumerCriteria(Criteria criteria) {
		super(criteria);
		_uid = new IntegerExpression("_uid", this);
		_firstName = new StringExpression("_firstName", this);
		_lastName = new StringExpression("_lastName", this);
		_userName = new StringExpression("_userName", this);
		_password = new StringExpression("_password", this);
		_userStatus = new IntegerExpression("_userStatus", this);
		_accountType = new IntegerExpression("_accountType", this);
		_endDate = new DateExpression("_endDate", this);
		_accountStatus = new BooleanExpression("_accountStatus", this);
		_waitingForChangeType = new IntegerExpression("_waitingForChangeType", this);
	}
	
	public CostumerCriteria(PersistentSession session) {
		this(session.createCriteria(Costumer.class));
	}
	
	public CostumerCriteria() throws PersistentException {
		this(good_reading.GoodReadingPersistentManager.instance().getSession());
	}
	
	public Costumer uniqueCostumer() {
		return (Costumer) super.uniqueResult();
	}
	
	public Costumer[] listCostumer() {
		java.util.List list = super.list();
		return (Costumer[]) list.toArray(new Costumer[list.size()]);
	}
}

