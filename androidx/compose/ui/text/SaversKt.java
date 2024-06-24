package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverKt$Saver$1;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.AndroidLocale;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.intl.PlatformLocaleKt;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ULong;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Savers.kt */
/* loaded from: classes.dex */
public final class SaversKt {
    public static final SaverKt$Saver$1 AnnotatedStringSaver = SaverKt.Saver(new Function2<SaverScope, AnnotatedString, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotatedStringSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, AnnotatedString annotatedString) {
            SaverScope Saver = saverScope;
            AnnotatedString it = annotatedString;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            Object[] objArr = new Object[4];
            SaverKt$Saver$1 saverKt$Saver$1 = SaversKt.AnnotatedStringSaver;
            objArr[0] = it.text;
            Collection collection = EmptyList.INSTANCE;
            Collection collection2 = it.spanStylesOrNull;
            if (collection2 == null) {
                collection2 = collection;
            }
            SaverKt$Saver$1 saverKt$Saver$12 = SaversKt.AnnotationRangeListSaver;
            objArr[1] = SaversKt.save(collection2, saverKt$Saver$12, Saver);
            Collection collection3 = it.paragraphStylesOrNull;
            if (collection3 != null) {
                collection = collection3;
            }
            objArr[2] = SaversKt.save(collection, saverKt$Saver$12, Saver);
            objArr[3] = SaversKt.save(it.annotations, saverKt$Saver$12, Saver);
            return CollectionsKt__CollectionsKt.arrayListOf(objArr);
        }
    }, new Function1<Object, AnnotatedString>() { // from class: androidx.compose.ui.text.SaversKt$AnnotatedStringSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final AnnotatedString invoke(Object it) {
            List list;
            List list2;
            String str;
            List list3;
            List list4;
            Intrinsics.checkNotNullParameter(it, "it");
            List list5 = (List) it;
            Object obj = list5.get(1);
            SaverKt$Saver$1 saverKt$Saver$1 = SaversKt.AnnotationRangeListSaver;
            Boolean bool = Boolean.FALSE;
            List list6 = null;
            if (!Intrinsics.areEqual(obj, bool) && obj != null) {
                list = (List) saverKt$Saver$1.$restore.invoke(obj);
            } else {
                list = null;
            }
            Object obj2 = list5.get(2);
            if (!Intrinsics.areEqual(obj2, bool) && obj2 != null) {
                list2 = (List) saverKt$Saver$1.$restore.invoke(obj2);
            } else {
                list2 = null;
            }
            Object obj3 = list5.get(0);
            if (obj3 != null) {
                str = (String) obj3;
            } else {
                str = null;
            }
            Intrinsics.checkNotNull(str);
            if (list != null) {
                List list7 = list;
                if (list7.isEmpty()) {
                    list7 = null;
                }
                list3 = list7;
            } else {
                list3 = null;
            }
            if (list2 != null) {
                List list8 = list2;
                if (list8.isEmpty()) {
                    list8 = null;
                }
                list4 = list8;
            } else {
                list4 = null;
            }
            Object obj4 = list5.get(3);
            if (!Intrinsics.areEqual(obj4, bool) && obj4 != null) {
                list6 = (List) saverKt$Saver$1.$restore.invoke(obj4);
            }
            return new AnnotatedString(str, list3, list4, list6);
        }
    });
    public static final SaverKt$Saver$1 AnnotationRangeListSaver = SaverKt.Saver(new Function2<SaverScope, List<? extends AnnotatedString.Range<? extends Object>>, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeListSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, List<? extends AnnotatedString.Range<? extends Object>> list) {
            SaverScope Saver = saverScope;
            List<? extends AnnotatedString.Range<? extends Object>> it = list;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            ArrayList arrayList = new ArrayList(it.size());
            int size = it.size();
            for (int r2 = 0; r2 < size; r2++) {
                arrayList.add(SaversKt.save(it.get(r2), SaversKt.AnnotationRangeSaver, Saver));
            }
            return arrayList;
        }
    }, new Function1<Object, List<? extends AnnotatedString.Range<? extends Object>>>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeListSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final List<? extends AnnotatedString.Range<? extends Object>> invoke(Object it) {
            AnnotatedString.Range range;
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int r2 = 0; r2 < size; r2++) {
                Object obj = list.get(r2);
                SaverKt$Saver$1 saverKt$Saver$1 = SaversKt.AnnotationRangeSaver;
                if (!Intrinsics.areEqual(obj, Boolean.FALSE) && obj != null) {
                    range = (AnnotatedString.Range) saverKt$Saver$1.$restore.invoke(obj);
                } else {
                    range = null;
                }
                Intrinsics.checkNotNull(range);
                arrayList.add(range);
            }
            return arrayList;
        }
    });
    public static final SaverKt$Saver$1 AnnotationRangeSaver = SaverKt.Saver(new Function2<SaverScope, AnnotatedString.Range<? extends Object>, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeSaver$1

        /* compiled from: Savers.kt */
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] r0 = new int[AnnotationType.values().length];
                try {
                    r0[AnnotationType.Paragraph.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    r0[AnnotationType.Span.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    r0[AnnotationType.VerbatimTts.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    r0[AnnotationType.Url.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    r0[AnnotationType.String.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = r0;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, AnnotatedString.Range<? extends Object> range) {
            AnnotationType annotationType;
            SaverScope Saver = saverScope;
            AnnotatedString.Range<? extends Object> it = range;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            Object obj = it.item;
            if (obj instanceof ParagraphStyle) {
                annotationType = AnnotationType.Paragraph;
            } else if (obj instanceof SpanStyle) {
                annotationType = AnnotationType.Span;
            } else if (obj instanceof VerbatimTtsAnnotation) {
                annotationType = AnnotationType.VerbatimTts;
            } else if (obj instanceof UrlAnnotation) {
                annotationType = AnnotationType.Url;
            } else {
                annotationType = AnnotationType.String;
            }
            int r2 = WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()];
            if (r2 != 1) {
                if (r2 != 2) {
                    if (r2 != 3) {
                        if (r2 != 4) {
                            if (r2 == 5) {
                                SaverKt$Saver$1 saverKt$Saver$1 = SaversKt.AnnotatedStringSaver;
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                        } else {
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.text.UrlAnnotation");
                            obj = SaversKt.save((UrlAnnotation) obj, SaversKt.UrlAnnotationSaver, Saver);
                        }
                    } else {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.text.VerbatimTtsAnnotation");
                        obj = SaversKt.save((VerbatimTtsAnnotation) obj, SaversKt.VerbatimTtsAnnotationSaver, Saver);
                    }
                } else {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.text.SpanStyle");
                    obj = SaversKt.save((SpanStyle) obj, SaversKt.SpanStyleSaver, Saver);
                }
            } else {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.text.ParagraphStyle");
                obj = SaversKt.save((ParagraphStyle) obj, SaversKt.ParagraphStyleSaver, Saver);
            }
            return CollectionsKt__CollectionsKt.arrayListOf(annotationType, obj, Integer.valueOf(it.start), Integer.valueOf(it.end), it.tag);
        }
    }, new Function1<Object, AnnotatedString.Range<? extends Object>>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeSaver$2

        /* compiled from: Savers.kt */
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] r0 = new int[AnnotationType.values().length];
                try {
                    r0[AnnotationType.Paragraph.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    r0[AnnotationType.Span.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    r0[AnnotationType.VerbatimTts.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    r0[AnnotationType.Url.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    r0[AnnotationType.String.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = r0;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final AnnotatedString.Range<? extends Object> invoke(Object it) {
            AnnotationType annotationType;
            Integer num;
            Integer num2;
            String str;
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object obj = list.get(0);
            Object obj2 = null;
            if (obj != null) {
                annotationType = (AnnotationType) obj;
            } else {
                annotationType = null;
            }
            Intrinsics.checkNotNull(annotationType);
            Object obj3 = list.get(2);
            if (obj3 != null) {
                num = (Integer) obj3;
            } else {
                num = null;
            }
            Intrinsics.checkNotNull(num);
            int intValue = num.intValue();
            Object obj4 = list.get(3);
            if (obj4 != null) {
                num2 = (Integer) obj4;
            } else {
                num2 = null;
            }
            Intrinsics.checkNotNull(num2);
            int intValue2 = num2.intValue();
            Object obj5 = list.get(4);
            if (obj5 != null) {
                str = (String) obj5;
            } else {
                str = null;
            }
            Intrinsics.checkNotNull(str);
            int r0 = WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()];
            if (r0 != 1) {
                if (r0 != 2) {
                    if (r0 != 3) {
                        if (r0 != 4) {
                            if (r0 == 5) {
                                Object obj6 = list.get(1);
                                if (obj6 != null) {
                                    obj2 = (String) obj6;
                                }
                                Intrinsics.checkNotNull(obj2);
                                return new AnnotatedString.Range<>(obj2, intValue, intValue2, str);
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        Object obj7 = list.get(1);
                        SaverKt$Saver$1 saverKt$Saver$1 = SaversKt.UrlAnnotationSaver;
                        if (!Intrinsics.areEqual(obj7, Boolean.FALSE) && obj7 != null) {
                            obj2 = (UrlAnnotation) saverKt$Saver$1.$restore.invoke(obj7);
                        }
                        Intrinsics.checkNotNull(obj2);
                        return new AnnotatedString.Range<>(obj2, intValue, intValue2, str);
                    }
                    Object obj8 = list.get(1);
                    SaverKt$Saver$1 saverKt$Saver$12 = SaversKt.VerbatimTtsAnnotationSaver;
                    if (!Intrinsics.areEqual(obj8, Boolean.FALSE) && obj8 != null) {
                        obj2 = (VerbatimTtsAnnotation) saverKt$Saver$12.$restore.invoke(obj8);
                    }
                    Intrinsics.checkNotNull(obj2);
                    return new AnnotatedString.Range<>(obj2, intValue, intValue2, str);
                }
                Object obj9 = list.get(1);
                SaverKt$Saver$1 saverKt$Saver$13 = SaversKt.SpanStyleSaver;
                if (!Intrinsics.areEqual(obj9, Boolean.FALSE) && obj9 != null) {
                    obj2 = (SpanStyle) saverKt$Saver$13.$restore.invoke(obj9);
                }
                Intrinsics.checkNotNull(obj2);
                return new AnnotatedString.Range<>(obj2, intValue, intValue2, str);
            }
            Object obj10 = list.get(1);
            SaverKt$Saver$1 saverKt$Saver$14 = SaversKt.ParagraphStyleSaver;
            if (!Intrinsics.areEqual(obj10, Boolean.FALSE) && obj10 != null) {
                obj2 = (ParagraphStyle) saverKt$Saver$14.$restore.invoke(obj10);
            }
            Intrinsics.checkNotNull(obj2);
            return new AnnotatedString.Range<>(obj2, intValue, intValue2, str);
        }
    });
    public static final SaverKt$Saver$1 VerbatimTtsAnnotationSaver = SaverKt.Saver(new Function2<SaverScope, VerbatimTtsAnnotation, Object>() { // from class: androidx.compose.ui.text.SaversKt$VerbatimTtsAnnotationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, VerbatimTtsAnnotation verbatimTtsAnnotation) {
            SaverScope Saver = saverScope;
            VerbatimTtsAnnotation it = verbatimTtsAnnotation;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            SaverKt$Saver$1 saverKt$Saver$1 = SaversKt.AnnotatedStringSaver;
            return it.verbatim;
        }
    }, new Function1<Object, VerbatimTtsAnnotation>() { // from class: androidx.compose.ui.text.SaversKt$VerbatimTtsAnnotationSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final VerbatimTtsAnnotation invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new VerbatimTtsAnnotation((String) it);
        }
    });
    public static final SaverKt$Saver$1 UrlAnnotationSaver = SaverKt.Saver(new Function2<SaverScope, UrlAnnotation, Object>() { // from class: androidx.compose.ui.text.SaversKt$UrlAnnotationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, UrlAnnotation urlAnnotation) {
            SaverScope Saver = saverScope;
            UrlAnnotation it = urlAnnotation;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            SaverKt$Saver$1 saverKt$Saver$1 = SaversKt.AnnotatedStringSaver;
            return it.url;
        }
    }, new Function1<Object, UrlAnnotation>() { // from class: androidx.compose.ui.text.SaversKt$UrlAnnotationSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final UrlAnnotation invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new UrlAnnotation((String) it);
        }
    });
    public static final SaverKt$Saver$1 ParagraphStyleSaver = SaverKt.Saver(new Function2<SaverScope, ParagraphStyle, Object>() { // from class: androidx.compose.ui.text.SaversKt$ParagraphStyleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, ParagraphStyle paragraphStyle) {
            SaverScope Saver = saverScope;
            ParagraphStyle it = paragraphStyle;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            SaverKt$Saver$1 saverKt$Saver$1 = SaversKt.AnnotatedStringSaver;
            Object save = SaversKt.save(new TextUnit(it.lineHeight), SaversKt.TextUnitSaver, Saver);
            TextIndent textIndent = TextIndent.None;
            return CollectionsKt__CollectionsKt.arrayListOf(it.textAlign, it.textDirection, save, SaversKt.save(it.textIndent, SaversKt.TextIndentSaver, Saver));
        }
    }, new Function1<Object, ParagraphStyle>() { // from class: androidx.compose.ui.text.SaversKt$ParagraphStyleSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final ParagraphStyle invoke(Object it) {
            TextAlign textAlign;
            TextDirection textDirection;
            TextUnit textUnit;
            TextIndent textIndent;
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object obj = list.get(0);
            if (obj != null) {
                textAlign = (TextAlign) obj;
            } else {
                textAlign = null;
            }
            Object obj2 = list.get(1);
            if (obj2 != null) {
                textDirection = (TextDirection) obj2;
            } else {
                textDirection = null;
            }
            Object obj3 = list.get(2);
            TextUnitType[] textUnitTypeArr = TextUnit.TextUnitTypes;
            SaverKt$Saver$1 saverKt$Saver$1 = SaversKt.TextUnitSaver;
            Boolean bool = Boolean.FALSE;
            if (!Intrinsics.areEqual(obj3, bool) && obj3 != null) {
                textUnit = (TextUnit) saverKt$Saver$1.$restore.invoke(obj3);
            } else {
                textUnit = null;
            }
            Intrinsics.checkNotNull(textUnit);
            long j = textUnit.packedValue;
            Object obj4 = list.get(3);
            TextIndent textIndent2 = TextIndent.None;
            SaverKt$Saver$1 saverKt$Saver$12 = SaversKt.TextIndentSaver;
            if (!Intrinsics.areEqual(obj4, bool) && obj4 != null) {
                textIndent = (TextIndent) saverKt$Saver$12.$restore.invoke(obj4);
            } else {
                textIndent = null;
            }
            return new ParagraphStyle(textAlign, textDirection, j, textIndent, null, null, null, null, null);
        }
    });
    public static final SaverKt$Saver$1 SpanStyleSaver = SaverKt.Saver(new Function2<SaverScope, SpanStyle, Object>() { // from class: androidx.compose.ui.text.SaversKt$SpanStyleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, SpanStyle spanStyle) {
            SaverScope Saver = saverScope;
            SpanStyle it = spanStyle;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            Color color = new Color(it.m516getColor0d7_KjU());
            SaverKt$Saver$1 saverKt$Saver$1 = SaversKt.ColorSaver;
            Object save = SaversKt.save(color, saverKt$Saver$1, Saver);
            TextUnit textUnit = new TextUnit(it.fontSize);
            SaverKt$Saver$1 saverKt$Saver$12 = SaversKt.TextUnitSaver;
            Object save2 = SaversKt.save(textUnit, saverKt$Saver$12, Saver);
            FontWeight fontWeight = FontWeight.W400;
            Object save3 = SaversKt.save(it.fontWeight, SaversKt.FontWeightSaver, Saver);
            FontStyle fontStyle = it.fontStyle;
            FontSynthesis fontSynthesis = it.fontSynthesis;
            String str = it.fontFeatureSettings;
            Object save4 = SaversKt.save(new TextUnit(it.letterSpacing), saverKt$Saver$12, Saver);
            Object save5 = SaversKt.save(it.baselineShift, SaversKt.BaselineShiftSaver, Saver);
            Object save6 = SaversKt.save(it.textGeometricTransform, SaversKt.TextGeometricTransformSaver, Saver);
            Object save7 = SaversKt.save(it.localeList, SaversKt.LocaleListSaver, Saver);
            Object save8 = SaversKt.save(new Color(it.background), saverKt$Saver$1, Saver);
            Object save9 = SaversKt.save(it.textDecoration, SaversKt.TextDecorationSaver, Saver);
            Shadow shadow = Shadow.None;
            return CollectionsKt__CollectionsKt.arrayListOf(save, save2, save3, fontStyle, fontSynthesis, -1, str, save4, save5, save6, save7, save8, save9, SaversKt.save(it.shadow, SaversKt.ShadowSaver, Saver));
        }
    }, new Function1<Object, SpanStyle>() { // from class: androidx.compose.ui.text.SaversKt$SpanStyleSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final SpanStyle invoke(Object it) {
            Color color;
            TextUnit textUnit;
            FontWeight fontWeight;
            FontStyle fontStyle;
            FontSynthesis fontSynthesis;
            String str;
            TextUnit textUnit2;
            BaselineShift baselineShift;
            TextGeometricTransform textGeometricTransform;
            LocaleList localeList;
            Color color2;
            TextDecoration textDecoration;
            Shadow shadow;
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object obj = list.get(0);
            int r2 = Color.$r8$clinit;
            SaverKt$Saver$1 saverKt$Saver$1 = SaversKt.ColorSaver;
            Boolean bool = Boolean.FALSE;
            if (!Intrinsics.areEqual(obj, bool) && obj != null) {
                color = (Color) saverKt$Saver$1.$restore.invoke(obj);
            } else {
                color = null;
            }
            Intrinsics.checkNotNull(color);
            long j = color.value;
            Object obj2 = list.get(1);
            TextUnitType[] textUnitTypeArr = TextUnit.TextUnitTypes;
            SaverKt$Saver$1 saverKt$Saver$12 = SaversKt.TextUnitSaver;
            if (!Intrinsics.areEqual(obj2, bool) && obj2 != null) {
                textUnit = (TextUnit) saverKt$Saver$12.$restore.invoke(obj2);
            } else {
                textUnit = null;
            }
            Intrinsics.checkNotNull(textUnit);
            long j2 = textUnit.packedValue;
            Object obj3 = list.get(2);
            FontWeight fontWeight2 = FontWeight.W400;
            SaverKt$Saver$1 saverKt$Saver$13 = SaversKt.FontWeightSaver;
            if (!Intrinsics.areEqual(obj3, bool) && obj3 != null) {
                fontWeight = (FontWeight) saverKt$Saver$13.$restore.invoke(obj3);
            } else {
                fontWeight = null;
            }
            Object obj4 = list.get(3);
            if (obj4 != null) {
                fontStyle = (FontStyle) obj4;
            } else {
                fontStyle = null;
            }
            Object obj5 = list.get(4);
            if (obj5 != null) {
                fontSynthesis = (FontSynthesis) obj5;
            } else {
                fontSynthesis = null;
            }
            Object obj6 = list.get(6);
            if (obj6 != null) {
                str = (String) obj6;
            } else {
                str = null;
            }
            Object obj7 = list.get(7);
            if (!Intrinsics.areEqual(obj7, bool) && obj7 != null) {
                textUnit2 = (TextUnit) saverKt$Saver$12.$restore.invoke(obj7);
            } else {
                textUnit2 = null;
            }
            Intrinsics.checkNotNull(textUnit2);
            long j3 = textUnit2.packedValue;
            Object obj8 = list.get(8);
            SaverKt$Saver$1 saverKt$Saver$14 = SaversKt.BaselineShiftSaver;
            if (!Intrinsics.areEqual(obj8, bool) && obj8 != null) {
                baselineShift = (BaselineShift) saverKt$Saver$14.$restore.invoke(obj8);
            } else {
                baselineShift = null;
            }
            Object obj9 = list.get(9);
            SaverKt$Saver$1 saverKt$Saver$15 = SaversKt.TextGeometricTransformSaver;
            if (!Intrinsics.areEqual(obj9, bool) && obj9 != null) {
                textGeometricTransform = (TextGeometricTransform) saverKt$Saver$15.$restore.invoke(obj9);
            } else {
                textGeometricTransform = null;
            }
            Object obj10 = list.get(10);
            SaverKt$Saver$1 saverKt$Saver$16 = SaversKt.LocaleListSaver;
            if (!Intrinsics.areEqual(obj10, bool) && obj10 != null) {
                localeList = (LocaleList) saverKt$Saver$16.$restore.invoke(obj10);
            } else {
                localeList = null;
            }
            Object obj11 = list.get(11);
            if (!Intrinsics.areEqual(obj11, bool) && obj11 != null) {
                color2 = (Color) saverKt$Saver$1.$restore.invoke(obj11);
            } else {
                color2 = null;
            }
            Intrinsics.checkNotNull(color2);
            long j4 = color2.value;
            Object obj12 = list.get(12);
            SaverKt$Saver$1 saverKt$Saver$17 = SaversKt.TextDecorationSaver;
            if (!Intrinsics.areEqual(obj12, bool) && obj12 != null) {
                textDecoration = (TextDecoration) saverKt$Saver$17.$restore.invoke(obj12);
            } else {
                textDecoration = null;
            }
            Object obj13 = list.get(13);
            Shadow shadow2 = Shadow.None;
            SaverKt$Saver$1 saverKt$Saver$18 = SaversKt.ShadowSaver;
            if (!Intrinsics.areEqual(obj13, bool) && obj13 != null) {
                shadow = (Shadow) saverKt$Saver$18.$restore.invoke(obj13);
            } else {
                shadow = null;
            }
            return new SpanStyle(j, j2, fontWeight, fontStyle, fontSynthesis, null, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, 49184);
        }
    });
    public static final SaverKt$Saver$1 TextDecorationSaver = SaverKt.Saver(new Function2<SaverScope, TextDecoration, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextDecorationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, TextDecoration textDecoration) {
            SaverScope Saver = saverScope;
            TextDecoration it = textDecoration;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return Integer.valueOf(it.mask);
        }
    }, new Function1<Object, TextDecoration>() { // from class: androidx.compose.ui.text.SaversKt$TextDecorationSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final TextDecoration invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new TextDecoration(((Integer) it).intValue());
        }
    });
    public static final SaverKt$Saver$1 TextGeometricTransformSaver = SaverKt.Saver(new Function2<SaverScope, TextGeometricTransform, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextGeometricTransformSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, TextGeometricTransform textGeometricTransform) {
            SaverScope Saver = saverScope;
            TextGeometricTransform it = textGeometricTransform;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return CollectionsKt__CollectionsKt.arrayListOf(Float.valueOf(it.scaleX), Float.valueOf(it.skewX));
        }
    }, new Function1<Object, TextGeometricTransform>() { // from class: androidx.compose.ui.text.SaversKt$TextGeometricTransformSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final TextGeometricTransform invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            return new TextGeometricTransform(((Number) list.get(0)).floatValue(), ((Number) list.get(1)).floatValue());
        }
    });
    public static final SaverKt$Saver$1 TextIndentSaver = SaverKt.Saver(new Function2<SaverScope, TextIndent, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextIndentSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, TextIndent textIndent) {
            SaverScope Saver = saverScope;
            TextIndent it = textIndent;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            TextUnit textUnit = new TextUnit(it.firstLine);
            SaverKt$Saver$1 saverKt$Saver$1 = SaversKt.TextUnitSaver;
            return CollectionsKt__CollectionsKt.arrayListOf(SaversKt.save(textUnit, saverKt$Saver$1, Saver), SaversKt.save(new TextUnit(it.restLine), saverKt$Saver$1, Saver));
        }
    }, new Function1<Object, TextIndent>() { // from class: androidx.compose.ui.text.SaversKt$TextIndentSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final TextIndent invoke(Object it) {
            TextUnit textUnit;
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object obj = list.get(0);
            TextUnitType[] textUnitTypeArr = TextUnit.TextUnitTypes;
            SaverKt$Saver$1 saverKt$Saver$1 = SaversKt.TextUnitSaver;
            Boolean bool = Boolean.FALSE;
            TextUnit textUnit2 = null;
            if (!Intrinsics.areEqual(obj, bool) && obj != null) {
                textUnit = (TextUnit) saverKt$Saver$1.$restore.invoke(obj);
            } else {
                textUnit = null;
            }
            Intrinsics.checkNotNull(textUnit);
            Object obj2 = list.get(1);
            if (!Intrinsics.areEqual(obj2, bool) && obj2 != null) {
                textUnit2 = (TextUnit) saverKt$Saver$1.$restore.invoke(obj2);
            }
            Intrinsics.checkNotNull(textUnit2);
            return new TextIndent(textUnit.packedValue, textUnit2.packedValue);
        }
    });
    public static final SaverKt$Saver$1 FontWeightSaver = SaverKt.Saver(new Function2<SaverScope, FontWeight, Object>() { // from class: androidx.compose.ui.text.SaversKt$FontWeightSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, FontWeight fontWeight) {
            SaverScope Saver = saverScope;
            FontWeight it = fontWeight;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return Integer.valueOf(it.weight);
        }
    }, new Function1<Object, FontWeight>() { // from class: androidx.compose.ui.text.SaversKt$FontWeightSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final FontWeight invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new FontWeight(((Integer) it).intValue());
        }
    });
    public static final SaverKt$Saver$1 BaselineShiftSaver = SaverKt.Saver(new Function2<SaverScope, BaselineShift, Object>() { // from class: androidx.compose.ui.text.SaversKt$BaselineShiftSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, BaselineShift baselineShift) {
            SaverScope Saver = saverScope;
            float f = baselineShift.multiplier;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            return Float.valueOf(f);
        }
    }, new Function1<Object, BaselineShift>() { // from class: androidx.compose.ui.text.SaversKt$BaselineShiftSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final BaselineShift invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new BaselineShift(((Float) it).floatValue());
        }
    });
    public static final SaverKt$Saver$1 TextRangeSaver = SaverKt.Saver(new Function2<SaverScope, TextRange, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextRangeSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, TextRange textRange) {
            SaverScope Saver = saverScope;
            long j = textRange.packedValue;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            int r6 = TextRange.$r8$clinit;
            Integer valueOf = Integer.valueOf((int) (j >> 32));
            SaverKt$Saver$1 saverKt$Saver$1 = SaversKt.AnnotatedStringSaver;
            return CollectionsKt__CollectionsKt.arrayListOf(valueOf, Integer.valueOf(TextRange.m523getEndimpl(j)));
        }
    }, new Function1<Object, TextRange>() { // from class: androidx.compose.ui.text.SaversKt$TextRangeSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final TextRange invoke(Object it) {
            Integer num;
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object obj = list.get(0);
            Integer num2 = null;
            if (obj != null) {
                num = (Integer) obj;
            } else {
                num = null;
            }
            Intrinsics.checkNotNull(num);
            int intValue = num.intValue();
            Object obj2 = list.get(1);
            if (obj2 != null) {
                num2 = (Integer) obj2;
            }
            Intrinsics.checkNotNull(num2);
            return new TextRange(TextRangeKt.TextRange(intValue, num2.intValue()));
        }
    });
    public static final SaverKt$Saver$1 ShadowSaver = SaverKt.Saver(new Function2<SaverScope, Shadow, Object>() { // from class: androidx.compose.ui.text.SaversKt$ShadowSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, Shadow shadow) {
            SaverScope Saver = saverScope;
            Shadow it = shadow;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return CollectionsKt__CollectionsKt.arrayListOf(SaversKt.save(new Color(it.color), SaversKt.ColorSaver, Saver), SaversKt.save(new Offset(it.offset), SaversKt.OffsetSaver, Saver), Float.valueOf(it.blurRadius));
        }
    }, new Function1<Object, Shadow>() { // from class: androidx.compose.ui.text.SaversKt$ShadowSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final Shadow invoke(Object it) {
            Color color;
            Offset offset;
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object obj = list.get(0);
            int r1 = Color.$r8$clinit;
            SaverKt$Saver$1 saverKt$Saver$1 = SaversKt.ColorSaver;
            Boolean bool = Boolean.FALSE;
            Float f = null;
            if (!Intrinsics.areEqual(obj, bool) && obj != null) {
                color = (Color) saverKt$Saver$1.$restore.invoke(obj);
            } else {
                color = null;
            }
            Intrinsics.checkNotNull(color);
            long j = color.value;
            Object obj2 = list.get(1);
            int r12 = Offset.$r8$clinit;
            SaverKt$Saver$1 saverKt$Saver$12 = SaversKt.OffsetSaver;
            if (!Intrinsics.areEqual(obj2, bool) && obj2 != null) {
                offset = (Offset) saverKt$Saver$12.$restore.invoke(obj2);
            } else {
                offset = null;
            }
            Intrinsics.checkNotNull(offset);
            long j2 = offset.packedValue;
            Object obj3 = list.get(2);
            if (obj3 != null) {
                f = (Float) obj3;
            }
            Intrinsics.checkNotNull(f);
            return new Shadow(j, j2, f.floatValue());
        }
    });
    public static final SaverKt$Saver$1 ColorSaver = SaverKt.Saver(new Function2<SaverScope, Color, Object>() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, Color color) {
            SaverScope Saver = saverScope;
            long j = color.value;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            return new ULong(j);
        }
    }, new Function1<Object, Color>() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final Color invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new Color(((ULong) it).data);
        }
    });
    public static final SaverKt$Saver$1 TextUnitSaver = SaverKt.Saver(new Function2<SaverScope, TextUnit, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextUnitSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, TextUnit textUnit) {
            SaverScope Saver = saverScope;
            long j = textUnit.packedValue;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Float valueOf = Float.valueOf(TextUnit.m598getValueimpl(j));
            SaverKt$Saver$1 saverKt$Saver$1 = SaversKt.AnnotatedStringSaver;
            return CollectionsKt__CollectionsKt.arrayListOf(valueOf, new TextUnitType(TextUnit.m597getTypeUIouoOA(j)));
        }
    }, new Function1<Object, TextUnit>() { // from class: androidx.compose.ui.text.SaversKt$TextUnitSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final TextUnit invoke(Object it) {
            Float f;
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object obj = list.get(0);
            TextUnitType textUnitType = null;
            if (obj != null) {
                f = (Float) obj;
            } else {
                f = null;
            }
            Intrinsics.checkNotNull(f);
            float floatValue = f.floatValue();
            Object obj2 = list.get(1);
            if (obj2 != null) {
                textUnitType = (TextUnitType) obj2;
            }
            Intrinsics.checkNotNull(textUnitType);
            return new TextUnit(TextUnitKt.pack(floatValue, textUnitType.type));
        }
    });
    public static final SaverKt$Saver$1 OffsetSaver = SaverKt.Saver(new Function2<SaverScope, Offset, Object>() { // from class: androidx.compose.ui.text.SaversKt$OffsetSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, Offset offset) {
            SaverScope Saver = saverScope;
            long j = offset.packedValue;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            if (Offset.m257equalsimpl0(j, Offset.Unspecified)) {
                return Boolean.FALSE;
            }
            Float valueOf = Float.valueOf(Offset.m259getXimpl(j));
            SaverKt$Saver$1 saverKt$Saver$1 = SaversKt.AnnotatedStringSaver;
            return CollectionsKt__CollectionsKt.arrayListOf(valueOf, Float.valueOf(Offset.m260getYimpl(j)));
        }
    }, new Function1<Object, Offset>() { // from class: androidx.compose.ui.text.SaversKt$OffsetSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final Offset invoke(Object it) {
            Float f;
            Intrinsics.checkNotNullParameter(it, "it");
            if (Intrinsics.areEqual(it, Boolean.FALSE)) {
                return new Offset(Offset.Unspecified);
            }
            List list = (List) it;
            Object obj = list.get(0);
            Float f2 = null;
            if (obj != null) {
                f = (Float) obj;
            } else {
                f = null;
            }
            Intrinsics.checkNotNull(f);
            float floatValue = f.floatValue();
            Object obj2 = list.get(1);
            if (obj2 != null) {
                f2 = (Float) obj2;
            }
            Intrinsics.checkNotNull(f2);
            return new Offset(OffsetKt.Offset(floatValue, f2.floatValue()));
        }
    });
    public static final SaverKt$Saver$1 LocaleListSaver = SaverKt.Saver(new Function2<SaverScope, LocaleList, Object>() { // from class: androidx.compose.ui.text.SaversKt$LocaleListSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, LocaleList localeList) {
            SaverScope Saver = saverScope;
            LocaleList it = localeList;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            List<Locale> list = it.localeList;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int r2 = 0; r2 < size; r2++) {
                arrayList.add(SaversKt.save(list.get(r2), SaversKt.LocaleSaver, Saver));
            }
            return arrayList;
        }
    }, new Function1<Object, LocaleList>() { // from class: androidx.compose.ui.text.SaversKt$LocaleListSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final LocaleList invoke(Object it) {
            Locale locale;
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int r2 = 0; r2 < size; r2++) {
                Object obj = list.get(r2);
                SaverKt$Saver$1 saverKt$Saver$1 = SaversKt.LocaleSaver;
                if (!Intrinsics.areEqual(obj, Boolean.FALSE) && obj != null) {
                    locale = (Locale) saverKt$Saver$1.$restore.invoke(obj);
                } else {
                    locale = null;
                }
                Intrinsics.checkNotNull(locale);
                arrayList.add(locale);
            }
            return new LocaleList(arrayList);
        }
    });
    public static final SaverKt$Saver$1 LocaleSaver = SaverKt.Saver(new Function2<SaverScope, Locale, Object>() { // from class: androidx.compose.ui.text.SaversKt$LocaleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, Locale locale) {
            SaverScope Saver = saverScope;
            Locale it = locale;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return it.platformLocale.toLanguageTag();
        }
    }, new Function1<Object, Locale>() { // from class: androidx.compose.ui.text.SaversKt$LocaleSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final Locale invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            PlatformLocaleKt.platformLocaleDelegate.getClass();
            java.util.Locale forLanguageTag = java.util.Locale.forLanguageTag((String) it);
            Intrinsics.checkNotNullExpressionValue(forLanguageTag, "forLanguageTag(languageTag)");
            return new Locale(new AndroidLocale(forLanguageTag));
        }
    });

    public static final Object save(Object obj, SaverKt$Saver$1 saver, SaverScope scope) {
        Object save;
        Intrinsics.checkNotNullParameter(saver, "saver");
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (obj == null || (save = saver.save(scope, obj)) == null) {
            return Boolean.FALSE;
        }
        return save;
    }
}
