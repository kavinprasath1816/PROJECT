package com.oams.portal.service.serviceImplementation;

import com.oams.portal.dao.StaffRepo;
import com.oams.portal.models.StaffModel;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StaffUserService implements UserDetailsService {

    @Autowired
    StaffRepo repo;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        try {
            Optional<StaffModel> staff = repo.loadByEmail(name);
            staff.orElseThrow(() -> new UsernameNotFoundException("User " + name.toUpperCase() + "Not found"));
            StaffModel s = staff.get();
            return new org.springframework.security.core.userdetails.User(
                    s.getStaffName(),
                    s.getPassword(),
                    s.getRole().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        }
        catch(Exception e){
            throw new Exception("Error in fetching User - "+name);
        }

    }
}
