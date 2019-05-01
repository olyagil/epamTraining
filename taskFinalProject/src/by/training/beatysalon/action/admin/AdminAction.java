package by.training.beatysalon.action.admin;

import by.training.beatysalon.action.Action;
import by.training.beatysalon.domain.Role;

abstract class AdminAction extends Action {

    AdminAction() {
        getAllowedRoles().add(Role.ADMINISTRATOR);
    }
}
