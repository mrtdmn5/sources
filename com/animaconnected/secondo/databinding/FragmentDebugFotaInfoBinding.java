package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDebugFotaInfoBinding implements ViewBinding {
    public final SwitchCompat fotaCloudSwitch;
    public final TextView fotaPages;
    public final TextView fotaPagesCompleted;
    public final TextView fotaRunningText;
    public final SwitchCompat fotaSlowSwitch;
    public final TextView fotaStartedFromDebug;
    public final TextView fotaSupportedText;
    private final ScrollView rootView;

    private FragmentDebugFotaInfoBinding(ScrollView scrollView, SwitchCompat switchCompat, TextView textView, TextView textView2, TextView textView3, SwitchCompat switchCompat2, TextView textView4, TextView textView5) {
        this.rootView = scrollView;
        this.fotaCloudSwitch = switchCompat;
        this.fotaPages = textView;
        this.fotaPagesCompleted = textView2;
        this.fotaRunningText = textView3;
        this.fotaSlowSwitch = switchCompat2;
        this.fotaStartedFromDebug = textView4;
        this.fotaSupportedText = textView5;
    }

    public static FragmentDebugFotaInfoBinding bind(View view) {
        int r0 = R.id.fota_cloud_switch;
        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(R.id.fota_cloud_switch, view);
        if (switchCompat != null) {
            r0 = R.id.fota_pages;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.fota_pages, view);
            if (textView != null) {
                r0 = R.id.fota_pages_completed;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.fota_pages_completed, view);
                if (textView2 != null) {
                    r0 = R.id.fota_running_text;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.fota_running_text, view);
                    if (textView3 != null) {
                        r0 = R.id.fota_slow_switch;
                        SwitchCompat switchCompat2 = (SwitchCompat) ViewBindings.findChildViewById(R.id.fota_slow_switch, view);
                        if (switchCompat2 != null) {
                            r0 = R.id.fota_started_from_debug;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(R.id.fota_started_from_debug, view);
                            if (textView4 != null) {
                                r0 = R.id.fota_supported_text;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(R.id.fota_supported_text, view);
                                if (textView5 != null) {
                                    return new FragmentDebugFotaInfoBinding((ScrollView) view, switchCompat, textView, textView2, textView3, switchCompat2, textView4, textView5);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDebugFotaInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDebugFotaInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_debug_fota_info, viewGroup, false);
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
