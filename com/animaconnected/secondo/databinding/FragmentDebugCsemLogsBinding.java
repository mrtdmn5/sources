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
public final class FragmentDebugCsemLogsBinding implements ViewBinding {
    public final Button btnClear;
    public final Button btnDisable;
    public final Button btnEnable;
    public final Button btnExport;
    private final LinearLayout rootView;
    public final TextView textAmount;

    private FragmentDebugCsemLogsBinding(LinearLayout linearLayout, Button button, Button button2, Button button3, Button button4, TextView textView) {
        this.rootView = linearLayout;
        this.btnClear = button;
        this.btnDisable = button2;
        this.btnEnable = button3;
        this.btnExport = button4;
        this.textAmount = textView;
    }

    public static FragmentDebugCsemLogsBinding bind(View view) {
        int r0 = R.id.btn_clear;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_clear, view);
        if (button != null) {
            r0 = R.id.btn_disable;
            Button button2 = (Button) ViewBindings.findChildViewById(R.id.btn_disable, view);
            if (button2 != null) {
                r0 = R.id.btn_enable;
                Button button3 = (Button) ViewBindings.findChildViewById(R.id.btn_enable, view);
                if (button3 != null) {
                    r0 = R.id.btn_export;
                    Button button4 = (Button) ViewBindings.findChildViewById(R.id.btn_export, view);
                    if (button4 != null) {
                        r0 = R.id.text_amount;
                        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.text_amount, view);
                        if (textView != null) {
                            return new FragmentDebugCsemLogsBinding((LinearLayout) view, button, button2, button3, button4, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDebugCsemLogsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDebugCsemLogsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_debug_csem_logs, viewGroup, false);
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
