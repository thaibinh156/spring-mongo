package com.infodation.user.MongoDbOAuth.services;

import com.infodation.user.MongoDbOAuth.models.User;
import com.infodation.user.MongoDbOAuth.models.modelDTOes.CreateUserDTO;
import com.infodation.user.MongoDbOAuth.models.modelDTOes.UpdateUserDTO;
import com.infodation.user.MongoDbOAuth.repositories.UserRepository;
import com.infodation.user.MongoDbOAuth.services.iservices.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(CreateUserDTO userDTO) {
        User newUser = userDTO.toUserEntity();
        return repository.save(newUser);
    }

    @Override
    public User update(String username, UpdateUserDTO userDTO) {
        User userUpdate = repository.getUserByUsername(username);
        userUpdate = userDTO.toUserEntity(userUpdate);
        return repository.save(userUpdate);
    }

    @Override
    public User getByUsername(String username) {
        return null;
    }

    @Override
    public void delete(String username) {

    }

    @Override
    public List<User> getAllUser() {
        return repository.findAll();
    }
}
