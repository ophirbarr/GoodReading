package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.orm.PersistentException;
import good_reading.Book;
import good_reading.Book_Subject;
import good_reading.Subject;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class SearchBooksTest {

	private boolean[] checkboxes1;
	private boolean[] checkboxes2;
	private boolean[] checkboxes3;
	private boolean[] checkboxes4;
	private String[] input1;
	private String[] input2;
	private String[] input3;
	private String[] input4;
	private Book[] expected1;
	private Book[] expected2;
	private Book[] expected3;
	private Book[] expected4;

	@Before
	public void setUp() throws Exception 
	{
		checkboxes1 = new boolean[] { false, false, false, false, false, false, false };
		checkboxes2 = new boolean[] { false, true, false, false, false, false, false };
		checkboxes3 = new boolean[] { false, false, false, false, false, true, false };
		checkboxes4 = new boolean[] { false, true, false, false, false, true, false };
		input1 = new String[] { "", "", "", "", "", "", "" };
		input2 = new String[] { "", "English", "", "", "", "", "" };
		input3 = new String[] { "", "", "", "", "", "Fantasy", "" };
		input4 = new String[] { "", "English", "", "", "", "Fantasy", "" };
		expected1 = new Book[0];
		expected2 = Book.listBookByQuery("_language = 'English'", "_title");
		expected3 = setUpExpected3();
		expected4 = setUpExpected4();
	}
	
	// Test search with empty input
	@Test
	public void testSearchBooksEmpty() 
	{
		Book[] result = controllers.SystemUserController.SearchBooks(checkboxes1, input1, false);
		Assert.assertTrue(Arrays.equals(expected1, result));
	}
	
	// Test search for books in English
	@Test
	public void testSearchBooksEnglish() throws PersistentException 
	{
		Book[] result = controllers.SystemUserController.SearchBooks(checkboxes2, input2, false);
		Assert.assertTrue(Arrays.equals(expected2, result));
	}
	
	// Test search for Fantasy books
	@Test
	public void testSearchBooksFantasy() throws PersistentException 
	{
		Book[] result = controllers.SystemUserController.SearchBooks(checkboxes3, input3, false);
		Assert.assertFalse(Arrays.equals(expected3, result));
	}
	
	// Test search for Fantasy books in English
	@Test
	public void testSearchBooksEnglishFantasy() throws PersistentException 
	{
		Book[] result = controllers.SystemUserController.SearchBooks(checkboxes4, input4, false);
		Assert.assertFalse(Arrays.equals(expected4, result));
	}

	
	
	
	
	// setup methods
	
	@SuppressWarnings("unused")
	private Book[] setUpExpected3() throws PersistentException
	{
		Subject subject = Subject.loadSubjectByQuery("_name like '%%Fantasy%%'", null);
		if (subject != null)
		{
			int sid = subject.get_sid();
			Book_Subject[] book_subject = Book_Subject.listBook_SubjectByQuery("_sid = '" + sid + "'", null);
			if (book_subject.length > 0)
			{
				String condition = "";
				for (int i = 0; i < book_subject.length; i++)
					condition = condition + "_bid = '" + book_subject[i].get_bid() + "' OR ";
				condition = condition.substring(0, condition.length() - 4);
				expected3 = Book.listBookByQuery(condition, "_title");			
			}
			else expected3 = new Book[0];
		}
		else expected3 = new Book[0];
		expected3 = Book.listBookByQuery("_language = 'English'", "_title");
		return expected3;
	}
	
	private Book[] setUpExpected4()
	{
		Collection<Book> collection = new ArrayList<Book>();
		collection.addAll(Arrays.asList(expected2));
		collection.retainAll(Arrays.asList(expected3));
		Book[] expected4 = collection.toArray(new Book[] {});
		return expected4;
	}
}
