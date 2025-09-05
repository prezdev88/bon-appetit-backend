package org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.identity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
    name = "app_role",
    uniqueConstraints = @UniqueConstraint(name = "uq_app_role_name", columnNames = "name")
)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AppRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80, nullable = false)
    private String name;

    @Builder.Default
    @ManyToMany(mappedBy = "roles")
    private Set<AppUserEntity> users = new HashSet<>();
}
