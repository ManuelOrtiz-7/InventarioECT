package com.InventarioECT;

import com.InventarioECT.entity.ERole;
import com.InventarioECT.entity.Role;
import com.InventarioECT.entity.Usuario;
import com.InventarioECT.repository.IRole;
import com.InventarioECT.repository.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class InventarioEctApplication {

	public static void main(String[] args) {

		SpringApplication.run(InventarioEctApplication.class, args);
	}

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	IUsuario iUsuario;

	@Bean
	CommandLineRunner init(){
		return args -> {
			Usuario usuario = Usuario.builder()
					.nombreUsuario("Manuel Arnoldo")
					.apellidoUsuario("Ortiz Reyes")
					.email("manuel.ortiz@tecnomusic.co")
					.username("manuel.ortiz")
					.password(passwordEncoder.encode("12345"))
					.roles(Set.of(Role.builder()
							.nombreRol(ERole.valueOf(ERole.SUPER_ADMIN.name()))
							.build()))
					.build();

			Usuario usuario1 = Usuario.builder()
					.nombreUsuario("Juan Diego")
					.apellidoUsuario("Castillo Ortiz")
					.email("archivo@tecnomusic.co")
					.username("juan.diego")
					.password(passwordEncoder.encode("54321"))
					.roles(Set.of(Role.builder()
							.nombreRol(ERole.valueOf(ERole.ADMIN.name()))
							.build()))
					.build();

			Usuario usuario2 = Usuario.builder()
					.nombreUsuario("Juan David")
					.apellidoUsuario("Fernandez")
					.email("juandavid@tecnomusic.co")
					.username("juan.david")
					.password(passwordEncoder.encode("13579"))
					.roles(Set.of(Role.builder()
							.nombreRol(ERole.valueOf(ERole.USER.name()))
							.build()))
					.build();

			iUsuario.save(usuario);
			iUsuario.save(usuario1);
			iUsuario.save(usuario2);
		};
	}
}
