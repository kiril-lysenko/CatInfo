package com.self.education.catinfo.repository;

import com.self.education.catinfo.domain.Cats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatsRepository extends JpaRepository<Cats, Long> {
}
