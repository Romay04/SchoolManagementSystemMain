package com.JavaMiniProject.SchoolManagementSystem.parent;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/v1/parent")


public class ParentController {
    @GetMapping
    public ResponseEntity<String>  sayHello() {
      return   ResponseEntity.ok("Welcome Parent");
    }

}
