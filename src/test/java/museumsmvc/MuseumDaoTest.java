package museumsmvc;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.PersistentObjectException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yrenh.museumsmvc.config.RootContextConfig;
import com.yrenh.museumsmvc.dao.MuseumDao;
import com.yrenh.museumsmvc.entity.Museum;

import museumsmvc.config.DataSourceConfig;

@ContextConfiguration(classes = { RootContextConfig.class, DataSourceConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class MuseumDaoTest {
	
	@Autowired
	private MuseumDao museumDao;
	
	@Test
	@Transactional
	public void addMuseumTest() {
		String expectedTitle = "museum1";
		String address = "address";
		
		Museum museum = new Museum();
		museum.setTitle(expectedTitle);
		museum.setAddress(address);
		museum.setFoundingDate(LocalDate.now());
		museumDao.save(museum);
		Long id = museum.getId();
		
		Assert.assertEquals(expectedTitle, museumDao.find(id).getTitle());
	}
	
	@Test(expected = InvalidDataAccessApiUsageException.class)
	@Transactional
	public void addMuseumWithIdTest() {
		String expectedTitle = "museum1";
		String address = "address";
		
		Museum museum = new Museum();
		museum.setId(5l);
		museum.setTitle(expectedTitle);
		museum.setAddress(address);
		museum.setFoundingDate(LocalDate.now());
		museumDao.save(museum);
		
		List<Museum> museums = museumDao.getAll();
		Assert.assertEquals(expectedTitle, museums.get(0).getTitle());
	}
	
	@Test
	@Transactional
	public void updateMuseumTest() {
		String oldTitle = "oldTitle";
		String newTitle = "newTitle";
		String address = "address";
		
		Museum museum = new Museum();
		museum.setTitle(oldTitle);
		museum.setAddress(address);
		museum.setFoundingDate(LocalDate.now());
		museumDao.save(museum);
		
		museum.setTitle(newTitle);
		museumDao.update(museum);
		
		Assert.assertEquals(newTitle, museumDao.find(museum.getId()).getTitle());
	}
	
	@Test
	@Transactional
	public void deleteMuseumTest() {
		String title = "Title";
		String address = "Address";
		
		Museum museum = new Museum();
		museum.setTitle(title);
		museum.setAddress(address);
		museum.setFoundingDate(LocalDate.now());
		museumDao.save(museum);
		Long id = museum.getId();
		
		museumDao.delete(museum);
		Assert.assertNull(museumDao.find(id));
	}
}
