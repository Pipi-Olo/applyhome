package com.pipiolo.home.repository;

import com.pipiolo.home.domain.Home;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HomeRepository extends JpaRepository<Home, Long> {

    Optional<Home> findByNoticeId(Long noticeId);
}