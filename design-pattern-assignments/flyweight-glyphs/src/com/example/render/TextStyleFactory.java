package com.example.render;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Objects;

/**
 * TextStyleFactory - factory for creating and caching TextStyle instances (Flyweight pattern)
 * This factory ensures that identical style configurations reuse the same TextStyle instance
 */
public class TextStyleFactory {
    private static final TextStyleFactory INSTANCE = new TextStyleFactory();
    private final Map<String, TextStyle> cache = new ConcurrentHashMap<>();
    
    private TextStyleFactory() {}
    
    public static TextStyleFactory getInstance() {
        return INSTANCE;
    }
    
    /**
     * Get or create a TextStyle instance
     * @param font the font name
     * @param size the font size
     * @param bold whether the text is bold
     * @return a TextStyle instance (cached if possible)
     */
    public TextStyle getTextStyle(String font, int size, boolean bold) {
        Objects.requireNonNull(font, "font");
        
        // Create cache key as suggested in hints: "Inter|14|B"
        String key = font + "|" + size + "|" + (bold ? "B" : "R");
        
        // Return cached instance or create and cache new one
        return cache.computeIfAbsent(key, k -> new TextStyle(font, size, bold));
    }
    
    /**
     * Get the number of cached TextStyle instances
     * @return cache size
     */
    public int getCacheSize() {
        return cache.size();
    }
}
