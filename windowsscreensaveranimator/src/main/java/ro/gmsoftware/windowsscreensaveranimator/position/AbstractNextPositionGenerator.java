package ro.gmsoftware.windowsscreensaveranimator.position;

import java.util.Random;

public abstract class AbstractNextPositionGenerator implements NextPositionGenerator {
    final int width;
    final int height;
    final protected Random random = new Random();

    protected AbstractNextPositionGenerator(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
