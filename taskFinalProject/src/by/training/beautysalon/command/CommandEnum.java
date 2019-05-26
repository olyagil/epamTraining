package by.training.beautysalon.command;

import by.training.beautysalon.command.account.AccountEditCommand;
import by.training.beautysalon.command.account.AccountMainCommand;
import by.training.beautysalon.command.account.AccountSaveAvatarCommand;
import by.training.beautysalon.command.account.AccountSaveCommand;
import by.training.beautysalon.command.account.AccountSavePasswordCommand;
import by.training.beautysalon.command.admin.*;
import by.training.beautysalon.command.common.LanguageCommand;
import by.training.beautysalon.command.common.LoginCommand;
import by.training.beautysalon.command.common.LogoutCommand;
import by.training.beautysalon.command.common.MainCommand;
import by.training.beautysalon.command.common.SignUpCommand;
import by.training.beautysalon.command.common.NotFoundCommand;
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
    NOTFOUND("notfound", new NotFoundCommand()),

    //GUEST'S COMMANDS
    LOGIN("login",new LoginCommand()),
    SIGNUP("signup",new SignUpCommand()),
    LANGUAGE("language",new LanguageCommand()),

    FEEDBACK("feedback",new FeedBackCommand()),
    SERVICES("services",new ServicesCommand()),
    EMPLOYEES("employees",new EmployeesCommand()),
    INDEX("index",new MainCommand()),
    MAIN("main",new MainCommand()),
    LOGOUT("logout",new LogoutCommand()),

    //ACCOUNT'S COMMANDS
    ACCOUNT_SAVE_AVATAR("account/save/avatar",new AccountSaveAvatarCommand()),
    ACCOUNT_SAVE_INFO("account/save/info",new AccountSaveCommand()),
    ACCOUNT_SAVE_PASSWORD("account/save/password",
            new AccountSavePasswordCommand()),
    ACCOUNT_EDIT_INFO("account/edit/info",new AccountEditCommand()),
    ACCOUNT_EDIT_PASSWORD("account/edit/password",new AccountEditCommand()),
    ACCOUNT_MAIN("account/main",new AccountMainCommand()),

    //ADMIN'S COMMANDS
    CLIENT_LIST("client/list",new ClientListCommand()),

    EMPLOYEE_LIST("employee/list",new EmployeeListCommand()),
    EMPLOYEE_EDIT("employee/edit",new EmployeeEditCommand()),
    EMPLOYEE_SAVE("employee/save",new EmployeeSaveCommand()),
    EMPLOYEE_ADD("employee/add",new EmployeeAddCommand()),

    //SERVICE'S COMMANDS
    SERVICE_LIST("service/list",new ServiceListCommand()),
    SERVICE_EDIT("service/edit",new ServiceEditCommand()),
    SERVICE_SAVE("service/save",new ServiceSaveCommand()),
    SERVICE_DELETE("service/delete",new ServiceDeleteCommand()),

    //ADMIN'S COMMAND
    USER_DELETE("user/delete",new UserDeleteCommand()),
    USER_VIEW("user/view",new UserViewCommand()),

    //COMMANDS WITH TALONS FOR EMPLOYEE
    TALON_ADD("talon/add",new TalonAddCommand()),
    TALON_EDIT("talon/edit",new TalonEditCommand()),
    TALON_SAVE("talon/save",new TalonSaveCommand()),
    TALON_DELETE("talon/delete",new TalonDeleteCommand()),
    TALON_LIST("talon/list",new TalonListCommand()),


    //COMMANDS WITH FEEDBACK
    FEEDBACK_LIST("feedback/list",new FeedBackListCommand()),
    FEEDBACK_DELETE("feedback/delete",new FeedBackDeleteCommand()),
    FEEDBACK_ADD("feedback/add",new FeedBackAddCommand()),
    FEEDBACK_SAVE("feedback/save",new FeedBackSaveCommand());

    private Command command;
    private String name;

    CommandEnum(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
    public String  getName() {
        return name;
    }
}
