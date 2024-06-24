package com.animaconnected.secondo.behaviour.habittracker;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.provider.habittracker.HabitTrackerProvider;
import com.animaconnected.watch.Slot;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HabitTrackerPlugin.kt */
/* loaded from: classes3.dex */
public final class HabitTrackerPlugin implements BehaviourPlugin<HabitTracker> {
    public static final int $stable = 8;
    private final HabitTracker behaviour;
    private final int configurationDescription;
    private HabitTracker habitTracker;
    private final int iconResourceId;
    private final int nameId;
    private final String type;

    public HabitTrackerPlugin() {
        HabitTracker habitTracker = new HabitTracker();
        this.habitTracker = habitTracker;
        this.behaviour = habitTracker;
        this.type = HabitTracker.TYPE;
        this.nameId = R.string.behaviour_name_habit_tracker;
        this.configurationDescription = R.layout.dialog_habit_tracker;
        this.iconResourceId = R.drawable.ic_habit_tracker;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Fragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return HabitTrackerFragment.Companion.newInstance(slot);
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getConfigurationDescription() {
        return this.configurationDescription;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getIconResourceId() {
        return this.iconResourceId;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getNameId() {
        return this.nameId;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public void initBehaviour(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public boolean isConfigured() {
        return HabitTrackerProvider.getInstance().isOnboardingDone();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public HabitTracker getBehaviour() {
        return this.behaviour;
    }
}
