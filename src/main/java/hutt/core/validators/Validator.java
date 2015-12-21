package hutt.core.validators;

import java.util.List;

import hutt.core.dto.responses.AbstractResponse.Error;

public interface Validator {

  public boolean hasError();

  public List<Error> getErrors();

  public void validate();
}
