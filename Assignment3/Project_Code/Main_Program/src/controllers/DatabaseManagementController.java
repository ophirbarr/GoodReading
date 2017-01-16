package controllers;

import org.orm.PersistentException;
import org.orm.PersistentSession;

import good_reading.Domain;
import good_reading.GoodReadingPersistentManager;
import good_reading.Subject;

public class DatabaseManagementController 
{
	
	/**
	 * Return a list of subjects by name
	 * @param name name of subject
	 * @return list of subjects by name
	 */
	public static Subject[] GetSubjects(String name)
	{
		Subject[] subjects = null;
		try {
			PersistentSession session = GoodReadingPersistentManager.instance().getSession();
			subjects = Subject.listSubjectByQuery("_name LIKE '%%" + name + "%%'", "_name");
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return subjects;
	}
	
	/**
	 * Return a list of ALL subjects
	 * @return list of subjects by name
	 */
	public static Subject[] GetAllSubjects()
	{
		Subject[] subjects = null;
		try {
			PersistentSession session = GoodReadingPersistentManager.instance().getSession();
			subjects = Subject.listSubjectByQuery(null, null);
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return subjects;
	}
	
	/**
	 * Return a list of domains by name
	 * @param name name of domain
	 * @return list of domains by name
	 */
	public static Domain[] GetDomains(String name)
	{
		Domain[] domains = null;
		try {
			PersistentSession session = GoodReadingPersistentManager.instance().getSession();
			domains = Domain.listDomainByQuery("_name LIKE '%%" + name + "%%'", "_name");
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return domains;
	}
	
	/**
	 * Return a list of ALL domains
	 * @return list of domains by name
	 */
	public static Domain[] GetAllDomains()
	{
		Domain[] domains = null;
		try {
			PersistentSession session = GoodReadingPersistentManager.instance().getSession();
			domains = Domain.listDomainByQuery(null, null);
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return domains;
	}

}
