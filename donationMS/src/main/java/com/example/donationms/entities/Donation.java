package com.example.donationms.entities;

import com.example.organisationms.entities.Organisation;
import com.example.userms.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateDonation;
    private Double montant;
    private Long idUser;
    private Long idOrganisation;
    @Transient
    private User user;
    @Transient
    private Organisation organisation;
}
