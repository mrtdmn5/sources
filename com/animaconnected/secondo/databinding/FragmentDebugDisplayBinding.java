package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.screens.debugsettings.DebugDisplayView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDebugDisplayBinding implements ViewBinding {
    public final ImageView debugDisplayImage;
    public final LinearLayout debugDisplayLayout;
    public final DebugDisplayView debugDisplayView;
    public final ImageView debugPicture;
    public final ImageView debugPicture2;
    public final Button editLayout;
    public final ImageView imgDebugPascalWatch;
    private final LinearLayout rootView;
    public final ScrollView scrollViewDebugDisplay;
    public final SwitchCompat showOverlay;
    public final TextView tvComplications;

    private FragmentDebugDisplayBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, DebugDisplayView debugDisplayView, ImageView imageView2, ImageView imageView3, Button button, ImageView imageView4, ScrollView scrollView, SwitchCompat switchCompat, TextView textView) {
        this.rootView = linearLayout;
        this.debugDisplayImage = imageView;
        this.debugDisplayLayout = linearLayout2;
        this.debugDisplayView = debugDisplayView;
        this.debugPicture = imageView2;
        this.debugPicture2 = imageView3;
        this.editLayout = button;
        this.imgDebugPascalWatch = imageView4;
        this.scrollViewDebugDisplay = scrollView;
        this.showOverlay = switchCompat;
        this.tvComplications = textView;
    }

    public static FragmentDebugDisplayBinding bind(View view) {
        int r0 = R.id.debug_display_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.debug_display_image, view);
        if (imageView != null) {
            r0 = R.id.debug_display_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.debug_display_layout, view);
            if (linearLayout != null) {
                r0 = R.id.debug_display_view;
                DebugDisplayView debugDisplayView = (DebugDisplayView) ViewBindings.findChildViewById(R.id.debug_display_view, view);
                if (debugDisplayView != null) {
                    r0 = R.id.debug_picture;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.debug_picture, view);
                    if (imageView2 != null) {
                        r0 = R.id.debug_picture2;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(R.id.debug_picture2, view);
                        if (imageView3 != null) {
                            r0 = R.id.edit_layout;
                            Button button = (Button) ViewBindings.findChildViewById(R.id.edit_layout, view);
                            if (button != null) {
                                r0 = R.id.img_debug_pascal_watch;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(R.id.img_debug_pascal_watch, view);
                                if (imageView4 != null) {
                                    r0 = R.id.scrollView_debug_display;
                                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(R.id.scrollView_debug_display, view);
                                    if (scrollView != null) {
                                        r0 = R.id.show_overlay;
                                        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(R.id.show_overlay, view);
                                        if (switchCompat != null) {
                                            r0 = R.id.tv_complications;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_complications, view);
                                            if (textView != null) {
                                                return new FragmentDebugDisplayBinding((LinearLayout) view, imageView, linearLayout, debugDisplayView, imageView2, imageView3, button, imageView4, scrollView, switchCompat, textView);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDebugDisplayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDebugDisplayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_debug_display, viewGroup, false);
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
