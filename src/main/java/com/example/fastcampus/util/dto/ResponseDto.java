package com.example.fastcampus.util.dto;

import com.example.fastcampus.util.enums.Status;
import lombok.Data;

@Data
public class ResponseDto<T> {
    Status status;
    T data;
}
