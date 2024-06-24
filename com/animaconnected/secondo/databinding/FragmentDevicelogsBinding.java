package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDevicelogsBinding implements ViewBinding {
    public final TextView devicelogsLogText;
    public final TextView devicelogsReadBytesText;
    public final TextView devicelogsReadPartText;
    public final ScrollView devicelogsScroll;
    public final Button devicelogsSendLogButton;
    private final LinearLayout rootView;

    private FragmentDevicelogsBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, ScrollView scrollView, Button button) {
        this.rootView = linearLayout;
        this.devicelogsLogText = textView;
        this.devicelogsReadBytesText = textView2;
        this.devicelogsReadPartText = textView3;
        this.devicelogsScroll = scrollView;
        this.devicelogsSendLogButton = button;
    }

    public static FragmentDevicelogsBinding bind(View view) {
        int r0 = R.id.devicelogs_log_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.devicelogs_log_text, view);
        if (textView != null) {
            r0 = R.id.devicelogs_read_bytes_text;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.devicelogs_read_bytes_text, view);
            if (textView2 != null) {
                r0 = R.id.devicelogs_read_part_text;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.devicelogs_read_part_text, view);
                if (textView3 != null) {
                    r0 = R.id.devicelogs_scroll;
                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(R.id.devicelogs_scroll, view);
                    if (scrollView != null) {
                        r0 = R.id.devicelogs_send_log_button;
                        Button button = (Button) ViewBindings.findChildViewById(R.id.devicelogs_send_log_button, view);
                        if (button != null) {
                            return new FragmentDevicelogsBinding((LinearLayout) view, textView, textView2, textView3, scrollView, button);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDevicelogsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDevicelogsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_devicelogs, viewGroup, false);
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
