package com.airbnb.lottie.parser;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonUtf8Reader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class LottieCompositionMoshiParser {
    public static final JsonReader.Options NAMES = JsonReader.Options.of("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");
    public static final JsonReader.Options ASSETS_NAMES = JsonReader.Options.of(ConfigurationItem.COLUMN_NAME_ID, "layers", "w", "h", "p", "u");
    public static final JsonReader.Options FONT_NAMES = JsonReader.Options.of("list");
    public static final JsonReader.Options MARKER_NAMES = JsonReader.Options.of("cm", "tm", "dr");

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0046. Please report as an issue. */
    public static LottieComposition parse(JsonUtf8Reader jsonUtf8Reader) throws IOException {
        float f;
        HashMap hashMap;
        ArrayList arrayList;
        SparseArrayCompat<FontCharacter> sparseArrayCompat;
        int r25;
        LongSparseArray<Layer> longSparseArray;
        float f2;
        float f3;
        boolean z;
        int r252;
        float f4;
        LongSparseArray<Layer> longSparseArray2;
        float f5;
        float f6;
        float f7;
        HashMap hashMap2;
        ArrayList arrayList2;
        SparseArrayCompat<FontCharacter> sparseArrayCompat2;
        float f8;
        float f9;
        LongSparseArray<Layer> longSparseArray3;
        float dpScale = Utils.dpScale();
        LongSparseArray<Layer> longSparseArray4 = new LongSparseArray<>();
        ArrayList arrayList3 = new ArrayList();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        HashMap hashMap5 = new HashMap();
        ArrayList arrayList4 = new ArrayList();
        SparseArrayCompat<FontCharacter> sparseArrayCompat3 = new SparseArrayCompat<>();
        LottieComposition lottieComposition = new LottieComposition();
        jsonUtf8Reader.beginObject();
        int r10 = 0;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        int r15 = 0;
        while (jsonUtf8Reader.hasNext()) {
            float f13 = f10;
            switch (jsonUtf8Reader.selectName(NAMES)) {
                case 0:
                    f7 = dpScale;
                    hashMap2 = hashMap5;
                    arrayList2 = arrayList4;
                    sparseArrayCompat2 = sparseArrayCompat3;
                    f8 = f11;
                    f9 = f12;
                    longSparseArray3 = longSparseArray4;
                    r15 = jsonUtf8Reader.nextInt();
                    longSparseArray4 = longSparseArray3;
                    f10 = f13;
                    dpScale = f7;
                    f11 = f8;
                    arrayList4 = arrayList2;
                    f12 = f9;
                    hashMap5 = hashMap2;
                    sparseArrayCompat3 = sparseArrayCompat2;
                    break;
                case 1:
                    f7 = dpScale;
                    hashMap2 = hashMap5;
                    arrayList2 = arrayList4;
                    sparseArrayCompat2 = sparseArrayCompat3;
                    f8 = f11;
                    f9 = f12;
                    longSparseArray3 = longSparseArray4;
                    r10 = jsonUtf8Reader.nextInt();
                    longSparseArray4 = longSparseArray3;
                    f10 = f13;
                    dpScale = f7;
                    f11 = f8;
                    arrayList4 = arrayList2;
                    f12 = f9;
                    hashMap5 = hashMap2;
                    sparseArrayCompat3 = sparseArrayCompat2;
                    break;
                case 2:
                    f = dpScale;
                    hashMap = hashMap5;
                    arrayList = arrayList4;
                    sparseArrayCompat = sparseArrayCompat3;
                    r25 = r10;
                    longSparseArray = longSparseArray4;
                    f11 = (float) jsonUtf8Reader.nextDouble();
                    f10 = f13;
                    longSparseArray4 = longSparseArray;
                    dpScale = f;
                    arrayList4 = arrayList;
                    hashMap5 = hashMap;
                    sparseArrayCompat3 = sparseArrayCompat;
                    r10 = r25;
                    break;
                case 3:
                    f = dpScale;
                    hashMap = hashMap5;
                    arrayList = arrayList4;
                    sparseArrayCompat = sparseArrayCompat3;
                    r25 = r10;
                    longSparseArray = longSparseArray4;
                    f12 = ((float) jsonUtf8Reader.nextDouble()) - 0.01f;
                    f10 = f13;
                    longSparseArray4 = longSparseArray;
                    dpScale = f;
                    arrayList4 = arrayList;
                    hashMap5 = hashMap;
                    sparseArrayCompat3 = sparseArrayCompat;
                    r10 = r25;
                    break;
                case 4:
                    f = dpScale;
                    hashMap = hashMap5;
                    arrayList = arrayList4;
                    sparseArrayCompat = sparseArrayCompat3;
                    r25 = r10;
                    longSparseArray = longSparseArray4;
                    f10 = (float) jsonUtf8Reader.nextDouble();
                    longSparseArray4 = longSparseArray;
                    dpScale = f;
                    arrayList4 = arrayList;
                    hashMap5 = hashMap;
                    sparseArrayCompat3 = sparseArrayCompat;
                    r10 = r25;
                    break;
                case 5:
                    f = dpScale;
                    hashMap = hashMap5;
                    arrayList = arrayList4;
                    sparseArrayCompat = sparseArrayCompat3;
                    r25 = r10;
                    f2 = f11;
                    f3 = f12;
                    longSparseArray = longSparseArray4;
                    String[] split = jsonUtf8Reader.nextString().split("\\.");
                    int parseInt = Integer.parseInt(split[0]);
                    int parseInt2 = Integer.parseInt(split[1]);
                    int parseInt3 = Integer.parseInt(split[2]);
                    if (parseInt >= 4 && (parseInt > 4 || (parseInt2 >= 4 && (parseInt2 > 4 || parseInt3 >= 0)))) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        lottieComposition.addWarning("Lottie only supports bodymovin >= 4.4.0");
                    }
                    f10 = f13;
                    f11 = f2;
                    f12 = f3;
                    longSparseArray4 = longSparseArray;
                    dpScale = f;
                    arrayList4 = arrayList;
                    hashMap5 = hashMap;
                    sparseArrayCompat3 = sparseArrayCompat;
                    r10 = r25;
                    break;
                case 6:
                    f = dpScale;
                    LongSparseArray<Layer> longSparseArray5 = longSparseArray4;
                    hashMap = hashMap5;
                    arrayList = arrayList4;
                    sparseArrayCompat = sparseArrayCompat3;
                    r25 = r10;
                    f2 = f11;
                    f3 = f12;
                    jsonUtf8Reader.beginArray();
                    int r1 = 0;
                    while (jsonUtf8Reader.hasNext()) {
                        Layer parse = LayerParser.parse(jsonUtf8Reader, lottieComposition);
                        if (parse.layerType == Layer.LayerType.IMAGE) {
                            r1++;
                        }
                        arrayList3.add(parse);
                        LongSparseArray<Layer> longSparseArray6 = longSparseArray5;
                        longSparseArray6.put(parse.layerId, parse);
                        if (r1 > 4) {
                            Logger.warning("You have " + r1 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                        }
                        longSparseArray5 = longSparseArray6;
                    }
                    longSparseArray = longSparseArray5;
                    jsonUtf8Reader.endArray();
                    f10 = f13;
                    f11 = f2;
                    f12 = f3;
                    longSparseArray4 = longSparseArray;
                    dpScale = f;
                    arrayList4 = arrayList;
                    hashMap5 = hashMap;
                    sparseArrayCompat3 = sparseArrayCompat;
                    r10 = r25;
                    break;
                case 7:
                    arrayList = arrayList4;
                    f2 = f11;
                    f3 = f12;
                    jsonUtf8Reader.beginArray();
                    while (jsonUtf8Reader.hasNext()) {
                        ArrayList arrayList5 = new ArrayList();
                        LongSparseArray longSparseArray7 = new LongSparseArray();
                        jsonUtf8Reader.beginObject();
                        HashMap hashMap6 = hashMap5;
                        String str = null;
                        String str2 = null;
                        int r12 = 0;
                        int r13 = 0;
                        while (jsonUtf8Reader.hasNext()) {
                            SparseArrayCompat<FontCharacter> sparseArrayCompat4 = sparseArrayCompat3;
                            int selectName = jsonUtf8Reader.selectName(ASSETS_NAMES);
                            if (selectName != 0) {
                                r252 = r10;
                                if (selectName != 1) {
                                    if (selectName != 2) {
                                        if (selectName != 3) {
                                            if (selectName != 4) {
                                                if (selectName != 5) {
                                                    jsonUtf8Reader.skipName();
                                                    jsonUtf8Reader.skipValue();
                                                    f4 = dpScale;
                                                    longSparseArray2 = longSparseArray4;
                                                } else {
                                                    jsonUtf8Reader.nextString();
                                                }
                                            } else {
                                                str2 = jsonUtf8Reader.nextString();
                                            }
                                        } else {
                                            r13 = jsonUtf8Reader.nextInt();
                                        }
                                    } else {
                                        r12 = jsonUtf8Reader.nextInt();
                                    }
                                } else {
                                    jsonUtf8Reader.beginArray();
                                    while (jsonUtf8Reader.hasNext()) {
                                        Layer parse2 = LayerParser.parse(jsonUtf8Reader, lottieComposition);
                                        longSparseArray7.put(parse2.layerId, parse2);
                                        arrayList5.add(parse2);
                                        dpScale = dpScale;
                                        longSparseArray4 = longSparseArray4;
                                    }
                                    f4 = dpScale;
                                    longSparseArray2 = longSparseArray4;
                                    jsonUtf8Reader.endArray();
                                }
                                dpScale = f4;
                                sparseArrayCompat3 = sparseArrayCompat4;
                                r10 = r252;
                                longSparseArray4 = longSparseArray2;
                            } else {
                                r252 = r10;
                                str = jsonUtf8Reader.nextString();
                            }
                            sparseArrayCompat3 = sparseArrayCompat4;
                            r10 = r252;
                        }
                        float f14 = dpScale;
                        LongSparseArray<Layer> longSparseArray8 = longSparseArray4;
                        SparseArrayCompat<FontCharacter> sparseArrayCompat5 = sparseArrayCompat3;
                        int r253 = r10;
                        jsonUtf8Reader.endObject();
                        if (str2 != null) {
                            hashMap4.put(str, new LottieImageAsset(r12, r13, str, str2));
                        } else {
                            hashMap3.put(str, arrayList5);
                        }
                        dpScale = f14;
                        hashMap5 = hashMap6;
                        sparseArrayCompat3 = sparseArrayCompat5;
                        r10 = r253;
                        longSparseArray4 = longSparseArray8;
                    }
                    f = dpScale;
                    hashMap = hashMap5;
                    sparseArrayCompat = sparseArrayCompat3;
                    r25 = r10;
                    jsonUtf8Reader.endArray();
                    longSparseArray = longSparseArray4;
                    f10 = f13;
                    f11 = f2;
                    f12 = f3;
                    longSparseArray4 = longSparseArray;
                    dpScale = f;
                    arrayList4 = arrayList;
                    hashMap5 = hashMap;
                    sparseArrayCompat3 = sparseArrayCompat;
                    r10 = r25;
                    break;
                case 8:
                    f2 = f11;
                    f3 = f12;
                    jsonUtf8Reader.beginObject();
                    while (jsonUtf8Reader.hasNext()) {
                        if (jsonUtf8Reader.selectName(FONT_NAMES) != 0) {
                            jsonUtf8Reader.skipName();
                            jsonUtf8Reader.skipValue();
                        } else {
                            jsonUtf8Reader.beginArray();
                            while (jsonUtf8Reader.hasNext()) {
                                JsonReader.Options options = FontParser.NAMES;
                                jsonUtf8Reader.beginObject();
                                String str3 = null;
                                String str4 = null;
                                String str5 = null;
                                while (jsonUtf8Reader.hasNext()) {
                                    int selectName2 = jsonUtf8Reader.selectName(FontParser.NAMES);
                                    if (selectName2 != 0) {
                                        ArrayList arrayList6 = arrayList4;
                                        if (selectName2 != 1) {
                                            if (selectName2 != 2) {
                                                if (selectName2 != 3) {
                                                    jsonUtf8Reader.skipName();
                                                    jsonUtf8Reader.skipValue();
                                                } else {
                                                    jsonUtf8Reader.nextDouble();
                                                }
                                            } else {
                                                str5 = jsonUtf8Reader.nextString();
                                            }
                                        } else {
                                            str4 = jsonUtf8Reader.nextString();
                                        }
                                        arrayList4 = arrayList6;
                                    } else {
                                        str3 = jsonUtf8Reader.nextString();
                                    }
                                }
                                jsonUtf8Reader.endObject();
                                hashMap5.put(str4, new Font(str3, str4, str5));
                                arrayList4 = arrayList4;
                            }
                            jsonUtf8Reader.endArray();
                        }
                    }
                    arrayList = arrayList4;
                    jsonUtf8Reader.endObject();
                    f = dpScale;
                    hashMap = hashMap5;
                    sparseArrayCompat = sparseArrayCompat3;
                    r25 = r10;
                    longSparseArray = longSparseArray4;
                    f10 = f13;
                    f11 = f2;
                    f12 = f3;
                    longSparseArray4 = longSparseArray;
                    dpScale = f;
                    arrayList4 = arrayList;
                    hashMap5 = hashMap;
                    sparseArrayCompat3 = sparseArrayCompat;
                    r10 = r25;
                    break;
                case 9:
                    f2 = f11;
                    f3 = f12;
                    jsonUtf8Reader.beginArray();
                    while (jsonUtf8Reader.hasNext()) {
                        JsonReader.Options options2 = FontCharacterParser.NAMES;
                        ArrayList arrayList7 = new ArrayList();
                        jsonUtf8Reader.beginObject();
                        double d = 0.0d;
                        String str6 = null;
                        String str7 = null;
                        char c = 0;
                        while (jsonUtf8Reader.hasNext()) {
                            int selectName3 = jsonUtf8Reader.selectName(FontCharacterParser.NAMES);
                            if (selectName3 != 0) {
                                if (selectName3 != 1) {
                                    if (selectName3 != 2) {
                                        if (selectName3 != 3) {
                                            if (selectName3 != 4) {
                                                if (selectName3 != 5) {
                                                    jsonUtf8Reader.skipName();
                                                    jsonUtf8Reader.skipValue();
                                                } else {
                                                    jsonUtf8Reader.beginObject();
                                                    while (jsonUtf8Reader.hasNext()) {
                                                        if (jsonUtf8Reader.selectName(FontCharacterParser.DATA_NAMES) != 0) {
                                                            jsonUtf8Reader.skipName();
                                                            jsonUtf8Reader.skipValue();
                                                        } else {
                                                            jsonUtf8Reader.beginArray();
                                                            while (jsonUtf8Reader.hasNext()) {
                                                                arrayList7.add((ShapeGroup) ContentModelParser.parse(jsonUtf8Reader, lottieComposition));
                                                            }
                                                            jsonUtf8Reader.endArray();
                                                        }
                                                    }
                                                    jsonUtf8Reader.endObject();
                                                }
                                            } else {
                                                str7 = jsonUtf8Reader.nextString();
                                            }
                                        } else {
                                            str6 = jsonUtf8Reader.nextString();
                                        }
                                    } else {
                                        d = jsonUtf8Reader.nextDouble();
                                    }
                                } else {
                                    jsonUtf8Reader.nextDouble();
                                }
                            } else {
                                c = jsonUtf8Reader.nextString().charAt(0);
                            }
                        }
                        jsonUtf8Reader.endObject();
                        FontCharacter fontCharacter = new FontCharacter(arrayList7, c, d, str6, str7);
                        sparseArrayCompat3.put(fontCharacter.hashCode(), fontCharacter);
                    }
                    jsonUtf8Reader.endArray();
                    f = dpScale;
                    hashMap = hashMap5;
                    arrayList = arrayList4;
                    sparseArrayCompat = sparseArrayCompat3;
                    r25 = r10;
                    longSparseArray = longSparseArray4;
                    f10 = f13;
                    f11 = f2;
                    f12 = f3;
                    longSparseArray4 = longSparseArray;
                    dpScale = f;
                    arrayList4 = arrayList;
                    hashMap5 = hashMap;
                    sparseArrayCompat3 = sparseArrayCompat;
                    r10 = r25;
                    break;
                case 10:
                    jsonUtf8Reader.beginArray();
                    while (jsonUtf8Reader.hasNext()) {
                        jsonUtf8Reader.beginObject();
                        String str8 = null;
                        float f15 = 0.0f;
                        float f16 = 0.0f;
                        while (jsonUtf8Reader.hasNext()) {
                            int selectName4 = jsonUtf8Reader.selectName(MARKER_NAMES);
                            if (selectName4 != 0) {
                                f5 = f12;
                                if (selectName4 != 1) {
                                    if (selectName4 != 2) {
                                        jsonUtf8Reader.skipName();
                                        jsonUtf8Reader.skipValue();
                                    } else {
                                        f6 = f11;
                                        f16 = (float) jsonUtf8Reader.nextDouble();
                                    }
                                } else {
                                    f6 = f11;
                                    f15 = (float) jsonUtf8Reader.nextDouble();
                                }
                                f11 = f6;
                            } else {
                                f5 = f12;
                                str8 = jsonUtf8Reader.nextString();
                            }
                            f12 = f5;
                        }
                        jsonUtf8Reader.endObject();
                        arrayList4.add(new Marker(str8, f15, f16));
                        f11 = f11;
                        f12 = f12;
                    }
                    f2 = f11;
                    f3 = f12;
                    jsonUtf8Reader.endArray();
                    f = dpScale;
                    hashMap = hashMap5;
                    arrayList = arrayList4;
                    sparseArrayCompat = sparseArrayCompat3;
                    r25 = r10;
                    longSparseArray = longSparseArray4;
                    f10 = f13;
                    f11 = f2;
                    f12 = f3;
                    longSparseArray4 = longSparseArray;
                    dpScale = f;
                    arrayList4 = arrayList;
                    hashMap5 = hashMap;
                    sparseArrayCompat3 = sparseArrayCompat;
                    r10 = r25;
                    break;
                default:
                    f = dpScale;
                    hashMap = hashMap5;
                    arrayList = arrayList4;
                    sparseArrayCompat = sparseArrayCompat3;
                    r25 = r10;
                    f2 = f11;
                    f3 = f12;
                    longSparseArray = longSparseArray4;
                    jsonUtf8Reader.skipName();
                    jsonUtf8Reader.skipValue();
                    f10 = f13;
                    f11 = f2;
                    f12 = f3;
                    longSparseArray4 = longSparseArray;
                    dpScale = f;
                    arrayList4 = arrayList;
                    hashMap5 = hashMap;
                    sparseArrayCompat3 = sparseArrayCompat;
                    r10 = r25;
                    break;
            }
        }
        float f17 = dpScale;
        lottieComposition.bounds = new Rect(0, 0, (int) (r15 * f17), (int) (r10 * f17));
        lottieComposition.startFrame = f11;
        lottieComposition.endFrame = f12;
        lottieComposition.frameRate = f10;
        lottieComposition.layers = arrayList3;
        lottieComposition.layerMap = longSparseArray4;
        lottieComposition.precomps = hashMap3;
        lottieComposition.images = hashMap4;
        lottieComposition.characters = sparseArrayCompat3;
        lottieComposition.fonts = hashMap5;
        lottieComposition.markers = arrayList4;
        return lottieComposition;
    }
}
