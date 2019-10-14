package com.quatra.connection.service;

import java.util.concurrent.ExecutionException;

public interface ArduinoChangerService {
    void changeLockState(String id, boolean state);
    Integer getRestartTimeById(String id) throws ExecutionException, InterruptedException;
}
