package by.training.beatysalon.validator;

import by.training.beatysalon.domain.Entity;
import by.training.beatysalon.domain.Feedback;
import by.training.beatysalon.domain.Service;
import by.training.beatysalon.domain.Talon;
import by.training.beatysalon.domain.User;
import by.training.beatysalon.domain.UserInfo;

import java.util.HashMap;
import java.util.Map;

public class ValidatorFactory {

    private static Map<Class<? extends Entity>,
            Class<? extends Validator<?>>> validators = new HashMap<>();

    static {
        validators.put(User.class, UserValidator.class);
//        validators.put(Service.class, ServiceValidator.class);
//        validators.put(Feedback.class, FeedbackValidator.class);
//        validators.put(Talon.class, TalonValidator.class);
    }

    public static <Type extends Entity> Validator<Type> createValidator(Class<Type> entity) {
        try {
            return (Validator<Type>) validators.get(entity).newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            return null;
        }
    }


}
