package com.oams.portal.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Table(name = "STAFF")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class StaffModel {

    public StaffModel(StaffInput staffInput) {
        this.staffName = staffInput.getStaffName();
        this.staffEmail = staffInput.getStaffEmail();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STAFF_ID")
    private int staffId;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "ROLE",joinColumns = @JoinColumn(name = "staff_id"))
    private Set<String> role;
    @Column(name = "NAME")
    private String staffName;
    @Column(name = "EMAIL")
    private String staffEmail;
    @Column(name = "IMAGE")
    private String ImageName;
    @Column(name = "PASSWORD")
    private String password;
}
