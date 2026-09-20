package com.labour.placement.repository;

import com.labour.placement.model.Labourer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabourerRepository extends JpaRepository<Labourer, Long> {
    // TODO: Define custom query methods once Entity attributes are set.
}
