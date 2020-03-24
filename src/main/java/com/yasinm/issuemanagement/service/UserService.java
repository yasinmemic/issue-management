package com.yasinm.issuemanagement.service;

import com.yasinm.issuemanagement.dto.UserDto;
import com.yasinm.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    UserDto save(UserDto user);

    UserDto getById(Long id);

    TPage<UserDto> getAllPageable(Pageable pageable);

    UserDto getByUsername(String username);

    List<UserDto> getAll();
}
