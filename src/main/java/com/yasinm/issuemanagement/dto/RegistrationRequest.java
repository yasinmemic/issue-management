package com.yasinm.issuemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created By Yasin Memic on Mar, 2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    private String nameSurname;
    private String username;
    private String password;
    private String email;
}
