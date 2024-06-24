package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public final class ShapeDataParser implements ValueParser<ShapeData> {
    public static final ShapeDataParser INSTANCE = new ShapeDataParser();
    public static final JsonReader.Options NAMES = JsonReader.Options.of("c", "v", "i", "o");

    @Override // com.airbnb.lottie.parser.ValueParser
    public final ShapeData parse(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName != 0) {
                if (selectName != 1) {
                    if (selectName != 2) {
                        if (selectName != 3) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        } else {
                            arrayList3 = JsonUtils.jsonToPoints(jsonReader, f);
                        }
                    } else {
                        arrayList2 = JsonUtils.jsonToPoints(jsonReader, f);
                    }
                } else {
                    arrayList = JsonUtils.jsonToPoints(jsonReader, f);
                }
            } else {
                z = jsonReader.nextBoolean();
            }
        }
        jsonReader.endObject();
        if (jsonReader.peek() == JsonReader.Token.END_ARRAY) {
            jsonReader.endArray();
        }
        if (arrayList != null && arrayList2 != null && arrayList3 != null) {
            if (arrayList.isEmpty()) {
                return new ShapeData(new PointF(), false, Collections.emptyList());
            }
            int size = arrayList.size();
            PointF pointF = (PointF) arrayList.get(0);
            ArrayList arrayList4 = new ArrayList(size);
            for (int r7 = 1; r7 < size; r7++) {
                PointF pointF2 = (PointF) arrayList.get(r7);
                int r9 = r7 - 1;
                arrayList4.add(new CubicCurveData(MiscUtils.addPoints((PointF) arrayList.get(r9), (PointF) arrayList3.get(r9)), MiscUtils.addPoints(pointF2, (PointF) arrayList2.get(r7)), pointF2));
            }
            if (z) {
                PointF pointF3 = (PointF) arrayList.get(0);
                int r13 = size - 1;
                arrayList4.add(new CubicCurveData(MiscUtils.addPoints((PointF) arrayList.get(r13), (PointF) arrayList3.get(r13)), MiscUtils.addPoints(pointF3, (PointF) arrayList2.get(0)), pointF3));
            }
            return new ShapeData(pointF, z, arrayList4);
        }
        throw new IllegalArgumentException("Shape data was missing information.");
    }
}
