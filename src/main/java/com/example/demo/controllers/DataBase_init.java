//package com.example.demo.controllers;
//
//import com.surrealdb.connection.SurrealConnection;
//import com.surrealdb.connection.SurrealWebSocketConnection;
//import com.surrealdb.driver.SyncSurrealDriver;
//
//import java.util.List;
//public class DataBase_init {
//
//    public static void Init(){
//        SurrealConnection connection = new SurrealWebSocketConnection("127.0.0.1", 8001, true);
//        connection.connect(30); // timeout after 30 seconds
//
//        SyncSurrealDriver driver = new SyncSurrealDriver(connection);
//
//        driver.signIn("root", "root"); // username & password
//        driver.use("Sambona", "Sambona"); // namespace & database
//
//        // for more docs, see https://surrealdb.com/docs/integration/libraries/java
//        String table = "Заказы";
//    }
//}
