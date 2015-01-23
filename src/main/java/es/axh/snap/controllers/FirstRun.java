package es.axh.snap.controllers;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.Sets;

import es.axh.snap.domain.security.Authority;
import es.axh.snap.domain.security.User;
import es.axh.snap.repository.AuthorityRepository;
import es.axh.snap.repository.UserRepository;


@RestController
@RequestMapping("/foo")
public class FirstRun {
	
	private final Logger log = LoggerFactory.getLogger(FirstRun.class);
	
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/first-time-run", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public String firtTimeRun() {
        log.debug("First Time Run");
        if(authorityRepository.findOne("ROLE_USER") == null) {
	        Authority role1 = new Authority();
	        role1.setName("ROLE_SYSTEM");
	        Authority role2 = new Authority();
	        role2.setName("ROLE_ADMIN");
	        Authority role3 = new Authority();
	        role3.setName("ROLE_USER");
	        authorityRepository.save(role1);
	        authorityRepository.save(role2);
	        authorityRepository.save(role3);
	        
	        User systemUser = createUserInformation("system", "system", "Alfredo", "Arellano", "highfredo@gmail.com", "es");
	        systemUser.setAuthorities(Sets.newHashSet(role1, role2, role3));
	        systemUser.setId("user-0");
	        systemUser.setCreatedBy("system");
	        
	        User adminUser = createUserInformation("admin", "admin", "Alfredo", "Arellano", "highfredo+admin@gmail.com", "es");
	        adminUser.setAuthorities(Sets.newHashSet(role2, role3));
	        adminUser.setId("user-1");
	        adminUser.setCreatedBy("system");
	        
	        User userUser = createUserInformation("user", "user", "Alfredo", "Arellano", "highfredo+user@gmail.com", "es");
	        userUser.setId("user-2");
	        userUser.setCreatedBy("system");
	        
	        userRepository.save(systemUser);
	        userRepository.save(adminUser);
	        userRepository.save(userUser);
	                
	        return "OK";
        } else {
        	return "Limpie antes la base de datos";
        }
    }
    
    
    private User createUserInformation(String login, String password, String firstName, String lastName, String email, String langKey) {
		User newUser = new User();
		Set<Authority> authorities = new HashSet<>();
		Authority authority = authorityRepository.findOne("ROLE_USER");
		authorities.add(authority);
		String encryptedPassword = passwordEncoder.encode(password);
		
		newUser.setLogin(login);
		newUser.setPassword(encryptedPassword);
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setEmail(email);
		newUser.setLangKey(langKey);
		newUser.setActivated(true);
		newUser.setAuthorities(authorities);
		newUser.setCreatedDate(new DateTime());

		return newUser;
    }
    
}
