package facebookweb;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.facebookweb.dao.FacebookDAOInterface;
import com.facebookweb.entity.FacebookUser;
import com.facebookweb.utility.DAOFactory;

public class FacebookDAOHibernateTest {
	FacebookDAOInterface fd1;

	@Before
	public void setUp() throws Exception {
		fd1 = DAOFactory.createObjectHibernate();
	}

	@After
	public void tearDown() throws Exception {
		fd1=null;
	}

	
	@Test
	public void testCreateProfileDAO() {
		
		 FacebookUser fu = new FacebookUser(); 
		  fu.setName("Swapnil");
		  fu.setPassword("ssss");
		  fu.setEmail("swapnil@yahoo.com");
		  fu.setAddress("Kanpur");
		
		int i=fd1.createProfileDAO(fu);
		
		assert i>0:"Registration fail because i is equal to 0";
	}

	@Test
	public void testLoginProfile() {
		//fail("Not yet implemented");
	}

	@Test
	public void testViewProfile() {
		//fail("Not yet implemented");
	}

	@Test
	public void testEditProfile() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDeleteProfile() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetTimeLine() {
		//fail("Not yet implemented");
	}

	@Test
	public void testCheckEmailDAO() {
		//fail("Not yet implemented");
	}

}
