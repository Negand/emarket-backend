/*----------------------------------

package com.rvs.emarket.security;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository_bk extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);  // <--- esto funciona si 'username' existe
    boolean existsByEmail(String email);        // <--- si usas email

}




 */