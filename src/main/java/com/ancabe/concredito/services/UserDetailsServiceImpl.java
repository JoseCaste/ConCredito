package com.ancabe.concredito.services;

import com.ancabe.concredito.models.Authority;
import com.ancabe.concredito.models.Promotor;
import com.ancabe.concredito.models.User;
import com.ancabe.concredito.models.UserCustomized;
import com.ancabe.concredito.repositories.PromotorRepository;
import com.ancabe.concredito.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user_ =userRepository.findByusername(username);
        if(user_ !=null) {
            /*List<GrantedAuthority> grantList = new ArrayList<>();
            for (Authority authority: user_.getAuthority()) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
                grantList.add(grantedAuthority);
            }*/
            List<GrantedAuthority> new_=user_.getAuthority().stream().map(item->{
               return new SimpleGrantedAuthority(item.getAuthority());
            }).collect(Collectors.toCollection(ArrayList::new));
            Collection<? extends GrantedAuthority> type =new_;
            //UserDetails user = (UserDetails) new User(user_.getUsername(), user_.getPassword(), grantList);
            //return user;
            return new UserCustomized(user_.getUsername(),user_.getPassword(),"Jose", true,
                    true,
                    true,
                    false
                    , type);
        }else{
            throw new UsernameNotFoundException("Credenciales no válidas");
        }
    }
    }
