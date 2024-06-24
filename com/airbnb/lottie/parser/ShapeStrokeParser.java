package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.animaconnected.watch.provider.DateTimeFormattersKt;

/* loaded from: classes.dex */
public final class ShapeStrokeParser {
    public static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "c", "w", "o", "lc", "lj", "ml", "hd", DateTimeFormattersKt.dayInMonthFormat);
    public static final JsonReader.Options DASH_PATTERN_NAMES = JsonReader.Options.of("n", "v");
}
