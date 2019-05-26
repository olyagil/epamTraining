package by.training.beautysalon.builder;

import by.training.beautysalon.entity.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Builder<Type extends Entity> {

    Type build(ResultSet resultSet) throws SQLException;

}
