package com.example.ewwithpostgres.service.impl;

import com.example.ewwithpostgres.model.Advertising;
import com.example.ewwithpostgres.repository.AdvertisingRepository;
import com.example.ewwithpostgres.service.AdvertisingService;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdvertisingServiceImpl implements AdvertisingService {
    private final AdvertisingRepository advertisingRepository;

    public AdvertisingServiceImpl(AdvertisingRepository advertisingRepository) {
        this.advertisingRepository = advertisingRepository;
    }

    @Override
    public List<Advertising> getAll(Pageable pageable) {
        return advertisingRepository.findAll(pageable).toList();
    }
}
