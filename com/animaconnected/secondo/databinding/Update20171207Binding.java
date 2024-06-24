package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class Update20171207Binding implements ViewBinding {
    private final LinearLayout rootView;

    private Update20171207Binding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public static Update20171207Binding bind(View view) {
        if (view != null) {
            return new Update20171207Binding((LinearLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static Update20171207Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static Update20171207Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.update_20171207, viewGroup, false);
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
