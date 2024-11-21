package com.springboot.ems.service;

import com.springboot.ems.model.JwtAuthResponse;
import com.springboot.ems.model.LoginDto;
import com.springboot.ems.model.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);

    JwtAuthResponse login(LoginDto loginDto);
}
