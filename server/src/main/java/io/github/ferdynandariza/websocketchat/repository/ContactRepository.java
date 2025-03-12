package io.github.ferdynandariza.websocketchat.repository;

import io.github.ferdynandariza.websocketchat.entity.Contact;
import io.github.ferdynandariza.websocketchat.entity.UserData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {

    Page<Contact> findBySavedBy(UserData savedBy, Pageable pageable);
}
