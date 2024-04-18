package com.example.client_1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DTO_Hotel_User {

    private BHotel hotel;

    private BUser user;


    public boolean isValid() {
        for (BUser bUser : hotel.getBookers()) {
            if (bUser.getId() == user.getId()) {
                return true;
            }
        }
        return false;
    }
}
