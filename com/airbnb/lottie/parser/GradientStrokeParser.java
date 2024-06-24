package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.animaconnected.watch.provider.DateTimeFormattersKt;

/* loaded from: classes.dex */
public final class GradientStrokeParser {
    public static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", DateTimeFormattersKt.dayInMonthFormat);
    public static final JsonReader.Options GRADIENT_NAMES = JsonReader.Options.of("p", "k");
    public static final JsonReader.Options DASH_PATTERN_NAMES = JsonReader.Options.of("n", "v");
}
