package com.home.appareil;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.home.bean.Appareil;
import com.home.dao.IAppareilDao;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AppareilDaoUnitTest {
	
	@Autowired
	private IAppareilDao appareilDao;
	
	@Test
	public void insertTest() {
		Appareil appareil = new Appareil();
		appareil.setName("test");
		appareil.setStatus("éteint");
		Appareil appareilSave = appareilDao.save(appareil);
		
		Appareil appareilGet = appareilDao.findById(appareilSave.getId()).get();
		
		assertEquals("test", appareilGet.getName());
		
		System.out.println(appareilGet);
	}

}
