package hutt.core.validators.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import hutt.core.dto.responses.AbstractResponse.Error;
import hutt.core.validators.Validator;
import lombok.Getter;

public abstract class AbstractValidator implements Validator {

  @Autowired
  protected MessageSource msg;

  @Getter
  private List<Error> errors = new ArrayList<>();

  protected void addError(Error e) {
    errors.add(e);
  }

  protected void addError(String[] fields, String errorCode, String message) {
    addError(newError(fields, errorCode, message));
  }

  protected void addError(String[] fields, String errorCode, String messageKey, String[] args) {
    addError(newError(fields, errorCode, messageKey, args));
  }

  protected Error newError(String[] fields, String errorCode, String messageKey, String[] args) {
    return newError(fields, errorCode, getMessage(messageKey, args));
  }

  protected Error newError(String[] fields, String errorCode, String message) {
    Error e = new Error();
    e.setErrorCode(errorCode);
    e.setMessage(message);
    e.setFields(Stream.of(fields).collect(Collectors.toList()));
    return e;
  }

  public boolean hasError() {
    return !errors.isEmpty();
  }

  protected String getMessage(String messageKey, Object[] args) {
    return msg.getMessage(messageKey, args, null);
  }
}
