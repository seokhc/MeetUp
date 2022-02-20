package com.meetup.meetup.moims.repository;

import com.meetup.meetup.moims.domain.Moim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoimRepository extends JpaRepository<Moim, Long> {
}
