package com.arcone.learning.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.arcone.learning.util.IdUtil.uuid;

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
    private Long latitude;
    private Long longitude;
}
