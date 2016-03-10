package org.registrator.community.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.testng.annotations.Test;

public class LimitLoginAuthenticationProviderTest {

	@Test
	public void f() {
		DaoAuthenticationProvider serv = new DaoAuthenticationProvider();

		Authentication auth = new UsernamePasswordAuthenticationToken(
				"userLogin", "password", new ArrayList<GrantedAuthority>());

		UserDetailsService uds = new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username)
					throws UsernameNotFoundException {
				System.out.println("loading user by username: "+username);
				if (username.equals("userLogin")) {
					return new UserDetails() {

						@Override
						public Collection<? extends GrantedAuthority> getAuthorities() {
							// TODO Auto-generated method stub
							List<GrantedAuthority> list = new LinkedList<GrantedAuthority>();
							list.add(new SimpleGrantedAuthority("ROLE_1"));
							return list;
						}

						@Override
						public String getPassword() {
							return "password";
						}

						@Override
						public String getUsername() {
							return "userLoginApproved";
						}

						@Override
						public boolean isAccountNonExpired() {
							// TODO Auto-generated method stub
							return true;
						}

						@Override
						public boolean isAccountNonLocked() {
							// TODO Auto-generated method stub
							return true;
						}

						@Override
						public boolean isCredentialsNonExpired() {
							// TODO Auto-generated method stub
							return true;
						}

						@Override
						public boolean isEnabled() {
							// TODO Auto-generated method stub
							return true;
						}

					};
				}
				return null;
			}

		};
		serv.setUserDetailsService(uds);
		serv.authenticate(auth);
	}
}
