package ro.gmsoftware.windowsscreensaveranimator.generator;

import ro.gmsoftware.windowsscreensaveranimator.position.NextPositionGenerator;
import ro.gmsoftware.windowsscreensaveranimator.position.RandomPositionGenerator;

public class AnimationGenerator {
    private final int width;
    private final int height;


    public AnimationGenerator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public NextPositionGenerator getNextPositionGenerator() {
        return new RandomPositionGenerator(width, height);
    }


}
