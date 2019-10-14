package com.quatra.connection.endpoints;

import com.quatra.connection.service.FirebaseChangerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/door")
public class FirebaseChangerController {
    private final FirebaseChangerService firebaseChangerService;

    @GetMapping("/lock")
    public ResponseEntity changeDoorState(@RequestParam  String id, @RequestParam boolean lockState) {
        firebaseChangerService.updateRoomsLock(id, lockState);

        return ResponseEntity.ok("State has been changed");
    }

    @GetMapping
    public ResponseEntity changeRealState(@RequestParam  String id, @RequestParam boolean realLockState) {
        firebaseChangerService.updateRealRoomLock(id, realLockState);

        // todo добавить контроль над ошибками
        return ResponseEntity.ok("State has been changed");
    }

//    @GetMapping
//    public ResponseEntity updateLockState(@RequestParam Integer status)
}
