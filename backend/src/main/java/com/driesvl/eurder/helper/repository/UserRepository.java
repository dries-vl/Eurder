package com.driesvl.eurder.helper.repository;

import com.driesvl.eurder.exceptions.types.CustomerAlreadyExistsException;
import com.driesvl.eurder.exceptions.types.InvalidUserIdException;
import com.driesvl.eurder.exceptions.types.UserAlreadyExistsException;
import com.driesvl.eurder.helper.repository.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {
    private final UserDB userDB;

    @Autowired
    public UserRepository(UserDB userDB) {
        this.userDB = userDB;
    }

    public void addUser(User user) {
        throwIfIdAlreadyTaken(user.getId());
        throwIfUserAlreadyExists(user.getEmail());
        getUserDB().put(user.getId(), user);
    }

    public Optional<User> getUser(String email) {
        return getUserDB().values()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    public User getUserById(UUID uuid) {
        throwIfUserNotFound(uuid);
        return getUserDB().get(uuid);
    }

    public List<User> getAllUsers() {
        return getUserDB().values().stream().toList();
    }

    private Map<UUID, User> getUserDB() {
        return this.userDB.getUserDB();
    }

    private void throwIfUserNotFound(UUID uuid) {
        if (!getUserDB().containsKey(uuid)) {
            throw new InvalidUserIdException(this.getClass().getSimpleName(), "User not found");
        }
    }
    private void throwIfIdAlreadyTaken(UUID uuid) {
        if (getUserDB().containsKey(uuid)) {
            throw new CustomerAlreadyExistsException(this.getClass().getSimpleName(), "Id already exists");
        }
    }

    private void throwIfUserAlreadyExists(String email) {
        if (emailExists(email)) {
            throw new UserAlreadyExistsException(this.getClass().getSimpleName(), "User with this email already exists");
        }
    }

    private boolean emailExists(String email) {
        return getUserDB().values()
                .stream()
                .map(User::getEmail)
                .anyMatch(m -> m.equals(email));
    }
}
