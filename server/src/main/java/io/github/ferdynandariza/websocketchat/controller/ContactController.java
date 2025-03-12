package io.github.ferdynandariza.websocketchat.controller;

import io.github.ferdynandariza.websocketchat.entity.Contact;
import io.github.ferdynandariza.websocketchat.entity.UserData;
import io.github.ferdynandariza.websocketchat.model.ContactRequest;
import io.github.ferdynandariza.websocketchat.services.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping(path = "/contacts")
    public ResponseEntity<Object> addContact(UserData userData, @RequestBody ContactRequest contact) {
        contactService.save(userData, contact);
        return ResponseEntity.noContent().build();
    }
}
