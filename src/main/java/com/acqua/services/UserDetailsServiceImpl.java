package com.acqua.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.acqua.repositories.UserRepository;



/**
 * Service for user detail
 * 
 * @author Christian Lusardi
 * @version 1.0
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
   
	@Autowired
	private UserRepository userRepository;

	
	
	/**
	 * Function to retrieve {@link UserDetails} from database
	 */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.acqua.entities.User applicationUser = userRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), new ArrayList<>());
    }
}