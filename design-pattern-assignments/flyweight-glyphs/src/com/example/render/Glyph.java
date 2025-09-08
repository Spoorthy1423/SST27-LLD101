package com.example.render;

public class Glyph {
    // Refactored: use TextStyle flyweight for shared style data
    private final char ch;           // extrinsic state (unique per glyph)
    private final TextStyle style;   // intrinsic state (shared across glyphs)

    public Glyph(char ch, TextStyle style) {
        this.ch = ch;
        this.style = style;
    }

    public int drawCost() { 
        return style.getSize() + (style.isBold() ? 10 : 0); 
    }
    
    public char getCh() { return ch; }
    public TextStyle getStyle() { return style; }
    
    // Convenience methods for backward compatibility
    public String getFont() { return style.getFont(); }
    public int getSize() { return style.getSize(); }
    public boolean isBold() { return style.isBold(); }
}
