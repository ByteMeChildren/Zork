package org.example;

import java.awt.print.Book;
import java.io.Console;

public class Main {
    public static void main(String[] args) {
        var book = new StoryReader.read();
        var console = new Console();
        var narrator = new StoryTeller(book, console);
        narrator.onceUponATime
    }
}