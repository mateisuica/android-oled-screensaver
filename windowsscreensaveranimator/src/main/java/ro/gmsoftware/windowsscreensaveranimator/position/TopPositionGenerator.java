package ro.gmsoftware.windowsscreensaveranimator.position;

import android.graphics.Point;

public class TopPositionGenerator extends AbstractNextPositionGenerator {


    protected TopPositionGenerator(int width, int height) {
        super(width, height);
    }

    @Override
    public Point getNextPosition() {
        int randomWidth = random.nextInt(width);
        return new Point(randomWidth, 0);
    }
}
