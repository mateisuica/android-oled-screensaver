package ro.gmsoftware.windowsscreensaveranimator.position;

import android.graphics.Point;

public class RightPositionGenerator extends AbstractNextPositionGenerator {

    protected RightPositionGenerator(int width, int height) {
        super(width, height);
    }

    @Override
    public Point getNextPosition() {
        int randomHeight = random.nextInt(height);
        return new Point(width, randomHeight);
    }
}
