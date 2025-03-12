package io.github.ferdynandariza.websocketchat.model;

public record ChatMessage(
        String chat,
        Long timestamp,
        String senderId
) { }
