package com.infodation.user.MongoDbOAuth.models.modelDTOes;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.infodation.user.MongoDbOAuth.models.Sex;
import com.infodation.user.MongoDbOAuth.models.User;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {
    @Valid

    @NotNull(message = "Name is null")
    private String name;

    @NotNull(message = "Username is null")
    private String username;

    private Sex sex;

    private String password;

    public User toUserEntity() {
        User newEntity = new User();
        newEntity.setCreatedDate(new Date());
        newEntity.setUpdatedDate(new Date());
        newEntity.setUserName(this.username);
        newEntity.setName(this.name);
        if (this.sex == null)
            newEntity.setSex(Sex.MALE);
        else newEntity.setSex(this.sex);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(this.password);
        newEntity.setPassword(encodedPassword);

        return newEntity;
    }
}
