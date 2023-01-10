package com.bootcamp.robotikka.robotikkaapi.util;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Generator {
    private static String ALPH = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String generatePrefix(int min, int max) {
        int generatedRand = generateRand(min, max);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < generatedRand; i++) {
            builder.append(ALPH.charAt(new Random().nextInt(ALPH.length() - 1)));
        }
        return builder.toString();
    }

    private int generateRand(int min, int max) { // as an example 10-50
        return new Random().nextInt((max - min) + min) + min;
    }

}
