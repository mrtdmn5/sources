package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class ItemKeyWordBinding implements ViewBinding {
    public final ImageView keywordClear;
    public final TextView keywordText;
    private final RelativeLayout rootView;

    private ItemKeyWordBinding(RelativeLayout relativeLayout, ImageView imageView, TextView textView) {
        this.rootView = relativeLayout;
        this.keywordClear = imageView;
        this.keywordText = textView;
    }

    public static ItemKeyWordBinding bind(View view) {
        int r0 = R.id.keyword_clear;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.keyword_clear, view);
        if (imageView != null) {
            r0 = R.id.keyword_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.keyword_text, view);
            if (textView != null) {
                return new ItemKeyWordBinding((RelativeLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static ItemKeyWordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemKeyWordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_key_word, viewGroup, false);
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
