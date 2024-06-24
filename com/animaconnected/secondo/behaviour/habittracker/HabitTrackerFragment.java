package com.animaconnected.secondo.behaviour.habittracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.habittracker.HabitTrackerChangedListener;
import com.animaconnected.secondo.provider.habittracker.HabitTrackerProvider;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.watch.Slot;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HabitTrackerFragment.kt */
/* loaded from: classes3.dex */
public final class HabitTrackerFragment extends BaseDetailsFragment implements HabitTrackerChangedListener {
    private Fragment currentFragment;
    private HabitTrackerProvider habitTrackerProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: HabitTrackerFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HabitTrackerFragment newInstance(Slot slot) {
            HabitTrackerFragment habitTrackerFragment = new HabitTrackerFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("slot", slot);
            bundle.putString("type", HabitTracker.TYPE);
            habitTrackerFragment.setArguments(bundle);
            return habitTrackerFragment;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0009, code lost:            if (r0.isOnboardingDone() == true) goto L8;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void updateContent() {
        /*
            r4 = this;
            com.animaconnected.secondo.provider.habittracker.HabitTrackerProvider r0 = r4.habitTrackerProvider
            if (r0 == 0) goto Lc
            boolean r0 = r0.isOnboardingDone()
            r1 = 1
            if (r0 != r1) goto Lc
            goto Ld
        Lc:
            r1 = 0
        Ld:
            if (r1 == 0) goto L14
            androidx.fragment.app.Fragment r0 = com.animaconnected.secondo.behaviour.habittracker.HabitTrackerOverviewFragment.newInstance()
            goto L18
        L14:
            androidx.fragment.app.Fragment r0 = com.animaconnected.secondo.behaviour.habittracker.HabitTrackerOnboardingFragment.newInstance()
        L18:
            r4.currentFragment = r0
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            if (r0 == 0) goto L23
            com.animaconnected.secondo.utils.ActivityUtilsKt.hideKeyboard(r0)
        L23:
            androidx.fragment.app.FragmentManager r0 = r4.getParentFragmentManager()
            androidx.fragment.app.BackStackRecord r0 = androidx.fragment.app.DialogFragment$$ExternalSyntheticOutline0.m(r0, r0)
            androidx.fragment.app.Fragment r1 = r4.currentFragment
            java.lang.String r2 = "null cannot be cast to non-null type androidx.fragment.app.Fragment"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            r2 = 0
            r3 = 2131427800(0x7f0b01d8, float:1.8477226E38)
            r0.replace(r3, r1, r2)
            r0.commit()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.habittracker.HabitTrackerFragment.updateContent():void");
    }

    private final void updateOverviewUi() {
        Fragment fragment = this.currentFragment;
        if (fragment instanceof HabitTrackerOverviewFragment) {
            Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.animaconnected.secondo.behaviour.habittracker.HabitTrackerOverviewFragment");
            ((HabitTrackerOverviewFragment) fragment).update();
        }
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.habitTrackerProvider = HabitTrackerProvider.getInstance();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_details_habit_tracker, viewGroup, false);
        updateContent();
        return inflate;
    }

    @Override // com.animaconnected.secondo.provider.habittracker.HabitTrackerChangedListener
    public void onHabitTrackerCountChanged() {
        updateOverviewUi();
    }

    @Override // com.animaconnected.secondo.provider.habittracker.HabitTrackerChangedListener
    public void onHabitTrackerOnboardingChanged() {
        updateContent();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        HabitTrackerProvider habitTrackerProvider = this.habitTrackerProvider;
        if (habitTrackerProvider != null) {
            habitTrackerProvider.unregisterHabitTrackerChangedListener(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        HabitTrackerProvider habitTrackerProvider = this.habitTrackerProvider;
        if (habitTrackerProvider != null) {
            habitTrackerProvider.registerHabitTrackerChangedListener(this);
        }
        HabitTrackerProvider habitTrackerProvider2 = this.habitTrackerProvider;
        if (habitTrackerProvider2 != null) {
            habitTrackerProvider2.checkResetInterval();
        }
        updateOverviewUi();
    }
}
