package com.animaconnected.secondo.behaviour.workout;

import android.content.Context;
import android.os.Build;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.behaviour.BehaviourPluginKt;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.workout.Workout;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutPlugin.kt */
/* loaded from: classes3.dex */
public final class WorkoutPlugin implements BehaviourPlugin<Workout> {
    public static final int $stable = 8;
    private final String[] requiredPermissions;
    private Workout workout;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Workout>() { // from class: com.animaconnected.secondo.behaviour.workout.WorkoutPlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Workout invoke() {
            Workout workout;
            workout = WorkoutPlugin.this.workout;
            if (workout != null) {
                return workout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("workout");
            throw null;
        }
    });
    private final String type = Workout.TYPE;
    private final int nameId = R.string.workout_name;
    private final int iconResourceId = R.drawable.ic_workout;

    public WorkoutPlugin() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 29) {
            strArr = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"};
        } else {
            strArr = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
        }
        this.requiredPermissions = strArr;
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
    public String[] getRequiredPermissions() {
        return this.requiredPermissions;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public void initBehaviour(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.workout = new Workout(new Function0<Boolean>() { // from class: com.animaconnected.secondo.behaviour.workout.WorkoutPlugin$initBehaviour$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Workout workout;
                WorkoutPlugin workoutPlugin = WorkoutPlugin.this;
                Context context2 = context;
                workout = workoutPlugin.workout;
                if (workout != null) {
                    return Boolean.valueOf(!BehaviourPluginKt.showFeatureIssueNotification(workoutPlugin, context2, workout.getTitle().app()));
                }
                Intrinsics.throwUninitializedPropertyAccessException("workout");
                throw null;
            }
        });
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public WorkoutFragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return WorkoutFragment.Companion.newInstance(slot);
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Workout getBehaviour() {
        return (Workout) this.behaviour$delegate.getValue();
    }
}
