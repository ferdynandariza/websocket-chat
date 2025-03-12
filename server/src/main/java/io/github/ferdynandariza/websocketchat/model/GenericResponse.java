package io.github.ferdynandariza.websocketchat.model;

import lombok.Data;

@Data
public class GenericResponse<T> {
    private String message;
    private T data;
}
