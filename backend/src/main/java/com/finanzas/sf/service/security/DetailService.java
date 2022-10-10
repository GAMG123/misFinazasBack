package com.finanzas.sf.service.security;

import com.finanzas.sf.dto.UserPrincipalDTO;
import com.finanzas.sf.errorhandler.GenericClientException;
import com.finanzas.sf.util.Util;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailService implements UserDetailsService{
    final Util util;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(Boolean.TRUE.equals(this.util.validateUser(username))) {
                      List<GrantedAuthority> authorities = null;
            return new UserPrincipalDTO(username, username, "", "seda",
                    true, authorities, null);
        }else {
            throw new GenericClientException("Error document DNI", HttpStatus.BAD_REQUEST);
        }
    }



}
