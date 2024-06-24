package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class WidgetComponentItemContactsBinding implements ViewBinding {
    public final SwitchCompat onoff;
    private final RelativeLayout rootView;
    public final TextView titleTextView;

    private WidgetComponentItemContactsBinding(RelativeLayout relativeLayout, SwitchCompat switchCompat, TextView textView) {
        this.rootView = relativeLayout;
        this.onoff = switchCompat;
        this.titleTextView = textView;
    }

    public static WidgetComponentItemContactsBinding bind(View view) {
        int r0 = R.id.onoff;
        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(R.id.onoff, view);
        if (switchCompat != null) {
            r0 = R.id.title_text_view;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
            if (textView != null) {
                return new WidgetComponentItemContactsBinding((RelativeLayout) view, switchCompat, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static WidgetComponentItemContactsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WidgetComponentItemContactsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.widget_component_item_contacts, viewGroup, false);
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
