package org.gearvrf.animation;

import org.gearvrf.ActivityInstrumentationGVRf;
import org.gearvrf.GVRHybridObject;
import org.gearvrf.viewmanager.TestDefaultGVRViewManager;

import org.gearvrf.GVRSceneObject;

/**
 * Created by Douglas on 2/28/15.
 */
public class GVRRotationByAxisAnimationTest extends ActivityInstrumentationGVRf {

    public void testCreateGVRRotationByAxisAnimationObject() {
        GVRSceneObject sceneObject = new GVRSceneObject(TestDefaultGVRViewManager.mGVRContext);
        new GVRRotationByAxisAnimation(sceneObject, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f);
    }

    public void testStartAnimationEngine() {
        GVRAnimationEngine animationEngine = TestDefaultGVRViewManager.mGVRContext.getAnimationEngine();
        GVRSceneObject sceneObject = new GVRSceneObject(TestDefaultGVRViewManager.mGVRContext);
        new GVRRotationByAxisAnimation
                (sceneObject, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f).start(animationEngine);
    }

    public void testFinishedAnimation() {

        GVRSceneObject sceneObject = new GVRSceneObject(TestDefaultGVRViewManager.mGVRContext);
        new GVRRotationByAxisAnimation
                (sceneObject, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f).setOnFinish(new GVROnFinish() {
            @Override
            public void finished(GVRAnimation animation) {
                assertNotNull(animation);
            }
        });
    }

    public void testGetElapsedTime() {
        GVRSceneObject sceneObject = new GVRSceneObject(TestDefaultGVRViewManager.mGVRContext);
        assertNotNull(new GVRRotationByAxisAnimation
                (sceneObject, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f).getElapsedTime());
    }

    public void testSetInterpolator() {

        GVRSceneObject sceneObject = new GVRSceneObject(TestDefaultGVRViewManager.mGVRContext);
        new GVRRotationByAxisAnimation
                (sceneObject, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f).setInterpolator(new GVRInterpolator() {
            @Override
            public float mapRatio(float ratio) {

                assertNotNull(ratio);
                return 0;
            }
        });
    }

    public void testRepeatMode() {
        GVRSceneObject sceneObject = new GVRSceneObject(TestDefaultGVRViewManager.mGVRContext);
        new GVRRotationByAxisAnimation
                (sceneObject, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f).setRepeatMode(2);
        assertEquals(new GVRRotationByAxisAnimation
                (sceneObject, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f).getRepeatCount(), 2);
    }

    public void testGetDurationAnimation() {
        GVRSceneObject sceneObject = new GVRSceneObject(TestDefaultGVRViewManager.mGVRContext);
        assertNotNull(new GVRRotationByAxisAnimation
                (sceneObject, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f).getDuration());
    }

}
