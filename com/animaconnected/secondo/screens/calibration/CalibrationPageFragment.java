package com.animaconnected.secondo.screens.calibration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.watch.device.WatchFace;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CalibrationPageFragment.kt */
/* loaded from: classes3.dex */
public final class CalibrationPageFragment extends Fragment {
    public static final int $stable = 0;
    public static final String CALIBRATION_DESCRIPTION_KEY = "calibration_desc_key";
    public static final Companion Companion = new Companion(null);
    public static final String HAND_KEY = "hand_key";
    public static final String HAS_ONBOARDING_STYLE_KEY = "has_onboarding_style_key";
    public static final String SPEED_MULTIPLIER_KEY = "speed_multiplier_key";
    public static final String WATCH_FACE_KEY = "watch_face_key";

    /* compiled from: CalibrationPageFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CalibrationPageFragment create() {
            return new CalibrationPageFragment();
        }

        private Companion() {
        }
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    public final int getHand() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getInt(HAND_KEY);
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final float getSpeedMultiplier() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getFloat(SPEED_MULTIPLIER_KEY);
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final WatchFace getWatchFace() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            WatchFace watchFace = (WatchFace) arguments.getSerializable(WATCH_FACE_KEY);
            if (watchFace == null) {
                return WatchFace.Main;
            }
            return watchFace;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        int r0;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.getBoolean(HAS_ONBOARDING_STYLE_KEY)) {
                r0 = R.layout.fragment_calibration_page_fragment_onboarding;
            } else {
                r0 = R.layout.fragment_calibration_page_fragment_settings;
            }
            View inflate = inflater.inflate(r0, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.calibration_description)).setText(arguments.getString(CALIBRATION_DESCRIPTION_KEY));
            return inflate;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
