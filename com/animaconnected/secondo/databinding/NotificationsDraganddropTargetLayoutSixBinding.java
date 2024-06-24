package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.screens.notification.widget.FillLayout;
import com.animaconnected.secondo.screens.notification.widget.NotificationsDragAndDropTargetLayout;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class NotificationsDraganddropTargetLayoutSixBinding implements ViewBinding {
    public final View containerLeftVerticalDivider;
    public final View containerRightVerticalDivider;
    public final RelativeLayout draganddropSourceGridViewPlaceHolder;
    public final FillLayout dropContainer1;
    public final FillLayout dropContainer2;
    public final FillLayout dropContainer3;
    public final FillLayout dropContainer4;
    public final FillLayout dropContainer5;
    public final FillLayout dropContainer6;
    public final LinearLayout dropTargetLayer;
    public final ImageView fiveNotificationsIcon;
    public final ImageView fourNotificationsIcon;
    public final View notificationsBottomLine;
    private final NotificationsDragAndDropTargetLayout rootView;
    public final ImageView sixNotificationsIcon;
    public final LinearLayout vibratingIconOne;
    public final LinearLayout vibratingIconThree;
    public final LinearLayout vibratingIconTwo;
    public final ImageView watchIconOne;
    public final ImageView watchIconThree;
    public final ImageView watchIconTwo;

    private NotificationsDraganddropTargetLayoutSixBinding(NotificationsDragAndDropTargetLayout notificationsDragAndDropTargetLayout, View view, View view2, RelativeLayout relativeLayout, FillLayout fillLayout, FillLayout fillLayout2, FillLayout fillLayout3, FillLayout fillLayout4, FillLayout fillLayout5, FillLayout fillLayout6, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, View view3, ImageView imageView3, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ImageView imageView4, ImageView imageView5, ImageView imageView6) {
        this.rootView = notificationsDragAndDropTargetLayout;
        this.containerLeftVerticalDivider = view;
        this.containerRightVerticalDivider = view2;
        this.draganddropSourceGridViewPlaceHolder = relativeLayout;
        this.dropContainer1 = fillLayout;
        this.dropContainer2 = fillLayout2;
        this.dropContainer3 = fillLayout3;
        this.dropContainer4 = fillLayout4;
        this.dropContainer5 = fillLayout5;
        this.dropContainer6 = fillLayout6;
        this.dropTargetLayer = linearLayout;
        this.fiveNotificationsIcon = imageView;
        this.fourNotificationsIcon = imageView2;
        this.notificationsBottomLine = view3;
        this.sixNotificationsIcon = imageView3;
        this.vibratingIconOne = linearLayout2;
        this.vibratingIconThree = linearLayout3;
        this.vibratingIconTwo = linearLayout4;
        this.watchIconOne = imageView4;
        this.watchIconThree = imageView5;
        this.watchIconTwo = imageView6;
    }

    public static NotificationsDraganddropTargetLayoutSixBinding bind(View view) {
        int r1 = R.id.container_left_vertical_divider;
        View findChildViewById = ViewBindings.findChildViewById(R.id.container_left_vertical_divider, view);
        if (findChildViewById != null) {
            r1 = R.id.container_right_vertical_divider;
            View findChildViewById2 = ViewBindings.findChildViewById(R.id.container_right_vertical_divider, view);
            if (findChildViewById2 != null) {
                r1 = R.id.draganddrop_source_grid_view_place_holder;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(R.id.draganddrop_source_grid_view_place_holder, view);
                if (relativeLayout != null) {
                    r1 = R.id.drop_container_1;
                    FillLayout fillLayout = (FillLayout) ViewBindings.findChildViewById(R.id.drop_container_1, view);
                    if (fillLayout != null) {
                        r1 = R.id.drop_container_2;
                        FillLayout fillLayout2 = (FillLayout) ViewBindings.findChildViewById(R.id.drop_container_2, view);
                        if (fillLayout2 != null) {
                            r1 = R.id.drop_container_3;
                            FillLayout fillLayout3 = (FillLayout) ViewBindings.findChildViewById(R.id.drop_container_3, view);
                            if (fillLayout3 != null) {
                                r1 = R.id.drop_container_4;
                                FillLayout fillLayout4 = (FillLayout) ViewBindings.findChildViewById(R.id.drop_container_4, view);
                                if (fillLayout4 != null) {
                                    r1 = R.id.drop_container_5;
                                    FillLayout fillLayout5 = (FillLayout) ViewBindings.findChildViewById(R.id.drop_container_5, view);
                                    if (fillLayout5 != null) {
                                        r1 = R.id.drop_container_6;
                                        FillLayout fillLayout6 = (FillLayout) ViewBindings.findChildViewById(R.id.drop_container_6, view);
                                        if (fillLayout6 != null) {
                                            r1 = R.id.drop_target_layer;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.drop_target_layer, view);
                                            if (linearLayout != null) {
                                                r1 = R.id.five_notifications_icon;
                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.five_notifications_icon, view);
                                                if (imageView != null) {
                                                    r1 = R.id.four_notifications_icon;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.four_notifications_icon, view);
                                                    if (imageView2 != null) {
                                                        r1 = R.id.notifications_bottom_line;
                                                        View findChildViewById3 = ViewBindings.findChildViewById(R.id.notifications_bottom_line, view);
                                                        if (findChildViewById3 != null) {
                                                            r1 = R.id.six_notifications_icon;
                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(R.id.six_notifications_icon, view);
                                                            if (imageView3 != null) {
                                                                r1 = R.id.vibrating_icon_one;
                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.vibrating_icon_one, view);
                                                                if (linearLayout2 != null) {
                                                                    r1 = R.id.vibrating_icon_three;
                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(R.id.vibrating_icon_three, view);
                                                                    if (linearLayout3 != null) {
                                                                        r1 = R.id.vibrating_icon_two;
                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(R.id.vibrating_icon_two, view);
                                                                        if (linearLayout4 != null) {
                                                                            r1 = R.id.watch_icon_one;
                                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(R.id.watch_icon_one, view);
                                                                            if (imageView4 != null) {
                                                                                r1 = R.id.watch_icon_three;
                                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(R.id.watch_icon_three, view);
                                                                                if (imageView5 != null) {
                                                                                    r1 = R.id.watch_icon_two;
                                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(R.id.watch_icon_two, view);
                                                                                    if (imageView6 != null) {
                                                                                        return new NotificationsDraganddropTargetLayoutSixBinding((NotificationsDragAndDropTargetLayout) view, findChildViewById, findChildViewById2, relativeLayout, fillLayout, fillLayout2, fillLayout3, fillLayout4, fillLayout5, fillLayout6, linearLayout, imageView, imageView2, findChildViewById3, imageView3, linearLayout2, linearLayout3, linearLayout4, imageView4, imageView5, imageView6);
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

    public static NotificationsDraganddropTargetLayoutSixBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static NotificationsDraganddropTargetLayoutSixBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.notifications_draganddrop_target_layout_six, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public NotificationsDragAndDropTargetLayout getRoot() {
        return this.rootView;
    }
}
