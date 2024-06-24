package com.animaconnected.watch.device;

import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.msgpack.MsgPack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: MsgPack.kt */
/* loaded from: classes3.dex */
public final class MsgPackKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.CharSequence, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object, java.util.regex.Pattern] */
    public static final Object[] parseStringToArray(String msgPackString) {
        Intrinsics.checkNotNullParameter(msgPackString, "msgPackString");
        List<??> split$default = StringsKt__StringsKt.split$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(msgPackString, "[", ""), "]", ""), new String[]{","}, 0, 6);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(split$default, 10));
        for (?? input : split$default) {
            if (StringsKt__StringsJVMKt.equals(input, "true")) {
                input = Boolean.TRUE;
            } else if (StringsKt__StringsJVMKt.equals(input, "false")) {
                input = Boolean.FALSE;
            } else {
                ?? compile = Pattern.compile("[A-z]");
                Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
                Intrinsics.checkNotNullParameter(input, "input");
                if (!compile.matcher(input).find()) {
                    input = Integer.valueOf(Integer.parseInt(input));
                }
            }
            arrayList.add(input);
        }
        return arrayList.toArray(new Object[0]);
    }

    public static final boolean tryBool(Map<Integer, ? extends MsgPack> map, int r2, boolean z) {
        MsgPack msgPack;
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map.containsKey(Integer.valueOf(r2)) && (msgPack = map.get(Integer.valueOf(r2))) != null) {
            return msgPack.asBoolean();
        }
        return z;
    }

    public static /* synthetic */ boolean tryBool$default(Map map, int r1, boolean z, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            z = false;
        }
        return tryBool(map, r1, z);
    }

    public static final CrashInfo tryCrashInfo(Map<String, ? extends MsgPack> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return new CrashInfo(tryInt$default(map, AnalyticsConstants.KEY_R0, 0, 2, (Object) null), tryInt$default(map, AnalyticsConstants.KEY_R1, 0, 2, (Object) null), tryInt$default(map, AnalyticsConstants.KEY_R2, 0, 2, (Object) null), tryInt$default(map, AnalyticsConstants.KEY_R3, 0, 2, (Object) null), tryInt$default(map, AnalyticsConstants.KEY_R12, 0, 2, (Object) null), tryInt$default(map, AnalyticsConstants.KEY_SP, 0, 2, (Object) null), tryInt$default(map, AnalyticsConstants.KEY_LR, 0, 2, (Object) null), tryInt$default(map, AnalyticsConstants.KEY_PC, 0, 2, (Object) null), tryInt$default(map, AnalyticsConstants.KEY_PSR, 0, 2, (Object) null), tryString(map, AnalyticsConstants.KEY_FILE_NAME), tryInt$default(map, AnalyticsConstants.KEY_LINE_NUMBER, 0, 2, (Object) null), tryLong$default(map, AnalyticsConstants.KEY_ERROR_CODE, 0L, 2, null));
    }

    public static final int tryInt(Map<Integer, ? extends MsgPack> map, int r2, int r3) {
        MsgPack msgPack;
        Intrinsics.checkNotNullParameter(map, "<this>");
        return (!map.containsKey(Integer.valueOf(r2)) || (msgPack = map.get(Integer.valueOf(r2))) == null) ? r3 : msgPack.asInt();
    }

    public static /* synthetic */ int tryInt$default(Map map, int r1, int r2, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            r2 = 0;
        }
        return tryInt((Map<Integer, ? extends MsgPack>) map, r1, r2);
    }

    public static final List<Integer> tryIntList(MsgPack msgPack) {
        Intrinsics.checkNotNullParameter(msgPack, "<this>");
        if (msgPack.isArrayValue()) {
            List<MsgPack> asList = msgPack.asList();
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(asList, 10));
            Iterator<T> it = asList.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((MsgPack) it.next()).asInt()));
            }
            return arrayList;
        }
        return null;
    }

    public static final List<MsgPack> tryList(Map<Integer, ? extends MsgPack> map, int r3) {
        MsgPack msgPack;
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (!map.containsKey(Integer.valueOf(r3)) || (msgPack = map.get(Integer.valueOf(r3))) == null) {
            return null;
        }
        return msgPack.asList();
    }

    public static final long tryLong(Map<String, ? extends MsgPack> map, String key, long j) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        MsgPack msgPack = map.get(key);
        if (msgPack != null) {
            return msgPack.asLong();
        }
        return j;
    }

    public static /* synthetic */ long tryLong$default(Map map, String str, long j, int r4, Object obj) {
        if ((r4 & 2) != 0) {
            j = 0;
        }
        return tryLong(map, str, j);
    }

    public static final String tryString(Map<String, ? extends MsgPack> map, String key) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        MsgPack msgPack = map.get(key);
        if (msgPack != null) {
            return msgPack.toString();
        }
        return null;
    }

    public static /* synthetic */ int tryInt$default(Map map, String str, int r2, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            r2 = 0;
        }
        return tryInt((Map<String, ? extends MsgPack>) map, str, r2);
    }

    public static final int tryInt(Map<String, ? extends MsgPack> map, String key, int r3) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        MsgPack msgPack = map.get(key);
        return msgPack != null ? msgPack.asInt() : r3;
    }
}
