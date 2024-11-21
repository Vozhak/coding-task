package com.example.coding_task.service;

import com.example.coding_task.dao.ShortURLRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ShortURLService {

    ShortURLRepository repository;

    public String shortenUrl(String fullUrl) {
        // TODO: Implement service method
        return null;
    }

    public List<String> findShortsWithClicksLessOrEqualsThan(int clicks) {
        // TODO: Implement service method
        return null;
    }
}
