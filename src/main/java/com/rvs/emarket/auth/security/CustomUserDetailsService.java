package com.rvs.emarket.auth.security;

import com.rvs.emarket.auth.model.User;
import com.rvs.emarket.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar por username
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Usuario no encontrado con username: " + username));

        // Agregar todos los permisos para pruebas
        /*-----------
        if ("admin".equals(username)) {
            user.getPermissions().add(new Permission(1L, "PRODUCT_READ", ""));
            user.getPermissions().add(new Permission(2L, "PRODUCT_CREATE", ""));
            user.getPermissions().add(new Permission(3L, "PRODUCT_UPDATE", ""));
            user.getPermissions().add(new Permission(4L, "PRODUCT_DELETE", ""));
        }

        System.out.println("Permisos de admin: " + user.getPermissions());
        System.out.println("Roles de admin: " + user.getRoles());
        -----*/

        return new CustomUserDetails(user);
    }
}
