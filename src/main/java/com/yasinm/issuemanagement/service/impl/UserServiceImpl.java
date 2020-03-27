package com.yasinm.issuemanagement.service.impl;

import com.yasinm.issuemanagement.dto.RegistrationRequest;
import com.yasinm.issuemanagement.dto.UserDto;
import com.yasinm.issuemanagement.entity.User;
import com.yasinm.issuemanagement.repository.UserRepository;
import com.yasinm.issuemanagement.service.UserService;
import com.yasinm.issuemanagement.util.TPage;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper,BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.encoder = encoder;
    }

    @Override
    public UserDto save(UserDto user) {
        User u = modelMapper.map(user, User.class);
        u = userRepository.save(u);
        user.setId(u.getId());
        return user;
    }

    @Override
    public UserDto getById(Long id) {
        User u = userRepository.getOne(id);
        return modelMapper.map(u, UserDto.class);
    }

    @Override
    public TPage<UserDto> getAllPageable(Pageable pageable) {
        Page<User> data = userRepository.findAll(pageable);
        TPage<UserDto> respnose = new TPage<UserDto>();
        respnose.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), UserDto[].class)));
        return respnose;
    }

    public List<UserDto> getAll() {
        List<User> data = userRepository.findAll();
        return Arrays.asList(modelMapper.map(data, UserDto[].class));
    }


    @Override
    public UserDto getByUsername(String username) {
        User u = userRepository.findByUsername(username);
        return modelMapper.map(u, UserDto.class);
    }

    @Transactional
    public Boolean register(RegistrationRequest registrationRequest) {
        try{
            User user = new User();
            user.setUsername(registrationRequest.getUsername());
            user.setNameSurname(registrationRequest.getNameSurname());
            user.setPassword(encoder.encode(registrationRequest.getPassword()));
            user.setEmail(registrationRequest.getEmail());
            userRepository.save(user);
            return Boolean.TRUE;
        }catch (Exception e){
            log.error("Registration => ", e);
            return Boolean.FALSE;
        }
    }
}
