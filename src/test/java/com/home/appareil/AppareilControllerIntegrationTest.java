package com.home.appareil;

import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.home.bean.Appareil;
import com.home.controller.AppareilController;
import com.home.service.IAppareilService;
import com.home.service.impl.AppareilService;

@RunWith(SpringRunner.class)
@WebMvcTest(AppareilController.class)
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class})
public class AppareilControllerIntegrationTest {
	
	@TestConfiguration
    static class AppareilControllerIntegrationTestContextConfiguration {
  
		@Bean
		public UserDetailsService userDetailsService(){
			GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
			UserDetails userDetails = (UserDetails)new User("ram", "ram123", Arrays.asList(authority));
			return new InMemoryUserDetailsManager(Arrays.asList(userDetails));
		} 
    }
 
    @Autowired
    private AppareilService appareilService;

	@Autowired
	private MockMvc mvc;

	@MockBean
	private IAppareilService service;
	
	@Test
	@WithMockUser(username = "user", password = "test", roles = "ADMIN")
	public void getAllAppareil() {
		
		Appareil appareil = new Appareil(1, "test", "éteint");
        Appareil appareil2 = new Appareil(2, "test2", "éteint");
        List<Appareil> appareils = new ArrayList<Appareil>();
        appareils.add(appareil);
        appareils.add(appareil2);
        
        given(service.getAppareils()).willReturn(appareils);
        
//        try {
//			mvc.perform(get("/appareil/all")
//				      .contentType(MediaType.APPLICATION_JSON))
//				      .andExpect(status().isOk())
//				      .andExpect(jsonPath("$", hasSize(2)))
//				      .andExpect(jsonPath("$[0].name", is(appareil.getName())));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
