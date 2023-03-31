package com.driesvl.eurder.authorization.repository;

import com.driesvl.eurder.authorization.repository.domain.Role;
import com.driesvl.eurder.authorization.repository.domain.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class UserDB {
    private static final User ADMIN_1 = new User("admin@mail.com", "pwd", Role.ADMIN);
    private static final UUID ADMIN_1_ID = ADMIN_1.getId();
    private final HashMap<UUID, User> users = new HashMap<>(Map.of(
            ADMIN_1_ID, ADMIN_1
    ));

    public Map<UUID, User> getUserDB() {
        return users;
    }
}
