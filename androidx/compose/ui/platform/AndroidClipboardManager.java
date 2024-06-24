package androidx.compose.ui.platform;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.os.Parcel;
import android.text.Annotation;
import android.text.SpannableString;
import android.util.Base64;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidClipboardManager.android.kt */
/* loaded from: classes.dex */
public final class AndroidClipboardManager implements ClipboardManager {
    public final android.content.ClipboardManager clipboardManager;

    public AndroidClipboardManager(Context context) {
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        this.clipboardManager = (android.content.ClipboardManager) systemService;
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x011d, code lost:            if (r5 == 2) goto L225;     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.platform.ClipboardManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.ui.text.AnnotatedString getText() {
        /*
            Method dump skipped, instructions count: 591
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidClipboardManager.getText():androidx.compose.ui.text.AnnotatedString");
    }

    @Override // androidx.compose.ui.platform.ClipboardManager
    public final boolean hasText() {
        ClipDescription primaryClipDescription = this.clipboardManager.getPrimaryClipDescription();
        if (primaryClipDescription != null) {
            return primaryClipDescription.hasMimeType("text/*");
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.text.SpannableString] */
    @Override // androidx.compose.ui.platform.ClipboardManager
    public final void setText(AnnotatedString annotatedString) {
        List list;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        byte b;
        boolean z5;
        List list2 = EmptyList.INSTANCE;
        List list3 = annotatedString.spanStylesOrNull;
        if (list3 == null) {
            list = list2;
        } else {
            list = list3;
        }
        boolean isEmpty = list.isEmpty();
        String str = annotatedString.text;
        if (!isEmpty) {
            ?? spannableString = new SpannableString(str);
            EncodeHelper encodeHelper = new EncodeHelper();
            if (list3 != null) {
                list2 = list3;
            }
            int size = list2.size();
            for (int r5 = 0; r5 < size; r5++) {
                AnnotatedString.Range range = (AnnotatedString.Range) list2.get(r5);
                SpanStyle spanStyle = (SpanStyle) range.item;
                encodeHelper.parcel.recycle();
                Parcel obtain = Parcel.obtain();
                Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
                encodeHelper.parcel = obtain;
                Intrinsics.checkNotNullParameter(spanStyle, "spanStyle");
                long m516getColor0d7_KjU = spanStyle.m516getColor0d7_KjU();
                long j = Color.Unspecified;
                byte b2 = 1;
                if (!Color.m317equalsimpl0(m516getColor0d7_KjU, j)) {
                    encodeHelper.encode((byte) 1);
                    encodeHelper.parcel.writeLong(spanStyle.m516getColor0d7_KjU());
                }
                long j2 = TextUnit.Unspecified;
                long j3 = spanStyle.fontSize;
                if (!TextUnit.m596equalsimpl0(j3, j2)) {
                    encodeHelper.encode((byte) 2);
                    encodeHelper.m498encodeR2X_6o(j3);
                }
                FontWeight fontWeight = spanStyle.fontWeight;
                if (fontWeight != null) {
                    encodeHelper.encode((byte) 3);
                    encodeHelper.parcel.writeInt(fontWeight.weight);
                }
                FontStyle fontStyle = spanStyle.fontStyle;
                if (fontStyle != null) {
                    encodeHelper.encode((byte) 4);
                    int r14 = fontStyle.value;
                    if (r14 == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (!z4) {
                        if (r14 == 1) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                            b = 1;
                            encodeHelper.encode(b);
                        }
                    }
                    b = 0;
                    encodeHelper.encode(b);
                }
                FontSynthesis fontSynthesis = spanStyle.fontSynthesis;
                if (fontSynthesis != null) {
                    encodeHelper.encode((byte) 5);
                    int r142 = fontSynthesis.value;
                    if (r142 == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        if (r142 == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            if (r142 == 2) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                b2 = 2;
                            } else {
                                if (r142 != 3) {
                                    b2 = 0;
                                }
                                if (b2 != 0) {
                                    b2 = 3;
                                }
                            }
                        }
                        encodeHelper.encode(b2);
                    }
                    b2 = 0;
                    encodeHelper.encode(b2);
                }
                String str2 = spanStyle.fontFeatureSettings;
                if (str2 != null) {
                    encodeHelper.encode((byte) 6);
                    encodeHelper.parcel.writeString(str2);
                }
                long j4 = spanStyle.letterSpacing;
                if (!TextUnit.m596equalsimpl0(j4, j2)) {
                    encodeHelper.encode((byte) 7);
                    encodeHelper.m498encodeR2X_6o(j4);
                }
                BaselineShift baselineShift = spanStyle.baselineShift;
                if (baselineShift != null) {
                    encodeHelper.encode((byte) 8);
                    encodeHelper.encode(baselineShift.multiplier);
                }
                TextGeometricTransform textGeometricTransform = spanStyle.textGeometricTransform;
                if (textGeometricTransform != null) {
                    encodeHelper.encode((byte) 9);
                    encodeHelper.encode(textGeometricTransform.scaleX);
                    encodeHelper.encode(textGeometricTransform.skewX);
                }
                long j5 = spanStyle.background;
                if (!Color.m317equalsimpl0(j5, j)) {
                    encodeHelper.encode((byte) 10);
                    encodeHelper.parcel.writeLong(j5);
                }
                TextDecoration textDecoration = spanStyle.textDecoration;
                if (textDecoration != null) {
                    encodeHelper.encode((byte) 11);
                    encodeHelper.parcel.writeInt(textDecoration.mask);
                }
                Shadow shadow = spanStyle.shadow;
                if (shadow != null) {
                    encodeHelper.encode((byte) 12);
                    encodeHelper.parcel.writeLong(shadow.color);
                    long j6 = shadow.offset;
                    encodeHelper.encode(Offset.m259getXimpl(j6));
                    encodeHelper.encode(Offset.m260getYimpl(j6));
                    encodeHelper.encode(shadow.blurRadius);
                }
                String encodeToString = Base64.encodeToString(encodeHelper.parcel.marshall(), 0);
                Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(bytes, Base64.DEFAULT)");
                spannableString.setSpan(new Annotation("androidx.compose.text.SpanStyle", encodeToString), range.start, range.end, 33);
            }
            str = spannableString;
        }
        this.clipboardManager.setPrimaryClip(ClipData.newPlainText("plain text", str));
    }
}
