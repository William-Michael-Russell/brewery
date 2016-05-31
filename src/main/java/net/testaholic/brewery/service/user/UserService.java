package net.testaholic.brewery.service.user;

import net.testaholic.brewery.domain.user.User;
import net.testaholic.brewery.domain.user.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

    User update(UserCreateForm form, long id);

}
