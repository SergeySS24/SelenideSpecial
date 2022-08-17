package Experiments;

import org.junit.jupiter.api.Test;

import static utils.RandomUtils.getRandomInt;
import static utils.RandomUtils.getRandomString;

public class Faker2 {


    @Test
    public static void main(String[] args) {
        com.github.javafaker.Faker faker = new com.github.javafaker.Faker();

        for (int i = 0; i < 1500; i++) {
            //System.out.println(getRandomInt(20, 100));
            //System.out.println(getRandomString(3) + getRandomInt(1, 584172345));
            System.out.println("2021-"+ getRandomInt(10, 12) +"-"+ getRandomInt(10, 31)+" "
                    + getRandomInt(10, 23)+":"+ getRandomInt(10, 59)+":"+ "00.0");

        }

    }
}

