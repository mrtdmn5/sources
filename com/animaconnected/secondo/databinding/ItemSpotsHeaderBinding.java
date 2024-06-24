package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class ItemSpotsHeaderBinding implements ViewBinding {
    public final TextView descriptionText;
    private final LinearLayout rootView;
    public final TextView titleTextView;

    private ItemSpotsHeaderBinding(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.descriptionText = textView;
        this.titleTextView = textView2;
    }

    public static ItemSpotsHeaderBinding bind(View view) {
        int r0 = R.id.description_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.description_text, view);
        if (textView != null) {
            r0 = R.id.title_text_view;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
            if (textView2 != null) {
                return new ItemSpotsHeaderBinding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static ItemSpotsHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemSpotsHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_spots_header, viewGroup, false);
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
