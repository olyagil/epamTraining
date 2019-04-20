package by.training.beatysalon.action;

import by.training.beatysalon.service.ServiceFactory;

public class ActionManagerFactory {

    public static ActionManager getManager(ServiceFactory factory) {
        return new ActionManagerImpl(factory);
    }
}
