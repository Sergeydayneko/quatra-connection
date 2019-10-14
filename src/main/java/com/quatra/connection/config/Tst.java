package com.quatra.connection.config;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Component
@RequiredArgsConstructor
public class Tst {
    private final Firestore firestore;


    @PostConstruct
    public void test() throws ExecutionException, InterruptedException {
        Map<String, String> values = Collections.singletonMap("Hello", "World");

        ApiFuture<DocumentReference> apiFuture = firestore.collection("users")
                .add(values);

        System.out.println(apiFuture);

        DocumentReference documentReference = firestore.collection("users").document("PYZs3PIvJfJzPBkZY9KJ");

        ApiFuture<DocumentSnapshot> snapshotApiFuture = documentReference.get(); // может добавлять обработчики исключений

        DocumentSnapshot snapshot = snapshotApiFuture.get();

        System.out.println(snapshot.getData());


    }
}
