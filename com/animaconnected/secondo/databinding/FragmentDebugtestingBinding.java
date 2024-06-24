package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDebugtestingBinding implements ViewBinding {
    public final Button bottomButton;
    public final Button depleteBatteriesButton;
    private final CoordinatorLayout rootView;
    public final Button testCoilButton;
    public final Button testFcte;
    public final Button testMovement;
    public final Button testPerpetual;
    public final Button testRssi;
    public final Button testTimeSpeedup;
    public final Button testVibrator;
    public final Button topButton;
    public final CoordinatorLayout topContainer;

    private FragmentDebugtestingBinding(CoordinatorLayout coordinatorLayout, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, Button button10, CoordinatorLayout coordinatorLayout2) {
        this.rootView = coordinatorLayout;
        this.bottomButton = button;
        this.depleteBatteriesButton = button2;
        this.testCoilButton = button3;
        this.testFcte = button4;
        this.testMovement = button5;
        this.testPerpetual = button6;
        this.testRssi = button7;
        this.testTimeSpeedup = button8;
        this.testVibrator = button9;
        this.topButton = button10;
        this.topContainer = coordinatorLayout2;
    }

    public static FragmentDebugtestingBinding bind(View view) {
        int r0 = R.id.bottom_button;
        Button button = (Button) ViewBindings.findChildViewById(R.id.bottom_button, view);
        if (button != null) {
            r0 = R.id.deplete_batteries_button;
            Button button2 = (Button) ViewBindings.findChildViewById(R.id.deplete_batteries_button, view);
            if (button2 != null) {
                r0 = R.id.test_coil_button;
                Button button3 = (Button) ViewBindings.findChildViewById(R.id.test_coil_button, view);
                if (button3 != null) {
                    r0 = R.id.test_fcte;
                    Button button4 = (Button) ViewBindings.findChildViewById(R.id.test_fcte, view);
                    if (button4 != null) {
                        r0 = R.id.test_movement;
                        Button button5 = (Button) ViewBindings.findChildViewById(R.id.test_movement, view);
                        if (button5 != null) {
                            r0 = R.id.test_perpetual;
                            Button button6 = (Button) ViewBindings.findChildViewById(R.id.test_perpetual, view);
                            if (button6 != null) {
                                r0 = R.id.test_rssi;
                                Button button7 = (Button) ViewBindings.findChildViewById(R.id.test_rssi, view);
                                if (button7 != null) {
                                    r0 = R.id.test_time_speedup;
                                    Button button8 = (Button) ViewBindings.findChildViewById(R.id.test_time_speedup, view);
                                    if (button8 != null) {
                                        r0 = R.id.test_vibrator;
                                        Button button9 = (Button) ViewBindings.findChildViewById(R.id.test_vibrator, view);
                                        if (button9 != null) {
                                            r0 = R.id.top_button;
                                            Button button10 = (Button) ViewBindings.findChildViewById(R.id.top_button, view);
                                            if (button10 != null) {
                                                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                                                return new FragmentDebugtestingBinding(coordinatorLayout, button, button2, button3, button4, button5, button6, button7, button8, button9, button10, coordinatorLayout);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDebugtestingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDebugtestingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_debugtesting, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }
}
