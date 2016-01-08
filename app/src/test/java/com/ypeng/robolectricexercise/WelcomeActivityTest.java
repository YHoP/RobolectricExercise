package com.ypeng.robolectricexercise;


import android.content.Intent;

import com.ypeng.robolectricexercise.login.LoginActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(RobolectricTestRunner.class)
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk=21)
public class WelcomeActivityTest {

    private WelcomeActivity mActivity;

    @Before
    public void setup() throws Exception {
        mActivity = Robolectric.setupActivity(WelcomeActivity.class);
    }

    @Test
    public void clickingLogin_shouldStartLoginActivity() throws Exception {
        mActivity.findViewById(R.id.login).performClick();

        Intent expectedIntent = new Intent(mActivity, LoginActivity.class);
        assertThat(Shadows.shadowOf(mActivity).getNextStartedActivity()).isEqualTo(expectedIntent);
    }
}