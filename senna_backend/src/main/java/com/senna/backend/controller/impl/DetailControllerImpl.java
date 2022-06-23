package com.senna.backend.controller.impl;

import com.senna.backend.controller.DetailController;
import com.senna.backend.dto.DetailDTO;
import com.senna.backend.mapper.DetailMapper;
import com.senna.backend.domain.Detail;
import com.senna.backend.service.DetailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/detail")
@RestController
public class DetailControllerImpl implements DetailController {
    private final ComposantService detailService;
    private final DetailMapper detailMapper;

    public DetailControllerImpl(ComposantService detailService, DetailMapper detailMapper) {
        this.detailService = detailService;
        this.detailMapper = detailMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DetailDTO save(@RequestBody DetailDTO detailDTO) {
        Detail detail = detailMapper.asEntity(detailDTO);
        return detailMapper.asDTO(detailService.save(detail));
    }

    @Override
    @GetMapping("/{id}")
    public DetailDTO findById(@PathVariable("id") Long id) {
        Detail detail = detailService.findById(id).orElse(null);
        return detailMapper.asDTO(detail);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        detailService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<DetailDTO> list() {
        return detailMapper.asDTOList(detailService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<DetailDTO> pageQuery(Pageable pageable) {
        Page<Detail> detailPage = detailService.findAll(pageable);
        List<DetailDTO> dtoList = detailPage
                .stream()
                .map(detailMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, detailPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public DetailDTO update(@RequestBody DetailDTO detailDTO, @PathVariable("id") Long id) {
        Detail detail = detailMapper.asEntity(detailDTO);
        return detailMapper.asDTO(detailService.update(detail, id));
    }
}