package io.github.rluu.airdash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.rluu.airdash.model.DataPointType;

@Repository
public interface DataPointTypeRepository extends JpaRepository<DataPointType, Long> {
    public DataPointType findByName(String name);
}
