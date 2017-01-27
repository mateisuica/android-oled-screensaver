package ro.gmsoftware.windowsscreensaveranimator.position;

import android.graphics.Point;

public class BottomPositionGenerator extends AbstractNextPositionGenerator {

    protected BottomPositionGenerator(int width, int height) {
        super(width, height);
    }

    @Override
    public Point getNextPosition() {
        int randomWidth = random.nextInt(width);
        return new Point(randomWidth, height);
    }
}
