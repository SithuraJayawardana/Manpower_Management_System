package com.labour.placement.repository;

import com.labour.placement.model.Placement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacementRepository extends JpaRepository<Placement, Long> {
    // TODO: Define custom query methods once Entity attributes are set.
}
