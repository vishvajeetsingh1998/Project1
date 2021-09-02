package whatsappwebtl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.whatsappweb.dao.WhatsappDAOInterface;
import com.whatsappweb.entity.WhatsappUser;
import com.whatsappweb.utility.ControllerFactory;

public class HibernateTest {
	WhatsappDAOInterface ww;

	@Before
	public void setUp() throws Exception {
		ww = ControllerFactory.createObjectHibernate();
	}

	@After
	public void tearDown() throws Exception {
		ww = null;
	}

	/*
	 * @Test public void testCreateProfileDAO() { WhatsappUser iu = new
	 * WhatsappUser(); iu.setName("Ramesh"); iu.setPassword("R@1234");
	 * iu.setAge(15); iu.setEmail("ramesh@gmail.com"); iu.setAddress("Mumbai"); int
	 * i = ww.createProfileDAO(iu); assert i > 0 : "Registration Failed.."; }
	 */

	@Test
	public void testLoginProfile() {
		WhatsappUser iu = new WhatsappUser();
		iu.setEmail("vishvajeetsingh3006@gmail.com");
		iu.setPassword("vishu3006");
		boolean b = ww.loginProfile(iu);
		assert b : "Login Failed";
		// fail("Not yet implemented");
	}

	@Test
	public void testViewProfile() {
		WhatsappUser iu = new WhatsappUser();
		iu.setEmail("vishvajeetsingh3006@gmail.com");
		WhatsappUser ws = ww.viewProfile(iu);
		assert ws != null : "Failed to view profile";
	}

	@Test
	public void testEditProfile() {
		WhatsappUser iu = new WhatsappUser();
		iu.setEmail("vishvajeetsingh3006@gmail.com");
		iu.setName("Vishvajeet Singh");
		iu.setPassword("vishu3006");
		iu.setAddress("Lucknow");
		int i = ww.editProfile(iu);
		assert i > 0 : "Failed to edit profile";
	}

	@Test
	public void testSearchProfile() {
		WhatsappUser iu = new WhatsappUser();
		iu.setName("Vishvajeet Singh");
		WhatsappUser ws = ww.searchProfile(iu);
		assert ws != null : "Profile not found";
	}

	/*
	 * @Test public void testDeleteProfile() { WhatsappUser iu = new WhatsappUser();
	 * iu.setEmail("ramesh@gmail.com"); iu.setPassword("1234@"); int i =
	 * ww.deleteProfile(iu); assert i > 0 : "password is incorrect"; }
	 */

	@Test
	public void testAllUser() {
		List<WhatsappUser> ll = ww.allUser();
		assert ll != null : "Zero Users";

	}

}
