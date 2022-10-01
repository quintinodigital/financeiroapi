package digital.quintino.financeiroapi.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import digital.quintino.financeiroapi.dto.ErrorMensageResponseDTO;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.CONFLICT)
	public ResponseEntity<ErrorMensageResponseDTO> constraintViolationException(ConstraintViolationException constraintViolationException) {
		ErrorMensageResponseDTO errorMensageResponseDTO = new ErrorMensageResponseDTO();
			errorMensageResponseDTO.setMessage(constraintViolationException.getMessage());
			errorMensageResponseDTO.setStatusCode(String.valueOf(HttpStatus.CONFLICT));
		return new ResponseEntity<>(errorMensageResponseDTO, HttpStatus.CONFLICT);
	}
	
}
