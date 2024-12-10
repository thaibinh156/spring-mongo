package com.infodation.user.MongoDbOAuth.services.iservices;

import com.infodation.user.MongoDbOAuth.models.User;
import com.infodation.user.MongoDbOAuth.models.modelDTOes.CreateUserDTO;
import com.infodation.user.MongoDbOAuth.models.modelDTOes.UpdateUserDTO;

import java.util.List;

public interface IUserService {
    User create(CreateUserDTO userDTO);
    User update(String username, UpdateUserDTO user);
    User getByUsername(String username);
    void delete(String username);
    List<User> getAllUser();
}
