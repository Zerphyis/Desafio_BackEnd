package com.Zerphyis.projects.contas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryConta extends JpaRepository<ContaUsarios,Long> {
}
