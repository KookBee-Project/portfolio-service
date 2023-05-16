package com.KookBee.portfolioservice.client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String userName;
    private String userEmail;
}
