package org.prezdev.bonappetit.domain.model.identity;

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
public class AppRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80, nullable = false)
    private String name;

    @Builder.Default
    @ManyToMany(mappedBy = "roles")
    private Set<AppUser> users = new HashSet<>();
}
