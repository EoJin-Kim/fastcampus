package com.example.fastcampus.util.response;

import com.example.fastcampus.util.dto.ResponseDto;
import com.example.fastcampus.util.enums.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseUtil{

    public static<T> ResponseEntity<?> getResponse(T responseData, Status status) {
        ResponseDto<T> responseDto = new ResponseDto<>();
        responseDto.setStatus(status);
        responseDto.setData(responseData);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }


}
