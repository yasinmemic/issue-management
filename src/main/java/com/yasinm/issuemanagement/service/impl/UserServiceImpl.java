package com.yasinm.issuemanagement.service.impl;

import com.yasinm.issuemanagement.entity.User;
import com.yasinm.issuemanagement.repository.UserRepository;
import com.yasinm.issuemanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        if(user.getUsername() == null){
            throw new IllegalArgumentException("Username can't be null!");
        }
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.getByUsername(username)  ;
    }
}
