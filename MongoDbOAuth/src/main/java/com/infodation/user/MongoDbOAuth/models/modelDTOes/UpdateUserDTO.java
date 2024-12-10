package com.infodation.user.MongoDbOAuth.models.modelDTOes;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.infodation.user.MongoDbOAuth.models.Sex;
import com.infodation.user.MongoDbOAuth.models.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDTO {
    @Valid

    @NotNull(message = "Name is null")
    @JsonAlias("name")
    private String name;

    @JsonAlias("sex")
    private Sex sex;

    @JsonAlias("password")
    private String password;

    public User toUserEntity(User user) {
        user.setUpdatedDate(new Date());

        if (this.sex == null)
            user.setSex(Sex.MALE);
        else user.setSex(this.sex);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(this.password);
        user.setPassword(encodedPassword);

        return user;
    }
}
