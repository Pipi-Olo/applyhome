package com.pipiolo.home.service;

import com.pipiolo.home.domain.Home;
import com.pipiolo.home.dto.HomeRequest;
import com.pipiolo.home.repository.HomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class HomeService {

    private final HomeRepository homeRepository;

    @Transactional
    public void upsert(HomeRequest request) {
        Home home = homeRepository.findByNoticeId(request.getNoticeId())
                .orElseGet(() -> Home.from(request));

        home.update(request);
        homeRepository.save(home);
    }
}
