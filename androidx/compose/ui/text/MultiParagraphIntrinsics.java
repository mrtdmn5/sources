package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultiParagraphIntrinsics.kt */
/* loaded from: classes.dex */
public final class MultiParagraphIntrinsics implements ParagraphIntrinsics {
    public final AnnotatedString annotatedString;
    public final ArrayList infoList;
    public final Lazy maxIntrinsicWidth$delegate;
    public final Lazy minIntrinsicWidth$delegate;
    public final List<AnnotatedString.Range<Placeholder>> placeholders;

    /* JADX WARN: Multi-variable type inference failed */
    public MultiParagraphIntrinsics(AnnotatedString annotatedString, TextStyle style, List<AnnotatedString.Range<Placeholder>> placeholders, Density density, FontFamily.Resolver fontFamilyResolver) {
        int r15;
        String str;
        String str2;
        int r28;
        int r30;
        ArrayList arrayList;
        List list;
        ArrayList arrayList2;
        String str3;
        List list2;
        int r12;
        boolean z;
        AnnotatedString annotatedString2 = annotatedString;
        Intrinsics.checkNotNullParameter(annotatedString2, "annotatedString");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        this.annotatedString = annotatedString2;
        this.placeholders = placeholders;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.minIntrinsicWidth$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new Function0<Float>() { // from class: androidx.compose.ui.text.MultiParagraphIntrinsics$minIntrinsicWidth$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Object obj;
                float f;
                ParagraphIntrinsics paragraphIntrinsics;
                ArrayList arrayList3 = MultiParagraphIntrinsics.this.infoList;
                if (arrayList3.isEmpty()) {
                    obj = null;
                } else {
                    Object obj2 = arrayList3.get(0);
                    float minIntrinsicWidth = ((ParagraphIntrinsicInfo) obj2).intrinsics.getMinIntrinsicWidth();
                    int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList3);
                    int r4 = 1;
                    if (1 <= lastIndex) {
                        while (true) {
                            Object obj3 = arrayList3.get(r4);
                            float minIntrinsicWidth2 = ((ParagraphIntrinsicInfo) obj3).intrinsics.getMinIntrinsicWidth();
                            if (Float.compare(minIntrinsicWidth, minIntrinsicWidth2) < 0) {
                                obj2 = obj3;
                                minIntrinsicWidth = minIntrinsicWidth2;
                            }
                            if (r4 == lastIndex) {
                                break;
                            }
                            r4++;
                        }
                    }
                    obj = obj2;
                }
                ParagraphIntrinsicInfo paragraphIntrinsicInfo = (ParagraphIntrinsicInfo) obj;
                if (paragraphIntrinsicInfo != null && (paragraphIntrinsics = paragraphIntrinsicInfo.intrinsics) != null) {
                    f = paragraphIntrinsics.getMinIntrinsicWidth();
                } else {
                    f = 0.0f;
                }
                return Float.valueOf(f);
            }
        });
        this.maxIntrinsicWidth$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new Function0<Float>() { // from class: androidx.compose.ui.text.MultiParagraphIntrinsics$maxIntrinsicWidth$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Object obj;
                float f;
                ParagraphIntrinsics paragraphIntrinsics;
                ArrayList arrayList3 = MultiParagraphIntrinsics.this.infoList;
                if (arrayList3.isEmpty()) {
                    obj = null;
                } else {
                    Object obj2 = arrayList3.get(0);
                    float maxIntrinsicWidth = ((ParagraphIntrinsicInfo) obj2).intrinsics.getMaxIntrinsicWidth();
                    int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList3);
                    int r4 = 1;
                    if (1 <= lastIndex) {
                        while (true) {
                            Object obj3 = arrayList3.get(r4);
                            float maxIntrinsicWidth2 = ((ParagraphIntrinsicInfo) obj3).intrinsics.getMaxIntrinsicWidth();
                            if (Float.compare(maxIntrinsicWidth, maxIntrinsicWidth2) < 0) {
                                obj2 = obj3;
                                maxIntrinsicWidth = maxIntrinsicWidth2;
                            }
                            if (r4 == lastIndex) {
                                break;
                            }
                            r4++;
                        }
                    }
                    obj = obj2;
                }
                ParagraphIntrinsicInfo paragraphIntrinsicInfo = (ParagraphIntrinsicInfo) obj;
                if (paragraphIntrinsicInfo != null && (paragraphIntrinsics = paragraphIntrinsicInfo.intrinsics) != null) {
                    f = paragraphIntrinsics.getMaxIntrinsicWidth();
                } else {
                    f = 0.0f;
                }
                return Float.valueOf(f);
            }
        });
        AnnotatedString annotatedString3 = AnnotatedStringKt.EmptyAnnotatedString;
        ParagraphStyle defaultParagraphStyle = style.paragraphStyle;
        Intrinsics.checkNotNullParameter(defaultParagraphStyle, "defaultParagraphStyle");
        String str4 = annotatedString2.text;
        int length = str4.length();
        List list3 = EmptyList.INSTANCE;
        List list4 = annotatedString2.paragraphStylesOrNull;
        list4 = list4 == null ? list3 : list4;
        ArrayList arrayList3 = new ArrayList();
        int size = list4.size();
        int r8 = 0;
        int r9 = 0;
        while (r8 < size) {
            AnnotatedString.Range<ParagraphStyle> range = list4.get(r8);
            ParagraphStyle paragraphStyle = range.item;
            List list5 = list4;
            int r6 = range.start;
            int r17 = size;
            if (r6 != r9) {
                arrayList3.add(new AnnotatedString.Range(r9, r6, defaultParagraphStyle));
            }
            ParagraphStyle merge = defaultParagraphStyle.merge(paragraphStyle);
            int r10 = range.end;
            arrayList3.add(new AnnotatedString.Range(r6, r10, merge));
            r8++;
            r9 = r10;
            list4 = list5;
            size = r17;
        }
        if (r9 != length) {
            arrayList3.add(new AnnotatedString.Range(r9, length, defaultParagraphStyle));
        }
        if (arrayList3.isEmpty()) {
            r15 = 0;
            arrayList3.add(new AnnotatedString.Range(0, 0, defaultParagraphStyle));
        } else {
            r15 = 0;
        }
        ArrayList arrayList4 = new ArrayList(arrayList3.size());
        int size2 = arrayList3.size();
        int r82 = r15;
        while (r82 < size2) {
            AnnotatedString.Range range2 = (AnnotatedString.Range) arrayList3.get(r82);
            int r62 = range2.start;
            int r7 = range2.end;
            if (r62 != r7) {
                str2 = str4.substring(r62, r7);
                str = str4;
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String…ing(startIndex, endIndex)");
            } else {
                str = str4;
                str2 = "";
            }
            List localSpanStyles = AnnotatedStringKt.getLocalSpanStyles(annotatedString2, r62, r7);
            ParagraphStyle paragraphStyle2 = (ParagraphStyle) range2.item;
            if (paragraphStyle2.textDirection != null) {
                r28 = r82;
                r30 = size2;
                arrayList = arrayList4;
                list = list3;
                arrayList2 = arrayList3;
                str3 = str2;
            } else {
                r28 = r82;
                r30 = size2;
                arrayList = arrayList4;
                list = list3;
                arrayList2 = arrayList3;
                str3 = str2;
                paragraphStyle2 = new ParagraphStyle(paragraphStyle2.textAlign, defaultParagraphStyle.textDirection, paragraphStyle2.lineHeight, paragraphStyle2.textIndent, paragraphStyle2.platformStyle, paragraphStyle2.lineHeightStyle, paragraphStyle2.lineBreak, paragraphStyle2.hyphens, paragraphStyle2.textMotion);
            }
            TextStyle textStyle = new TextStyle(style.spanStyle, defaultParagraphStyle.merge(paragraphStyle2));
            if (localSpanStyles == null) {
                list2 = list;
            } else {
                list2 = localSpanStyles;
            }
            List<AnnotatedString.Range<Placeholder>> list6 = this.placeholders;
            ArrayList arrayList5 = new ArrayList(list6.size());
            int size3 = list6.size();
            int r11 = 0;
            while (true) {
                r12 = range2.start;
                if (r11 >= size3) {
                    break;
                }
                AnnotatedString.Range<Placeholder> range3 = list6.get(r11);
                AnnotatedString.Range<Placeholder> range4 = range3;
                if (AnnotatedStringKt.intersect(r12, r7, range4.start, range4.end)) {
                    arrayList5.add(range3);
                }
                r11++;
            }
            ArrayList arrayList6 = new ArrayList(arrayList5.size());
            int size4 = arrayList5.size();
            for (int r5 = 0; r5 < size4; r5++) {
                AnnotatedString.Range range5 = (AnnotatedString.Range) arrayList5.get(r5);
                int r13 = range5.start;
                int r14 = range5.end;
                if (r12 <= r13 && r14 <= r7) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    arrayList6.add(new AnnotatedString.Range(r13 - r12, r14 - r12, range5.item));
                } else {
                    throw new IllegalArgumentException("placeholder can not overlap with paragraph.".toString());
                }
            }
            ArrayList arrayList7 = arrayList;
            arrayList7.add(new ParagraphIntrinsicInfo(ParagraphIntrinsicsKt.ParagraphIntrinsics(textStyle, fontFamilyResolver, density, str3, list2, arrayList6), r12, r7));
            r82 = r28 + 1;
            annotatedString2 = annotatedString;
            size2 = r30;
            arrayList4 = arrayList7;
            str4 = str;
            list3 = list;
            arrayList3 = arrayList2;
        }
        this.infoList = arrayList4;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public final boolean getHasStaleResolvedFonts() {
        ArrayList arrayList = this.infoList;
        int size = arrayList.size();
        for (int r3 = 0; r3 < size; r3++) {
            if (((ParagraphIntrinsicInfo) arrayList.get(r3)).intrinsics.getHasStaleResolvedFonts()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public final float getMaxIntrinsicWidth() {
        return ((Number) this.maxIntrinsicWidth$delegate.getValue()).floatValue();
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public final float getMinIntrinsicWidth() {
        return ((Number) this.minIntrinsicWidth$delegate.getValue()).floatValue();
    }
}
