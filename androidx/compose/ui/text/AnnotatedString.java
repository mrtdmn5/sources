package androidx.compose.ui.text;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: AnnotatedString.kt */
/* loaded from: classes.dex */
public final class AnnotatedString implements CharSequence {
    public final List<Range<? extends Object>> annotations;
    public final List<Range<ParagraphStyle>> paragraphStylesOrNull;
    public final List<Range<SpanStyle>> spanStylesOrNull;
    public final String text;

    public AnnotatedString() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnnotatedString(String text, List<Range<SpanStyle>> list, List<Range<ParagraphStyle>> list2, List<? extends Range<? extends Object>> list3) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.spanStylesOrNull = list;
        this.paragraphStylesOrNull = list2;
        this.annotations = list3;
        if (list2 != null) {
            List sortedWith = CollectionsKt___CollectionsKt.sortedWith(list2, new AnnotatedString$special$$inlined$sortedBy$1());
            int size = sortedWith.size();
            int r8 = -1;
            int r0 = 0;
            while (r0 < size) {
                Range range = (Range) sortedWith.get(r0);
                if (range.start >= r8) {
                    int length = this.text.length();
                    int r2 = range.end;
                    if (!(r2 <= length)) {
                        throw new IllegalArgumentException(("ParagraphStyle range [" + range.start + ", " + r2 + ") is out of boundary").toString());
                    }
                    r0++;
                    r8 = r2;
                } else {
                    throw new IllegalArgumentException("ParagraphStyle should not overlap".toString());
                }
            }
        }
    }

    @Override // java.lang.CharSequence
    public final char charAt(int r2) {
        return this.text.charAt(r2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnnotatedString)) {
            return false;
        }
        AnnotatedString annotatedString = (AnnotatedString) obj;
        if (Intrinsics.areEqual(this.text, annotatedString.text) && Intrinsics.areEqual(this.spanStylesOrNull, annotatedString.spanStylesOrNull) && Intrinsics.areEqual(this.paragraphStylesOrNull, annotatedString.paragraphStylesOrNull) && Intrinsics.areEqual(this.annotations, annotatedString.annotations)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r2;
        int r22;
        int hashCode = this.text.hashCode() * 31;
        int r1 = 0;
        List<Range<SpanStyle>> list = this.spanStylesOrNull;
        if (list != null) {
            r2 = list.hashCode();
        } else {
            r2 = 0;
        }
        int r0 = (hashCode + r2) * 31;
        List<Range<ParagraphStyle>> list2 = this.paragraphStylesOrNull;
        if (list2 != null) {
            r22 = list2.hashCode();
        } else {
            r22 = 0;
        }
        int r02 = (r0 + r22) * 31;
        List<Range<? extends Object>> list3 = this.annotations;
        if (list3 != null) {
            r1 = list3.hashCode();
        }
        return r02 + r1;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.text.length();
    }

    public final AnnotatedString plus(AnnotatedString other) {
        Intrinsics.checkNotNullParameter(other, "other");
        Builder builder = new Builder(this);
        builder.append(other);
        return builder.toAnnotatedString();
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.text;
    }

    @Override // java.lang.CharSequence
    public final AnnotatedString subSequence(int r6, int r7) {
        if (r6 <= r7) {
            String str = this.text;
            if (r6 == 0 && r7 == str.length()) {
                return this;
            }
            String substring = str.substring(r6, r7);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return new AnnotatedString(substring, AnnotatedStringKt.access$filterRanges(r6, this.spanStylesOrNull, r7), AnnotatedStringKt.access$filterRanges(r6, this.paragraphStylesOrNull, r7), AnnotatedStringKt.access$filterRanges(r6, this.annotations, r7));
        }
        throw new IllegalArgumentException(("start (" + r6 + ") should be less or equal to end (" + r7 + ')').toString());
    }

    /* compiled from: AnnotatedString.kt */
    /* loaded from: classes.dex */
    public static final class Builder implements Appendable {
        public final ArrayList annotations;
        public final ArrayList paragraphStyles;
        public final ArrayList spanStyles;
        public final ArrayList styleStack;
        public final StringBuilder text;

        /* compiled from: AnnotatedString.kt */
        /* loaded from: classes.dex */
        public static final class MutableRange<T> {
            public int end;
            public final T item;
            public final int start;
            public final String tag;

            public /* synthetic */ MutableRange(Object obj, int r3, int r4, int r5) {
                this(obj, r3, (r5 & 4) != 0 ? Integer.MIN_VALUE : r4, (r5 & 8) != 0 ? "" : null);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MutableRange)) {
                    return false;
                }
                MutableRange mutableRange = (MutableRange) obj;
                if (Intrinsics.areEqual(this.item, mutableRange.item) && this.start == mutableRange.start && this.end == mutableRange.end && Intrinsics.areEqual(this.tag, mutableRange.tag)) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                int hashCode;
                T t = this.item;
                if (t == null) {
                    hashCode = 0;
                } else {
                    hashCode = t.hashCode();
                }
                return this.tag.hashCode() + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.end, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.start, hashCode * 31, 31), 31);
            }

            public final Range<T> toRange(int r5) {
                boolean z;
                int r0 = this.end;
                if (r0 != Integer.MIN_VALUE) {
                    r5 = r0;
                }
                if (r5 != Integer.MIN_VALUE) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return new Range<>(this.item, this.start, r5, this.tag);
                }
                throw new IllegalStateException("Item.end should be set first".toString());
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("MutableRange(item=");
                sb.append(this.item);
                sb.append(", start=");
                sb.append(this.start);
                sb.append(", end=");
                sb.append(this.end);
                sb.append(", tag=");
                return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.tag, ')');
            }

            public MutableRange(T t, int r3, int r4, String tag) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                this.item = t;
                this.start = r3;
                this.end = r4;
                this.tag = tag;
            }
        }

        public Builder() {
            this.text = new StringBuilder(16);
            this.spanStyles = new ArrayList();
            this.paragraphStyles = new ArrayList();
            this.annotations = new ArrayList();
            this.styleStack = new ArrayList();
        }

        public final void addStyle(SpanStyle style, int r5, int r6) {
            Intrinsics.checkNotNullParameter(style, "style");
            this.spanStyles.add(new MutableRange(style, r5, r6, 8));
        }

        @Override // java.lang.Appendable
        public final Appendable append(CharSequence charSequence) {
            if (charSequence instanceof AnnotatedString) {
                append((AnnotatedString) charSequence);
            } else {
                this.text.append(charSequence);
            }
            return this;
        }

        public final void pop(int r5) {
            boolean z;
            ArrayList arrayList = this.styleStack;
            if (r5 < arrayList.size()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                while (arrayList.size() - 1 >= r5) {
                    if (!arrayList.isEmpty()) {
                        ((MutableRange) arrayList.remove(arrayList.size() - 1)).end = this.text.length();
                    } else {
                        throw new IllegalStateException("Nothing to pop.".toString());
                    }
                }
                return;
            }
            throw new IllegalStateException((r5 + " should be less than " + arrayList.size()).toString());
        }

        public final AnnotatedString toAnnotatedString() {
            StringBuilder sb = this.text;
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "text.toString()");
            ArrayList arrayList = this.spanStyles;
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size = arrayList.size();
            for (int r6 = 0; r6 < size; r6++) {
                arrayList2.add(((MutableRange) arrayList.get(r6)).toRange(sb.length()));
            }
            ArrayList arrayList3 = null;
            if (arrayList2.isEmpty()) {
                arrayList2 = null;
            }
            ArrayList arrayList4 = this.paragraphStyles;
            ArrayList arrayList5 = new ArrayList(arrayList4.size());
            int size2 = arrayList4.size();
            for (int r8 = 0; r8 < size2; r8++) {
                arrayList5.add(((MutableRange) arrayList4.get(r8)).toRange(sb.length()));
            }
            if (arrayList5.isEmpty()) {
                arrayList5 = null;
            }
            ArrayList arrayList6 = this.annotations;
            ArrayList arrayList7 = new ArrayList(arrayList6.size());
            int size3 = arrayList6.size();
            for (int r5 = 0; r5 < size3; r5++) {
                arrayList7.add(((MutableRange) arrayList6.get(r5)).toRange(sb.length()));
            }
            if (!arrayList7.isEmpty()) {
                arrayList3 = arrayList7;
            }
            return new AnnotatedString(sb2, arrayList2, arrayList5, arrayList3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List, java.util.List<androidx.compose.ui.text.AnnotatedString$Range<? extends java.lang.Object>>] */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r8v0 */
        /* JADX WARN: Type inference failed for: r8v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r8v10, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r8v9, types: [java.util.List, java.util.List<androidx.compose.ui.text.AnnotatedString$Range<androidx.compose.ui.text.ParagraphStyle>>] */
        @Override // java.lang.Appendable
        public final Appendable append(CharSequence charSequence, int r18, int r19) {
            ?? r8;
            List list;
            ?? r1;
            boolean z = charSequence instanceof AnnotatedString;
            StringBuilder sb = this.text;
            if (z) {
                AnnotatedString text = (AnnotatedString) charSequence;
                Intrinsics.checkNotNullParameter(text, "text");
                int length = sb.length();
                String str = text.text;
                sb.append((CharSequence) str, r18, r19);
                List<Range<SpanStyle>> localSpanStyles = AnnotatedStringKt.getLocalSpanStyles(text, r18, r19);
                if (localSpanStyles != null) {
                    int size = localSpanStyles.size();
                    for (int r9 = 0; r9 < size; r9++) {
                        Range<SpanStyle> range = localSpanStyles.get(r9);
                        addStyle(range.item, range.start + length, range.end + length);
                    }
                }
                if (r18 == r19 || (r8 = text.paragraphStylesOrNull) == 0) {
                    r8 = 0;
                } else if (r18 != 0 || r19 < str.length()) {
                    ArrayList arrayList = new ArrayList(r8.size());
                    int size2 = r8.size();
                    for (int r11 = 0; r11 < size2; r11++) {
                        Object obj = r8.get(r11);
                        Range range2 = (Range) obj;
                        if (AnnotatedStringKt.intersect(r18, r19, range2.start, range2.end)) {
                            arrayList.add(obj);
                        }
                    }
                    r8 = new ArrayList(arrayList.size());
                    int size3 = arrayList.size();
                    for (int r112 = 0; r112 < size3; r112++) {
                        Range range3 = (Range) arrayList.get(r112);
                        r8.add(new Range(RangesKt___RangesKt.coerceIn(range3.start, r18, r19) - r18, RangesKt___RangesKt.coerceIn(range3.end, r18, r19) - r18, range3.item));
                    }
                }
                if (r8 != 0) {
                    int size4 = r8.size();
                    for (int r10 = 0; r10 < size4; r10++) {
                        Range range4 = (Range) r8.get(r10);
                        ParagraphStyle style = (ParagraphStyle) range4.item;
                        int r13 = range4.start + length;
                        int r113 = range4.end + length;
                        Intrinsics.checkNotNullParameter(style, "style");
                        this.paragraphStyles.add(new MutableRange(style, r13, r113, 8));
                    }
                }
                if (r18 == r19 || (r1 = text.annotations) == 0) {
                    list = null;
                } else {
                    if (r18 != 0 || r19 < str.length()) {
                        ArrayList arrayList2 = new ArrayList(r1.size());
                        int size5 = r1.size();
                        for (int r82 = 0; r82 < size5; r82++) {
                            Object obj2 = r1.get(r82);
                            Range range5 = (Range) obj2;
                            if (AnnotatedStringKt.intersect(r18, r19, range5.start, range5.end)) {
                                arrayList2.add(obj2);
                            }
                        }
                        r1 = new ArrayList(arrayList2.size());
                        int size6 = arrayList2.size();
                        for (int r83 = 0; r83 < size6; r83++) {
                            Range range6 = (Range) arrayList2.get(r83);
                            r1.add(new Range(range6.item, RangesKt___RangesKt.coerceIn(range6.start, r18, r19) - r18, RangesKt___RangesKt.coerceIn(range6.end, r18, r19) - r18, range6.tag));
                        }
                    }
                    list = r1;
                }
                if (list != null) {
                    int size7 = list.size();
                    for (int r7 = 0; r7 < size7; r7++) {
                        Range range7 = (Range) list.get(r7);
                        this.annotations.add(new MutableRange(range7.item, range7.start + length, range7.end + length, range7.tag));
                    }
                }
            } else {
                sb.append(charSequence, r18, r19);
            }
            return this;
        }

        /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
        public Builder(AnnotatedString text) {
            this();
            Intrinsics.checkNotNullParameter(text, "text");
            append(text);
        }

        @Override // java.lang.Appendable
        public final Appendable append(char c) {
            this.text.append(c);
            return this;
        }

        public final void append(AnnotatedString text) {
            Intrinsics.checkNotNullParameter(text, "text");
            StringBuilder sb = this.text;
            int length = sb.length();
            sb.append(text.text);
            List<Range<SpanStyle>> list = text.spanStylesOrNull;
            if (list != null) {
                int size = list.size();
                for (int r4 = 0; r4 < size; r4++) {
                    Range<SpanStyle> range = list.get(r4);
                    addStyle(range.item, range.start + length, range.end + length);
                }
            }
            List<Range<ParagraphStyle>> list2 = text.paragraphStylesOrNull;
            if (list2 != null) {
                int size2 = list2.size();
                for (int r42 = 0; r42 < size2; r42++) {
                    Range<ParagraphStyle> range2 = list2.get(r42);
                    ParagraphStyle style = range2.item;
                    int r7 = range2.start + length;
                    int r5 = range2.end + length;
                    Intrinsics.checkNotNullParameter(style, "style");
                    this.paragraphStyles.add(new MutableRange(style, r7, r5, 8));
                }
            }
            List<Range<? extends Object>> list3 = text.annotations;
            if (list3 != null) {
                int size3 = list3.size();
                for (int r0 = 0; r0 < size3; r0++) {
                    Range<? extends Object> range3 = list3.get(r0);
                    this.annotations.add(new MutableRange(range3.item, range3.start + length, range3.end + length, range3.tag));
                }
            }
        }
    }

    /* compiled from: AnnotatedString.kt */
    /* loaded from: classes.dex */
    public static final class Range<T> {
        public final int end;
        public final T item;
        public final int start;
        public final String tag;

        public Range(T t, int r3, int r4, String tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.item = t;
            this.start = r3;
            this.end = r4;
            this.tag = tag;
            if (!(r3 <= r4)) {
                throw new IllegalArgumentException("Reversed range is not supported".toString());
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Range)) {
                return false;
            }
            Range range = (Range) obj;
            if (Intrinsics.areEqual(this.item, range.item) && this.start == range.start && this.end == range.end && Intrinsics.areEqual(this.tag, range.tag)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int hashCode;
            T t = this.item;
            if (t == null) {
                hashCode = 0;
            } else {
                hashCode = t.hashCode();
            }
            return this.tag.hashCode() + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.end, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.start, hashCode * 31, 31), 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Range(item=");
            sb.append(this.item);
            sb.append(", start=");
            sb.append(this.start);
            sb.append(", end=");
            sb.append(this.end);
            sb.append(", tag=");
            return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.tag, ')');
        }

        public Range(int r2, int r3, Object obj) {
            this(obj, r2, r3, "");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.collections.EmptyList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AnnotatedString(java.lang.String r3, java.util.ArrayList r4, int r5) {
        /*
            r2 = this;
            r0 = r5 & 2
            kotlin.collections.EmptyList r1 = kotlin.collections.EmptyList.INSTANCE
            if (r0 == 0) goto L7
            r4 = r1
        L7:
            r5 = r5 & 4
            r0 = 0
            if (r5 == 0) goto Ld
            goto Le
        Ld:
            r1 = r0
        Le:
            java.lang.String r5 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r5)
            java.lang.String r5 = "spanStyles"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            java.lang.String r5 = "paragraphStyles"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r5)
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L28
            r4 = r0
        L28:
            java.util.List r4 = (java.util.List) r4
            r2.<init>(r3, r4, r0, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.AnnotatedString.<init>(java.lang.String, java.util.ArrayList, int):void");
    }
}
