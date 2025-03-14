package io.github.ferdynandariza.websocketchat.repository;

import io.github.ferdynandariza.websocketchat.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserData, String> {
    Optional<UserData> findByUsername(String username);
}
