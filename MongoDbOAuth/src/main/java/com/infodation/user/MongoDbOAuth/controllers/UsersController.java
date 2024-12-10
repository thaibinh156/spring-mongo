package com.infodation.user.MongoDbOAuth.controllers;

import com.infodation.user.MongoDbOAuth.models.User;
import com.infodation.user.MongoDbOAuth.models.modelDTOes.CreateUserDTO;
import com.infodation.user.MongoDbOAuth.models.modelDTOes.UpdateUserDTO;
import com.infodation.user.MongoDbOAuth.services.iservices.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final IUserService userService;

    public UsersController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAllUser();
    }

    @PostMapping
    public User user(@RequestBody CreateUserDTO userDTO) {
        return userService.create(userDTO);
    }

    @PutMapping("/{username}")
    public User user(@PathVariable("username") String username,@RequestBody UpdateUserDTO userDTO) {
        return userService.update(username, userDTO);
    }
}
