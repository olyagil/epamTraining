package by.training.beautysalon.command;

import by.training.beautysalon.exception.PersistentException;
import by.training.beautysalon.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandManagerImpl implements CommandManager {
    private ServiceFactory factory;

    public CommandManagerImpl(ServiceFactory factory) {
        this.factory = factory;
    }

    @Override
    public Command.Forward execute(Command command, HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        command.setFactory(factory);
        return command.exec(request, response);
    }

    @Override
    public void close() {
        factory.close();
    }
}
