package com.growthMap.controller;

import com.growthMap.domain.User;
import com.growthMap.domain.UserDTO;
import com.growthMap.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/*")
@CrossOrigin(origins={"*"}, maxAge = 6000)
public class UserController {

    @Autowired
    private UserService userService;

    // 멤버전체 보기
    @GetMapping("/user")
    public ResponseEntity<List<User>> showAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.showAll());
    }


    // 회원 1명 상세 조회
    @GetMapping("/user/{id}")
    public ResponseEntity<User> show(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.show(id));
    }

    // 회원가입
    @PostMapping("/user/signup")
    public ResponseEntity register(@RequestBody UserDTO userDTO) {

        User user = User.builder()
                .userid(userDTO.getUserid())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .name(userDTO.getName())
                .interest(userDTO.getInterest())
                .profileurl(userDTO.getProfileurl())
                .nickname(userDTO.getNickname())
                .build();

        // 서비스를 이용해 리포지터리에 유저 저장
        User registerMember = userService.create(user);
        UserDTO responseDTO = userDTO.builder()
                .userid(registerMember.getUserid())
                .email(registerMember.getEmail())
                .password(registerMember.getPassword())
                .name(registerMember.getName())
                .interest(registerMember.getInterest())
                .profileurl(registerMember.getProfileurl())
                .nickname(registerMember.getNickname())
                .build();
        return ResponseEntity.ok().body(responseDTO);
    }

    // 회원 수정

    // 회원 삭제 : http://localhost:8080/api/user/{id}
    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable String id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
