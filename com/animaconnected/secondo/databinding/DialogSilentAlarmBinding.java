package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DialogSilentAlarmBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnOk;
    private final LinearLayout rootView;

    private DialogSilentAlarmBinding(LinearLayout linearLayout, Button button, Button button2) {
        this.rootView = linearLayout;
        this.btnCancel = button;
        this.btnOk = button2;
    }

    public static DialogSilentAlarmBinding bind(View view) {
        int r0 = R.id.btn_cancel;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_cancel, view);
        if (button != null) {
            r0 = R.id.btn_ok;
            Button button2 = (Button) ViewBindings.findChildViewById(R.id.btn_ok, view);
            if (button2 != null) {
                return new DialogSilentAlarmBinding((LinearLayout) view, button, button2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DialogSilentAlarmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogSilentAlarmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_silent_alarm, viewGroup, false);
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
