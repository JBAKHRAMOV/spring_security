package com.comapny.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.comapny.security.UserRole.*;

@Repository("fake")
@RequiredArgsConstructor
public class FakeApplicationUserDAOService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    public Optional<ApplicationUser> findByName(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        return Arrays.asList(
                new ApplicationUser(
                        passwordEncoder.encode("passwd"),
                        "anna",
                        STUDENT.getGrantedAuthority(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        passwordEncoder.encode("passwd"),
                        "linda",
                        ADMIN.getGrantedAuthority(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        passwordEncoder.encode("passwd"),
                        "tom",
                        ADMINISTRATE.getGrantedAuthority(),
                        true,
                        true,
                        true,
                        true
                )
        );
    }
}
