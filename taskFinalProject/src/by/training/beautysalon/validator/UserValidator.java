package by.training.beautysalon.validator;

import by.training.beautysalon.entity.enumeration.Gender;
import by.training.beautysalon.utill.ImageUtill;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Base64;
import java.util.regex.Pattern;

public class UserValidator {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String REGEX_LOGIN = "^[a-zA-Z0-9_-]{3,16}$";
    private static final String REGEX_PASSWORD = "^[a-zA-Z0-9_-]{6,18}$";

    public static boolean checkLogin(String login) {
        return login != null && Pattern.matches(REGEX_LOGIN, login);
    }

    public static boolean checkPassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }


    public static String getPhone(String phone) {
            return phone.replaceAll("\\+375\\(", "")
                    .replaceAll("\\)", "")
                    .replaceAll("-","");
    }

    public static String getAvatar(Part filePart, Gender gender) throws IOException, SQLException {
        InputStream stream = filePart.getInputStream();
        byte[] imageBytes = stream.readAllBytes();
        String avatar = Base64.getEncoder().encodeToString(imageBytes);
        if (avatar.isEmpty()) {
            if (gender.equals(Gender.MALE)) {
                avatar = ImageUtill.encoderFromFile("D:/IdeaProjects" +
                        "/epamTraining/taskFinalProject/web/img/man_avatar.png");
            } else {
                avatar = ImageUtill.encoderFromFile("D:/IdeaProjects" +
                        "/epamTraining/taskFinalProject/web/img/woman_avatar.png");
            }
        }
        return avatar;
    }
}
