package io.github.ferdynandariza.websocketchat.resolver;

import io.github.ferdynandariza.websocketchat.entity.UserData;
import io.github.ferdynandariza.websocketchat.services.JwtService;
import io.github.ferdynandariza.websocketchat.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class UserResolver implements HandlerMethodArgumentResolver {

    private final JwtService jwtService;
    private final UserService userService;

    public UserResolver(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return UserData.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authHeader == null) {
            return null;
        }

        String token = authHeader.substring("Bearer ".length());
        String username = jwtService.getUsernameFromToken(token);
        return userService.getUserByUsername(username);
    }
}
