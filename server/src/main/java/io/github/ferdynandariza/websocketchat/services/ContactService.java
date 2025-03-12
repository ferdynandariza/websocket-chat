package io.github.ferdynandariza.websocketchat.services;

import io.github.ferdynandariza.websocketchat.entity.Contact;
import io.github.ferdynandariza.websocketchat.entity.UserData;
import io.github.ferdynandariza.websocketchat.model.ContactRequest;
import io.github.ferdynandariza.websocketchat.repository.ContactRepository;
import io.github.ferdynandariza.websocketchat.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final UserRepository userRepository;

    public ContactService(ContactRepository contactRepository, UserRepository userRepository) {
        this.contactRepository = contactRepository;
        this.userRepository = userRepository;
    }

    public void save(UserData savedBy, ContactRequest request) {
        UserData savedUser = userRepository.findByUsername(request.username()).orElseThrow(
                () -> new UsernameNotFoundException("Username not found")
        );
        Contact contact = new Contact();
        contact.setSavedBy(savedBy);
        contact.setSavedUser(savedUser);
        contact.setSavedName(request.contactName());
        contactRepository.save(contact);
    }
}
