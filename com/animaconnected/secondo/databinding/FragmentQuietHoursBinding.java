package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.screens.notification.alarm.widget.TextTime;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentQuietHoursBinding implements ViewBinding {
    public final TextView description;
    public final TextTime quietHoursEndTime;
    public final LinearLayout quietHoursEndTimeContainer;
    public final TextTime quietHoursStartTime;
    public final LinearLayout quietHoursStartTimeContainer;
    public final SwitchCompat quietHoursSwitch;
    private final FrameLayout rootView;
    public final TextView titleTextView;

    private FragmentQuietHoursBinding(FrameLayout frameLayout, TextView textView, TextTime textTime, LinearLayout linearLayout, TextTime textTime2, LinearLayout linearLayout2, SwitchCompat switchCompat, TextView textView2) {
        this.rootView = frameLayout;
        this.description = textView;
        this.quietHoursEndTime = textTime;
        this.quietHoursEndTimeContainer = linearLayout;
        this.quietHoursStartTime = textTime2;
        this.quietHoursStartTimeContainer = linearLayout2;
        this.quietHoursSwitch = switchCompat;
        this.titleTextView = textView2;
    }

    public static FragmentQuietHoursBinding bind(View view) {
        int r0 = R.id.description;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.description, view);
        if (textView != null) {
            r0 = R.id.quiet_hours_end_time;
            TextTime textTime = (TextTime) ViewBindings.findChildViewById(R.id.quiet_hours_end_time, view);
            if (textTime != null) {
                r0 = R.id.quiet_hours_end_time_container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.quiet_hours_end_time_container, view);
                if (linearLayout != null) {
                    r0 = R.id.quiet_hours_start_time;
                    TextTime textTime2 = (TextTime) ViewBindings.findChildViewById(R.id.quiet_hours_start_time, view);
                    if (textTime2 != null) {
                        r0 = R.id.quiet_hours_start_time_container;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.quiet_hours_start_time_container, view);
                        if (linearLayout2 != null) {
                            r0 = R.id.quiet_hours_switch;
                            SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(R.id.quiet_hours_switch, view);
                            if (switchCompat != null) {
                                r0 = R.id.title_text_view;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                                if (textView2 != null) {
                                    return new FragmentQuietHoursBinding((FrameLayout) view, textView, textTime, linearLayout, textTime2, linearLayout2, switchCompat, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentQuietHoursBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentQuietHoursBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_quiet_hours, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
