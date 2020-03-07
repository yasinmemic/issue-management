package com.yasinm.issuemanagement.service.impl;

import com.yasinm.issuemanagement.dto.UserDto;
import com.yasinm.issuemanagement.entity.User;
import com.yasinm.issuemanagement.repository.UserRepository;
import com.yasinm.issuemanagement.service.UserService;
import com.yasinm.issuemanagement.util.TPage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto save(UserDto user) {
      User userEntity = modelMapper.map(user,User.class);
      userEntity = userRepository.save(userEntity);
      user.setId(userEntity.getId());
      return user;
    }

    @Override
    public UserDto getById(Long id) {
        return modelMapper.map(userRepository.findById(id),UserDto.class);
    }

    @Override
    public TPage<UserDto> getAllPageable(Pageable pageable) {
        Page<User> userList = userRepository.findAll(pageable);
        UserDto[] users = modelMapper.map(userList.getContent(), UserDto[].class);
        TPage<UserDto> userDtoTPage = new TPage<>();
        userDtoTPage.setStat(userList, Arrays.asList(users));
        return userDtoTPage;
    }

    @Override
    public UserDto getByUsername(String username) {
        return modelMapper.map(userRepository.getByUsername(username), UserDto.class);
    }
}
