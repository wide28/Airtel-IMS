package com.B4.IMS;

import com.B4.IMS.model.SystemUser;
import com.B4.IMS.repository.SystemUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ImsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImsApplication.class, args);
    }

    // This automatically runs when the application starts
    @Bean
    public CommandLineRunner seedDatabase(SystemUserRepository userRepository) {
        return args -> {
            // Check if admin exists to prevent duplicates
            if (userRepository.findByUsername("24rp01734").isEmpty()) {
                SystemUser admin = new SystemUser();
                admin.setFullName("DUFITUMUCUNGUZI Dieudonne");
                admin.setUsername("24rp01734");
                admin.setPassword("24rp04260");
                admin.setRole("SYSADMIN");
                
                userRepository.save(admin);
                System.out.println("✅ Cloud Admin User successfully injected!");
            }
        };
    }
}