package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class ActivityMainBinding implements ViewBinding {
    public final RelativeLayout container;
    public final FrameLayout content;
    public final RelativeLayout globalDemoModeButton;
    public final ImageView imageViewBackgroundGradientBottom;
    public final ImageView imageViewBackgroundGradientTop;
    public final ImageView imageViewWatchShadow;
    public final ImageView imageViewWhiteForWhatIsNew;
    public final FrameLayout revealedFragmentContainer;
    private final FrameLayout rootView;
    public final FrameLayout statusContainer;
    public final ImageView watchButtonPlaceholder;
    public final LinearLayout watchLayer;
    public final RelativeLayout watchParent;
    public final RelativeLayout watchParentContainer;

    private ActivityMainBinding(FrameLayout frameLayout, RelativeLayout relativeLayout, FrameLayout frameLayout2, RelativeLayout relativeLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, FrameLayout frameLayout3, FrameLayout frameLayout4, ImageView imageView5, LinearLayout linearLayout, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4) {
        this.rootView = frameLayout;
        this.container = relativeLayout;
        this.content = frameLayout2;
        this.globalDemoModeButton = relativeLayout2;
        this.imageViewBackgroundGradientBottom = imageView;
        this.imageViewBackgroundGradientTop = imageView2;
        this.imageViewWatchShadow = imageView3;
        this.imageViewWhiteForWhatIsNew = imageView4;
        this.revealedFragmentContainer = frameLayout3;
        this.statusContainer = frameLayout4;
        this.watchButtonPlaceholder = imageView5;
        this.watchLayer = linearLayout;
        this.watchParent = relativeLayout3;
        this.watchParentContainer = relativeLayout4;
    }

    public static ActivityMainBinding bind(View view) {
        int r1 = R.id.container;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(R.id.container, view);
        if (relativeLayout != null) {
            r1 = R.id.content;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(R.id.content, view);
            if (frameLayout != null) {
                r1 = R.id.global_demo_mode_button;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(R.id.global_demo_mode_button, view);
                if (relativeLayout2 != null) {
                    r1 = R.id.image_view_background_gradient_bottom;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.image_view_background_gradient_bottom, view);
                    if (imageView != null) {
                        r1 = R.id.image_view_background_gradient_top;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.image_view_background_gradient_top, view);
                        if (imageView2 != null) {
                            r1 = R.id.image_view_watch_shadow;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(R.id.image_view_watch_shadow, view);
                            if (imageView3 != null) {
                                r1 = R.id.image_view_white_for_what_is_new;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(R.id.image_view_white_for_what_is_new, view);
                                if (imageView4 != null) {
                                    r1 = R.id.revealed_fragment_container;
                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(R.id.revealed_fragment_container, view);
                                    if (frameLayout2 != null) {
                                        r1 = R.id.status_container;
                                        FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(R.id.status_container, view);
                                        if (frameLayout3 != null) {
                                            r1 = R.id.watch_button_placeholder;
                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(R.id.watch_button_placeholder, view);
                                            if (imageView5 != null) {
                                                r1 = R.id.watch_layer;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.watch_layer, view);
                                                if (linearLayout != null) {
                                                    r1 = R.id.watch_parent;
                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(R.id.watch_parent, view);
                                                    if (relativeLayout3 != null) {
                                                        r1 = R.id.watch_parent_container;
                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(R.id.watch_parent_container, view);
                                                        if (relativeLayout4 != null) {
                                                            return new ActivityMainBinding((FrameLayout) view, relativeLayout, frameLayout, relativeLayout2, imageView, imageView2, imageView3, imageView4, frameLayout2, frameLayout3, imageView5, linearLayout, relativeLayout3, relativeLayout4);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r1)));
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
