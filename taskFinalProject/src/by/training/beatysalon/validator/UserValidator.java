package by.training.beatysalon.validator;

import by.training.beatysalon.domain.Role;
import by.training.beatysalon.domain.User;
import by.training.beatysalon.exception.IncorrectFormDataException;

import javax.servlet.http.HttpServletRequest;

public class UserValidator implements Validator<User> {


    @Override
    public User validate(HttpServletRequest request) throws IncorrectFormDataException {
        User user = new User();

        String parameter = request.getParameter("id");
        if (parameter != null) {
            try {
                user.setId(Integer.parseInt(parameter));
            } catch (NumberFormatException e) {
                throw new IncorrectFormDataException("id,", parameter);
            }
            parameter = request.getParameter("login");
            if (parameter != null && !parameter.isEmpty()) {
                user.setLogin(parameter);
            } else {
                throw new IncorrectFormDataException("login", parameter);
            }
            parameter = request.getParameter("role");
            try {
                if (parameter != null && !parameter.isEmpty()) {
                    user.setRole(Role.getById(Integer.parseInt(parameter)));
                }
            } catch (NumberFormatException e) {
                throw new IncorrectFormDataException("role", parameter);
            }
        }
        return user;
    }
}
