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

public class Customer_BookCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression _uid;
	public final IntegerExpression _bid;
	
	public Customer_BookCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_uid = new IntegerExpression("_uid", this);
		_bid = new IntegerExpression("_bid", this);
	}
	
	public Customer_BookCriteria(PersistentSession session) {
		this(session.createCriteria(Customer_Book.class));
	}
	
	public Customer_BookCriteria() throws PersistentException {
		this(good_reading.GoodReadingPersistentManager.instance().getSession());
	}
	
	public Customer_Book uniqueCustomer_Book() {
		return (Customer_Book) super.uniqueResult();
	}
	
	public Customer_Book[] listCustomer_Book() {
		java.util.List list = super.list();
		return (Customer_Book[]) list.toArray(new Customer_Book[list.size()]);
	}
}

