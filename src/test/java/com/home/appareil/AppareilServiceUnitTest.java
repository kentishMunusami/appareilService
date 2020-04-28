package com.home.appareil;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.home.bean.Appareil;
import com.home.dao.IAppareilDao;
import com.home.service.impl.AppareilService;

@RunWith(SpringRunner.class)
public class AppareilServiceUnitTest {
	
	@TestConfiguration
    static class AppareilServiceTestContextConfiguration {
  
        @Bean
        public AppareilService employeeService() {
            return new AppareilService();
        }
    }
 
    @Autowired
    private AppareilService appareilService;
 
    @MockBean
    private IAppareilDao appareilDao;
    
    @Before
    public void setUp() {
        Appareil appareil = new Appareil(1, "test", "éteint");
        Appareil appareil2 = new Appareil(2, "test2", "éteint");
        List<Appareil> appareils = new ArrayList<Appareil>();
        appareils.add(appareil);
        appareils.add(appareil2);
     
        Mockito.when(appareilDao.findAll())
          .thenReturn(appareils);
    }
    
    @Test
    public void findAllTest() {
    	List<Appareil> appareils = appareilService.getAppareils();
    	assertEquals(2, appareils.size());
    }

}
