package br.com.grupoencantos.encantos_api.domain.aluno;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;

public class AlunoSpecification {
    
    public static Specification<Aluno> toPredicate(String filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            predicates.add(criteriaBuilder.isTrue(root.get("ativo")));

            if (filter != null && !filter.isEmpty()) {
                predicates.add(
                    criteriaBuilder.or(
                        criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("nome")), "%" + filter.toLowerCase() + "%"
                        ),
                        criteriaBuilder.like(
                            root.get("cpf"), "%" + filter + "%"
                        )
                    )
                );
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
