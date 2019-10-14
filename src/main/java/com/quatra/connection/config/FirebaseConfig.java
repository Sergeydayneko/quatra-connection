package com.quatra.connection.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
@Scope(scopeName = "prototype")
public class FirebaseConfig {

    /* Добавление листнеров для прослушки изменения событий
    DatabaseReference ref = FirebaseDatabase.getInstance()
    .getReference("restricted_access/secret_document");
ref.addListenerForSingleValueEvent(new ValueEventListener() {
  @Override
  public void onDataChange(DataSnapshot dataSnapshot) {
    Object document = dataSnapshot.getValue();
    System.out.println(document);
  }

     */

    // todo операции сохранения/обновления должны быть транзакционны

    @Bean
    public FirebaseOptions createFirebaseServiceAccount() throws IOException {
        val serviceAccount = new FileInputStream("./ServiceAccountKey.json");

        FirebaseOptions firebaseOptions = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(firebaseOptions);

        return firebaseOptions;
    }

    @Bean
    @DependsOn({"createFirebaseServiceAccount"})
    public Firestore initFirestore() {
        return FirestoreClient.getFirestore();
    }
}
