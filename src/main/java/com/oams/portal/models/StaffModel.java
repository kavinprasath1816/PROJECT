package com.oams.portal.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
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
    @CollectionTable(name = "ROLE", joinColumns = @JoinColumn(name = "STAFF_ID"))
    private Set<String> role;
    @Column(name = "NAME")
    private String staffName;
    @Column(name = "EMAIL", unique = true)
    private String staffEmail;
    @Column(name = "IMAGE")
    private String ImageName;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "CREATED_AT")
    @CreationTimestamp
    private Timestamp createdAt;
    @Column(name = "UPDATED_AT")
    @UpdateTimestamp
    private Timestamp updatedAt;
}
