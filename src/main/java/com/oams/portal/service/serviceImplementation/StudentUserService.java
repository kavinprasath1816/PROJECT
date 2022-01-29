package com.oams.portal.service.serviceImplementation;

import com.oams.portal.dao.StudentRepo;
import com.oams.portal.exceptions.BasicExceptions;
import com.oams.portal.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentUserService implements UserDetailsService {

    @Autowired
    StudentRepo repo;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        try {
            Optional<Student> student = repo.loadByEmail(name);
            student.orElseThrow(() -> new UsernameNotFoundException("User " + name.toUpperCase() + "Not found"));
            Student s = student.get();
            return new org.springframework.security.core.userdetails.User(
                    s.getName(),
                    s.getPassword(),
                    s.getRole().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        }
        catch(Exception e){
            throw new BasicExceptions("Error in fetching student "+name);
        }
    }
}
