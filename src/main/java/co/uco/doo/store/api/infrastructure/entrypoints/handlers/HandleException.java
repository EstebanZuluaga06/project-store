package co.uco.doo.store.api.infrastructure.entrypoints.handlers;

import ch.qos.logback.core.model.processor.ProcessorException;
import co.uco.doo.store.api.domain.exceptions.ProductExceptions;
import co.uco.doo.store.api.infrastructure.entrypoints.dtos.HeaderResponse;
import co.uco.doo.store.api.infrastructure.entrypoints.dtos.ObjectResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class HandleException {
    @ExceptionHandler({ProductExceptions.class})
    public ResponseEntity<ObjectResponse> badRequestException(Exception exception){
        return ResponseEntity.ok().body(
                new ObjectResponse<>(
                        new HeaderResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BANDWIDTH_LIMIT_EXCEEDED.getReasonPhrase()),
                        exception.getMessage()
                )
        );
    }
}
