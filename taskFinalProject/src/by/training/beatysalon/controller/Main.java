package by.training.beatysalon.controller;


import by.training.beatysalon.domain.Client;
import by.training.beatysalon.domain.Person;
import by.training.beatysalon.domain.Role;
import by.training.beatysalon.domain.Service;
import by.training.beatysalon.domain.Specialist;
import by.training.beatysalon.domain.Specialty;
import by.training.beatysalon.domain.Talon;
import by.training.beatysalon.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/salon_db" +
            "?useUnicode=true&characterEncoding=UTF-8";
    private static final String DB_USER = "salon_user";
    private static final String DB_PASSWORD = "salon_password";

    private static final String SELECT_USER = "select `id`, `login`, " +
            "`password`, `role` from users";
    private static final String SELECT_CLIENT = "select `id`, `surname`, " +
            "`name`, `patronymic`, `card_number`, `phone` from clients";
    private static final String SELECT_SERVICE = "select `id`, `code`, " +
            "`name`, `price`, `duration` from services";
    private static final String SELECT_SPECIALIST = "select `id`, `surname`, " +
            "`name`, `patronymic`, `begin_working_day`, `end_working_day`, " +
            "`cabinet_number`, `salary`, `specialty` from specialists";
    private static final String SELECT_TALON = "select `id`, `service_id`, " +
            "`specialist_id`, `client_id`, `reception_date` from talons";

    public static void main(String[] args) {
        System.out.println(createUsers());
        System.out.println(createClients());
        System.out.println(createServices());
        System.out.println(createSpecialists());
        System.out.println(createTalons());
    }

    private static List<User> createUsers() {
        List<User> users = new ArrayList<>();
        Connection cn;
        try {
            cn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_USER);
            User user;
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setRole(Role.getById(rs.getInt("role")));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;

    }

    private static List<Person> createClients() {
        List<Person> clients = new ArrayList<>();
        Connection cn;
        try {
            cn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_CLIENT);
            Person client;
            while (rs.next()) {
                client = new Client();
                client.setId(rs.getInt("id"));
                client.setSurname(rs.getString("surname"));
                client.setName(rs.getString("name"));
                client.setPatronymic(rs.getString("patronymic"));
                ((Client) client).setCardNumber(rs.getString("card_number"));
                ((Client) client).setPhone(rs.getString("phone"));
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    private static List<Service> createServices() {
        List<Service> services = new ArrayList<>();
        Connection cn;
        try {
            cn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_SERVICE);
            Service service;
            while (rs.next()) {
                service = new Service();
                service.setId(rs.getInt("id"));
                service.setCode(rs.getString("code"));
                service.setName(rs.getString("name"));
                service.setPrice(rs.getDouble("price"));
                service.setDuration(rs.getDouble("duration"));
                services.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

    private static List<Person> createSpecialists() {
        List<Person> specialists = new ArrayList<>();
        Connection cn;
        try {
            cn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_SPECIALIST);
            Person specialist;
            while (rs.next()) {
                specialist = new Specialist();
                specialist.setId(rs.getInt("id"));
                specialist.setSurname(rs.getString("surname"));
                specialist.setName(rs.getString("name"));
                specialist.setPatronymic(rs.getString("patronymic"));
                ((Specialist) specialist).setBeginWorkingDay(rs.getTime(
                        "begin_working_day"));
                ((Specialist) specialist).setEndWorkingDay(rs.getTime(
                        "end_working_day"));
                ((Specialist) specialist).setCabinetNumber(rs.getInt(
                        "cabinet_number"));
                ((Specialist) specialist).setSalary(rs.getDouble("salary"));
                ((Specialist) specialist).setSpecialty(Specialty.getById(rs.getInt("specialty")));
                specialists.add(specialist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return specialists;
    }

    private static List<Talon> createTalons() {
        List<Talon> talons = new ArrayList<>();
        Connection cn;
        try {
            cn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_TALON);
            Talon talon;
            while (rs.next()) {
                talon = new Talon();
                talon.setId(rs.getInt("id"));
//                talon.setService(createServices().get(rs.getInt(
//                        "service_id")));
//                talon.setSpecialist(createSpecialists().get(rs.getInt(
//                        "specialist_id")));
//                talon.setClient(createClients().get(rs.getInt("client_id")));
talon.setReceptionDate(rs.getTimestamp("reception_date"));
                talons.add(talon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return talons;
    }
}
