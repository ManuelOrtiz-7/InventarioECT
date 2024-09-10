package com.InventarioECT.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    @GetMapping("/registro")
    public String registro() {
        return "Pagina de registro";
    }

    @GetMapping("/login")
    public String login() {
        return "Pagina de login";
    }

}
