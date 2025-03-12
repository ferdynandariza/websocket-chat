package io.github.ferdynandariza.websocketchat.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table
@Data
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private ChatType chatType;

    @OneToOne
    private Message lastMessage;

    @UpdateTimestamp
    private Timestamp updatedAt;
}
