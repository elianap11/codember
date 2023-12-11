package org.example;

import org.example.challenges.Challenge_01;
import org.example.challenges.Challenge_02;
import org.example.challenges.Challenge_03;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        Challenge_01 challenge_01 = new Challenge_01();
        challenge_01.searchPatterns();

        Challenge_02 challenge_02 = new Challenge_02();
        challenge_02.miniCompiler();

        Challenge_03 challenge_03 = new Challenge_03();
        challenge_03.validPasswordCounter();

    }
}