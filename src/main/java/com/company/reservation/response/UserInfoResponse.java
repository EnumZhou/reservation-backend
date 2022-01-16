package com.company.reservation.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserInfoResponse {
    private Long id;
    private String username;
    private String email;
    private List<String> roles;
    private String cookie;
//    public UserInfoResponse(Long id, String username, String email, List<String> roles,String cookie) {
//        this.id = id;
//        this.username = username;
//        this.email = email;
//        this.roles = roles;
//        this.cookie = cookie;
//    }

}
