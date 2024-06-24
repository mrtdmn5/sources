package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDebugImagePreviewItemBinding implements ViewBinding {
    private final ImageView rootView;

    private FragmentDebugImagePreviewItemBinding(ImageView imageView) {
        this.rootView = imageView;
    }

    public static FragmentDebugImagePreviewItemBinding bind(View view) {
        if (view != null) {
            return new FragmentDebugImagePreviewItemBinding((ImageView) view);
        }
        throw new NullPointerException("rootView");
    }

    public static FragmentDebugImagePreviewItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDebugImagePreviewItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_debug_image_preview_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ImageView getRoot() {
        return this.rootView;
    }
}
