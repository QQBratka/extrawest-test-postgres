package com.example.ewwithpostgres.controller;

import com.example.ewwithpostgres.dto.response.AdvertisingResponseDto;
import com.example.ewwithpostgres.service.AdvertisingService;
import com.example.ewwithpostgres.service.mapper.AdvertisingMapper;
import com.example.ewwithpostgres.util.PaginationUtil;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advertising")
@AllArgsConstructor
public class AdvertisingController {
    private final AdvertisingMapper advertisingMapper;
    private final AdvertisingService advertisingService;
    private final PaginationUtil pagination;

    @GetMapping
    @PreAuthorize("hasAuthority('users:read')")
    public List<AdvertisingResponseDto> getAll(
            @RequestParam (defaultValue = "0") Integer page,
            @RequestParam (defaultValue = "5") Integer size,
            @RequestParam (defaultValue = "price") String sortBy) {
        PageRequest pageRequest = pagination.paginate(page, size, sortBy);
        return advertisingService.getAll(pageRequest).stream()
                .map(advertisingMapper::toDto)
                .collect(Collectors.toList());
    }
}
