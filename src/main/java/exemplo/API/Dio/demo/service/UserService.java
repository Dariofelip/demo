package exemplo.API.Dio.demo.service;

import exemplo.API.Dio.demo.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);

}
