package com.cognizant.authorizationmicroservice.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cognizant.authorizationmicroservice.model.UserDao;

@DataJpaTest
public class UserRepositoryTest {
	
	@MockBean
	private UserRepository repo;
	
	@Test
	void testUserRepositoryFindByname()
	{
		UserDao user = new UserDao(1, "admin" ,"password");
		when(repo.findByUsername("admin")).thenReturn(user);
		assertThat(repo.findByUsername("admin")).isEqualTo((user));
				
	}

}
