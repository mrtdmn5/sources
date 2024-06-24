package com.animaconnected.secondo.screens.calibration;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.calibration.CalibrationWheelView;
import com.animaconnected.watch.BaseWatchProviderListener;
import com.animaconnected.watch.behaviour.util.VibratorPatterns;
import com.animaconnected.watch.device.Capabilities;
import com.animaconnected.watch.device.WatchFace;
import com.animaconnected.watch.device.WatchFacePosition;
import com.kronaby.watch.app.R;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CalibrationPresenter.kt */
/* loaded from: classes3.dex */
public final class CalibrationPresenter extends BaseWatchProviderListener implements CalibrationWheelView.WheelListener {
    private static final String ACTION_CALIBRATION = "calibration";
    private static final int MAX_CALIBRATION_CONNECTION_INTERVAL = 100;
    private static final int MIN_INTERVAL_BETWEEN_CALIBRATION_VIBRATIONS = 800;
    private final CalibrationCalculator calibrationCalculator;
    private final Context context;
    private final boolean hasOnboardingStyle;
    private long lastTouchTimestamp;
    private final CalibrationView view;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: CalibrationPresenter.kt */
    /* loaded from: classes3.dex */
    public interface CalibrationView {
        void deviceTimeout();

        void displayProgress(boolean z);

        void setPagerData(List<CalibrationPageFragment> list);
    }

    /* compiled from: CalibrationPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public CalibrationPresenter(Context context, CalibrationView view, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        this.context = context;
        this.view = view;
        this.hasOnboardingStyle = z;
        this.calibrationCalculator = new CalibrationCalculator();
    }

    private final CalibrationPageFragment createCalibrationPageFragment(int r4, WatchFace watchFace, int r6, float f) {
        CalibrationPageFragment create = CalibrationPageFragment.Companion.create();
        Bundle bundle = new Bundle();
        bundle.putString(CalibrationPageFragment.CALIBRATION_DESCRIPTION_KEY, this.context.getResources().getString(r4));
        bundle.putSerializable(CalibrationPageFragment.WATCH_FACE_KEY, watchFace);
        bundle.putInt(CalibrationPageFragment.HAND_KEY, r6);
        bundle.putFloat(CalibrationPageFragment.SPEED_MULTIPLIER_KEY, f);
        bundle.putBoolean(CalibrationPageFragment.HAS_ONBOARDING_STYLE_KEY, this.hasOnboardingStyle);
        create.setArguments(bundle);
        return create;
    }

    public static /* synthetic */ CalibrationPageFragment createCalibrationPageFragment$default(CalibrationPresenter calibrationPresenter, int r1, WatchFace watchFace, int r3, float f, int r5, Object obj) {
        if ((r5 & 8) != 0) {
            f = 1.0f;
        }
        return calibrationPresenter.createCalibrationPageFragment(r1, watchFace, r3, f);
    }

    private final void onCalibratePossible(boolean z) {
        this.view.displayProgress(z);
    }

    private final List<CalibrationPageFragment> pagerData() {
        ListBuilder listBuilder = new ListBuilder();
        Capabilities capabilities = ProviderFactory.getWatch().getCapabilities();
        Map<WatchFace, Capabilities.WatchFaceData> watchFaces = capabilities.getWatchFaces();
        WatchFace watchFace = WatchFace.Main;
        Capabilities.WatchFaceData watchFaceData = watchFaces.get(watchFace);
        Intrinsics.checkNotNull(watchFaceData);
        int size = watchFaceData.getHands().size();
        if (size != 1) {
            if (size == 2) {
                listBuilder.add(createCalibrationPageFragment$default(this, R.string.calibration_description_main_minute, watchFace, 1, 0.0f, 8, null));
                listBuilder.add(createCalibrationPageFragment$default(this, R.string.calibration_description_main_hour, watchFace, 0, 0.0f, 8, null));
            }
        } else {
            listBuilder.add(createCalibrationPageFragment$default(this, R.string.calibration_description_main_both, watchFace, 0, 0.0f, 8, null));
        }
        Map<WatchFace, Capabilities.WatchFaceData> watchFaces2 = capabilities.getWatchFaces();
        WatchFace watchFace2 = WatchFace.FirstSubdial;
        Capabilities.WatchFaceData watchFaceData2 = watchFaces2.get(watchFace2);
        Map<WatchFace, Capabilities.WatchFaceData> watchFaces3 = capabilities.getWatchFaces();
        WatchFace watchFace3 = WatchFace.SecondSubdial;
        Capabilities.WatchFaceData watchFaceData3 = watchFaces3.get(watchFace3);
        if (watchFaceData2 != null) {
            if (watchFaceData2.getPosition() == WatchFacePosition.BottomCenter) {
                if (watchFaceData2.getHands().size() == 1) {
                    listBuilder.add(createCalibrationPageFragment$default(this, R.string.calibration_description_complication, watchFace2, 0, 0.0f, 8, null));
                } else if (watchFaceData2.getHands().size() == 2) {
                    listBuilder.add(createCalibrationPageFragment$default(this, R.string.calibration_description_complication_minute, watchFace2, 1, 0.0f, 8, null));
                    listBuilder.add(createCalibrationPageFragment$default(this, R.string.calibration_description_complication_hour, watchFace2, 0, 0.0f, 8, null));
                }
            } else if (watchFaceData2.getPosition() == WatchFacePosition.BottomRight && watchFaceData3 != null && watchFaceData3.getPosition() == WatchFacePosition.BottomLeft) {
                listBuilder.add(createCalibrationPageFragment$default(this, R.string.calibration_description_complication_right, watchFace2, 0, 0.0f, 8, null));
                listBuilder.add(createCalibrationPageFragment$default(this, R.string.calibration_description_complication_left, watchFace3, 0, 0.0f, 8, null));
            }
        }
        return CollectionsKt__CollectionsKt.build(listBuilder);
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onCalibrationTimeout() {
        this.view.deviceTimeout();
    }

    @Override // com.animaconnected.secondo.screens.calibration.CalibrationWheelView.WheelListener
    public void onCalibrationWheelTouched() {
        if (!ProviderFactory.createBluetoothOnboardingProvider().isOnboardingFinished()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - this.lastTouchTimestamp > 800) {
                ProviderFactory.getWatch().startVibratorWithPattern(VibratorPatterns.getCalibrationWheelTouch());
            }
            this.lastTouchTimestamp = uptimeMillis;
        }
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener, com.animaconnected.watch.device.WatchEventListener
    public void onConnIntChange(int r1, int r2, int r3) {
        if (r1 <= 100) {
            onCalibratePossible(true);
            ProviderFactory.getAppAnalytics().sendAction(ACTION_CALIBRATION);
        } else {
            onCalibratePossible(false);
        }
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onConnectionChanged(boolean z) {
        if (!z) {
            onCalibratePossible(false);
        }
    }

    @Override // com.animaconnected.secondo.screens.calibration.CalibrationWheelView.WheelListener
    public void onNewCalibrationReached(double d) {
        this.calibrationCalculator.onNewAngle(d);
    }

    public final void onPause() {
        ProviderFactory.getWatch().unregisterListener(this);
        ProviderFactory.getWatch().setCalibrationMode(false);
    }

    public final void onResume() {
        ProviderFactory.getWatch().registerListener(this);
        boolean z = true;
        ProviderFactory.getWatch().setCalibrationMode(true);
        if (ProviderFactory.getWatch().getCurrentConnInt() > 100) {
            z = false;
        }
        onCalibratePossible(z);
    }

    public final void onUIReady() {
        this.view.setPagerData(pagerData());
    }

    public final void setWatchFaceAndHand(WatchFace watchFace, int r3, float f) {
        Intrinsics.checkNotNullParameter(watchFace, "watchFace");
        this.calibrationCalculator.setNewCalibrationState(watchFace, r3, f);
    }
}
