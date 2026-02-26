package fi.haagahelia.bookstore.service;

import fi.haagahelia.bookstore.storage.AppUser;
import fi.haagahelia.bookstore.storage.AppUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    AppUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser curruser = repository.findByUsername(username);

        if (curruser == null) {
            throw new UsernameNotFoundException("User or password not found");
        }

        UserDetails user = new org.springframework.security.core.userdetails.User(
            username, 
            curruser.getPassword(), 
            AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }

}
