package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDfulogsBinding implements ViewBinding {
    public final Button copyLog;
    public final Button hideTime;
    public final TextView logsText;
    private final LinearLayout rootView;

    private FragmentDfulogsBinding(LinearLayout linearLayout, Button button, Button button2, TextView textView) {
        this.rootView = linearLayout;
        this.copyLog = button;
        this.hideTime = button2;
        this.logsText = textView;
    }

    public static FragmentDfulogsBinding bind(View view) {
        int r0 = R.id.copy_log;
        Button button = (Button) ViewBindings.findChildViewById(R.id.copy_log, view);
        if (button != null) {
            r0 = R.id.hide_time;
            Button button2 = (Button) ViewBindings.findChildViewById(R.id.hide_time, view);
            if (button2 != null) {
                r0 = R.id.logs_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(R.id.logs_text, view);
                if (textView != null) {
                    return new FragmentDfulogsBinding((LinearLayout) view, button, button2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDfulogsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDfulogsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_dfulogs, viewGroup, false);
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
