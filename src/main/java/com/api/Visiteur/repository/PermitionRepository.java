package com.api.Visiteur.repository;

import com.api.Visiteur.entities.Permition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermitionRepository  extends JpaRepository<Permition,Long> {
}
