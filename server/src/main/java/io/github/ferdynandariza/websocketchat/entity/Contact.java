package io.github.ferdynandariza.websocketchat.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(optional = false)
    private UserData savedBy;

    @ManyToOne(optional = false)
    private UserData savedUser;

    @Column(nullable = false)
    private String savedName;
}
