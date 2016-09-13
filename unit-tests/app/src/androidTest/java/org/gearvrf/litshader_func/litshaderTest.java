package org.gearvrf.litshader_func;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;

import org.gearvrf.ActivityInstrumentationGVRf;
import org.gearvrf.viewmanager.LitshaderActivity;
import org.gearvrf.viewmanager.TestDefaultGVRViewManager;


/**
 * Created by j.elidelson on 9/18/2015.
 */
public class litshaderTest extends ActivityInstrumentationGVRf {

    public litshaderTest() {
        //super(SceneObjectActivity.class);
    }

    public void testGetInstance() {
        Instrumentation mInstrumentation = getInstrumentation();
        // We register our interest in the activity
        Instrumentation.ActivityMonitor monitor = mInstrumentation.addMonitor(LitshaderActivity.class.getName(), null, false);
        // We launch it
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClassName(mInstrumentation.getTargetContext(), LitshaderActivity.class.getName());
        mInstrumentation.startActivitySync(intent);
        try {
            Thread.sleep(TestDefaultGVRViewManager.DelayTest+4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Activity currentActivity = getInstrumentation().waitForMonitor(monitor);

        assertNotNull(currentActivity);
        // We register our interest in the next activity from the sequence in this use case
        //mInstrumentation.removeMonitor(monitor);
        //monitor = mInstrumentation.addMonitor(YourNextClass.class.getName(), null, false);
    }
}