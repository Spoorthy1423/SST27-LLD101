package com.example.render;
public class App {
    public static void main(String[] args) {
        Renderer r = new Renderer();
        String text = "Hello Flyweight! ".repeat(2000);
        int cost = r.render(text);
        int cacheSize = r.getStyleCacheSize();
        
        System.out.println("Cost=" + cost);
        System.out.println("Style cache size=" + cacheSize + " (should be 2: Inter|14|R and Inter|14|B)");
        System.out.println("Text length=" + text.length() + " characters");
        System.out.println("Memory efficiency: " + text.length() + " glyphs use only " + cacheSize + " style objects");
    }
}
