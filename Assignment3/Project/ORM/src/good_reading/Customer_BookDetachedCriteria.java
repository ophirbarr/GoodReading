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

public class Customer_BookDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression _uid;
	public final IntegerExpression _bid;
	
	public Customer_BookDetachedCriteria() {
		super(good_reading.Customer_Book.class, good_reading.Customer_BookCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_uid = new IntegerExpression("_uid", this.getDetachedCriteria());
		_bid = new IntegerExpression("_bid", this.getDetachedCriteria());
	}
	
	public Customer_BookDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, good_reading.Customer_BookCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_uid = new IntegerExpression("_uid", this.getDetachedCriteria());
		_bid = new IntegerExpression("_bid", this.getDetachedCriteria());
	}
	
	public Customer_Book uniqueCustomer_Book(PersistentSession session) {
		return (Customer_Book) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Customer_Book[] listCustomer_Book(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Customer_Book[]) list.toArray(new Customer_Book[list.size()]);
	}
}

