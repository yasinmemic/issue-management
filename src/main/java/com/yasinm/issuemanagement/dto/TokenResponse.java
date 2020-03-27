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
public class TokenResponse {

    private String username;
    private String token;
}
