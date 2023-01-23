package com.tobySpring.chapter1;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void add() throws SQLException, ClassNotFoundException {
//        UserDao userDao = new UserDao();

        User user = new User();
        user.setId("blackShip");
        user.setName("흑선");
        user.setPassword("move");

//        userDao.add(user);
        
        System.out.println(user.getId() + " 등록 성공");

//        User user2 = userDao.get(user.getId());
//        System.out.println(user2.getName());
//        System.out.println(user2.getPassword());
//
//        System.out.println(user2.getId() + "조회 성공");
    }

    @Test
    void get() {
    }
}