package com.tobySpring.chapter1;

import java.sql.*;

public abstract class UserDao {
    private SimpleConnectionMaker simpleConnectionMaker;
    public UserDao() {
        simpleConnectionMaker = new SimpleConnectionMaker();
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
//        Connection connection = getConnection();
        Connection connection = simpleConnectionMaker.makeNewConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into users(id,name,password) values(?,?,?)"
        );
        preparedStatement.setString(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getPassword());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }


    public User get(String id) throws ClassNotFoundException, SQLException {
//        Connection connection = getConnection();
        Connection connection = simpleConnectionMaker.makeNewConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from users where id = ?"
        );

        preparedStatement.setString(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        User user = new User();
        user.setId(resultSet.getString("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return user;
    }

    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;

    public class NUserDao extends UserDao {
        @Override
        public Connection getConnection() throws ClassNotFoundException, SQLException {
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/mooncompany", "root", "Powermove!1"
                );
                return connection;
            }
        }
    }

    public class DUserDao extends UserDao {
        @Override
        public Connection getConnection() throws ClassNotFoundException, SQLException {
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/mooncompany", "root", "Powermove!1"
                );
                return connection;
            }
        }
    }
}
