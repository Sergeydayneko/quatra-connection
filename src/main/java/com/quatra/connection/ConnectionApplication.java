package com.quatra.connection;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseOptions;
import com.quatra.connection.config.FirebaseConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@RequiredArgsConstructor
public class ConnectionApplication {
    private final Firestore firestore;
    private final FirebaseOptions firebaseOptions;


    public static void main(String[] args) {
        SpringApplication.run(ConnectionApplication.class, args);

    }

}
