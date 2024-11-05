package br.com.fujideia.iesp.tecback.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/cache")
@RequiredArgsConstructor
public class CacheController {
    private final CacheManager cacheManager;

    @GetMapping
    @Cacheable("CACHE_HELLO")
    public String hello(){
        log.info("Hello");
        return "Texto Hello";
    }
}
