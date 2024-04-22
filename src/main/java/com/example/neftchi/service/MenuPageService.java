package com.example.neftchi.service;

import com.example.neftchi.repository.MenuPageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuPageService {

    private final MenuPageRepository menuPageRepository;


}