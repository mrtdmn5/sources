package com.animaconnected.watch.provider.preferences;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.fitness.SessionType;
import java.util.List;
import java.util.Map;

/* compiled from: PreferenceProvider.kt */
/* loaded from: classes3.dex */
public interface Preferences {
    CommonFlow<Integer> getBrightnessFlow();

    CommonFlow<ColorTheme> getColorThemeFlow();

    CommonFlow<List<WorkoutMetrics>> getMetricsForSessionType(SessionType sessionType);

    AppId getQuickAction();

    CommonFlow<Boolean> getQuickActionFirstShownFlow();

    CommonFlow<AppId> getQuickActionFlow();

    CommonFlow<Map<SessionType, GPSPreferences>> getSessionTypeGPSPreferencesFlow();

    CommonFlow<Integer> getSpeedCalibrationCoefficient();

    void setBrightness(int r1);

    void setColorTheme(ColorTheme colorTheme);

    void setMetricsForSessionType(SessionType sessionType, List<? extends WorkoutMetrics> list);

    void setQuickAction(AppId appId);

    void setSessionTypeGPSPreferences(Map<SessionType, ? extends GPSPreferences> map);
}
