package com.animaconnected.secondo.screens;

import com.animaconnected.secondo.screens.debugtesting.DebugTestingFragment;
import com.animaconnected.secondo.screens.settings.SettingsFragment;

/* loaded from: classes3.dex */
public final class FragmentFactory {
    private FragmentFactory() {
    }

    public static BaseFragment getDebugTestingFragment() {
        return DebugTestingFragment.newInstance();
    }

    public static BaseFragment getSettingsFragment() {
        return SettingsFragment.newInstance();
    }
}
