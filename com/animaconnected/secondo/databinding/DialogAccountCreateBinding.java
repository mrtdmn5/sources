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
public final class DialogAccountCreateBinding implements ViewBinding {
    public final TextView btnCancel;
    public final TextView btnCreateAccount;
    public final Button btnLoginApple;
    public final Button btnLoginGoogle;
    private final LinearLayout rootView;
    public final TextView tvCreateAccount;

    private DialogAccountCreateBinding(LinearLayout linearLayout, TextView textView, TextView textView2, Button button, Button button2, TextView textView3) {
        this.rootView = linearLayout;
        this.btnCancel = textView;
        this.btnCreateAccount = textView2;
        this.btnLoginApple = button;
        this.btnLoginGoogle = button2;
        this.tvCreateAccount = textView3;
    }

    public static DialogAccountCreateBinding bind(View view) {
        int r0 = R.id.btn_cancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.btn_cancel, view);
        if (textView != null) {
            r0 = R.id.btn_create_account;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.btn_create_account, view);
            if (textView2 != null) {
                r0 = R.id.btn_login_apple;
                Button button = (Button) ViewBindings.findChildViewById(R.id.btn_login_apple, view);
                if (button != null) {
                    r0 = R.id.btn_login_google;
                    Button button2 = (Button) ViewBindings.findChildViewById(R.id.btn_login_google, view);
                    if (button2 != null) {
                        r0 = R.id.tv_create_account;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.tv_create_account, view);
                        if (textView3 != null) {
                            return new DialogAccountCreateBinding((LinearLayout) view, textView, textView2, button, button2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DialogAccountCreateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogAccountCreateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_account_create, viewGroup, false);
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
