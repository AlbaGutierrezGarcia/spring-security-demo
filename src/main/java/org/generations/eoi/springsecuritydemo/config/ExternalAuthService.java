package org.generations.eoi.springsecuritydemo.config;



import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ExternalAuthService {

    private static final double PROBABILIDAD_EXITO = 0.4;
    private final Random random = new Random();

    public boolean authenticateRandomly(String username, String password) {
        double valor = random.nextDouble();
        return valor <= PROBABILIDAD_EXITO;
    }
}