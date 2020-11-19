package pl.sda.bootcamp.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class AppSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {

        String redirect = null;

        List<String> authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        for (String authority: authorities){
            if(authority.equals("ROLE_ADMIN")){
                redirect="/admin-dashboard";
            }else if (authority.equals("ROLE_TRAINER")){
                redirect="/trainer-dashboard";
            }else{
                redirect="/user-dashboard";
            }
        }

        if(redirect==null){
            throw new IllegalStateException();
        } else{
            new DefaultRedirectStrategy().sendRedirect(httpServletRequest,httpServletResponse, redirect);
        }


    }
}
