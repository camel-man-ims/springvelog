package com.example.springvelog.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class UserApiResponse {

    private Long id;

    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    @CreatedDate
    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;
}