package by.training.beatysalon.validator;

import by.training.beatysalon.domain.Entity;
import by.training.beatysalon.exception.IncorrectFormDataException;

import javax.servlet.http.HttpServletRequest;

public interface Validator<Type extends Entity> {

    Type validate(HttpServletRequest request) throws IncorrectFormDataException;
}
