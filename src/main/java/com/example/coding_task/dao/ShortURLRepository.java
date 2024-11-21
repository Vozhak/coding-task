package com.example.coding_task.dao;

import com.example.coding_task.model.ShortURL;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ShortURLRepository extends CrudRepository<ShortURL, Long> {
    // TODO: Implement repository method
    List<ShortURL> findWithClicksLessOrEqualThan(int clicks);
}
