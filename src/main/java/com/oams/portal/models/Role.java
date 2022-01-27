package com.oams.portal.models;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.util.Set;

@Embeddable
@Getter
@Setter
@ToString
public class Role {
    private Set<String> role;
}
