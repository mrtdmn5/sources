package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentOnboardingLoginBinding implements ViewBinding {
    public final LinearLayout bottomSection;
    public final Button btnLoginApple;
    public final Button btnLoginGoogle;
    public final LinearLayout dividerOrSection;
    public final View middleSpacer;
    private final ConstraintLayout rootView;
    public final LinearLayout topSection;
    public final View topSpacer;
    public final Button tvCreateAccount;
    public final TextView tvEmailLogin;
    public final TextView tvNotNow;

    private FragmentOnboardingLoginBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, Button button, Button button2, LinearLayout linearLayout2, View view, LinearLayout linearLayout3, View view2, Button button3, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.bottomSection = linearLayout;
        this.btnLoginApple = button;
        this.btnLoginGoogle = button2;
        this.dividerOrSection = linearLayout2;
        this.middleSpacer = view;
        this.topSection = linearLayout3;
        this.topSpacer = view2;
        this.tvCreateAccount = button3;
        this.tvEmailLogin = textView;
        this.tvNotNow = textView2;
    }

    public static FragmentOnboardingLoginBinding bind(View view) {
        int r0 = R.id.bottom_section;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.bottom_section, view);
        if (linearLayout != null) {
            r0 = R.id.btn_login_apple;
            Button button = (Button) ViewBindings.findChildViewById(R.id.btn_login_apple, view);
            if (button != null) {
                r0 = R.id.btn_login_google;
                Button button2 = (Button) ViewBindings.findChildViewById(R.id.btn_login_google, view);
                if (button2 != null) {
                    r0 = R.id.divider_or_section;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.divider_or_section, view);
                    if (linearLayout2 != null) {
                        r0 = R.id.middle_spacer;
                        View findChildViewById = ViewBindings.findChildViewById(R.id.middle_spacer, view);
                        if (findChildViewById != null) {
                            r0 = R.id.top_section;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(R.id.top_section, view);
                            if (linearLayout3 != null) {
                                r0 = R.id.top_spacer;
                                View findChildViewById2 = ViewBindings.findChildViewById(R.id.top_spacer, view);
                                if (findChildViewById2 != null) {
                                    r0 = R.id.tv_create_account;
                                    Button button3 = (Button) ViewBindings.findChildViewById(R.id.tv_create_account, view);
                                    if (button3 != null) {
                                        r0 = R.id.tv_email_login;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_email_login, view);
                                        if (textView != null) {
                                            r0 = R.id.tv_not_now;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.tv_not_now, view);
                                            if (textView2 != null) {
                                                return new FragmentOnboardingLoginBinding((ConstraintLayout) view, linearLayout, button, button2, linearLayout2, findChildViewById, linearLayout3, findChildViewById2, button3, textView, textView2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentOnboardingLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentOnboardingLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_onboarding_login, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
