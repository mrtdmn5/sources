package com.animaconnected.watch.device;

import com.animaconnected.info.ByteUtils;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: MsgPackWatch.kt */
/* loaded from: classes3.dex */
public final class MsgPackWatchKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String dumpUartLogPartToStr(byte[] bArr) {
        boolean z;
        StringBuilder sb = new StringBuilder(DfuBaseService.ERROR_REMOTE_TYPE_SECURE);
        for (byte b : bArr) {
            if (b == 0) {
                sb.append("\\0");
            } else if (b == 92) {
                sb.append("\\\\");
            } else {
                boolean z2 = true;
                if (b == 10 || b == 13) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    sb.append((char) b);
                } else {
                    if (32 > b || b >= Byte.MAX_VALUE) {
                        z2 = false;
                    }
                    if (z2) {
                        sb.append((char) b);
                    } else {
                        sb.append(ByteUtils.toHex(b));
                    }
                }
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
