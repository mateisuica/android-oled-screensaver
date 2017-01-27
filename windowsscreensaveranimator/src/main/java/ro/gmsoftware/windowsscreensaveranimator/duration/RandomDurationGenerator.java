package ro.gmsoftware.windowsscreensaveranimator.duration;

import java.util.Random;

public class RandomDurationGenerator implements DurationGenerator {

    private final Random random = new Random();
    private final int minimum = 1500;
    private final int maximum = 2500;

    @Override
    public int getNextDuration() {
        return random.nextInt(maximum - minimum) + minimum;
    }
}
