package net.testaholic.brewery.service.user;

import net.testaholic.brewery.domain.user.Users;
import net.testaholic.brewery.domain.user.UserCreateForm;
import net.testaholic.brewery.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Users> getUserById(long id) {
        LOGGER.debug("Getting user={}", id);
        return Optional.ofNullable(userRepository.findOne(id));
    }

    @Override
    public Optional<Users> getUserByEmail(String email) {
        LOGGER.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));
        return userRepository.findOneByEmail(email);
    }

    @Override
    public Collection<Users> getAllUsers() {
        LOGGER.debug("Getting all users");
        return userRepository.findAll(new Sort("email"));
    }

    @Override
    public Users update(UserCreateForm form, long id){
        Users users = parseUser(form);
        users.setId(id);
        return userRepository.save(users);
    }


    @Override
    public Users create(UserCreateForm form) {
        return userRepository.save(parseUser(form));
    }

    private Users parseUser(UserCreateForm form){
        Users users = new Users();
        users.setEmail(form.getEmail());
        users.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        users.setRole(form.getRole());
        return users;
    }

}
