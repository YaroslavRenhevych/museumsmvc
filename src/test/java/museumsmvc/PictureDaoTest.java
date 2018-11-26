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
import com.yrenh.museumsmvc.dao.PictureDao;
import com.yrenh.museumsmvc.entity.Picture;


import museumsmvc.config.DataSourceConfig;

@ContextConfiguration(classes = { RootContextConfig.class, DataSourceConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class PictureDaoTest {
	
	@Autowired
	private PictureDao pictureDao;
	
	@Test
	@Transactional
	public void savePictureTest() {
		String expectedTitle = "Title";
		
		Picture picture = new Picture();
		picture.setTitle(expectedTitle);
		picture.setCreationDate(LocalDate.now());
		pictureDao.save(picture);
		Long id = picture.getId();
		
		Assert.assertEquals(expectedTitle, pictureDao.find(id).getTitle());
	}
	
	@Test(expected = InvalidDataAccessApiUsageException.class)
	@Transactional
	public void savePictureWithIdTest() {
		String title = "Title";
		Long id = 1l;
		
		Picture picture = new Picture();
		picture.setId(id);
		picture.setTitle(title);
		picture.setCreationDate(LocalDate.now());
		pictureDao.save(picture);
	}
	
	@Test
	@Transactional
	public void updatePictureTest() {
		String oldTitle = "Olditle";
		String newTitle = "Newtitle";
		
		Picture picture = new Picture();
		picture.setTitle(oldTitle);
		picture.setCreationDate(LocalDate.now());
		pictureDao.save(picture);
		Long id = picture.getId();
		
		picture.setTitle(newTitle);
		pictureDao.update(picture);
		Assert.assertEquals(newTitle, pictureDao.find(id).getTitle());
	}
	
	@Test
	@Transactional
	public void deletePictureTest() {
		String expectedTitle = "Title";
		
		Picture picture = new Picture();
		picture.setTitle(expectedTitle);
		picture.setCreationDate(LocalDate.now());
		pictureDao.save(picture);
		Long id = picture.getId();
		
		pictureDao.delete(picture);
		Assert.assertNull(pictureDao.find(id));
	}
}
