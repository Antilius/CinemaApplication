package GUI.TextPainters;

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

public class TextPainter{
    
    public static int lengthOfStringWithSpecifiedFontInPixels(String s, Font f){
        AffineTransform affinetransform = new AffineTransform();     
        FontRenderContext frc = new FontRenderContext(affinetransform,false,false); 
        return (int)(f.getStringBounds(s, frc).getWidth());
    }
    
    public static int heightOfStringWithSpecifiedFontInPixels(String s, Font f){
        AffineTransform affinetransform = new AffineTransform();     
        FontRenderContext frc = new FontRenderContext(affinetransform,false,false); 
        return (int)(f.getStringBounds(s, frc).getHeight());
    }
    
}

