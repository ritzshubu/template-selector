package com.template.automation.controller;

import com.template.automation.dto.Template;
import com.template.automation.service.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/template")
public class TemplateController {

    private final TemplateService templateService;

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Template> addTemplate(@RequestBody Template template) {
        templateService.addTemplate(template);
        return new ResponseEntity<>(template, HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Template>> getAllTemplate() {
        List<Template> cours = templateService.getAllTemplate();
        return new ResponseEntity<>(cours, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Template> getTemplateById(@PathVariable int id) {
        Optional<Template> course = templateService.getTemplateById(id);
        return course.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Void> deleteTemplate(@PathVariable int id) {
        boolean deleted = templateService.deleteCourse(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
