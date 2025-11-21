package com.fiap.futureskills.controller;

import com.fiap.futureskills.domain.skill.Skill;
import com.fiap.futureskills.dto.SkillDTO;
import com.fiap.futureskills.service.SkillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/skills")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @PostMapping
    public ResponseEntity<Skill> createSkill(
            @RequestBody @Valid SkillDTO dto,
            UriComponentsBuilder uriBuilder) {
        Skill skill = skillService.createSkill(dto);
        URI uri = uriBuilder.path("/skills/{id}").buildAndExpand(skill.getId()).toUri();
        return ResponseEntity.created(uri).body(skill);
    }

    @GetMapping
    public ResponseEntity<Page<Skill>> getAllSkills(Pageable pageable) {
        return ResponseEntity.ok(skillService.getAllSkills(pageable));
    }
}
