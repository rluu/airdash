package io.github.rluu.airdash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.rluu.airdash.model.Chart;

@Repository
public interface ChartRepository extends JpaRepository<Chart, Long> {
    public List<Chart> findAllByUserId(Long userId);

    public List<Chart> findAllByUserIdAndLocationId(Long userId, Long locationId);

    public List<Chart> findAllByUserIdAndLocationIdOrderByUpdateDttmDesc(Long userId, Long locationId);
}
