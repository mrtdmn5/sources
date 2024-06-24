package com.animaconnected.secondo.screens.notification.stepgoal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.activity.ActivityFragment;
import com.animaconnected.secondo.screens.activity.ActivitySetupFragment;
import com.animaconnected.secondo.screens.activity.StepFormatHelper;
import com.animaconnected.secondo.screens.notification.NotificationDetailsFragment;
import com.animaconnected.watch.WatchProvider;
import com.kronaby.watch.app.R;
import java.util.Locale;

/* loaded from: classes3.dex */
public class StepGoalFragment extends NotificationDetailsFragment {
    final WatchProvider mWatch = ProviderFactory.getWatch();

    private BaseFragment getFirstActivityFragment() {
        if (ProviderFactory.getSettingProvider().getActivityOnboardingCompleted()) {
            return ActivityFragment.newInstance(true, getName());
        }
        return ActivitySetupFragment.newInstance(true, getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        getMainController().gotoNextFragment(getFirstActivityFragment(), false);
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationDetailsFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationDetailsFragment, com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return "StepGoal";
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_step_goal, viewGroup, false);
        StepFormatHelper stepFormatHelper = new StepFormatHelper(Locale.getDefault());
        ((TextView) inflate.findViewById(R.id.step_goal_description)).setText(getResources().getString(R.string.fragment_step_goal_description, stepFormatHelper.formatNumber(this.mWatch.fitness().getGoalOnce(DateTimeUtilsKt.currentTimeMillis()).getSteps())));
        Button button = (Button) inflate.findViewById(R.id.goto_activity);
        if (ProviderFactory.getSettingProvider().getActivityOnboardingCompleted()) {
            button.setText(getText(R.string.activity_open));
        } else {
            button.setText(getText(R.string.activity_activate));
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.notification.stepgoal.StepGoalFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepGoalFragment.this.lambda$onCreateView$0(view);
            }
        });
        initView(inflate);
        return inflate;
    }
}
