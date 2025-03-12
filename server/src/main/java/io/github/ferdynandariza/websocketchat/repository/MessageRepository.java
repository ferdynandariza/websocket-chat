package io.github.ferdynandariza.websocketchat.repository;

import io.github.ferdynandariza.websocketchat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, String> {
}
