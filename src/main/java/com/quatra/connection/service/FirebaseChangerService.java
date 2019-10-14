package com.quatra.connection.service;

public interface FirebaseChangerService {
    boolean updateRoomsLock(String id, boolean state);
    boolean updateRealRoomLock(String id, boolean realLockState);
}
