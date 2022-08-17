package Experiments;

import org.junit.jupiter.api.Test;

public class Faker1 {


    @Test
    public static void main(String[] args) {
        com.github.javafaker.Faker faker = new com.github.javafaker.Faker();

        for (int i = 0; i < 100; i++) {
            System.out.println("" + i + ": " + faker.internet().macAddress());
        }

    }
}

