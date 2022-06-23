package com.senna.backend.controller.impl;

import com.senna.backend.controller.AuthController;
import com.senna.backend.domain.User;
import com.senna.backend.dto.CustomerDTO;
import com.senna.backend.dto.ProviderDTO;
import com.senna.backend.dto.UserDTO;
import com.senna.backend.mapper.CustomerMapper;
import com.senna.backend.mapper.ProviderMapper;
import com.senna.backend.mapper.UserMapper;
import com.senna.backend.security.JwtTokenUtil;
import com.senna.backend.security.UserDetails;
import com.senna.backend.service.CustomerService;
import com.senna.backend.service.ProviderService;
import com.senna.backend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuthControllerImpl implements AuthController {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetails userDetails;
    private final UserService userService;
    private final ProviderService providerService;
    private final AdminService customerService;
    private final UserMapper userMapper;
    private final ProviderMapper providerMapper;
    private final CustomerMapper customerMapper;

    public AuthControllerImpl(JwtTokenUtil jwtTokenUtil, UserDetails userDetails, UserService userService,
            ProviderService providerService, AdminService customerService, UserMapper userMapper,
            ProviderMapper providerMapper, CustomerMapper customerMapper) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetails = userDetails;
        this.userService = userService;
        this.providerService = providerService;
        this.customerService = customerService;
        this.userMapper = userMapper;
        this.providerMapper = providerMapper;
        this.customerMapper = customerMapper;
    }

    @Data
    public static class AuthRequest {
        @NonNull
        private String email;
        @NonNull
        private String password;
    }

    @Data
    @AllArgsConstructor
    public static class AuthResponse {
        private String token;
        private String type;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        System.out.println(request);
        Optional<User> user = userService.checkCredentials(request.getEmail(), request.getPassword());
        String token = jwtTokenUtil.generateToken(userDetails.loadUserByUsername(request.getEmail()));
        System.out.println(token);
        return user.map(value -> ResponseEntity.status(HttpStatus.OK)
                .body(new AuthResponse(token, userService.getUserType(value.getUser_id()))))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/register/provider")
    public HttpStatus registerProvider(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO.getFirst_name());
        User user = userService.save(userMapper.asEntity(userDTO));
        ProviderDTO providerDTO = new ProviderDTO();
        providerDTO.setUser(user);
        providerService.save(providerMapper.asEntity(providerDTO));
        return HttpStatus.CREATED;
    }

    @PostMapping("/register/customer")
    public HttpStatus registerCustomer(@RequestBody UserDTO userDTO) {
        User user = userService.save(userMapper.asEntity(userDTO));
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setUser(user);
        customerService.save(customerMapper.asEntity(customerDTO));
        return HttpStatus.CREATED;
    }
}