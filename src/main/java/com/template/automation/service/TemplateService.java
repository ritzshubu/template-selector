package com.template.automation.service;

import com.template.automation.dto.Template;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TemplateService {

    private final List<Template> templatesList = new ArrayList<>();

    public void addTemplate(Template template) {
        templatesList.add(template);
    }

    public List<Template> getAllTemplate() {
        return templatesList;
    }

    public Optional<Template> getTemplateById(int id) {
        return templatesList.stream()
                .filter(template -> template.getId() == id)
                .findFirst();
    }

    public boolean deleteCourse(int id) {
        return templatesList
                .removeIf(template -> template.getId() == id);
    }
}
