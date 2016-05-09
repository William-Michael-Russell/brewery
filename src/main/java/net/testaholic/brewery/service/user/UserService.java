package net.testaholic.brewery.service.user;

import net.testaholic.brewery.domain.User;
import net.testaholic.brewery.domain.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
