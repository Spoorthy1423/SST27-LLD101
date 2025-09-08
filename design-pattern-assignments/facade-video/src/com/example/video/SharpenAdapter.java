package com.example.video;

import java.util.Objects;

/**
 * SharpenAdapter - adapts LegacySharpen API to work with Frame arrays
 * This adapter implements the Adapter pattern by converting the legacy
 * string-based handle API to work with actual Frame objects
 */
public class SharpenAdapter {
    private final LegacySharpen legacySharpen;
    
    public SharpenAdapter(LegacySharpen legacySharpen) {
        this.legacySharpen = Objects.requireNonNull(legacySharpen, "legacySharpen");
    }
    
    /**
     * Apply sharpen filter to frames using the legacy API
     * @param frames the frames to sharpen
     * @param strength the sharpen strength
     * @return the sharpened frames (in this case, we return the same frames as the legacy API is simulated)
     */
    public Frame[] sharpen(Frame[] frames, int strength) {
        Objects.requireNonNull(frames, "frames");
        if (strength < 0) {
            throw new IllegalArgumentException("Strength must be non-negative");
        }
        
        // Convert frames to a handle string for the legacy API
        String framesHandle = "FRAMES:" + frames.length + ":" + frames[0].w + "x" + frames[0].h;
        
        // Apply sharpen using legacy API
        String resultHandle = legacySharpen.applySharpen(framesHandle, strength);
        
        // In a real implementation, we would convert the result back to frames
        // For this simulation, we return the original frames
        return frames;
    }
}
