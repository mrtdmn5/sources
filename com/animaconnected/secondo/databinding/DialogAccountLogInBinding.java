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
public final class DialogAccountLogInBinding implements ViewBinding {
    public final TextView btnCancel;
    public final Button btnLoginApple;
    public final TextView btnLoginEmail;
    public final Button btnLoginGoogle;
    private final LinearLayout rootView;
    public final TextView tvLogIn;

    private DialogAccountLogInBinding(LinearLayout linearLayout, TextView textView, Button button, TextView textView2, Button button2, TextView textView3) {
        this.rootView = linearLayout;
        this.btnCancel = textView;
        this.btnLoginApple = button;
        this.btnLoginEmail = textView2;
        this.btnLoginGoogle = button2;
        this.tvLogIn = textView3;
    }

    public static DialogAccountLogInBinding bind(View view) {
        int r0 = R.id.btn_cancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.btn_cancel, view);
        if (textView != null) {
            r0 = R.id.btn_login_apple;
            Button button = (Button) ViewBindings.findChildViewById(R.id.btn_login_apple, view);
            if (button != null) {
                r0 = R.id.btn_login_email;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.btn_login_email, view);
                if (textView2 != null) {
                    r0 = R.id.btn_login_google;
                    Button button2 = (Button) ViewBindings.findChildViewById(R.id.btn_login_google, view);
                    if (button2 != null) {
                        r0 = R.id.tv_log_in;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.tv_log_in, view);
                        if (textView3 != null) {
                            return new DialogAccountLogInBinding((LinearLayout) view, textView, button, textView2, button2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DialogAccountLogInBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogAccountLogInBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_account_log_in, viewGroup, false);
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
