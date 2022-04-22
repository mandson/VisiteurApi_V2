package com.api.Visiteur.repository;

import com.api.Visiteur.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
