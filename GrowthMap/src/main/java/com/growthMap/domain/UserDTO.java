package com.growthMap.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String token;
    private String userId;
    private String email;
    private String password;
    private String name;
    private String interest;
    private String profileUrl;
    private String nickname;

}
