package com.fiap.futureskills.service;

import com.fiap.futureskills.domain.skill.Skill;
import com.fiap.futureskills.dto.SkillDTO;
import com.fiap.futureskills.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillRepository skillRepository;

    // Cria uma nova habilidade no sistema.
    // TODO: Adicionar validação para não permitir skills duplicadas com o mesmo
    // nome.
    public Skill createSkill(SkillDTO dto) {
        // Convertendo DTO para Entity
        Skill skill = Skill.builder()
                .name(dto.name())
                .description(dto.description())
                .category(dto.category())
                .build();

        return skillRepository.save(skill);
    }

    // Retorna todas as skills paginadas para não sobrecarregar a API
    public Page<Skill> getAllSkills(Pageable pageable) {
        return skillRepository.findAll(pageable);
    }
}
