package com.arcone.learning.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

import static com.arcone.learning.model.UserStatusEnum.ACTIVE;
import static com.arcone.learning.util.IdUtil.uuid;
import static javax.persistence.EnumType.STRING;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserPO {
    @Id
    @Builder.Default
    private final String id = uuid();
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_birth", columnDefinition = "DATE")
    private LocalDate dateBirth;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String secret;
    @Enumerated(STRING)
    @Builder.Default
    private final UserStatusEnum status = ACTIVE;
}
