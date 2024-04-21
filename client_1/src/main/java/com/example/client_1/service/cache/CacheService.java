package com.example.client_1.service.cache;

import com.example.client_1.model.BHotel;
import com.example.client_1.model.CacheDTO;
import com.example.client_1.repository.IHotel;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class CacheService {


    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private IHotel hotelRepo;

    private List<BHotel> cacheDTO = new ArrayList<>();

    public boolean isObjectInCache(String cacheName, int key) {
        Cache cache = cacheManager.getCache(cacheName);
        if (cache != null) {
            return cache.get(key) != null;
        }

        return false;
    }
    public boolean needToAddToCache(BHotel hotel) {
        cacheDTO.add(hotel);
        int amount = Collections.frequency(cacheDTO,hotel);
        return amount >= 3;

    }
    @Cacheable(value = "hotel",key = "#id")
    public BHotel getter(int id) {
        log.warn("new cache");
        return hotelRepo.findById(id).orElseThrow();
    }
    @CachePut(value = "hotel",key = "#id")
    public BHotel setter(BHotel hotel,int id) {
        return hotel;
    }
    @CacheEvict(value = "hotel",key = "#bHotel.id")
    public void deleter(BHotel bHotel) {}

    @CacheEvict(value = "hotel",key = "#id")
    public void deleter(int id) {}
}
