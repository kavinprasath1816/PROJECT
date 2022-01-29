package com.oams.portal.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;


@Table(name = "STAFF")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class StaffModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STAFF_ID")
    private int staffId;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "ROLE", joinColumns = @JoinColumn(name = "staff_id"))
    private Set<String> role;
    @Column(name = "NAME")
    private String staffName;
    @Column(name = "EMAIL", unique = true)
    private String staffEmail;
    @Column(name = "IMAGE")
    private String ImageName;
    @Column(name = "PASSWORD")
    private String password;
}
