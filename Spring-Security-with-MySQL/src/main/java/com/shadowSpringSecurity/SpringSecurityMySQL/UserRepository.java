package com.shadowSpringSecurity.SpringSecurityMySQL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}


// Spring security will do the authentication for us.