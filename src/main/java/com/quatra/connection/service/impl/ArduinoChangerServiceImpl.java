package com.quatra.connection.service.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.quatra.connection.service.ArduinoChangerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@AllArgsConstructor
@Slf4j
public class ArduinoChangerServiceImpl implements ArduinoChangerService {
    private final Firestore firestore;

    private static final String COLLECTION_NAME = "doors";
    private static final String START_TIMER_KEY = "startTimer";

    @Override
    public void changeLockState(String id, boolean state) {
        // todo апи куда отправлять на arduino
    }

    @Override
    public Integer getRestartTimeById(String id) throws ExecutionException, InterruptedException {
        log.debug("Starting to get restartTimer for ID = " + id);
        DocumentSnapshot documentSnapshot;

        ApiFuture<DocumentSnapshot> documentReference =
                firestore.collection(COLLECTION_NAME)
                        .document(id)
                        .get();

        if (documentReference.isDone()) {
            documentSnapshot = documentReference.get();

            return (Integer) documentSnapshot.get(START_TIMER_KEY);
        }


        log.error("StarTimer variable has not been found for ID = " + id);
        return null;
    }
}
