package io.github.ferdynandariza.websocketchat.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table
@Data
public class ChatParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne(optional = false)
    private Chat chat;
    @ManyToOne(optional = false)
    private UserData user;
    @Column(nullable = false)
    private Boolean isAdmin;
    private LocalDateTime joinedAt;
}
