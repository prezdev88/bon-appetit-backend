package org.prezdev.bonappetit.domain.model;

import lombok.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AppUser {

    private Long id;
    private String name;

    @Builder.Default
    private boolean enabled = true;

    private OffsetDateTime createdAt;

    private String userIdNumber;

    @Builder.Default
    private Set<AppRole> roles = new HashSet<>();
}
