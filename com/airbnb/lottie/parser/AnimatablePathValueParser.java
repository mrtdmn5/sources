package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonUtf8Reader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class AnimatablePathValueParser {
    public static final JsonReader.Options NAMES = JsonReader.Options.of("k", "x", DateTimeFormattersKt.yearNoPaddingFormat);

    public static AnimatablePathValue parse(JsonUtf8Reader jsonUtf8Reader, LottieComposition lottieComposition) throws IOException {
        boolean z;
        ArrayList arrayList = new ArrayList();
        if (jsonUtf8Reader.peek() == JsonReader.Token.BEGIN_ARRAY) {
            jsonUtf8Reader.beginArray();
            while (jsonUtf8Reader.hasNext()) {
                if (jsonUtf8Reader.peek() == JsonReader.Token.BEGIN_OBJECT) {
                    z = true;
                } else {
                    z = false;
                }
                arrayList.add(new PathKeyframe(lottieComposition, KeyframeParser.parse(jsonUtf8Reader, lottieComposition, Utils.dpScale(), PathParser.INSTANCE, z, false)));
            }
            jsonUtf8Reader.endArray();
            KeyframesParser.setEndFrames(arrayList);
        } else {
            arrayList.add(new Keyframe(JsonUtils.jsonToPoint(jsonUtf8Reader, Utils.dpScale())));
        }
        return new AnimatablePathValue(arrayList);
    }

    public static AnimatableValue parseSplitPath(JsonUtf8Reader jsonUtf8Reader, LottieComposition lottieComposition) throws IOException {
        jsonUtf8Reader.beginObject();
        AnimatablePathValue animatablePathValue = null;
        AnimatableFloatValue animatableFloatValue = null;
        boolean z = false;
        AnimatableFloatValue animatableFloatValue2 = null;
        while (jsonUtf8Reader.peek() != JsonReader.Token.END_OBJECT) {
            int selectName = jsonUtf8Reader.selectName(NAMES);
            if (selectName != 0) {
                if (selectName != 1) {
                    if (selectName != 2) {
                        jsonUtf8Reader.skipName();
                        jsonUtf8Reader.skipValue();
                    } else if (jsonUtf8Reader.peek() == JsonReader.Token.STRING) {
                        jsonUtf8Reader.skipValue();
                        z = true;
                    } else {
                        animatableFloatValue = AnimatableValueParser.parseFloat(jsonUtf8Reader, lottieComposition, true);
                    }
                } else if (jsonUtf8Reader.peek() == JsonReader.Token.STRING) {
                    jsonUtf8Reader.skipValue();
                    z = true;
                } else {
                    animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonUtf8Reader, lottieComposition, true);
                }
            } else {
                animatablePathValue = parse(jsonUtf8Reader, lottieComposition);
            }
        }
        jsonUtf8Reader.endObject();
        if (z) {
            lottieComposition.addWarning("Lottie doesn't support expressions.");
        }
        if (animatablePathValue != null) {
            return animatablePathValue;
        }
        return new AnimatableSplitDimensionPathValue(animatableFloatValue2, animatableFloatValue);
    }
}
