package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.animaconnected.watch.provider.DateTimeFormattersKt;

/* loaded from: classes.dex */
public final class LayerParser {
    public static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd");
    public static final JsonReader.Options TEXT_NAMES = JsonReader.Options.of(DateTimeFormattersKt.dayInMonthFormat, "a");
    public static final JsonReader.Options EFFECTS_NAMES = JsonReader.Options.of("ty", "nm");

    /* renamed from: com.airbnb.lottie.parser.LayerParser$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType;

        static {
            int[] r0 = new int[Layer.MatteType.values().length];
            $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType = r0;
            try {
                r0[Layer.MatteType.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[Layer.MatteType.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0061. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0465  */
    /* JADX WARN: Type inference failed for: r4v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.airbnb.lottie.model.layer.Layer parse(com.airbnb.lottie.parser.moshi.JsonUtf8Reader r48, com.airbnb.lottie.LottieComposition r49) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1564
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.LayerParser.parse(com.airbnb.lottie.parser.moshi.JsonUtf8Reader, com.airbnb.lottie.LottieComposition):com.airbnb.lottie.model.layer.Layer");
    }
}
