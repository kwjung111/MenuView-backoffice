package backoffice.backoffice.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsVO implements UserDetails {
    //스시에서 인증/인가 작업에 사용되는 클래스
    //모든 필드에 대해 getter,setter 작성

    private String username;
    private String password;
    private String name;

    private List<GrantedAuthority> authorities;

    //getter
    @Override
    public String getUsername() {
        return username;
    }

    
    @Override
    public String getPassword() {
        return password;
    }

    public String getName(){
        return name;
    }

    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    //setter
    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setAuthorities(List<String> authList) {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (int i = 0; i < authList.size(); i++) {
            authorities.add(new SimpleGrantedAuthority(authList.get(i)));
        }

        this.authorities = authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true ;
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
