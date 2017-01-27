package ro.gmsoftware.windowsscreensaveranimator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.util.Log;
import android.view.View;

import ro.gmsoftware.windowsscreensaveranimator.duration.DurationGenerator;
import ro.gmsoftware.windowsscreensaveranimator.duration.RandomDurationGenerator;
import ro.gmsoftware.windowsscreensaveranimator.generator.AnimationGenerator;
import ro.gmsoftware.windowsscreensaveranimator.position.NextPositionGenerator;


public class LogoAnimator {

    private final static String TAG = LogoAnimator.class.getSimpleName();
    private final DurationGenerator randomDurationGenerator = new RandomDurationGenerator();

    private final View surfaceView;
    private AnimationGenerator animationGenerator;
    private final int screenwidth;
    private final int screenhgt;

    public LogoAnimator(final int screenwidth, final int screenhgt, final View surfaceView) {
        this.surfaceView = surfaceView;
        this.screenwidth = screenwidth;
        this.screenhgt = screenhgt;

        requerySize();
        animationGenerator = new AnimationGenerator(screenwidth, screenhgt);
    }

    private void requerySize() {
        Log.d(TAG, "RequerySize");
        surfaceView.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(surfaceView.getWidth() != 0) {
                    animationGenerator = new AnimationGenerator(screenwidth - surfaceView.getWidth(), screenhgt - surfaceView.getHeight());
                    Log.d(TAG, "Screen Width: " + screenwidth + " Height: " + screenhgt);
                    Log.d(TAG, "Image Width: " + surfaceView.getWidth() + " Height: " + surfaceView.getHeight());
                    Log.d(TAG, "Random bounds Width: " + (screenwidth - surfaceView.getWidth()) + " Height: " + (screenhgt - surfaceView.getHeight()));
                } else {
                    requerySize();
                }
            }
        }, 500);
    }


    public void animate() {
        final AnimatorSet mAnimatorSet = new AnimatorSet();
        final NextPositionGenerator nextPositionGenerator = animationGenerator.getNextPositionGenerator();
        Point initialPosition = nextPositionGenerator.getNextPosition();
        Point nextPosition = nextPositionGenerator.getNextPosition();
        mAnimatorSet.playTogether(ObjectAnimator.ofFloat(surfaceView, "x", initialPosition.x, nextPosition.x),
                ObjectAnimator.ofFloat(surfaceView, "y", initialPosition.y, nextPosition.y), ObjectAnimator.ofFloat(surfaceView, "rotation", 0));

        mAnimatorSet.setDuration(randomDurationGenerator.getNextDuration());
        mAnimatorSet.start();
        mAnimatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                final NextPositionGenerator nextPositionGenerator = animationGenerator.getNextPositionGenerator();
                Point nextPosition = nextPositionGenerator.getNextPosition();
                mAnimatorSet.playTogether(ObjectAnimator.ofFloat(surfaceView, "x", surfaceView.getX(), nextPosition.x),
                        ObjectAnimator.ofFloat(surfaceView, "y", surfaceView.getY(), nextPosition.y));

                mAnimatorSet.setDuration(randomDurationGenerator.getNextDuration());
                mAnimatorSet.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
