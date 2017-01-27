package ro.gmsoftware.windowsscreensaveranimator.position;

import android.graphics.Point;

public class RandomPositionGenerator extends AbstractNextPositionGenerator {
    public RandomPositionGenerator(int width, int height) {
        super(width, height);
    }

    @Override
    public Point getNextPosition() {
        return new Point(random.nextInt(width), random.nextInt(height));
    }
}
