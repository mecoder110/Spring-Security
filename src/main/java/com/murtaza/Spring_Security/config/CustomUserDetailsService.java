
package com.murtaza.Spring_Security.config;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.murtaza.Spring_Security.entity.UserEntity;
import com.murtaza.Spring_Security.repository.UserRepository;

@Configuration
@EnableWebSecurity
class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserEntity user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("" + "User not found"));

		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true,
				List.of(new SimpleGrantedAuthority("ROLE_USER")));
	}

}
