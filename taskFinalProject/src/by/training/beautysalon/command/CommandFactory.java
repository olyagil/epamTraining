package by.training.beautysalon.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandFactory {
    private static final Logger LOGGER = LogManager.getLogger();

    public static Command create(String command) {
        CommandEnum commandEnum;
        try {
            commandEnum = CommandEnum.valueOf(command
                    .toUpperCase()
                    .replaceAll("/", "_"));
        } catch (IllegalArgumentException e) {
            LOGGER.error("Such command doesn't exist: " + command);
            commandEnum = CommandEnum.UNKNOWN_COMMAND;
        }
        return commandEnum.getCommand();
    }
}
