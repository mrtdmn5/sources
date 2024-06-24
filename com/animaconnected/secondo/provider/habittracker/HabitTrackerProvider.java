package com.animaconnected.secondo.provider.habittracker;

import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.behaviour.util.VibratorPatterns;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes3.dex */
public class HabitTrackerProvider {
    public static final int MAX_GOAL = 99;
    public static final int MIN_GOAL = 1;
    private static HabitTrackerProvider sInstance;
    private final Set<HabitTrackerChangedListener> mListeners = new CopyOnWriteArraySet();
    private final HabitTrackerStorage mStorage = new HabitTrackerStorage(KronabyApplication.getContext());

    private HabitTrackerProvider() {
    }

    public static HabitTrackerProvider getInstance() {
        if (sInstance == null) {
            sInstance = new HabitTrackerProvider();
        }
        return sInstance;
    }

    private void notifyCountChanged() {
        Iterator<HabitTrackerChangedListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onHabitTrackerCountChanged();
        }
    }

    private void notifyOnboardingChanged() {
        Iterator<HabitTrackerChangedListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onHabitTrackerOnboardingChanged();
        }
    }

    private void resetCount() {
        this.mStorage.setCurrentCount(0);
        notifyCountChanged();
    }

    public void addCount(int r4) {
        if (!isOnboardingDone()) {
            return;
        }
        checkResetInterval();
        int currentCount = this.mStorage.getCurrentCount();
        int goalCount = this.mStorage.getGoalCount();
        if (currentCount < goalCount && currentCount + r4 >= goalCount) {
            ProviderFactory.getWatch().startVibratorWithPattern(VibratorPatterns.getHabitTrackerGoalReached());
        }
        int r0 = currentCount + r4;
        if (r0 > 99) {
            r0 = 99;
        }
        this.mStorage.setCurrentCount(r0);
        notifyCountChanged();
    }

    public void checkResetInterval() {
        Calendar calendar = Calendar.getInstance();
        Calendar lastDateUsed = this.mStorage.getLastDateUsed();
        if (this.mStorage.getResetInterval() != ResetInverval.NEVER && calendar.get(1) != lastDateUsed.get(1)) {
            resetCount();
        } else if (this.mStorage.getResetInterval() == ResetInverval.DAY && calendar.get(6) != lastDateUsed.get(6)) {
            resetCount();
        } else if (this.mStorage.getResetInterval() == ResetInverval.WEEK && calendar.get(3) != lastDateUsed.get(3)) {
            resetCount();
        } else if (this.mStorage.getResetInterval() == ResetInverval.MONTH && calendar.get(2) != lastDateUsed.get(2)) {
            resetCount();
        }
        this.mStorage.setLastDateUsed(calendar);
    }

    public int getCount() {
        return this.mStorage.getCurrentCount();
    }

    public int getGoalCount() {
        return this.mStorage.getGoalCount();
    }

    public String getGoalName() {
        return this.mStorage.getGoalName();
    }

    public ResetInverval getResetInteval() {
        return this.mStorage.getResetInterval();
    }

    public boolean isOnboardingDone() {
        return this.mStorage.getOnboardingDone();
    }

    public void registerHabitTrackerChangedListener(HabitTrackerChangedListener habitTrackerChangedListener) {
        this.mListeners.add(habitTrackerChangedListener);
    }

    public void removeCount(int r2) {
        int currentCount = this.mStorage.getCurrentCount() - r2;
        if (currentCount < 0) {
            currentCount = 0;
        }
        this.mStorage.setCurrentCount(currentCount);
        notifyCountChanged();
    }

    public void resetData() {
        this.mStorage.setGoalName("");
        this.mStorage.setGoalCount(1);
        this.mStorage.setResetInterval(ResetInverval.DAY);
    }

    public void setCount(int r2) {
        this.mStorage.setCurrentCount(r2);
        notifyCountChanged();
    }

    public void setOnboardingDone(boolean z) {
        boolean z2;
        if (isOnboardingDone() != z) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mStorage.setOnboardingDone(z);
        if (z2) {
            notifyOnboardingChanged();
        }
    }

    public void setSetupData(String str, int r3, ResetInverval resetInverval) {
        this.mStorage.setGoalName(str);
        this.mStorage.setGoalCount(r3);
        this.mStorage.setResetInterval(resetInverval);
    }

    public void unregisterHabitTrackerChangedListener(HabitTrackerChangedListener habitTrackerChangedListener) {
        this.mListeners.remove(habitTrackerChangedListener);
    }
}
