package com.sislocacao.adapter.output.repository.jpa;

import com.sislocacao.adapter.output.repository.jpa.entity.ImovelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelJpaRepository extends JpaRepository<ImovelEntity, Long > {
}
