package com.quatra.connection.endpoints;

import com.quatra.connection.service.impl.ArduinoChangerServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/arduino")
public class ArduinoChangeController {
    private final ArduinoChangerServiceImpl firebaseChangerService;

    @GetMapping("/restartTimer")
    public ResponseEntity<Integer> getRestartTimeById(@RequestParam String id) {
        try {
            return ResponseEntity.ok(firebaseChangerService.getRestartTimeById(id));
        } catch (ExecutionException | InterruptedException ex) {
            log.error("Error occurred while was trying to get restartTimer for id = " + id);
            return null;
        }
    }

//    @GetMapping("/data")
//    @GetMapping("/path")

}
