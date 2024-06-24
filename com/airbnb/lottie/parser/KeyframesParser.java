package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class KeyframesParser {
    public static final JsonReader.Options NAMES = JsonReader.Options.of("k");

    public static ArrayList parse(JsonReader jsonReader, LottieComposition lottieComposition, float f, ValueParser valueParser, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonReader.Token.STRING) {
            lottieComposition.addWarning("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(NAMES) != 0) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonReader.Token.NUMBER) {
                    arrayList.add(KeyframeParser.parse(jsonReader, lottieComposition, f, valueParser, false, z));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(KeyframeParser.parse(jsonReader, lottieComposition, f, valueParser, true, z));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(KeyframeParser.parse(jsonReader, lottieComposition, f, valueParser, false, z));
            }
        }
        jsonReader.endObject();
        setEndFrames(arrayList);
        return arrayList;
    }

    public static void setEndFrames(ArrayList arrayList) {
        int r2;
        T t;
        int size = arrayList.size();
        int r1 = 0;
        while (true) {
            r2 = size - 1;
            if (r1 >= r2) {
                break;
            }
            Keyframe keyframe = (Keyframe) arrayList.get(r1);
            r1++;
            Keyframe keyframe2 = (Keyframe) arrayList.get(r1);
            keyframe.endFrame = Float.valueOf(keyframe2.startFrame);
            if (keyframe.endValue == 0 && (t = keyframe2.startValue) != 0) {
                keyframe.endValue = t;
                if (keyframe instanceof PathKeyframe) {
                    ((PathKeyframe) keyframe).createPath();
                }
            }
        }
        Keyframe keyframe3 = (Keyframe) arrayList.get(r2);
        if ((keyframe3.startValue == 0 || keyframe3.endValue == 0) && arrayList.size() > 1) {
            arrayList.remove(keyframe3);
        }
    }
}
