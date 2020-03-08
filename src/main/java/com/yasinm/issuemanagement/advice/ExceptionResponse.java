package com.yasinm.issuemanagement.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created By Yasin Memic on Mar, 2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

    private Date date;
    private String message;
}
