package com.github.yizzuide.milkomeda.crust;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * CrustUserDetails
 * 用户验证的源数据
 *
 * @author yizzuide
 * @since 1.14.0
 * Create at 2019/11/11 17:23
 */
@Data
public class CrustUserDetails implements UserDetails {
    private static final long serialVersionUID = 2749178892063846690L;

    private String uid;
    private String username;
    private String password;
    private String salt;
    private Collection<? extends GrantedAuthority> authorities;

    CrustUserDetails(String uid, String username, String password, String salt, Collection<? extends GrantedAuthority> authorities) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.authorities = authorities;
    }

    CrustUserDetails(String uid, String username, Collection<? extends GrantedAuthority> authorities) {
        this.uid = uid;
        this.username = username;
        this.authorities = authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}