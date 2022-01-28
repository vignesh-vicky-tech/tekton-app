package com.example.service;

import com.example.domain.entity.WebEntity;
import com.example.exception.EntityNotFoundException;
import com.example.repository.WebEntityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Web entity service layer
 */
@Service
@Slf4j
@AllArgsConstructor
public class ExampleWebService {

    private WebEntityRepository webEntityRepository;

    public List<WebEntity> getAll() {
        return webEntityRepository.findAll();
    }

    public WebEntity getById(Long id) {
        return webEntityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("WebEntity by id: " + id + " not found."));
    }
    
    public List<WebEntity> getAllByLastName(String lastName) {
        return webEntityRepository.findAllByLastName(lastName);
    }

    public List<WebEntity> getAllByFistName(String firstName) {
        return webEntityRepository.findAllByFirstName(firstName);
    }

    public void deleteById(Long id) {
        webEntityRepository.deleteById(id);
    }

}
