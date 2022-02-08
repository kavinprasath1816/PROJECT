package com.oams.portal.service.serviceImplementation;

import com.oams.portal.dao.StudentJpaRepo;
import com.oams.portal.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
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
    StudentJpaRepo repo;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Optional<Student> student = repo.loadByEmail(name);
        student.orElseThrow(() -> new UsernameNotFoundException("User " + name.toUpperCase() + "Not found"));
        Student s = student.get();
        return new org.springframework.security.core.userdetails.User(
                s.getEmail(),
                s.getPassword(),
                s.getRole().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));

    }
}
