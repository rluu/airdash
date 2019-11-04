package io.github.rluu.airdash.repository;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.rluu.airdash.model.DataPoint;

@Repository
public interface DataPointRepository extends JpaRepository<DataPoint, Long> {

    public List<DataPoint> findAllByChartId(Long chartId);

    public List<DataPoint> findAllByChartIdAndAcquireDttmBetween(Long chartId, ZonedDateTime startTime, ZonedDateTime endTime);

    public List<DataPoint> findAllByChartIdAndAcquireDttmAfter(Long chartId, ZonedDateTime startTime);
}
