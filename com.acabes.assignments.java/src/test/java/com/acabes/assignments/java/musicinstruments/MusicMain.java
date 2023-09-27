package com.acabes.assignments.java.musicinstruments;

abstract class Instrument{
    abstract void tune();
    abstract void play();
}

class Guitar extends Instrument{
    @Override
    void tune() {
        System.out.println("Tuning the guitar...");
    }

    @Override
    void play() {
        System.out.println("Playing the guitar...");
    }
}

class Violin extends Instrument{

    @Override
    void tune() {
        System.out.println("Tuning the violin...");
    }

    @Override
    void play() {
        System.out.println("Playing the violin..");
    }
}
public class MusicMain {
    public static void main(String[] args) {
        Guitar guitar = new Guitar();
        Violin violin = new Violin();

        guitar.tune();
        guitar.play();
        violin.tune();
        violin.play();
    }
}
