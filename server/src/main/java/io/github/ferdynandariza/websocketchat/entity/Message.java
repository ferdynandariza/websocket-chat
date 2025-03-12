package io.github.ferdynandariza.websocketchat.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(optional = false)
    private Chat chat;

    @Column(nullable = false)
    private String text;

    @ManyToOne(optional = false)
    private UserData sender;

    @Column(nullable = false)
    private LocalDateTime sentAt;

    private LocalDateTime receivedAt;

    private LocalDateTime readAt;

    @ManyToOne
    private Message replyTo;
}
