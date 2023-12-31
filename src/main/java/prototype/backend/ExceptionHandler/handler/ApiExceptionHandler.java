package prototype.backend.ExceptionHandler.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import prototype.backend.ExceptionHandler.exception.ApiRequestException;
import prototype.backend.ExceptionHandler.exception.DataBaseException;
import prototype.backend.ExceptionHandler.exception.NotFoundException;
import prototype.backend.ExceptionHandler.exception.UniqueEntityException;
import prototype.backend.dto.response.ResponseDTO;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiRequestException.class)
    public ResponseEntity<ResponseDTO> handleApiRequestException(ApiRequestException e){
        return new ResponseEntity<>(initExceptionResponse(e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UniqueEntityException.class)
    public ResponseEntity<ResponseDTO> handleUniqueEntityException(UniqueEntityException e){
        return new ResponseEntity<>(initExceptionResponse(e), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ResponseDTO> handleNotFoundException(NotFoundException e){
        return new ResponseEntity<>(initExceptionResponse(e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<ResponseDTO> handleDataBaseException(DataBaseException e){
        return new ResponseEntity<>(initExceptionResponse(e), HttpStatus.BAD_REQUEST);
    }

    public ResponseDTO initExceptionResponse(RuntimeException e){
        return new ResponseDTO(e);
    }
}
