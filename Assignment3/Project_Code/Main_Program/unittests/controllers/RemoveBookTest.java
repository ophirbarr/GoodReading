package controllers;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.orm.PersistentException;
import common.Message;
import good_reading.Book;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class RemoveBookTest 
{
	private Message param = new Message("DeleteItem", "DatabaseManagementController");
	private Book book;
	private boolean expected;

	@Before
	public void setUp() throws Exception 
	{
		book = controllers.DatabaseManagementController.AddBook();
		param.add(0);
		param.add(book.get_bid());
		expected = true;
	}

	// (1) Test to remove a newly added book in DB
	@Test
	public void testRemoveNewBook() throws PersistentException 
	{
		Assert.assertTrue(Arrays.equals(Book.listBookByQuery("_bid = '" + book.get_bid() + "'", null), new Book[] { book })); // test that book is in DB
		boolean result = controllers.DatabaseManagementController.DeleteItem(param);
		Assert.assertTrue(expected == result);  // test success
		Assert.assertTrue(Arrays.equals(Book.listBookByQuery("_bid = '" + book.get_bid() + "'", null), new Book[0])); // test that book is NOT in DB
	}
}
