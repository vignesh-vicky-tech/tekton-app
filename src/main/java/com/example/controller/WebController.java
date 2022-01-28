package com.example.controller;

import com.example.domain.entity.WebEntity;
import com.example.domain.mapper.WebEntityMapper;
import com.example.domain.vo.WebEntityNameVO;
import com.example.domain.vo.WebEntityVO;
import com.example.service.ExampleWebService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description REST-controller
 */
@Api("Operation with web entities.")
@RestController
@RequestMapping(value = "/web-entity", produces = {MediaType.APPLICATION_JSON_VALUE})
@Slf4j
@AllArgsConstructor
public class WebController {

    private final ExampleWebService webService;
    private final WebEntityMapper webEntityMapper;

    @ApiOperation(value = "Get all web entities.")
    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<WebEntityVO>> getAll() {
        List<WebEntity> webEntities = webService.getAll();
        List<WebEntityVO> webEntityVOs = webEntityMapper.domainListToVoList(webEntities);
        return ResponseEntity.ok().body(webEntityVOs);
    }

    @ApiOperation(value = "Get web entity by id.")
    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<WebEntityVO> getById(@PathVariable Long id) {
        WebEntity webEntity = webService.getById(id);
        WebEntityVO webEntityVO = webEntityMapper.domainToVo(webEntity);
        return ResponseEntity.ok().body(webEntityVO);
    }

    @ApiOperation(value = "Get web entities by last name.")
    @PostMapping("/get-by/last-name")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getByLastName(@RequestBody WebEntityNameVO nameVo) {
        String lastName = nameVo.getName();
        if (!StringUtils.hasText(lastName)) {
            return ResponseEntity.badRequest().body("Last name not be empty.");
        }
        List<WebEntity> webEntities = webService.getAllByLastName(lastName);
        List<WebEntityVO> webEntityVos = webEntityMapper.domainListToVoList(webEntities);
        return ResponseEntity.ok().body(webEntityVos);
    }

    @ApiOperation(value = "Get web entities by last name.")
    @PostMapping("/get-by/first-name")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getByFirstName(@RequestBody WebEntityNameVO nameVo) {
        String firstName = nameVo.getName();
        if (!StringUtils.hasText(firstName)) {
            return ResponseEntity.badRequest().body("First name not be empty.");
        }
        List<WebEntity> webEntities = webService.getAllByFistName(firstName);
        List<WebEntityVO> webEntityVos = webEntityMapper.domainListToVoList(webEntities);
        return ResponseEntity.ok().body(webEntityVos);
    }

    @ApiOperation(value = "Get web entities by last name.")
    @PostMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        webService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
