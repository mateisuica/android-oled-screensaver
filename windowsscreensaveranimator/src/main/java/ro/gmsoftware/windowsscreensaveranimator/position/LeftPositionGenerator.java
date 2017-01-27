package ro.gmsoftware.windowsscreensaveranimator.position;

import android.graphics.Point;

public class LeftPositionGenerator extends AbstractNextPositionGenerator {

    protected LeftPositionGenerator(int width, int height) {
        super(width, height);
    }

    @Override
    public Point getNextPosition() {
        int randomHeight = random.nextInt(height);
        return new Point(0, randomHeight);
    }
}
