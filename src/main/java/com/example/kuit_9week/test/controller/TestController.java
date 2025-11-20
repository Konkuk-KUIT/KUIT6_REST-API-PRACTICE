package com.example.kuit_9week.test.controller;

import com.example.kuit_9week.test.dto.TestRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PostMapping("/testV0")
    public ResponseEntity<String> testV0(@RequestBody TestRequest request) {
        if (request.testInput() == null) {
            return ResponseEntity.badRequest().body("testInput 은 null 일 수 없습니다.");
        }

        try {
            int input = Integer.parseInt(request.testInput());

            if (input % 2 == 1) {
                return ResponseEntity.status(400).body("짝수만 입력 가능합니다.");
            }

            return ResponseEntity.ok("입력값 : " + input);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(400).body("숫자 형식이 아닙니다.");
        }
    }

}
