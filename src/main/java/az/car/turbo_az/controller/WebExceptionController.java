package az.car.turbo_az.controller;

import az.car.turbo_az.exception.BaseException;
import az.car.turbo_az.exception.CommonMessage;
import az.car.turbo_az.exception.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class WebExceptionController {

    @ExceptionHandler(BaseException.class)
    private ResponseEntity<CommonResponse> handle(BaseException ex, WebRequest request) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setStatus("Error");
        CommonMessage message = new CommonMessage();
        message.setMessage(ex.getMsg());
        message.setCode(ex.getCode());
        message.setDescription(ex.getDescription());
        commonResponse.setErrorMessage(message);
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(commonResponse);
        return ResponseEntity.ok(commonResponse);
    }
}
