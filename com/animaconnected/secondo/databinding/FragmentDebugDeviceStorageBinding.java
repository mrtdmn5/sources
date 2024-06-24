package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDebugDeviceStorageBinding implements ViewBinding {
    public final TextView deviceStorageContent;
    public final Button formatFlash;
    public final LinearLayout layoutDebugDeviceStorageButtons;
    public final LinearLayout layoutDirDescription;
    private final RelativeLayout rootView;
    public final Button runGc;
    public final RecyclerView rvDebugDeviceStorage;
    public final TextView tvDebugDeviceStorageTitle;

    private FragmentDebugDeviceStorageBinding(RelativeLayout relativeLayout, TextView textView, Button button, LinearLayout linearLayout, LinearLayout linearLayout2, Button button2, RecyclerView recyclerView, TextView textView2) {
        this.rootView = relativeLayout;
        this.deviceStorageContent = textView;
        this.formatFlash = button;
        this.layoutDebugDeviceStorageButtons = linearLayout;
        this.layoutDirDescription = linearLayout2;
        this.runGc = button2;
        this.rvDebugDeviceStorage = recyclerView;
        this.tvDebugDeviceStorageTitle = textView2;
    }

    public static FragmentDebugDeviceStorageBinding bind(View view) {
        int r0 = R.id.device_storage_content;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.device_storage_content, view);
        if (textView != null) {
            r0 = R.id.format_flash;
            Button button = (Button) ViewBindings.findChildViewById(R.id.format_flash, view);
            if (button != null) {
                r0 = R.id.layout_debug_device_storage_buttons;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.layout_debug_device_storage_buttons, view);
                if (linearLayout != null) {
                    r0 = R.id.layout_dir_description;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.layout_dir_description, view);
                    if (linearLayout2 != null) {
                        r0 = R.id.run_gc;
                        Button button2 = (Button) ViewBindings.findChildViewById(R.id.run_gc, view);
                        if (button2 != null) {
                            r0 = R.id.rv_debug_device_storage;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(R.id.rv_debug_device_storage, view);
                            if (recyclerView != null) {
                                r0 = R.id.tv_debug_device_storage_title;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.tv_debug_device_storage_title, view);
                                if (textView2 != null) {
                                    return new FragmentDebugDeviceStorageBinding((RelativeLayout) view, textView, button, linearLayout, linearLayout2, button2, recyclerView, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDebugDeviceStorageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDebugDeviceStorageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_debug_device_storage, viewGroup, false);
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
