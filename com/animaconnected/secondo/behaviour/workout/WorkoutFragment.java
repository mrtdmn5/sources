package com.animaconnected.secondo.behaviour.workout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.secondo.screens.details.BaseDetailsFragmentKt;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.workout.Workout;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutFragment.kt */
/* loaded from: classes3.dex */
public final class WorkoutFragment extends BaseDetailsFragment {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);

    /* compiled from: WorkoutFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WorkoutFragment newInstance(Slot slot) {
            WorkoutFragment workoutFragment = new WorkoutFragment();
            Bundle bundle = new Bundle();
            BaseDetailsFragmentKt.putSlot(bundle, workoutFragment.getSLOT(), slot);
            bundle.putString(workoutFragment.getTYPE(), Workout.TYPE);
            workoutFragment.setArguments(bundle);
            return workoutFragment;
        }

        private Companion() {
        }
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_details_workout, viewGroup, false);
    }
}
