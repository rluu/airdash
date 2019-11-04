package io.github.rluu.airdash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.rluu.airdash.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    public Location findByName(String name);
}
