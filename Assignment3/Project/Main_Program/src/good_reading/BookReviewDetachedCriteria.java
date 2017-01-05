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

public class BookReviewDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression _rid;
	public final IntegerExpression _bid;
	public final StringExpression _review;
	public final StringExpression _costumerName;
	public final BooleanExpression _approved;
	
	public BookReviewDetachedCriteria() {
		super(good_reading.BookReview.class, good_reading.BookReviewCriteria.class);
		_rid = new IntegerExpression("_rid", this.getDetachedCriteria());
		_bid = new IntegerExpression("_bid", this.getDetachedCriteria());
		_review = new StringExpression("_review", this.getDetachedCriteria());
		_costumerName = new StringExpression("_costumerName", this.getDetachedCriteria());
		_approved = new BooleanExpression("_approved", this.getDetachedCriteria());
	}
	
	public BookReviewDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, good_reading.BookReviewCriteria.class);
		_rid = new IntegerExpression("_rid", this.getDetachedCriteria());
		_bid = new IntegerExpression("_bid", this.getDetachedCriteria());
		_review = new StringExpression("_review", this.getDetachedCriteria());
		_costumerName = new StringExpression("_costumerName", this.getDetachedCriteria());
		_approved = new BooleanExpression("_approved", this.getDetachedCriteria());
	}
	
	public BookReview uniqueBookReview(PersistentSession session) {
		return (BookReview) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public BookReview[] listBookReview(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (BookReview[]) list.toArray(new BookReview[list.size()]);
	}
}

