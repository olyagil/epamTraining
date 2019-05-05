package by.training.beautysalon.command;

import by.training.beautysalon.domain.Role;

import java.util.Arrays;

public abstract class AuthorizedUserCommand extends Command {

    public AuthorizedUserCommand() {
        getAllowedRoles().addAll(Arrays.asList(Role.values()));
    }
}
