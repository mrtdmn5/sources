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
public final class ItemDebugDeviceStorageBinding implements ViewBinding {
    public final ImageView ivDebugDeviceStorageImage;
    public final RelativeLayout layoutDebugDeviceStorage;
    private final RelativeLayout rootView;
    public final TextView tvDebugDeviceStorageHash;
    public final ImageView tvDebugDeviceStorageRemove;
    public final TextView tvDebugDeviceStorageRowContent;
    public final TextView tvDebugDeviceStorageRowPath;
    public final TextView tvDebugDeviceStorageTs;

    private ItemDebugDeviceStorageBinding(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, TextView textView, ImageView imageView2, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = relativeLayout;
        this.ivDebugDeviceStorageImage = imageView;
        this.layoutDebugDeviceStorage = relativeLayout2;
        this.tvDebugDeviceStorageHash = textView;
        this.tvDebugDeviceStorageRemove = imageView2;
        this.tvDebugDeviceStorageRowContent = textView2;
        this.tvDebugDeviceStorageRowPath = textView3;
        this.tvDebugDeviceStorageTs = textView4;
    }

    public static ItemDebugDeviceStorageBinding bind(View view) {
        int r0 = R.id.iv_debug_device_storage_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.iv_debug_device_storage_image, view);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            r0 = R.id.tv_debug_device_storage_hash;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_debug_device_storage_hash, view);
            if (textView != null) {
                r0 = R.id.tv_debug_device_storage_remove;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.tv_debug_device_storage_remove, view);
                if (imageView2 != null) {
                    r0 = R.id.tv_debug_device_storage_row_content;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.tv_debug_device_storage_row_content, view);
                    if (textView2 != null) {
                        r0 = R.id.tv_debug_device_storage_row_path;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.tv_debug_device_storage_row_path, view);
                        if (textView3 != null) {
                            r0 = R.id.tv_debug_device_storage_ts;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(R.id.tv_debug_device_storage_ts, view);
                            if (textView4 != null) {
                                return new ItemDebugDeviceStorageBinding(relativeLayout, imageView, relativeLayout, textView, imageView2, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static ItemDebugDeviceStorageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemDebugDeviceStorageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_debug_device_storage, viewGroup, false);
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
