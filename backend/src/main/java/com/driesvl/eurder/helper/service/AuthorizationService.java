package com.driesvl.eurder.helper.service;

import com.driesvl.eurder.exceptions.types.UnauthorizedException;
import com.driesvl.eurder.helper.repository.UserRepository;
import com.driesvl.eurder.helper.repository.domain.Authorization;
import com.driesvl.eurder.helper.repository.domain.Feature;
import com.driesvl.eurder.helper.repository.domain.Role;
import com.driesvl.eurder.helper.repository.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class AuthorizationService {
    private final UserRepository userRepository;
    @Autowired
    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateAuthorization(String encodedAuthorization, Feature feature) {
        Authorization authorization = decodeUserAuthorization(encodedAuthorization);
        User user = getAndVerifyUserExists(authorization.email());
        verifyUserPasswordIsCorrect(user, authorization);
        verifyUserHasAccessToFeature(user.getRole(), feature);
    }

    private User getAndVerifyUserExists(String email) {
        return userRepository.getUser(email)
            .orElseThrow(() -> new UnauthorizedException(this.getClass().getSimpleName(), "User does not exist"));
    }

    private void verifyUserPasswordIsCorrect(User user, Authorization authorization) {
        if (!user.getPassword().equals(authorization.password())) {
            throw new UnauthorizedException(this.getClass().getSimpleName(), "Password is incorrect");
        }
    }

    private void verifyUserHasAccessToFeature(Role role, Feature feature) {
        if (!role.containsFeature(feature)) {
            throw new UnauthorizedException(this.getClass().getSimpleName(), "User does not have access to " + feature.name());
        }
    }

    private Authorization decodeUserAuthorization(String encodedAuthorization) {
        String decodedUserAndPassword = new String(Base64.getDecoder().decode(encodedAuthorization.substring("Basic ".length())));
        String user = decodedUserAndPassword.substring(0, decodedUserAndPassword.indexOf(":"));
        String password = decodedUserAndPassword.substring(decodedUserAndPassword.indexOf(":") + 1);
        return new Authorization(user, password);
    }
}
