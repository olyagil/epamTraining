package by.training.beautysalon.command;

import by.training.beautysalon.command.account.AccountEditCommand;
import by.training.beautysalon.command.account.AccountMainCommand;
import by.training.beautysalon.command.account.AccountSaveAvatarCommand;
import by.training.beautysalon.command.account.AccountSaveCommand;
import by.training.beautysalon.command.admin.*;
import by.training.beautysalon.command.employee.TalonDeleteCommand;
import by.training.beautysalon.command.employee.TalonEditCommand;
import by.training.beautysalon.command.employee.TalonListCommand;
import by.training.beautysalon.command.employee.TalonSaveCommand;
import by.training.beautysalon.command.guest.FeedBackCommand;
import by.training.beautysalon.command.guest.ServicesCommand;
import by.training.beautysalon.command.guest.EmployeesCommand;

public enum CommandEnum {
    UNKNOWN_COMMAND(new UnknownCommand()),
    //COMMON COMMANDS
    LOGIN(new LoginCommand()),
    SIGNUP(new SignUpCommand()),
    MAIN(new MainCommand()),
    LOGOUT(new LogoutCommand()),
    LANGUAGE(new LanguageCommand()),

    //GUEST'S COMMANDS
    FEEDBACK(new FeedBackCommand()),
    SERVICES(new ServicesCommand()),
    EMPLOYEES(new EmployeesCommand()),

    //ACCOUNT'S COMMANDS
    ACCOUNT_SAVE_AVATAR(new AccountSaveAvatarCommand()),
    ACCOUNT_SAVE_INFO(new AccountSaveCommand()),
    //    ACCOUNT_SAVE_PASSWORD(new AccountSavePasswordCommand()),
    ACCOUNT_EDIT_INFO(new AccountEditCommand()),
    ACCOUNT_EDIT_PASSWORD(new AccountEditCommand()),
    ACCOUNT_MAIN(new AccountMainCommand()),

    //ADMIN'S COMMANDS
    CLIENT_LIST(new ClientListCommand()),
//    CLIENT_ADD(new ClientAddCommand()),

    EMPLOYEE_LIST(new EmployeeListCommand()),
    EMPLOYEE_EDIT(new EmployeeEditCommand()),
    EMPLOYEE_SAVE(new EmployeeSaveCommand()),

    //ADMIN'S COMMAND FOR BOTH USER AND EMPLOYEE
    USER_DELETE(new UserDeleteCommand()),
    USER_VIEW(new UserViewCommand()),


    //SERVICE'S COMMANDS
    SERVICE_LIST(new ServiceListCommand()),
    SERVICE_EDIT(new ServiceEditCommand()),
    SERVICE_SAVE(new ServiceSaveCommand()),
    SERVICE_DELETE(new ServiceDeleteCommand()),


    //EMPLOYEE'S COMMANDS
    TALON_LIST(new TalonListCommand()),
    TALON_EDIT(new TalonEditCommand()),
    TALON_SAVE(new TalonSaveCommand()),
    TALON_DELETE(new TalonDeleteCommand());


    private Command command;

    CommandEnum(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
