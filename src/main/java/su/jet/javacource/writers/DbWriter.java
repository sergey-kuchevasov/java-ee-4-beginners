/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.jet.javacource.writers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import su.jet.javacource.User;

/**
 *
 * @author kurmesov
 */
public class DbWriter implements Writer {

    private String connectionString;
    private String user;
    private String password;

    public DbWriter(String connectionString, String user, String password) {
        this.connectionString = connectionString;
        this.user = user;
        this.password = password;
    }

    @Override
    public void write(Set<User> users) {
        Map<User, List<Exception>> errors = new HashMap<>();
        try (Connection connection
                = DriverManager.getConnection(this.connectionString, this.user, this.password)) {
            for (User user : users) {
                List<Exception> errorList = new ArrayList<>();
                System.out.println("db: handling user" + user.toString());
                int userId = user.getId();
                String name = user.getName();
                if (name == null && name.isEmpty()) {
                    throw new IllegalArgumentException("User has empty name: " + user);
                }
                try {
                    System.out.println("Записываем информацию о пользователе в БД: " + user);
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO USERS VALUES(?,?)");
                    statement.setInt(1, userId);
                    statement.setString(2, name);
                    statement.executeUpdate();
                    System.out.println("Данные о пользователе успешно записаны в БД : " + user);
                } catch (SQLException | IllegalArgumentException ex) {
                    errorList.add(ex);
                    System.out.println("Error occured while writing data: " + ex);
                } finally {
                    if (!errorList.isEmpty()) {
                        errors.put(user, errorList);
                    }
                }
            }
            System.out.println("Произошли следующие ошибки при обработке данных:");
            Set<User> badUsers = errors.keySet();
            for (User user : badUsers) {
                System.out.println("    Пользователь: " + user);
                List<Exception> listOfErrors = errors.get(user);
                for (Exception e : listOfErrors) {
                    System.out.println(e);
                }
            }
        } catch (SQLException ex) {
            //Как быть с этим Exception? Не хорошо заставлять интерфейс бросать 
            //специфичные для какой-то реализации исключения
            System.out.println("Произошла ошибка при работе с БД. Информация о пользователях не сохранена в БД: " + users);
            System.out.println(ex);
        }
    }
}
