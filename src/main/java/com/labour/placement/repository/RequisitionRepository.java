package com.labour.placement.repository;

import com.labour.placement.model.Requisition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisitionRepository extends JpaRepository<Requisition, Long> {
    // TODO: Define custom query methods once Entity attributes are set.
}
