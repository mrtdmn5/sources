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
public final class ImportantAppListItemBinding implements ViewBinding {
    public final ImageView appIcon;
    public final TextView appName;
    public final TextView notInstalled;
    private final RelativeLayout rootView;

    private ImportantAppListItemBinding(RelativeLayout relativeLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.appIcon = imageView;
        this.appName = textView;
        this.notInstalled = textView2;
    }

    public static ImportantAppListItemBinding bind(View view) {
        int r0 = R.id.app_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.app_icon, view);
        if (imageView != null) {
            r0 = R.id.app_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.app_name, view);
            if (textView != null) {
                r0 = R.id.not_installed;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.not_installed, view);
                if (textView2 != null) {
                    return new ImportantAppListItemBinding((RelativeLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static ImportantAppListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ImportantAppListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.important_app_list_item, viewGroup, false);
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
