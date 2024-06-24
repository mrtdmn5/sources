package com.animaconnected.secondo.behaviour.habittracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.habittracker.HabitTrackerProvider;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class HabitTrackerOverviewFragment extends Fragment {
    private TextView mCurrentCountAmountTextView;
    private HabitTrackerProvider mHabitTrackerProvider;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        this.mHabitTrackerProvider.addCount(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        this.mHabitTrackerProvider.removeCount(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(View view) {
        this.mHabitTrackerProvider.setCount(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(View view) {
        this.mHabitTrackerProvider.resetData();
        this.mHabitTrackerProvider.setOnboardingDone(false);
    }

    public static Fragment newInstance() {
        return new HabitTrackerOverviewFragment();
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_habit_tracker_overview, viewGroup, false);
        this.mHabitTrackerProvider = HabitTrackerProvider.getInstance();
        this.mCurrentCountAmountTextView = (TextView) inflate.findViewById(R.id.current_count_amount_text_view);
        ((TextView) inflate.findViewById(R.id.habit_title)).setText(String.format("\"%s\"", this.mHabitTrackerProvider.getGoalName()));
        int stringGoalResId = this.mHabitTrackerProvider.getResetInteval().getStringGoalResId();
        TextView textView = (TextView) inflate.findViewById(R.id.reset_interval_text);
        if (stringGoalResId != -1) {
            textView.setText(stringGoalResId);
        } else {
            textView.setVisibility(4);
        }
        inflate.findViewById(R.id.btn_add_count).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.behaviour.habittracker.HabitTrackerOverviewFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HabitTrackerOverviewFragment.this.lambda$onCreateView$0(view);
            }
        });
        inflate.findViewById(R.id.btn_delete_count).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.behaviour.habittracker.HabitTrackerOverviewFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HabitTrackerOverviewFragment.this.lambda$onCreateView$1(view);
            }
        });
        inflate.findViewById(R.id.btn_reset_count).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.behaviour.habittracker.HabitTrackerOverviewFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HabitTrackerOverviewFragment.this.lambda$onCreateView$2(view);
            }
        });
        inflate.findViewById(R.id.btn_delete_habit).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.behaviour.habittracker.HabitTrackerOverviewFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HabitTrackerOverviewFragment.this.lambda$onCreateView$3(view);
            }
        });
        update();
        return inflate;
    }

    public void update() {
        this.mCurrentCountAmountTextView.setText(String.format("%s/%s", Integer.valueOf(this.mHabitTrackerProvider.getCount()), Integer.valueOf(this.mHabitTrackerProvider.getGoalCount())));
    }
}
