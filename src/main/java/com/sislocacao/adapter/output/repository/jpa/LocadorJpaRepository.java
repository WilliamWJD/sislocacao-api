package com.sislocacao.adapter.output.repository.jpa;

import com.sislocacao.adapter.output.repository.jpa.entity.LocadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocadorJpaRepository extends JpaRepository<LocadorEntity, Long > {
}
