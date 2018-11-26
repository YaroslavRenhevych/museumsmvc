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
import com.yrenh.museumsmvc.dao.PainterDao;
import com.yrenh.museumsmvc.entity.Painter;

import museumsmvc.config.DataSourceConfig;

@ContextConfiguration(classes = { RootContextConfig.class, DataSourceConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class PainterDaoTest {

	@Autowired
	private PainterDao painterDao;
	
	@Test
	@Transactional
	public void addPainterTest() {
		String firstName = "Firstname";
		String lastName = "Lastname";
		String country = "Country";
		
		Painter painter = new Painter();
		painter.setFirstName(firstName);
		painter.setLastName(lastName);
		painter.setCountry(country);
		painter.setBirthDate(LocalDate.now());
		painterDao.save(painter);
		Long id = painter.getId();
		
		Assert.assertEquals(firstName, painterDao.find(id).getFirstName());
	}
	
	@Test(expected = InvalidDataAccessApiUsageException.class)
	@Transactional
	public void addPainterWithIdTest() {
		Long id = 1l;
		String firstName = "Firstname";
		String lastName = "Lastname";
		String country = "Country";
		
		Painter painter = new Painter();
		painter.setId(id);
		painter.setFirstName(firstName);
		painter.setLastName(lastName);
		painter.setCountry(country);
		painter.setBirthDate(LocalDate.now());
		painterDao.save(painter);
	}
	
	@Test
	@Transactional
	public void updateMuseumTest() {
		String oldFirstName = "Oldfirstname";
		String newFirstName = "Newfirstname";
		String lastName = "Lastname";
		String country = "Country";
		
		Painter painter = new Painter();
		painter.setFirstName(oldFirstName);
		painter.setLastName(lastName);
		painter.setCountry(country);
		painter.setBirthDate(LocalDate.now());
		painterDao.save(painter);
		Long id = painter.getId();
		
		painter.setFirstName(newFirstName);
		painterDao.update(painter);
		Assert.assertEquals(newFirstName, painterDao.find(id).getFirstName());
	}
	
	@Test
	@Transactional
	public void deleteMuseum() {
		String firstName = "Firstname";
		String lastName = "Lastname";
		String country = "Country";
		
		Painter painter = new Painter();
		painter.setFirstName(firstName);
		painter.setLastName(lastName);
		painter.setCountry(country);
		painter.setBirthDate(LocalDate.now());
		painterDao.save(painter);
		Long id = painter.getId();
		
		painterDao.delete(painter);
		Assert.assertNull(painterDao.find(id));
	}
}
