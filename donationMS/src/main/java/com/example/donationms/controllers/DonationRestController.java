package com.example.donationms.controllers;

import com.example.donationms.entities.Donation;
import com.example.donationms.models.Organisation;
import com.example.donationms.models.User;
import com.example.donationms.repos.DonationRepo;
import com.example.donationms.service.OrganisationRestClient;
import com.example.donationms.service.UserRestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DonationRestController {
    DonationRepo donationRepo;
    UserRestClient userRestClient;
    OrganisationRestClient organisationRestClient;

    public DonationRestController(DonationRepo donationRepo, UserRestClient userRestClient,
                                  OrganisationRestClient organisationRestClient) {
        this.donationRepo = donationRepo;
        this.userRestClient = userRestClient;
        this.organisationRestClient = organisationRestClient;
    }

    @GetMapping
    public List<Donation> getAllDonations() {
        return donationRepo.findAll();
    }
/*
    @GetMapping("/donations/{id}")
    public Donation getDonationById(@PathVariable Long id) {
        Long idUser = 1L;
        Long idOrganisation = 1L;
        Donation donation = donationRepo.findById(id).get();
        User user = userRestClient.getUserById(idUser);
        Organisation organisation = organisationRestClient.getOrganisationById(idOrganisation);
        donation.setIdUser(user.getId());
        donation.setIdOrganisation(organisation.getId());
        return donation;
    }
*/
    @GetMapping("/organisation/{organisationId}")
    public List<Donation> getDonationsByOrganisation(@PathVariable Long idOrganisation) {
        return donationRepo.findByidOrganisation(idOrganisation);
    }
}
