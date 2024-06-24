package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.compose.ui.platform.ComposeView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.screens.CustomToolbar;
import com.animaconnected.secondo.widget.TopFadeScrollView;
import com.google.android.gms.maps.MapView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentWorkoutDetailsBinding implements ViewBinding {
    public final Button btnDelete;
    public final ImageView btnExportGpx;
    public final Button btnExportTcx;
    public final Button btnStravaUpload;
    public final ComposeView composeViewActivityType;
    public final ComposeView composeViewWorkout;
    public final RelativeLayout containerAnimatedToolbar;
    public final FrameLayout containerMap;
    public final ImageView ivToolbarBack;
    public final ImageView ivToolbarCollapse;
    public final ImageView ivToolbarExpand;
    public final LayoutWorkoutDetailsLinechartBinding layoutElevation;
    public final LayoutWorkoutDetailsLinechartBinding layoutHeartRate;
    public final LayoutWorkoutDetailsSplitsBinding layoutSplits;
    public final LinearLayout layoutWorkout;
    public final MapView mapView;
    private final RelativeLayout rootView;
    public final TopFadeScrollView scrollView;
    public final CustomToolbar toolbarNoAnimation;
    public final TextView tvToolbarTitle;
    public final View viewAnimContainer;
    public final View viewGradient;

    private FragmentWorkoutDetailsBinding(RelativeLayout relativeLayout, Button button, ImageView imageView, Button button2, Button button3, ComposeView composeView, ComposeView composeView2, RelativeLayout relativeLayout2, FrameLayout frameLayout, ImageView imageView2, ImageView imageView3, ImageView imageView4, LayoutWorkoutDetailsLinechartBinding layoutWorkoutDetailsLinechartBinding, LayoutWorkoutDetailsLinechartBinding layoutWorkoutDetailsLinechartBinding2, LayoutWorkoutDetailsSplitsBinding layoutWorkoutDetailsSplitsBinding, LinearLayout linearLayout, MapView mapView, TopFadeScrollView topFadeScrollView, CustomToolbar customToolbar, TextView textView, View view, View view2) {
        this.rootView = relativeLayout;
        this.btnDelete = button;
        this.btnExportGpx = imageView;
        this.btnExportTcx = button2;
        this.btnStravaUpload = button3;
        this.composeViewActivityType = composeView;
        this.composeViewWorkout = composeView2;
        this.containerAnimatedToolbar = relativeLayout2;
        this.containerMap = frameLayout;
        this.ivToolbarBack = imageView2;
        this.ivToolbarCollapse = imageView3;
        this.ivToolbarExpand = imageView4;
        this.layoutElevation = layoutWorkoutDetailsLinechartBinding;
        this.layoutHeartRate = layoutWorkoutDetailsLinechartBinding2;
        this.layoutSplits = layoutWorkoutDetailsSplitsBinding;
        this.layoutWorkout = linearLayout;
        this.mapView = mapView;
        this.scrollView = topFadeScrollView;
        this.toolbarNoAnimation = customToolbar;
        this.tvToolbarTitle = textView;
        this.viewAnimContainer = view;
        this.viewGradient = view2;
    }

    public static FragmentWorkoutDetailsBinding bind(View view) {
        int r1 = R.id.btn_delete;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_delete, view);
        if (button != null) {
            r1 = R.id.btn_export_gpx;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.btn_export_gpx, view);
            if (imageView != null) {
                r1 = R.id.btn_export_tcx;
                Button button2 = (Button) ViewBindings.findChildViewById(R.id.btn_export_tcx, view);
                if (button2 != null) {
                    r1 = R.id.btn_strava_upload;
                    Button button3 = (Button) ViewBindings.findChildViewById(R.id.btn_strava_upload, view);
                    if (button3 != null) {
                        r1 = R.id.compose_view_activity_type;
                        ComposeView composeView = (ComposeView) ViewBindings.findChildViewById(R.id.compose_view_activity_type, view);
                        if (composeView != null) {
                            r1 = R.id.compose_view_workout;
                            ComposeView composeView2 = (ComposeView) ViewBindings.findChildViewById(R.id.compose_view_workout, view);
                            if (composeView2 != null) {
                                r1 = R.id.container_animated_toolbar;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(R.id.container_animated_toolbar, view);
                                if (relativeLayout != null) {
                                    r1 = R.id.container_map;
                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(R.id.container_map, view);
                                    if (frameLayout != null) {
                                        r1 = R.id.iv_toolbar_back;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.iv_toolbar_back, view);
                                        if (imageView2 != null) {
                                            r1 = R.id.iv_toolbar_collapse;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(R.id.iv_toolbar_collapse, view);
                                            if (imageView3 != null) {
                                                r1 = R.id.iv_toolbar_expand;
                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(R.id.iv_toolbar_expand, view);
                                                if (imageView4 != null) {
                                                    r1 = R.id.layout_elevation;
                                                    View findChildViewById = ViewBindings.findChildViewById(R.id.layout_elevation, view);
                                                    if (findChildViewById != null) {
                                                        LayoutWorkoutDetailsLinechartBinding bind = LayoutWorkoutDetailsLinechartBinding.bind(findChildViewById);
                                                        r1 = R.id.layout_heart_rate;
                                                        View findChildViewById2 = ViewBindings.findChildViewById(R.id.layout_heart_rate, view);
                                                        if (findChildViewById2 != null) {
                                                            LayoutWorkoutDetailsLinechartBinding bind2 = LayoutWorkoutDetailsLinechartBinding.bind(findChildViewById2);
                                                            r1 = R.id.layout_splits;
                                                            View findChildViewById3 = ViewBindings.findChildViewById(R.id.layout_splits, view);
                                                            if (findChildViewById3 != null) {
                                                                LayoutWorkoutDetailsSplitsBinding bind3 = LayoutWorkoutDetailsSplitsBinding.bind(findChildViewById3);
                                                                r1 = R.id.layout_workout;
                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.layout_workout, view);
                                                                if (linearLayout != null) {
                                                                    r1 = R.id.map_view;
                                                                    MapView mapView = (MapView) ViewBindings.findChildViewById(R.id.map_view, view);
                                                                    if (mapView != null) {
                                                                        r1 = R.id.scroll_view;
                                                                        TopFadeScrollView topFadeScrollView = (TopFadeScrollView) ViewBindings.findChildViewById(R.id.scroll_view, view);
                                                                        if (topFadeScrollView != null) {
                                                                            r1 = R.id.toolbar_no_animation;
                                                                            CustomToolbar customToolbar = (CustomToolbar) ViewBindings.findChildViewById(R.id.toolbar_no_animation, view);
                                                                            if (customToolbar != null) {
                                                                                r1 = R.id.tv_toolbar_title;
                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_toolbar_title, view);
                                                                                if (textView != null) {
                                                                                    r1 = R.id.view_anim_container;
                                                                                    View findChildViewById4 = ViewBindings.findChildViewById(R.id.view_anim_container, view);
                                                                                    if (findChildViewById4 != null) {
                                                                                        r1 = R.id.view_gradient;
                                                                                        View findChildViewById5 = ViewBindings.findChildViewById(R.id.view_gradient, view);
                                                                                        if (findChildViewById5 != null) {
                                                                                            return new FragmentWorkoutDetailsBinding((RelativeLayout) view, button, imageView, button2, button3, composeView, composeView2, relativeLayout, frameLayout, imageView2, imageView3, imageView4, bind, bind2, bind3, linearLayout, mapView, topFadeScrollView, customToolbar, textView, findChildViewById4, findChildViewById5);
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

    public static FragmentWorkoutDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentWorkoutDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_workout_details, viewGroup, false);
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
