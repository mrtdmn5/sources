package com.animaconnected.secondo.screens.watch.imageprovider;

import android.content.Context;
import android.graphics.Bitmap;
import com.animaconnected.info.DeviceType;
import com.animaconnected.info.FirmwareVariant;
import com.animaconnected.secondo.provider.productinfo.watchimage.WatchImageHelper;
import com.animaconnected.secondo.provider.productinfo.watchimage.WatchImageType;
import com.animaconnected.watch.device.Capabilities;
import com.kronaby.watch.app.R;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class WatchImageModelFactory {
    private static final String DK52_DEFAULT_SKU = "DK52_DEFAULT_SKU";
    private static final String GARBO_DEFAULT_SKU = "GARBO_DEFAULT_SKU";
    private static final String MEZZO_DEFAULT_SKU = "MEZZO_DEFAULT_SKU";
    private static final String PASCAL_DEFAULT_SKU = "PASCAL_DEFAULT_SKU";
    private static final String SECONDO_DEFAULT_SKU = "SECONDO_DEFAULT_SKU";
    private static final HashMap<String, HashMap<WatchImageType, Integer>> SKETCH_IMAGE_MODEL_DICTIONARY = new HashMap<String, HashMap<WatchImageType, Integer>>() { // from class: com.animaconnected.secondo.screens.watch.imageprovider.WatchImageModelFactory.1
        {
            put("GARBO_DEFAULT_SKU", new HashMap<WatchImageType, Integer>() { // from class: com.animaconnected.secondo.screens.watch.imageprovider.WatchImageModelFactory.1.1
                {
                    put(WatchImageType.SKU, Integer.valueOf(R.drawable.sketch_garbo));
                    put(WatchImageType.THUMBNAIL, Integer.valueOf(R.drawable.sketch_garbo_thumb));
                    put(WatchImageType.MAIN_HOUR_HAND, Integer.valueOf(R.drawable.sketch_main_hr));
                    put(WatchImageType.MAIN_MIN_HAND, Integer.valueOf(R.drawable.sketch_main_min));
                    put(WatchImageType.GLOW, Integer.valueOf(R.drawable.garbo_glow));
                }
            });
            put("SECONDO_DEFAULT_SKU", new HashMap<WatchImageType, Integer>() { // from class: com.animaconnected.secondo.screens.watch.imageprovider.WatchImageModelFactory.1.2
                {
                    put(WatchImageType.SKU, Integer.valueOf(R.drawable.sketch_secondo));
                    put(WatchImageType.THUMBNAIL, Integer.valueOf(R.drawable.sketch_secondo_thumb));
                    put(WatchImageType.MAIN_HOUR_HAND, Integer.valueOf(R.drawable.sketch_main_hr));
                    put(WatchImageType.MAIN_MIN_HAND, Integer.valueOf(R.drawable.sketch_main_min));
                    put(WatchImageType.SUB_HOUR_HAND, Integer.valueOf(R.drawable.sketch_sub1_hr));
                    put(WatchImageType.SUB_MIN_HAND, Integer.valueOf(R.drawable.sketch_sub1_min));
                    put(WatchImageType.GLOW, Integer.valueOf(R.drawable.secondo_glow));
                }
            });
            put("MEZZO_DEFAULT_SKU", new HashMap<WatchImageType, Integer>() { // from class: com.animaconnected.secondo.screens.watch.imageprovider.WatchImageModelFactory.1.3
                {
                    put(WatchImageType.SKU, Integer.valueOf(R.drawable.sketch_mezzo));
                    put(WatchImageType.THUMBNAIL, Integer.valueOf(R.drawable.sketch_mezzo_thumb));
                    put(WatchImageType.MAIN_HOUR_HAND, Integer.valueOf(R.drawable.sketch_main_hr));
                    put(WatchImageType.MAIN_MIN_HAND, Integer.valueOf(R.drawable.sketch_main_min));
                    put(WatchImageType.SUB_MIN_HAND, Integer.valueOf(R.drawable.sketch_sub1_min));
                    put(WatchImageType.GLOW, Integer.valueOf(R.drawable.secondo_glow));
                }
            });
            put("SONIC_DEFAULT_SKU", new HashMap<WatchImageType, Integer>() { // from class: com.animaconnected.secondo.screens.watch.imageprovider.WatchImageModelFactory.1.4
                {
                    put(WatchImageType.SKU, Integer.valueOf(R.drawable.sketch_sonic));
                    put(WatchImageType.THUMBNAIL, Integer.valueOf(R.drawable.sketch_sonic_thumb));
                    put(WatchImageType.MAIN_HOUR_HAND, Integer.valueOf(R.drawable.sketch_main_hr));
                    put(WatchImageType.MAIN_MIN_HAND, Integer.valueOf(R.drawable.sketch_main_min));
                    put(WatchImageType.SUB_MIN_HAND, Integer.valueOf(R.drawable.sketch_sub2_min));
                    put(WatchImageType.GLOW, Integer.valueOf(R.drawable.secondo_glow));
                }
            });
            put("DK52_DEFAULT_SKU", new HashMap<WatchImageType, Integer>() { // from class: com.animaconnected.secondo.screens.watch.imageprovider.WatchImageModelFactory.1.5
                {
                    WatchImageType watchImageType = WatchImageType.SKU;
                    Integer valueOf = Integer.valueOf(R.drawable.nrf52);
                    put(watchImageType, valueOf);
                    put(WatchImageType.THUMBNAIL, valueOf);
                    put(WatchImageType.MAIN_HOUR_HAND, -1);
                    put(WatchImageType.MAIN_MIN_HAND, -1);
                    put(WatchImageType.GLOW, -1);
                }
            });
            put("PASCAL_DEFAULT_SKU", new HashMap<WatchImageType, Integer>() { // from class: com.animaconnected.secondo.screens.watch.imageprovider.WatchImageModelFactory.1.6
                {
                    put(WatchImageType.SKU, Integer.valueOf(R.drawable.pascal_watch_sketch));
                    put(WatchImageType.THUMBNAIL, Integer.valueOf(R.drawable.pascal_watch_sketch_thumb));
                    put(WatchImageType.MAIN_HOUR_HAND, Integer.valueOf(R.drawable.pascal_sketch_main_hr));
                    put(WatchImageType.MAIN_MIN_HAND, Integer.valueOf(R.drawable.pascal_sketch_main_min));
                    put(WatchImageType.GLOW, -1);
                }
            });
        }
    };
    private static final String SONIC_DEFAULT_SKU = "SONIC_DEFAULT_SKU";
    private static final String WATCH_TYPE_2_1_1_DEFAULT_SKU = "SONIC_DEFAULT_SKU";
    private static final String WATCH_TYPE_2_1_DEFAULT_SKU = "MEZZO_DEFAULT_SKU";
    private static final String WATCH_TYPE_2_2_DEFAULT_SKU = "SECONDO_DEFAULT_SKU";
    private static final String WATCH_TYPE_2_DEFAULT_SKU = "GARBO_DEFAULT_SKU";
    private static final String WATCH_TYPE_2_SUB_DISPLAY_DEFAULT_SKU = "PASCAL_DEFAULT_SKU";
    private static final String WATCH_TYPE_DK52_BOARD = "DK52_DEFAULT_SKU";
    private static final String WATCH_TYPE_UNKNOWN_DEFAULT_SKU = "GARBO_DEFAULT_SKU";

    /* renamed from: com.animaconnected.secondo.screens.watch.imageprovider.WatchImageModelFactory$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$animaconnected$info$DeviceType;

        static {
            int[] r0 = new int[DeviceType.values().length];
            $SwitchMap$com$animaconnected$info$DeviceType = r0;
            try {
                r0[DeviceType.BT001.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$animaconnected$info$DeviceType[DeviceType.BT002.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$animaconnected$info$DeviceType[DeviceType.FKS927.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$animaconnected$info$DeviceType[DeviceType.FKS933.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$animaconnected$info$DeviceType[DeviceType.BT003.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$animaconnected$info$DeviceType[DeviceType.PASCAL_FULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$animaconnected$info$DeviceType[DeviceType.PASCAL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static HashMap<WatchImageType, Bitmap> getDefaultSketch(Context context, DeviceType deviceType, FirmwareVariant firmwareVariant) {
        HashMap<WatchImageType, Bitmap> hashMap = new HashMap<>();
        String str = "GARBO_DEFAULT_SKU";
        switch (AnonymousClass2.$SwitchMap$com$animaconnected$info$DeviceType[deviceType.ordinal()]) {
            case 1:
                str = "SECONDO_DEFAULT_SKU";
                break;
            case 6:
            case 7:
                if (firmwareVariant.getValue() != null && firmwareVariant.getValue().intValue() == 201) {
                    str = "DK52_DEFAULT_SKU";
                    break;
                } else {
                    str = "PASCAL_DEFAULT_SKU";
                    break;
                }
                break;
        }
        for (Map.Entry<WatchImageType, Integer> entry : SKETCH_IMAGE_MODEL_DICTIONARY.get(str).entrySet()) {
            hashMap.put(entry.getKey(), WatchImageHelper.getBitmapFromResource(context, entry.getValue().intValue()));
        }
        return hashMap;
    }

    public static HashMap<WatchImageType, Bitmap> getSketchImagesFromWatchType(Context context, Capabilities capabilities, DeviceType deviceType, FirmwareVariant firmwareVariant) {
        HashMap<WatchImageType, Integer> sketchResources = getSketchResources(capabilities, deviceType, firmwareVariant);
        HashMap<WatchImageType, Bitmap> hashMap = new HashMap<>();
        for (Map.Entry<WatchImageType, Integer> entry : sketchResources.entrySet()) {
            hashMap.put(entry.getKey(), WatchImageHelper.getBitmapFromResource(context, entry.getValue().intValue()));
        }
        return hashMap;
    }

    private static HashMap<WatchImageType, Integer> getSketchResources(Capabilities capabilities, DeviceType deviceType, FirmwareVariant firmwareVariant) {
        if (deviceType != DeviceType.PASCAL && deviceType != DeviceType.PASCAL_FULL) {
            if (capabilities.hasWatchfaceLayout(2)) {
                return SKETCH_IMAGE_MODEL_DICTIONARY.get("GARBO_DEFAULT_SKU");
            }
            if (capabilities.hasWatchfaceLayout(2, 1)) {
                return SKETCH_IMAGE_MODEL_DICTIONARY.get("MEZZO_DEFAULT_SKU");
            }
            if (capabilities.hasWatchfaceLayout(2, 2)) {
                return SKETCH_IMAGE_MODEL_DICTIONARY.get("SECONDO_DEFAULT_SKU");
            }
            if (capabilities.hasWatchfaceLayout(2, 1, 1)) {
                return SKETCH_IMAGE_MODEL_DICTIONARY.get("SONIC_DEFAULT_SKU");
            }
            return SKETCH_IMAGE_MODEL_DICTIONARY.get("GARBO_DEFAULT_SKU");
        }
        if (firmwareVariant.getValue() != null && firmwareVariant.getValue().intValue() == 201) {
            return SKETCH_IMAGE_MODEL_DICTIONARY.get("DK52_DEFAULT_SKU");
        }
        return SKETCH_IMAGE_MODEL_DICTIONARY.get("PASCAL_DEFAULT_SKU");
    }
}
