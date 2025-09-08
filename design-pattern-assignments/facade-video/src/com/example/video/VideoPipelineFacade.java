package com.example.video;

import java.nio.file.Path;
import java.util.Objects;

/**
 * VideoPipelineFacade - provides a simplified interface for video processing pipeline
 * This facade hides the complexity of orchestrating Decoder, FilterEngine, Encoder, and SharpenAdapter
 */
public class VideoPipelineFacade {
    private final Decoder decoder;
    private final FilterEngine filterEngine;
    private final Encoder encoder;
    private final SharpenAdapter sharpenAdapter;
    
    public VideoPipelineFacade() {
        this.decoder = new Decoder();
        this.filterEngine = new FilterEngine();
        this.encoder = new Encoder();
        this.sharpenAdapter = new SharpenAdapter(new LegacySharpen());
    }
    
    /**
     * Process a video file through the complete pipeline
     * @param src the source video file path
     * @param out the output video file path
     * @param gray whether to apply grayscale filter
     * @param scale the scale factor (null to skip scaling)
     * @param sharpenStrength the sharpen strength (null to skip sharpening)
     * @return the output file path
     */
    public Path process(Path src, Path out, boolean gray, Double scale, Integer sharpenStrength) {
        Objects.requireNonNull(src, "src");
        Objects.requireNonNull(out, "out");
        
        // Step 1: Decode the video
        Frame[] frames = decoder.decode(src);
        
        // Step 2: Apply grayscale filter if requested
        if (gray) {
            frames = filterEngine.grayscale(frames);
        }
        
        // Step 3: Apply scaling if requested
        if (scale != null) {
            frames = filterEngine.scale(frames, scale);
        }
        
        // Step 4: Apply sharpen filter if requested
        if (sharpenStrength != null) {
            frames = sharpenAdapter.sharpen(frames, sharpenStrength);
        }
        
        // Step 5: Encode the processed frames
        return encoder.encode(frames, out);
    }
}
