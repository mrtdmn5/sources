package com.animaconnected.secondo.behaviour.habittracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.habittracker.HabitTrackerProvider;
import com.animaconnected.secondo.provider.habittracker.ResetInverval;
import com.animaconnected.secondo.screens.pickerdialog.PickerDialogFragment;
import com.animaconnected.secondo.screens.pickerdialog.PickerDialogFragmentCallback;
import com.kronaby.watch.app.R;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class HabitTrackerOnboardingFragment extends Fragment implements PickerDialogFragmentCallback {
    private static final int RESET_INTERVAL_DIALOG_ID = 2;
    private static final int SET_GOAL_DIALOG_ID = 1;
    private int mGoalValueIndex;
    private ArrayList<String> mGoalValues;
    private EditText mHabitNameEditText;
    private HabitTrackerProvider mHabitTrackerProvider;
    private int mResetIntervalValueIndex;
    private ArrayList<String> mResetIntervalValues;
    private TextView mSetGoalValueTextView;
    private TextView mSetResetIntervalValueTextView;

    private String getGoalName() {
        String obj = this.mHabitNameEditText.getText().toString();
        if (obj.isEmpty()) {
            return getString(R.string.behaviour_habit_tracker_onboarding_name_hint);
        }
        return obj;
    }

    private void initPickerValues() {
        this.mGoalValues = new ArrayList<>();
        for (int r0 = 1; r0 <= 99; r0++) {
            this.mGoalValues.add(String.valueOf(r0));
        }
        this.mGoalValueIndex = this.mGoalValues.indexOf(String.valueOf(this.mHabitTrackerProvider.getGoalCount()));
        this.mResetIntervalValues = ResetInverval.getResetIntervalStrings(getContext());
        this.mResetIntervalValueIndex = ResetInverval.getIndexOf(this.mHabitTrackerProvider.getResetInteval().getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        this.mHabitNameEditText.clearFocus();
        showSetGoalDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        this.mHabitNameEditText.clearFocus();
        showSetResetIntervalDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(View view) {
        onboardingDone();
    }

    public static Fragment newInstance() {
        return new HabitTrackerOnboardingFragment();
    }

    private void onboardingDone() {
        this.mHabitTrackerProvider.setSetupData(getGoalName(), Integer.parseInt(this.mGoalValues.get(this.mGoalValueIndex)), ResetInverval.getValueFromIndex(this.mResetIntervalValueIndex));
        this.mHabitTrackerProvider.setCount(0);
        this.mHabitTrackerProvider.setOnboardingDone(true);
    }

    private void refresh() {
        this.mSetGoalValueTextView.setText(this.mGoalValues.get(this.mGoalValueIndex));
        this.mSetResetIntervalValueTextView.setText(this.mResetIntervalValues.get(this.mResetIntervalValueIndex));
    }

    private void showSetGoalDialog() {
        PickerDialogFragment.newInstance(1, getString(R.string.behaviour_habit_tracker_onboarding_goal), this.mGoalValues, this.mGoalValueIndex).show(getChildFragmentManager(), (String) null);
    }

    private void showSetResetIntervalDialog() {
        PickerDialogFragment.newInstance(2, getString(R.string.behaviour_habit_tracker_onboarding_reset_interval), this.mResetIntervalValues, this.mResetIntervalValueIndex).show(getChildFragmentManager(), (String) null);
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHabitTrackerProvider = HabitTrackerProvider.getInstance();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_habit_tracker_onboarding, viewGroup, false);
        this.mHabitNameEditText = (EditText) inflate.findViewById(R.id.name_edit_text);
        this.mSetGoalValueTextView = (TextView) inflate.findViewById(R.id.set_goal_value);
        inflate.findViewById(R.id.set_goal_button_container).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.behaviour.habittracker.HabitTrackerOnboardingFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HabitTrackerOnboardingFragment.this.lambda$onCreateView$0(view);
            }
        });
        this.mSetResetIntervalValueTextView = (TextView) inflate.findViewById(R.id.set_reset_interval_value);
        inflate.findViewById(R.id.set_reset_interval_button_container).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.behaviour.habittracker.HabitTrackerOnboardingFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HabitTrackerOnboardingFragment.this.lambda$onCreateView$1(view);
            }
        });
        inflate.findViewById(R.id.btn_start_tracking).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.behaviour.habittracker.HabitTrackerOnboardingFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HabitTrackerOnboardingFragment.this.lambda$onCreateView$2(view);
            }
        });
        initPickerValues();
        refresh();
        return inflate;
    }

    @Override // com.animaconnected.secondo.screens.pickerdialog.PickerDialogFragmentCallback
    public void onIndexSelected(int r2, int r3) {
        if (r3 == 1) {
            this.mGoalValueIndex = r2;
        } else if (r3 == 2) {
            this.mResetIntervalValueIndex = r2;
        }
        refresh();
    }
}
