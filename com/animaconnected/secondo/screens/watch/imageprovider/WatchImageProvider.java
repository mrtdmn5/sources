package com.animaconnected.secondo.screens.watch.imageprovider;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.animaconnected.secondo.behaviour.date.Date;
import com.animaconnected.secondo.behaviour.steps.Steps;
import com.animaconnected.secondo.behaviour.time.Time;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.productinfo.ProductInfoProvider;
import com.animaconnected.secondo.provider.productinfo.watchimage.WatchImageHelper;
import com.animaconnected.secondo.provider.productinfo.watchimage.WatchImageType;
import com.animaconnected.secondo.widget.WatchLayout;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.timer.Timer;
import com.animaconnected.watch.device.Capabilities;
import com.kronaby.watch.app.R;
import java.util.Map;

/* loaded from: classes3.dex */
public class WatchImageProvider {
    public static WatchLayout addWatchLayout(Context context, ViewGroup viewGroup) {
        View inflate;
        int r2;
        Capabilities capabilities = ProviderFactory.getWatch().getCapabilities();
        Map images = ProductInfoProvider.getImages();
        if (!WatchImageHelper.validateImages(capabilities, images)) {
            images = WatchImageModelFactory.getSketchImagesFromWatchType(context, capabilities, ProviderFactory.getWatch().getDeviceType(), ProviderFactory.getWatch().getFirmwareVariant());
        }
        boolean hasSubComplications = capabilities.hasSubComplications();
        boolean hasOneSubComplication = capabilities.hasOneSubComplication();
        boolean hasTwoSubComplications = capabilities.hasTwoSubComplications();
        if (hasSubComplications && images.size() != 4) {
            if (hasOneSubComplication) {
                if (capabilities.hasWatchfaceLayout(2, 2)) {
                    r2 = R.layout.watch_layout_with_one_sub_complication_2_2;
                } else if (capabilities.hasWatchfaceLayout(2, 1)) {
                    r2 = R.layout.watch_layout_with_one_sub_complication_2_1;
                } else {
                    throw new RuntimeException("Unknown watch type");
                }
                inflate = LayoutInflater.from(context).inflate(r2, viewGroup, true);
                if (capabilities.hasWatchfaceLayout(2, 1)) {
                    ((ImageView) inflate.findViewById(R.id.imageViewWatchHandHoursComplication)).setImageBitmap((Bitmap) images.get(WatchImageType.SUB_MIN_HAND));
                } else {
                    ((ImageView) inflate.findViewById(R.id.imageViewWatchHandHoursComplication)).setImageBitmap((Bitmap) images.get(WatchImageType.SUB_HOUR_HAND));
                    ((ImageView) inflate.findViewById(R.id.imageViewWatchHandMinutesComplication)).setImageBitmap((Bitmap) images.get(WatchImageType.SUB_MIN_HAND));
                }
                ((ImageView) inflate.findViewById(R.id.imageViewWatchGlass)).setImageBitmap((Bitmap) images.get(WatchImageType.GLOW));
            } else if (hasTwoSubComplications) {
                if (capabilities.hasWatchfaceLayout(2, 1, 1)) {
                    inflate = LayoutInflater.from(context).inflate(R.layout.watch_layout_with_two_sub_complications_2_1_1, viewGroup, true);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageViewWatchHandHoursComplication1);
                    WatchImageType watchImageType = WatchImageType.SUB_MIN_HAND;
                    imageView.setImageBitmap((Bitmap) images.get(watchImageType));
                    ((ImageView) inflate.findViewById(R.id.imageViewWatchHandHoursComplication2)).setImageBitmap((Bitmap) images.get(watchImageType));
                    ((ImageView) inflate.findViewById(R.id.imageViewWatchGlass)).setImageBitmap((Bitmap) images.get(WatchImageType.GLOW));
                } else {
                    throw new RuntimeException("Unknown watch type");
                }
            } else {
                throw new IllegalArgumentException("Unknown skuNumber");
            }
        } else {
            inflate = LayoutInflater.from(context).inflate(R.layout.clickable_watch_layout, viewGroup, true);
            ((ImageView) inflate.findViewById(R.id.imageViewWatchGlass)).setImageBitmap((Bitmap) images.get(WatchImageType.GLOW));
        }
        ((ImageView) inflate.findViewById(R.id.imageViewMeter)).setImageBitmap((Bitmap) images.get(WatchImageType.SKU));
        ((ImageView) inflate.findViewById(R.id.imageViewWatchHandHours)).setImageBitmap((Bitmap) images.get(WatchImageType.MAIN_HOUR_HAND));
        ((ImageView) inflate.findViewById(R.id.imageViewWatchHandMinutes)).setImageBitmap((Bitmap) images.get(WatchImageType.MAIN_MIN_HAND));
        return (WatchLayout) viewGroup.getChildAt(viewGroup.getChildCount() - 1);
    }

    public int getComplicationsDragAndDropTargetLayout() {
        return R.layout.complications_draganddrop_target_layout_garbo;
    }

    public int getPushersDragAndDropTargetLayout() {
        int numOfButtons = ProviderFactory.getWatch().getCapabilities().getNumOfButtons();
        if (numOfButtons != 1) {
            if (numOfButtons == 3) {
                return R.layout.pushers_two_pushers_draganddrop_target_layout;
            }
            throw new IllegalArgumentException("Unsupported number of pushers");
        }
        return R.layout.pushers_one_pusher_draganddrop_target_layout;
    }

    public int getWatchDynamicImageHourHandResource(String str, Slot slot) {
        if (!str.equals(Date.TYPE) && !str.equals(Steps.type)) {
            if (str.equals(Time.TYPE)) {
                return R.drawable.small_hand_android;
            }
            return R.drawable.garbo_hour_hand_details;
        }
        return R.drawable.big_hand_android;
    }

    public int getWatchDynamicImageMinuteHandResource(String str, Slot slot) {
        if (str.equals(Time.TYPE)) {
            return R.drawable.big_hand_android;
        }
        return R.drawable.garbo_minute_hand_details;
    }

    public int getWatchSubComplicationImageResource(String str, Slot slot) {
        if (str.equals(Steps.type)) {
            return R.drawable.percent;
        }
        if (str.equals(Date.TYPE)) {
            return R.drawable.date_0_31;
        }
        if (str.equals(Time.TYPE)) {
            return R.drawable.time_0_12;
        }
        if (str.equals(Timer.TYPE)) {
            return R.drawable.garbo_watch_0_55;
        }
        throw new IllegalArgumentException("Unsupported behaviour: ".concat(str));
    }
}
