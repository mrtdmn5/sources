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
public final class FragmentDeviceinfoBinding implements ViewBinding {
    public final Button btnSend;
    public final TextView deviceInfoText;
    private final LinearLayout rootView;

    private FragmentDeviceinfoBinding(LinearLayout linearLayout, Button button, TextView textView) {
        this.rootView = linearLayout;
        this.btnSend = button;
        this.deviceInfoText = textView;
    }

    public static FragmentDeviceinfoBinding bind(View view) {
        int r0 = R.id.btn_send;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_send, view);
        if (button != null) {
            r0 = R.id.device_info_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.device_info_text, view);
            if (textView != null) {
                return new FragmentDeviceinfoBinding((LinearLayout) view, button, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDeviceinfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDeviceinfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_deviceinfo, viewGroup, false);
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
