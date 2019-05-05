package by.training.beautysalon.command;

import by.training.beautysalon.service.ServiceFactory;

public class CommandManagerFactory {

    public static CommandManager getManager(ServiceFactory factory) {
        return new CommandManagerImpl(factory);
    }
}
