package com.KookBee.portfolioservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CLASS-SERVICE")
public interface ClassServiceClient {
    @GetMapping("/class/curriculum/skillset/{id}")
    Curriculum getCurriculumByCurriculumId(@PathVariable Long id);
    @GetMapping("/studentBootcamp/{id}")
    StudentBootcamp findByStudentId (@PathVariable Long id);
}