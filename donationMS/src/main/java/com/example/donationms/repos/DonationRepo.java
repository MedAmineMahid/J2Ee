package com.example.donationms.repos;

import com.example.donationms.entities.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonationRepo extends JpaRepository<Donation,Long> {
    List<Donation> findByidOrganisation(Long idorganisation);
}
