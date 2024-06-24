package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.screens.notification.SwitchWrapper;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentNotificationContactBinding implements ViewBinding {
    public final FrameLayout bottomDialogContainer;
    public final SwitchWrapper calls;
    public final LinearLayout container;
    public final SwitchWrapper emails;
    public final SwitchWrapper messages;
    public final TextView nameTextView;
    public final Button remove;
    private final RelativeLayout rootView;

    private FragmentNotificationContactBinding(RelativeLayout relativeLayout, FrameLayout frameLayout, SwitchWrapper switchWrapper, LinearLayout linearLayout, SwitchWrapper switchWrapper2, SwitchWrapper switchWrapper3, TextView textView, Button button) {
        this.rootView = relativeLayout;
        this.bottomDialogContainer = frameLayout;
        this.calls = switchWrapper;
        this.container = linearLayout;
        this.emails = switchWrapper2;
        this.messages = switchWrapper3;
        this.nameTextView = textView;
        this.remove = button;
    }

    public static FragmentNotificationContactBinding bind(View view) {
        int r0 = R.id.bottom_dialog_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(R.id.bottom_dialog_container, view);
        if (frameLayout != null) {
            r0 = R.id.calls;
            SwitchWrapper switchWrapper = (SwitchWrapper) ViewBindings.findChildViewById(R.id.calls, view);
            if (switchWrapper != null) {
                r0 = R.id.container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.container, view);
                if (linearLayout != null) {
                    r0 = R.id.emails;
                    SwitchWrapper switchWrapper2 = (SwitchWrapper) ViewBindings.findChildViewById(R.id.emails, view);
                    if (switchWrapper2 != null) {
                        r0 = R.id.messages;
                        SwitchWrapper switchWrapper3 = (SwitchWrapper) ViewBindings.findChildViewById(R.id.messages, view);
                        if (switchWrapper3 != null) {
                            r0 = R.id.name_text_view;
                            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.name_text_view, view);
                            if (textView != null) {
                                r0 = R.id.remove;
                                Button button = (Button) ViewBindings.findChildViewById(R.id.remove, view);
                                if (button != null) {
                                    return new FragmentNotificationContactBinding((RelativeLayout) view, frameLayout, switchWrapper, linearLayout, switchWrapper2, switchWrapper3, textView, button);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentNotificationContactBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentNotificationContactBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_notification_contact, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
