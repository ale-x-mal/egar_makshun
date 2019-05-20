package org.egar.makshun.jdbc;

import org.egar.makshun.jdbc.model.User;
import org.egar.makshun.jdbc.service.UserService;
import org.egar.makshun.jdbc.service.impl.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        UserService userServiceImpl = new UserServiceImpl();

        System.out.println("===========findAllUsers==========");
        System.out.println(userServiceImpl.findAllUsers());

        System.out.println("===========findAllUsersByRole==========");
        System.out.println(userServiceImpl.findAllUsersByRole("user"));

        System.out.println("===========getOne==========");
        System.out.println(userServiceImpl.getOne(4L));

        System.out.println("===========runFunction==========");
        System.out.println(userServiceImpl.runFunction());

//        System.out.println("===========update==========");
//        System.out.println(userServiceImpl.save(new User(2L,"ivanov","123")));

//        System.out.println("===========save==========");
//        System.out.println(userServiceImpl.save(new User(null,"makshun","111")));
//        System.out.println(userServiceImpl.findAllUsers());
//
//        System.out.println("===========remove==========");
//        userServiceImpl.remove(9L);
//        System.out.println(userServiceImpl.findAllUsers());



    }
}
