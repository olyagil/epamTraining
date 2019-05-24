package by.training.beautysalon.command;

import by.training.beautysalon.command.account.AccountEditCommand;
import by.training.beautysalon.command.account.AccountMainCommand;
import by.training.beautysalon.command.account.AccountSaveAvatarCommand;
import by.training.beautysalon.command.account.AccountSaveCommand;
import by.training.beautysalon.command.account.AccountSavePasswordCommand;
import by.training.beautysalon.command.admin.*;
import by.training.beautysalon.command.comman.LanguageCommand;
import by.training.beautysalon.command.comman.LoginCommand;
import by.training.beautysalon.command.comman.LogoutCommand;
import by.training.beautysalon.command.comman.MainCommand;
import by.training.beautysalon.command.comman.SignUpCommand;
import by.training.beautysalon.command.comman.UnknownCommand;
import by.training.beautysalon.command.employee.TalonAddCommand;
import by.training.beautysalon.command.employee.TalonDeleteCommand;
import by.training.beautysalon.command.employee.TalonEditCommand;
import by.training.beautysalon.command.employee.TalonListCommand;
import by.training.beautysalon.command.employee.TalonSaveCommand;
import by.training.beautysalon.command.feedback.FeedBackAddCommand;
import by.training.beautysalon.command.feedback.FeedBackDeleteCommand;
import by.training.beautysalon.command.feedback.FeedBackListCommand;
import by.training.beautysalon.command.feedback.FeedBackSaveCommand;
import by.training.beautysalon.command.guest.FeedBackCommand;
import by.training.beautysalon.command.guest.ServicesCommand;
import by.training.beautysalon.command.guest.EmployeesCommand;

public enum CommandEnum {
    UNKNOWN_COMMAND(new UnknownCommand()),
    //COMMON COMMANDS
    INDEX(new MainCommand()),
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
    ACCOUNT_SAVE_PASSWORD(new AccountSavePasswordCommand()),
    ACCOUNT_EDIT_INFO(new AccountEditCommand()),
    ACCOUNT_EDIT_PASSWORD(new AccountEditCommand()),
    ACCOUNT_MAIN(new AccountMainCommand()),

    //ADMIN'S COMMANDS
    CLIENT_LIST(new ClientListCommand()),
//    CLIENT_ADD(new ClientAddCommand()),

    EMPLOYEE_LIST(new EmployeeListCommand()),
    EMPLOYEE_EDIT(new EmployeeEditCommand()),
    EMPLOYEE_SAVE(new EmployeeSaveCommand()),
    EMPLOYEE_ADD(new EmployeeAddCommand()),
    //ADMIN'S COMMAND FOR BOTH USER AND EMPLOYEE
    USER_DELETE(new UserDeleteCommand()),
    USER_VIEW(new UserViewCommand()),


    //SERVICE'S COMMANDS
    SERVICE_LIST(new ServiceListCommand()),
    SERVICE_EDIT(new ServiceEditCommand()),
    SERVICE_SAVE(new ServiceSaveCommand()),
    SERVICE_DELETE(new ServiceDeleteCommand()),


    //COMMANDS WITH TALONS
    TALON_LIST(new TalonListCommand()),
    TALON_ADD(new TalonAddCommand()),
    TALON_EDIT(new TalonEditCommand()),
    TALON_SAVE(new TalonSaveCommand()),
    TALON_DELETE(new TalonDeleteCommand()),


    //COMMENDS WITH FEEDBACK
    FEEDBACK_LIST(new FeedBackListCommand()),
    FEEDBACK_DELETE(new FeedBackDeleteCommand()),
    FEEDBACK_ADD(new FeedBackAddCommand()),
    FEEDBACK_SAVE(new FeedBackSaveCommand());


    //CLIENT"S COMMANDS

    private Command command;

    CommandEnum(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
