package com.rq.loyalty.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAddress implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private String country;
    private String state;
    private String city;
    private String district;
    private String street;
    private String number;
    private String complement;
    private String reference;
    private String formattedAddress;
    private String postalCode;
    private Coordinates coordinates;

}
