package kotlinx.serialization.json.internal;

import kotlinx.serialization.json.DecodeSequenceMode;

/* compiled from: JsonIterator.kt */
/* loaded from: classes4.dex */
public final /* synthetic */ class JsonIteratorKt$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        int[] r0 = new int[DecodeSequenceMode.values().length];
        try {
            r0[DecodeSequenceMode.WHITESPACE_SEPARATED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            r0[DecodeSequenceMode.ARRAY_WRAPPED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            r0[DecodeSequenceMode.AUTO_DETECT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        $EnumSwitchMapping$0 = r0;
    }
}
