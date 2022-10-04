package com.example.enumtest.service.impl;

import com.example.enumtest.model.business.User;
import com.example.enumtest.model.entity.UserEntity;
import com.example.enumtest.model.enums.Status;
import com.example.enumtest.repository.UserRepository;
import com.example.enumtest.service.UserService;
import com.example.enumtest.util.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    /**
     * Saves a user in db
     *
     * @param toSaveUser to be saved
     * @return User
     */
    @Override
    public User save(User toSaveUser) {
        var entity = userMapper.serviceToRepo(toSaveUser);
        entity.setStatus(Status.getValid());
        var savedEntity = userRepository.save(entity);
        return userMapper.repoToService(savedEntity);
    }

    /**
     * Retrieving all UserEntities from db
     *
     * @return List<User>
     */
    @Override
    public List<User> findAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream().map(userMapper::repoToService).collect(Collectors.toList());
    }

    @Override
    public User deleteById(Integer id) {
        UserEntity userEntity = findByIdEntity(id);
        userEntity.setStatus(Status.getDeleted());
        UserEntity savedEntity = userRepository.save(userEntity);
        return userMapper.repoToService(savedEntity);
    }

    @Override
    public UserEntity findByIdEntity(Integer id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isEmpty())
            throw new NullPointerException("User with id " + id);
        return userEntity.get();
    }

    @Override
    public User findById(Integer id) {
        UserEntity userEntity = findByIdEntity(id);
        return userMapper.repoToService(userEntity);
    }
}
