package io.github.rluu.airdash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.rluu.airdash.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
