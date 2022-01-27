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
        this.password = staffInput.getPassword();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private int staffId;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "ROLE",joinColumns = @JoinColumn(name = "staff_id"))
    private Set<String> role;
    @Column(name = "staff_name")
    private String staffName;
    @Column(name = "staff_email")
    private String staffEmail;
    @Column(name = "image_name")
    private String ImageName;
    @Column(name = "password")
    private String password;
}
