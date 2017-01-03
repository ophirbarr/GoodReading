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

public class BookReviewCriteria extends AbstractORMCriteria {
	public final IntegerExpression _rid;
	public final IntegerExpression _bid;
	public final StringExpression _review;
	public final StringExpression _costumerName;
	public final BooleanExpression _approved;
	
	public BookReviewCriteria(Criteria criteria) {
		super(criteria);
		_rid = new IntegerExpression("_rid", this);
		_bid = new IntegerExpression("_bid", this);
		_review = new StringExpression("_review", this);
		_costumerName = new StringExpression("_costumerName", this);
		_approved = new BooleanExpression("_approved", this);
	}
	
	public BookReviewCriteria(PersistentSession session) {
		this(session.createCriteria(BookReview.class));
	}
	
	public BookReviewCriteria() throws PersistentException {
		this(good_reading.GoodReadingPersistentManager.instance().getSession());
	}
	
	public BookReview uniqueBookReview() {
		return (BookReview) super.uniqueResult();
	}
	
	public BookReview[] listBookReview() {
		java.util.List list = super.list();
		return (BookReview[]) list.toArray(new BookReview[list.size()]);
	}
}

