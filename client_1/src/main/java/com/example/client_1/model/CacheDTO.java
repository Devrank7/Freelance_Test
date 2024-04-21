package com.example.client_1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class CacheDTO {

    private BHotel bHotel;
    private int countSee;

    public CacheDTO(BHotel bHotel) {
        this.bHotel = bHotel;
        countSee++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        CacheDTO cacheDTO = (CacheDTO) o;
        return Objects.equals(bHotel, cacheDTO.bHotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bHotel, countSee);
    }
}
