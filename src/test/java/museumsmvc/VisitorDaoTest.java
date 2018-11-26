package museumsmvc;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yrenh.museumsmvc.config.RootContextConfig;
import com.yrenh.museumsmvc.dao.VisitorDao;
import com.yrenh.museumsmvc.entity.Visitor;

import museumsmvc.config.DataSourceConfig;

@ContextConfiguration( classes = { RootContextConfig.class, DataSourceConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class VisitorDaoTest {

	@Autowired
	private VisitorDao visitorDao;
	
	@Test
	@Transactional
	public void saveVisitorTest() {
		String expectedFirstName = "Firstname";
		String lastName = "Lastname";
		String phone = "Phone";
		String email ="Email";
		
		Visitor visitor = new Visitor();
		visitor.setFirstName(expectedFirstName);
		visitor.setLastName(lastName);
		visitor.setPhone(phone);
		visitor.setEmail(email);
		visitor.setBirthDate(LocalDate.now());
		visitorDao.save(visitor);
		Long id = visitor.getId();
		
		Assert.assertEquals(expectedFirstName, visitorDao.find(id).getFirstName());
	}
	
	@Test(expected = InvalidDataAccessApiUsageException.class)
	@Transactional
	public void saveVisitorWithIdTest() {
		String expectedFirstName = "Firstname";
		String lastName = "Lastname";
		String phone = "Phone";
		String email ="Email";
		Long id = 1l;
		
		Visitor visitor = new Visitor();
		visitor.setId(id);
		visitor.setFirstName(expectedFirstName);
		visitor.setLastName(lastName);
		visitor.setPhone(phone);
		visitor.setEmail(email);
		visitor.setBirthDate(LocalDate.now());
		visitorDao.save(visitor);
	}
	
	@Test
	@Transactional
	public void updateVisitorTest() {
		String oldFirstName = "OldFirstname";
		String newFirstName = "Newfirstname";
		String lastName = "Lastname";
		String phone = "Phone";
		String email ="Email";
		
		Visitor visitor = new Visitor();
		visitor.setFirstName(oldFirstName);
		visitor.setLastName(lastName);
		visitor.setPhone(phone);
		visitor.setEmail(email);
		visitor.setBirthDate(LocalDate.now());
		visitorDao.save(visitor);
		Long id = visitor.getId();
		
		visitor.setFirstName(newFirstName);
		visitorDao.update(visitor);
		Assert.assertEquals(newFirstName, visitorDao.find(id).getFirstName());
	}
	
	@Test
	@Transactional
	public void deleteVisitor() {
		String expectedFirstName = "Firstname";
		String lastName = "Lastname";
		String phone = "Phone";
		String email ="Email";
		
		Visitor visitor = new Visitor();
		visitor.setFirstName(expectedFirstName);
		visitor.setLastName(lastName);
		visitor.setPhone(phone);
		visitor.setEmail(email);
		visitor.setBirthDate(LocalDate.now());
		visitorDao.save(visitor);
		Long id = visitor.getId();
		
		visitorDao.delete(visitor);
		Assert.assertNull(visitorDao.find(id));
	}
}
