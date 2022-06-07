package com.tia.portfolio.api;

import com.tia.portfolio.api.profile.entity.PfLandUserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PfLandUserProfileRepository extends JpaRepository<PfLandUserProfile, Integer> {
}