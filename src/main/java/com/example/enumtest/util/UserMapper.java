package com.example.enumtest.util;

import com.example.enumtest.model.business.User;
import com.example.enumtest.model.dto.UserDto;
import com.example.enumtest.model.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    /**
     * Controller layer to business layer
     *
     * @param userDto
     * @return User
     */
    User controllerToService(UserDto userDto);

    /**
     * Business layer to controller layer
     *
     * @param user
     * @return UserDto
     */
    UserDto serviceToController(User user);

    /**
     * Business layer to db layer
     *
     * @param user
     * @return UserEntity
     */
    UserEntity serviceToRepo(User user);

    /**
     * Db layer to business layer
     *
     * @param user
     * @return User
     */
    User repoToService(UserEntity user);
}
