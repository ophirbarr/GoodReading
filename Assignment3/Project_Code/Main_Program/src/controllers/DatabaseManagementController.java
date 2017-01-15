package controllers;

import org.orm.PersistentException;

import good_reading.Subject;

public class DatabaseManagementController 
{
	public static Subject[] GetSubjects(String name)
	{
		Subject[] subjects = null;
		try {
			subjects = Subject.listSubjectByQuery("_name LIKE '%%" + name + "%%'", "_name");
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		
		return subjects;
	}

}
