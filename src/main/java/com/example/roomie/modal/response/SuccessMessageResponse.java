package com.example.roomie.modal.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SuccessMessageResponse {

    private String status = HttpStatus.OK.toString();
    private String message;
    private String path;

    public SuccessMessageResponse(String message, String path){
        this.message = message;
        this.path = path;

    }

}
