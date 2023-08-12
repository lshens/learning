package com.arcone.learning.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static com.arcone.learning.util.IdUtil.uuid;
import static javax.persistence.FetchType.LAZY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "addresses")
public class AddressPO {
    @Id
    @Default
    private String id = uuid();
    @Column(name = "postal_code")
    private String postalCode;
    private String city;
    private String country;
    private String street;
    private Float latitude;
    private Float longitude;
    @Column(name = "user_id")
    private String userId;
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserPO user;
}
