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
public final class ItemDetailsChooserFooterBinding implements ViewBinding {
    public final Button button;
    public final LinearLayout buttonContainer;
    private final LinearLayout rootView;

    private ItemDetailsChooserFooterBinding(LinearLayout linearLayout, Button button, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.button = button;
        this.buttonContainer = linearLayout2;
    }

    public static ItemDetailsChooserFooterBinding bind(View view) {
        int r0 = R.id.button;
        Button button = (Button) ViewBindings.findChildViewById(R.id.button, view);
        if (button != null) {
            r0 = R.id.button_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.button_container, view);
            if (linearLayout != null) {
                return new ItemDetailsChooserFooterBinding((LinearLayout) view, button, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static ItemDetailsChooserFooterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemDetailsChooserFooterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_details_chooser_footer, viewGroup, false);
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
