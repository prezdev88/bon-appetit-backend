package org.prezdev.bonappetit.domain.model;

import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AppRole {

    private Long id;
    private String name;

    @Builder.Default
    private Set<AppUser> users = new HashSet<>();
}
