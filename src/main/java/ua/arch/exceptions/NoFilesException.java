package ua.arch.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.BAD_REQUEST)
@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class NoFilesException extends RuntimeException {}