package io.github.ferdynandariza.websocketchat.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public record UserResponse(
        @JsonInclude(value = JsonInclude.Include.NON_NULL)
        String id,
        String username,
        @JsonInclude(value = JsonInclude.Include.NON_NULL)
        String token
) {
    public UserResponse(String id, String username) {
        this(id, username, null);
    }
}

