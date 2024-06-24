package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class ItemSpotBinding implements ViewBinding {
    public final RelativeLayout layoutAddress;
    private final RelativeLayout rootView;
    public final TextView spotAddress;
    public final ImageView spotClear;
    public final TextView spotCustomName;
    public final EditText spotEdit;
    public final ImageView spotRename;
    public final TextView spotTime;

    private ItemSpotBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, ImageView imageView, TextView textView2, EditText editText, ImageView imageView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.layoutAddress = relativeLayout2;
        this.spotAddress = textView;
        this.spotClear = imageView;
        this.spotCustomName = textView2;
        this.spotEdit = editText;
        this.spotRename = imageView2;
        this.spotTime = textView3;
    }

    public static ItemSpotBinding bind(View view) {
        int r0 = R.id.layout_address;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(R.id.layout_address, view);
        if (relativeLayout != null) {
            r0 = R.id.spot_address;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.spot_address, view);
            if (textView != null) {
                r0 = R.id.spot_clear;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.spot_clear, view);
                if (imageView != null) {
                    r0 = R.id.spot_custom_name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.spot_custom_name, view);
                    if (textView2 != null) {
                        r0 = R.id.spot_edit;
                        EditText editText = (EditText) ViewBindings.findChildViewById(R.id.spot_edit, view);
                        if (editText != null) {
                            r0 = R.id.spot_rename;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.spot_rename, view);
                            if (imageView2 != null) {
                                r0 = R.id.spot_time;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.spot_time, view);
                                if (textView3 != null) {
                                    return new ItemSpotBinding((RelativeLayout) view, relativeLayout, textView, imageView, textView2, editText, imageView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static ItemSpotBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemSpotBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_spot, viewGroup, false);
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
