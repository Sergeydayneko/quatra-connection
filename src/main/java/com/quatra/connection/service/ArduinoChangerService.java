package com.quatra.connection.service;

import java.util.concurrent.ExecutionException;

public interface ArduinoChangerService {
    void changeLockState(String id, boolean state);
    Integer getRestartTimeById(String id) throws ExecutionException, InterruptedException;
    boolean updateRoomsLock(String id, boolean state);
    boolean updateRealRoomLock(String id, boolean realLockState);
}
