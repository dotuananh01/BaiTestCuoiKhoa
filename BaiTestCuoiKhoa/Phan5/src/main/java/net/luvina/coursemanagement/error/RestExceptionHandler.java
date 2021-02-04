package net.luvina.coursemanagement.error;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class RestExceptionHandler {
    @ExceptionHandler({ServiceRuntimeException.class})
    public ResponseEntity<ApiError> handleServiceRuntimeException(ServiceRuntimeException ex) {
        ApiError apiError = new ApiError(ex.getErrorCode(), ex.getMessage());
        return new ResponseEntity<>(apiError, ex.getHttpStatus());
    }
}
