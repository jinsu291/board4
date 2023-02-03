package com.example.board4.app.member.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private long id;
    private String username;

    @JsonIgnore
    private String password;

    private String email;
    private String nickname;

    public Member(String username, String password, String email, String nickname) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
    }

}
