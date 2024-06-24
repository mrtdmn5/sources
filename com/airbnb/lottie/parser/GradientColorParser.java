package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class GradientColorParser implements ValueParser<GradientColor> {
    public int colorPoints;

    public GradientColorParser(int r1) {
        this.colorPoints = r1;
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    public final GradientColor parse(JsonReader jsonReader, float f) throws IOException {
        boolean z;
        int r13;
        float f2;
        int r17;
        float[] fArr;
        int r2;
        int argb;
        int r0;
        ArrayList arrayList = new ArrayList();
        int r5 = 1;
        if (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        int r6 = 4;
        if (arrayList.size() == 4 && ((Float) arrayList.get(0)).floatValue() == 1.0f) {
            arrayList.set(0, Float.valueOf(0.0f));
            arrayList.add(Float.valueOf(1.0f));
            arrayList.add((Float) arrayList.get(1));
            arrayList.add((Float) arrayList.get(2));
            arrayList.add((Float) arrayList.get(3));
            this.colorPoints = 2;
        }
        if (z) {
            jsonReader.endArray();
        }
        if (this.colorPoints == -1) {
            this.colorPoints = arrayList.size() / 4;
        }
        int r22 = this.colorPoints;
        float[] fArr2 = new float[r22];
        int[] r9 = new int[r22];
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
        while (true) {
            r13 = this.colorPoints * r6;
            if (r10 >= r13) {
                break;
            }
            int r132 = r10 / 4;
            double floatValue = ((Float) arrayList.get(r10)).floatValue();
            int r62 = r10 % 4;
            if (r62 != 0) {
                if (r62 != r5) {
                    if (r62 != 2) {
                        if (r62 == 3) {
                            r9[r132] = Color.argb(255, r11, r12, (int) (floatValue * 255.0d));
                        }
                    } else {
                        r12 = (int) (floatValue * 255.0d);
                    }
                } else {
                    r11 = (int) (floatValue * 255.0d);
                }
            } else {
                if (r132 > 0) {
                    float f3 = (float) floatValue;
                    if (fArr2[r132 - 1] >= f3) {
                        fArr2[r132] = f3 + 0.01f;
                    }
                }
                fArr2[r132] = (float) floatValue;
            }
            r10++;
            r5 = 1;
            r6 = 4;
        }
        GradientColor gradientColor = new GradientColor(fArr2, r9);
        if (arrayList.size() > r13) {
            int size = (arrayList.size() - r13) / 2;
            float[] fArr3 = new float[size];
            float[] fArr4 = new float[size];
            int r102 = 0;
            while (r13 < arrayList.size()) {
                if (r13 % 2 == 0) {
                    fArr3[r102] = ((Float) arrayList.get(r13)).floatValue();
                } else {
                    fArr4[r102] = ((Float) arrayList.get(r13)).floatValue();
                    r102++;
                }
                r13++;
            }
            float[] fArr5 = gradientColor.positions;
            if (fArr5.length == 0) {
                fArr5 = fArr3;
            } else if (size != 0) {
                int length = fArr5.length + size;
                float[] fArr6 = new float[length];
                int r133 = 0;
                int r14 = 0;
                int r15 = 0;
                for (int r122 = 0; r122 < length; r122++) {
                    float f4 = Float.NaN;
                    if (r14 < fArr5.length) {
                        f2 = fArr5[r14];
                    } else {
                        f2 = Float.NaN;
                    }
                    if (r15 < size) {
                        f4 = fArr3[r15];
                    }
                    if (!Float.isNaN(f4) && f2 >= f4) {
                        if (!Float.isNaN(f2) && f4 >= f2) {
                            fArr6[r122] = f2;
                            r14++;
                            r15++;
                            r133++;
                        } else {
                            fArr6[r122] = f4;
                            r15++;
                        }
                    } else {
                        fArr6[r122] = f2;
                        r14++;
                    }
                }
                if (r133 == 0) {
                    fArr5 = fArr6;
                } else {
                    fArr5 = Arrays.copyOf(fArr6, length - r133);
                }
            }
            int length2 = fArr5.length;
            int[] r103 = new int[length2];
            int r112 = 0;
            while (r112 < length2) {
                float f5 = fArr5[r112];
                int binarySearch = Arrays.binarySearch(fArr2, f5);
                int binarySearch2 = Arrays.binarySearch(fArr3, f5);
                int[] r7 = gradientColor.colors;
                if (binarySearch >= 0 && binarySearch2 <= 0) {
                    int r72 = r7[binarySearch];
                    if (size >= 2 && f5 > fArr3[0]) {
                        for (int r134 = 1; r134 < size; r134++) {
                            float f6 = fArr3[r134];
                            if (f6 >= f5 || r134 == size - 1) {
                                if (f6 <= f5) {
                                    r0 = (int) (fArr4[r134] * 255.0f);
                                } else {
                                    int r02 = r134 - 1;
                                    float f7 = fArr3[r02];
                                    float f8 = (f5 - f7) / (f6 - f7);
                                    float f9 = fArr4[r02];
                                    float f10 = fArr4[r134];
                                    PointF pointF = MiscUtils.pathFromDataCurrentPoint;
                                    r0 = (int) ((((f10 - f9) * f8) + f9) * 255.0f);
                                }
                                argb = Color.argb(r0, Color.red(r72), Color.green(r72), Color.blue(r72));
                            }
                        }
                        throw new IllegalArgumentException("Unreachable code.");
                    }
                    argb = Color.argb((int) (fArr4[0] * 255.0f), Color.red(r72), Color.green(r72), Color.blue(r72));
                    r103[r112] = argb;
                    r17 = r22;
                    fArr = fArr2;
                } else {
                    if (binarySearch2 < 0) {
                        binarySearch2 = -(binarySearch2 + 1);
                    }
                    float f11 = fArr4[binarySearch2];
                    if (r7.length >= 2 && f5 != fArr2[0]) {
                        for (int r135 = 1; r135 < r22; r135++) {
                            float f12 = fArr2[r135];
                            if (f12 >= f5 || r135 == r22 - 1) {
                                int r142 = r135 - 1;
                                float f13 = fArr2[r142];
                                float f14 = (f5 - f13) / (f12 - f13);
                                int r136 = r7[r135];
                                int r73 = r7[r142];
                                int red = Color.red(r73);
                                int red2 = Color.red(r136);
                                PointF pointF2 = MiscUtils.pathFromDataCurrentPoint;
                                r17 = r22;
                                fArr = fArr2;
                                r2 = Color.argb((int) (f11 * 255.0f), (int) (((red2 - red) * f14) + red), (int) (((Color.green(r136) - r14) * f14) + Color.green(r73)), (int) ((f14 * (Color.blue(r136) - r7)) + Color.blue(r73)));
                            }
                        }
                        throw new IllegalArgumentException("Unreachable code.");
                    }
                    r17 = r22;
                    fArr = fArr2;
                    r2 = r7[0];
                    r103[r112] = r2;
                }
                r112++;
                fArr2 = fArr;
                r22 = r17;
            }
            return new GradientColor(fArr5, r103);
        }
        return gradientColor;
    }
}
