
package linerupper;

import edu.wpi.first.smartdashboard.properties.IntegerProperty;
import edu.wpi.first.wpijavacv.WPIColor;
import edu.wpi.first.wpijavacv.WPIColorImage;
import edu.wpi.first.wpijavacv.WPIImage;
import edu.wpi.first.wpijavacv.WPIPoint;

/*
 * @author
 * aaron
 */
public class LinerUpper extends WPICameraExtension {

    private static final String NAME = "Liner Upper";
    
    private IntegerProperty _line_x_pos_top;
    private IntegerProperty _line_x_pos_bottom;
    
    public LinerUpper() {
        _line_x_pos_top = new IntegerProperty(this, "Line X Point Top (px)", 160);
        _line_x_pos_bottom = new IntegerProperty(this, "Line X Point Bottom (px)", 160);
    }
   
    @Override
    public WPIImage processImage(WPIColorImage rawImage)
    {
        WPIPoint p1 = new WPIPoint(_line_x_pos_top.getValue(), 0);
        WPIPoint p2 = new WPIPoint(_line_x_pos_bottom.getValue(), rawImage.getHeight());
        rawImage.drawLine(p1, p2, WPIColor.BLUE, 5);
        
        return rawImage;
    }
    
    public static void main(String[] args) {
       //nothing to see here
    }
}
