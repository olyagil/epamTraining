package by.training.beautysalon.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandFactory {
    private static final Logger LOGGER = LogManager.getLogger();

    public static Command create(String command) {
        CommandEnum commandEnum =
                CommandEnum.valueOf(command.toUpperCase().replaceAll("/", "_"));
        return commandEnum.getCommand();
//        LOGGER.error("There are not such command: " + command);
//        throw new UnsupportedOperationException("Unknown command: " + command);
    }
}
