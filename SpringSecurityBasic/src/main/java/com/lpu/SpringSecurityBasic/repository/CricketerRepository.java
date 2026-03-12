package com.lpu.SpringSecurityBasic.repository;

import com.lpu.SpringSecurityBasic.entity.Cricketer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CricketerRepository extends JpaRepository<Cricketer,Integer> {

    Cricketer findByName(String name);
}
