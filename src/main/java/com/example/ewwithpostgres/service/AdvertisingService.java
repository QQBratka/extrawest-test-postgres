package com.example.ewwithpostgres.service;

import com.example.ewwithpostgres.model.Advertising;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface AdvertisingService {
    List<Advertising> getAll(Pageable pageable);
}
