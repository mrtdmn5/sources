package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentSettingsDebuggingBinding implements ViewBinding {
    public final EditText debuggingAdditionalInfo;
    public final TextView debuggingDataInfo;
    public final ProgressBar debuggingProgressbar;
    public final Button debuggingSendLogs;
    public final LinearLayout detailLayout;
    private final LinearLayout rootView;

    private FragmentSettingsDebuggingBinding(LinearLayout linearLayout, EditText editText, TextView textView, ProgressBar progressBar, Button button, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.debuggingAdditionalInfo = editText;
        this.debuggingDataInfo = textView;
        this.debuggingProgressbar = progressBar;
        this.debuggingSendLogs = button;
        this.detailLayout = linearLayout2;
    }

    public static FragmentSettingsDebuggingBinding bind(View view) {
        int r0 = R.id.debugging_additional_info;
        EditText editText = (EditText) ViewBindings.findChildViewById(R.id.debugging_additional_info, view);
        if (editText != null) {
            r0 = R.id.debugging_data_info;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.debugging_data_info, view);
            if (textView != null) {
                r0 = R.id.debugging_progressbar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.debugging_progressbar, view);
                if (progressBar != null) {
                    r0 = R.id.debugging_send_logs;
                    Button button = (Button) ViewBindings.findChildViewById(R.id.debugging_send_logs, view);
                    if (button != null) {
                        LinearLayout linearLayout = (LinearLayout) view;
                        return new FragmentSettingsDebuggingBinding(linearLayout, editText, textView, progressBar, button, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentSettingsDebuggingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentSettingsDebuggingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_settings_debugging, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
