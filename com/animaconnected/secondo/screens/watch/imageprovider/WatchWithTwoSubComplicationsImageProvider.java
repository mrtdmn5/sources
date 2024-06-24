package com.animaconnected.secondo.screens.watch.imageprovider;

import com.animaconnected.secondo.behaviour.date.Date;
import com.animaconnected.secondo.behaviour.dayofweek.DayOfWeek;
import com.animaconnected.secondo.behaviour.steps.Steps;
import com.animaconnected.secondo.behaviour.time.Time;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.timer.Timer;
import com.animaconnected.watch.device.Capabilities;
import com.animaconnected.watch.device.Scale;
import com.animaconnected.watch.device.WatchConstantsKt;
import com.animaconnected.watch.device.WatchFace;
import com.kronaby.watch.app.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class WatchWithTwoSubComplicationsImageProvider extends WatchImageProvider {
    @Override // com.animaconnected.secondo.screens.watch.imageprovider.WatchImageProvider
    public int getComplicationsDragAndDropTargetLayout() {
        return R.layout.complications_draganddrop_target_layout_two_sub_complications;
    }

    @Override // com.animaconnected.secondo.screens.watch.imageprovider.WatchImageProvider
    public int getWatchDynamicImageHourHandResource(String str, Slot slot) {
        if (slot != Slot.SubComplication1 && slot != Slot.SubComplication2) {
            if (slot != Slot.MainComplication && slot != Slot.MainComplicationDouble) {
                if (slot == Slot.Unknown) {
                    if (!str.equals(Date.TYPE) && !str.equals(Steps.type) && !str.equals(DayOfWeek.TYPE)) {
                        return R.drawable.secondo_main_hour_hand;
                    }
                    return R.drawable.big_hand_android;
                }
                throw new RuntimeException("Unsupported slot: " + slot);
            }
            if (str.equals(Date.TYPE) || str.equals(Steps.type)) {
                return R.drawable.big_hand_android;
            }
            if (str.equals(Time.TYPE)) {
                return R.drawable.small_hand_android;
            }
            return R.drawable.secondo_main_hour_hand;
        }
        if (str.equals(Time.TYPE)) {
            Capabilities capabilities = ProviderFactory.getWatch().getCapabilities();
            WatchFace watchFace = WatchConstantsKt.toWatchFace(slot);
            if (capabilities.hasScaleOnWatchFace(watchFace, Scale.ZeroToTwentyFour)) {
                return R.drawable.big_hand_android;
            }
            if (capabilities.hasScaleOnWatchFace(watchFace, Scale.ZeroToTwelve)) {
                return R.drawable.small_hand_android;
            }
            throw new RuntimeException("Slot put on unsupported watch face");
        }
        if (str.equals(Date.TYPE)) {
            if (ProviderFactory.getWatch().getCapabilities().hasScaleOnWatchFace(WatchConstantsKt.toWatchFace(slot), Scale.ZeroToThirtyOne)) {
                return R.drawable.big_hand_android;
            }
            throw new RuntimeException("Slot put on unsupported watch face");
        }
        if (str.equals(DayOfWeek.TYPE)) {
            if (ProviderFactory.getWatch().getCapabilities().hasScaleOnWatchFace(WatchConstantsKt.toWatchFace(slot), Scale.DaysOfWeek)) {
                return R.drawable.big_hand_android;
            }
            throw new RuntimeException("Slot put on unsupported watch face");
        }
        if (!str.equals(Steps.type)) {
            return R.drawable.secondo_main_hour_hand;
        }
        return R.drawable.big_hand_android;
    }

    @Override // com.animaconnected.secondo.screens.watch.imageprovider.WatchImageProvider
    public int getWatchDynamicImageMinuteHandResource(String str, Slot slot) {
        if (slot != Slot.SubComplication1 && slot != Slot.SubComplication2) {
            if (slot != Slot.MainComplication && slot != Slot.MainComplicationDouble) {
                if (slot == Slot.Unknown) {
                    if (str.equals(Time.TYPE)) {
                        return R.drawable.big_hand_android;
                    }
                    return R.drawable.secondo_main_minute_hand;
                }
                throw new RuntimeException("Unsupported slot: " + slot);
            }
            if (str.equals(Time.TYPE)) {
                return R.drawable.big_hand_android;
            }
            return R.drawable.secondo_main_minute_hand;
        }
        if (str.equals(Time.TYPE)) {
            if (ProviderFactory.getWatch().getCapabilities().hasScaleOnWatchFace(WatchConstantsKt.toWatchFace(slot), Scale.ZeroToTwelve)) {
                return R.drawable.big_hand_android;
            }
            throw new RuntimeException("Slot put on unsupported watch face");
        }
        return R.drawable.secondo_minute_hand_details;
    }

    @Override // com.animaconnected.secondo.screens.watch.imageprovider.WatchImageProvider
    public int getWatchSubComplicationImageResource(String str, Slot slot) {
        if (str.equals(Steps.type)) {
            return R.drawable.percent;
        }
        if (str.equals(Date.TYPE)) {
            if (slot != Slot.SubComplication1 && slot != Slot.SubComplication2) {
                if (slot == Slot.MainComplication || slot == Slot.MainComplicationDouble || slot == Slot.Unknown) {
                    return R.drawable.date_0_31;
                }
                throw new IllegalArgumentException("Unsupported behaviour and slot combination. Behaviour: " + str + "Slot: " + slot);
            }
            if (ProviderFactory.getWatch().getCapabilities().hasScaleOnWatchFace(WatchConstantsKt.toWatchFace(slot), Scale.ZeroToThirtyOne)) {
                return R.drawable.date_0_31_1;
            }
            throw new RuntimeException("Slot put on unsupported watch face");
        }
        if (str.equals(Time.TYPE)) {
            if (slot != Slot.SubComplication1 && slot != Slot.SubComplication2) {
                if (slot == Slot.MainComplication || slot == Slot.MainComplicationDouble || slot == Slot.Unknown) {
                    return R.drawable.time_0_12;
                }
                throw new IllegalArgumentException("Unsupported behaviour and slot combination. Behaviour: " + str + "Slot: " + slot);
            }
            Capabilities capabilities = ProviderFactory.getWatch().getCapabilities();
            WatchFace watchFace = WatchConstantsKt.toWatchFace(slot);
            if (capabilities.hasScaleOnWatchFace(watchFace, Scale.ZeroToTwelve)) {
                return R.drawable.time_0_12;
            }
            if (capabilities.hasScaleOnWatchFace(watchFace, Scale.ZeroToTwentyFour)) {
                return R.drawable.time_0_24;
            }
            throw new RuntimeException("Slot put on unsupported watch face");
        }
        if (str.equals(Timer.TYPE)) {
            if (slot != Slot.SubComplication1 && slot != Slot.SubComplication2) {
                if (slot != Slot.MainComplication && slot != Slot.MainComplicationDouble) {
                    if (slot == Slot.Unknown) {
                        return R.drawable.generic_complication_0_60;
                    }
                    throw new IllegalArgumentException("Unsupported behaviour and slot combination. Behaviour: " + str + "Slot: " + slot);
                }
                return R.drawable.secondo_0_60;
            }
            return R.drawable.secondo_comp_0_59;
        }
        if (str.equals(DayOfWeek.TYPE)) {
            if (slot != Slot.SubComplication1 && slot != Slot.SubComplication2) {
                if (slot == Slot.Unknown) {
                    return R.drawable.dayofweek;
                }
                throw new IllegalArgumentException("Unsupported behaviour and slot combination. Behaviour: " + str + "Slot: " + slot);
            }
            if (ProviderFactory.getWatch().getCapabilities().hasScaleOnWatchFace(WatchConstantsKt.toWatchFace(slot), Scale.DaysOfWeek)) {
                return R.drawable.dayofweek;
            }
            throw new RuntimeException("Slot put on unsupported watch face");
        }
        throw new IllegalArgumentException("Unsupported behaviour: ".concat(str));
    }
}
