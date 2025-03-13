package exemplo.API.Dio.demo.service.impl;

import exemplo.API.Dio.demo.model.User;
import exemplo.API.Dio.demo.repository.UserRepository;
import exemplo.API.Dio.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {

    private final UserRepository UserRepository;

    public UserServiceimpl(UserRepository userRepository){
        this.UserRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return UserRepository.findById(id).orElseThrow(NoSuchFieldException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(UserRepository.existsAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account nunber already exists.");
        }
        return UserRepository.save(userToCreate);
    }
}
