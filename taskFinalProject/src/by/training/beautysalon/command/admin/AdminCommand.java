package by.training.beautysalon.command.admin;

import by.training.beautysalon.command.Command;
import by.training.beautysalon.domain.Role;

abstract class AdminCommand extends Command {

    AdminCommand() {
        getAllowedRoles().add(Role.ADMINISTRATOR);
    }
}
