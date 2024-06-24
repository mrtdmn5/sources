package okhttp3;

import io.ktor.http.ContentTypesKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal._HeadersCommonKt;
import okhttp3.internal._UtilCommonKt;

/* compiled from: Headers.kt */
/* loaded from: classes4.dex */
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, KMappedMarker {
    public final String[] namesAndValues;

    /* compiled from: Headers.kt */
    /* loaded from: classes4.dex */
    public static final class Builder {
        public final ArrayList namesAndValues = new ArrayList(20);

        public final void add(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            _HeadersCommonKt.headersCheckName(name);
            _HeadersCommonKt.headersCheckValue(value, name);
            _HeadersCommonKt.commonAddLenient(this, name, value);
        }

        public final Headers build() {
            Object[] array = this.namesAndValues.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return new Headers((String[]) array);
        }

        public final void removeAll(String str) {
            int r0 = 0;
            while (true) {
                ArrayList arrayList = this.namesAndValues;
                if (r0 < arrayList.size()) {
                    if (StringsKt__StringsJVMKt.equals(str, (String) arrayList.get(r0))) {
                        arrayList.remove(r0);
                        arrayList.remove(r0);
                        r0 -= 2;
                    }
                    r0 += 2;
                } else {
                    return;
                }
            }
        }
    }

    /* compiled from: Headers.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static Headers of(String... strArr) {
            boolean z;
            boolean z2;
            String[] inputNamesAndValues = (String[]) Arrays.copyOf(strArr, strArr.length);
            Intrinsics.checkNotNullParameter(inputNamesAndValues, "inputNamesAndValues");
            int r3 = 0;
            if (inputNamesAndValues.length % 2 == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                String[] strArr2 = (String[]) Arrays.copyOf(inputNamesAndValues, inputNamesAndValues.length);
                int length = strArr2.length;
                for (int r5 = 0; r5 < length; r5++) {
                    if (strArr2[r5] != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        strArr2[r5] = StringsKt__StringsKt.trim(inputNamesAndValues[r5]).toString();
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null".toString());
                    }
                }
                int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, strArr2.length - 1, 2);
                if (progressionLastElement >= 0) {
                    while (true) {
                        String str = strArr2[r3];
                        String str2 = strArr2[r3 + 1];
                        _HeadersCommonKt.headersCheckName(str);
                        _HeadersCommonKt.headersCheckValue(str2, str);
                        if (r3 == progressionLastElement) {
                            break;
                        }
                        r3 += 2;
                    }
                }
                return new Headers(strArr2);
            }
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        }
    }

    public Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Headers) {
            if (Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues)) {
                return true;
            }
        }
        return false;
    }

    public final String get(String str) {
        String[] namesAndValues = this.namesAndValues;
        Intrinsics.checkNotNullParameter(namesAndValues, "namesAndValues");
        int length = namesAndValues.length - 2;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(length, 0, -2);
        if (progressionLastElement <= length) {
            while (!StringsKt__StringsJVMKt.equals(str, namesAndValues[length])) {
                if (length != progressionLastElement) {
                    length -= 2;
                }
            }
            return namesAndValues[length + 1];
        }
        return null;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    public final Iterator<Pair<? extends String, ? extends String>> iterator() {
        int length = this.namesAndValues.length / 2;
        Pair[] pairArr = new Pair[length];
        for (int r2 = 0; r2 < length; r2++) {
            pairArr[r2] = new Pair(name(r2), value(r2));
        }
        return ContentTypesKt.iterator(pairArr);
    }

    public final String name(int r4) {
        String str = (String) ArraysKt___ArraysKt.getOrNull(r4 * 2, this.namesAndValues);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("name[" + r4 + ']');
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        CollectionsKt__ReversedViewsKt.addAll(builder.namesAndValues, this.namesAndValues);
        return builder;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int length = this.namesAndValues.length / 2;
        for (int r2 = 0; r2 < length; r2++) {
            String name = name(r2);
            String value = value(r2);
            sb.append(name);
            sb.append(": ");
            if (_UtilCommonKt.isSensitiveHeader(name)) {
                value = "██";
            }
            sb.append(value);
            sb.append("\n");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String value(int r4) {
        String str = (String) ArraysKt___ArraysKt.getOrNull((r4 * 2) + 1, this.namesAndValues);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("value[" + r4 + ']');
    }

    public final List<String> values(String str) {
        int length = this.namesAndValues.length / 2;
        List<String> list = null;
        ArrayList arrayList = null;
        for (int r3 = 0; r3 < length; r3++) {
            if (StringsKt__StringsJVMKt.equals(str, name(r3))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(r3));
            }
        }
        if (arrayList != null) {
            list = CollectionsKt___CollectionsKt.toList(arrayList);
        }
        if (list == null) {
            return EmptyList.INSTANCE;
        }
        return list;
    }
}
