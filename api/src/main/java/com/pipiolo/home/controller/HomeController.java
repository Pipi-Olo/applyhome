package com.pipiolo.home.controller;

import com.pipiolo.home.domain.Home;
import com.pipiolo.home.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/home")
@Controller
public class HomeController {

    private final HomeService homeService;

    @GetMapping()
    public ModelAndView homes() {
        Map<String, Object> map = new HashMap<>();
        List<Home> homeList = homeService.getHomes();
        map.put("homes", homeList);

        return new ModelAndView("home/index", map);
    }
}
