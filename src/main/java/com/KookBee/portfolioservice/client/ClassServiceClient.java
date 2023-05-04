package com.KookBee.portfolioservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CLASS-SERVICE")
public interface ClassServiceClient {
    @GetMapping("/class/curriculum/curriculumList")
    List<Curriculum> getCurriculumByUserId();
    @GetMapping("/studentBootcamp/{id}")
    StudentBootcamp findByStudentId (@PathVariable("id") Long id);
    @GetMapping("/class/curriculum/{curriculumId}")
    Curriculum getCurriculumByCurriculumId(@PathVariable("curriculumId") Long curriculumId);
}