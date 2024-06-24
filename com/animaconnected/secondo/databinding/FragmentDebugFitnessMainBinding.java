package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDebugFitnessMainBinding implements ViewBinding {
    public final Button deleteDataOnCloud;
    public final Button fitnessDatabase;
    public final Button fitnessDebugDataDelete;
    public final Button fitnessDebugDataExport;
    public final Button fitnessDebugDataImport;
    public final TextView fitnessDebugLastSession;
    public final TextView fitnessDebugLiveModeData;
    public final Button fitnessDebugPreDataDelete;
    public final TextView fitnessDebugState;
    public final Button fitnessDeleteLocal;
    public final Button fitnessForceSync;
    public final Button fitnessPreProcess;
    public final Button fitnessPreProcessRestingHeartRate;
    public final Button fitnessPreProcessSleep;
    public final Button fitnessResetOnboarding;
    public final ProgressBar progressBarCalculating;
    private final ScrollView rootView;

    private FragmentDebugFitnessMainBinding(ScrollView scrollView, Button button, Button button2, Button button3, Button button4, Button button5, TextView textView, TextView textView2, Button button6, TextView textView3, Button button7, Button button8, Button button9, Button button10, Button button11, Button button12, ProgressBar progressBar) {
        this.rootView = scrollView;
        this.deleteDataOnCloud = button;
        this.fitnessDatabase = button2;
        this.fitnessDebugDataDelete = button3;
        this.fitnessDebugDataExport = button4;
        this.fitnessDebugDataImport = button5;
        this.fitnessDebugLastSession = textView;
        this.fitnessDebugLiveModeData = textView2;
        this.fitnessDebugPreDataDelete = button6;
        this.fitnessDebugState = textView3;
        this.fitnessDeleteLocal = button7;
        this.fitnessForceSync = button8;
        this.fitnessPreProcess = button9;
        this.fitnessPreProcessRestingHeartRate = button10;
        this.fitnessPreProcessSleep = button11;
        this.fitnessResetOnboarding = button12;
        this.progressBarCalculating = progressBar;
    }

    public static FragmentDebugFitnessMainBinding bind(View view) {
        int r1 = R.id.delete_data_on_cloud;
        Button button = (Button) ViewBindings.findChildViewById(R.id.delete_data_on_cloud, view);
        if (button != null) {
            r1 = R.id.fitness_database;
            Button button2 = (Button) ViewBindings.findChildViewById(R.id.fitness_database, view);
            if (button2 != null) {
                r1 = R.id.fitness_debug_data_delete;
                Button button3 = (Button) ViewBindings.findChildViewById(R.id.fitness_debug_data_delete, view);
                if (button3 != null) {
                    r1 = R.id.fitness_debug_data_export;
                    Button button4 = (Button) ViewBindings.findChildViewById(R.id.fitness_debug_data_export, view);
                    if (button4 != null) {
                        r1 = R.id.fitness_debug_data_import;
                        Button button5 = (Button) ViewBindings.findChildViewById(R.id.fitness_debug_data_import, view);
                        if (button5 != null) {
                            r1 = R.id.fitness_debug_last_session;
                            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.fitness_debug_last_session, view);
                            if (textView != null) {
                                r1 = R.id.fitness_debug_live_mode_data;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.fitness_debug_live_mode_data, view);
                                if (textView2 != null) {
                                    r1 = R.id.fitness_debug_pre_data_delete;
                                    Button button6 = (Button) ViewBindings.findChildViewById(R.id.fitness_debug_pre_data_delete, view);
                                    if (button6 != null) {
                                        r1 = R.id.fitness_debug_state;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.fitness_debug_state, view);
                                        if (textView3 != null) {
                                            r1 = R.id.fitness_delete_local;
                                            Button button7 = (Button) ViewBindings.findChildViewById(R.id.fitness_delete_local, view);
                                            if (button7 != null) {
                                                r1 = R.id.fitness_force_sync;
                                                Button button8 = (Button) ViewBindings.findChildViewById(R.id.fitness_force_sync, view);
                                                if (button8 != null) {
                                                    r1 = R.id.fitness_pre_process;
                                                    Button button9 = (Button) ViewBindings.findChildViewById(R.id.fitness_pre_process, view);
                                                    if (button9 != null) {
                                                        r1 = R.id.fitness_pre_process_resting_heart_rate;
                                                        Button button10 = (Button) ViewBindings.findChildViewById(R.id.fitness_pre_process_resting_heart_rate, view);
                                                        if (button10 != null) {
                                                            r1 = R.id.fitness_pre_process_sleep;
                                                            Button button11 = (Button) ViewBindings.findChildViewById(R.id.fitness_pre_process_sleep, view);
                                                            if (button11 != null) {
                                                                r1 = R.id.fitness_reset_onboarding;
                                                                Button button12 = (Button) ViewBindings.findChildViewById(R.id.fitness_reset_onboarding, view);
                                                                if (button12 != null) {
                                                                    r1 = R.id.progress_bar_calculating;
                                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.progress_bar_calculating, view);
                                                                    if (progressBar != null) {
                                                                        return new FragmentDebugFitnessMainBinding((ScrollView) view, button, button2, button3, button4, button5, textView, textView2, button6, textView3, button7, button8, button9, button10, button11, button12, progressBar);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r1)));
    }

    public static FragmentDebugFitnessMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDebugFitnessMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_debug_fitness_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }
}
