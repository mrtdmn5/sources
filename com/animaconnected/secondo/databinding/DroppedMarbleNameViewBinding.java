package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DroppedMarbleNameViewBinding implements ViewBinding {
    private final TextView rootView;

    private DroppedMarbleNameViewBinding(TextView textView) {
        this.rootView = textView;
    }

    public static DroppedMarbleNameViewBinding bind(View view) {
        if (view != null) {
            return new DroppedMarbleNameViewBinding((TextView) view);
        }
        throw new NullPointerException("rootView");
    }

    public static DroppedMarbleNameViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DroppedMarbleNameViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dropped_marble_name_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }
}
