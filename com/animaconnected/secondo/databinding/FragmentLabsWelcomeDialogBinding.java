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
public final class FragmentLabsWelcomeDialogBinding implements ViewBinding {
    public final Button labsWelcomeButton;
    private final LinearLayout rootView;

    private FragmentLabsWelcomeDialogBinding(LinearLayout linearLayout, Button button) {
        this.rootView = linearLayout;
        this.labsWelcomeButton = button;
    }

    public static FragmentLabsWelcomeDialogBinding bind(View view) {
        Button button = (Button) ViewBindings.findChildViewById(R.id.labs_welcome_button, view);
        if (button != null) {
            return new FragmentLabsWelcomeDialogBinding((LinearLayout) view, button);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.labs_welcome_button)));
    }

    public static FragmentLabsWelcomeDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentLabsWelcomeDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_labs_welcome_dialog, viewGroup, false);
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
