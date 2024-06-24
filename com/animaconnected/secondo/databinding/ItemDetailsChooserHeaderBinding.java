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
public final class ItemDetailsChooserHeaderBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView titleTextView;

    private ItemDetailsChooserHeaderBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.titleTextView = textView;
    }

    public static ItemDetailsChooserHeaderBinding bind(View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
        if (textView != null) {
            return new ItemDetailsChooserHeaderBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.title_text_view)));
    }

    public static ItemDetailsChooserHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemDetailsChooserHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_details_chooser_header, viewGroup, false);
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
