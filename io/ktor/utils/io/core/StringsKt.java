package io.ktor.utils.io.core;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import io.ktor.utils.io.charsets.EncodingKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: Strings.kt */
/* loaded from: classes3.dex */
public final class StringsKt {
    public static final void prematureEndOfStream(int r3) {
        throw new EOFException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Premature end of stream: expected ", r3, " bytes"));
    }

    public static byte[] readBytes$default(ByteReadPacket byteReadPacket) {
        boolean z;
        long remaining = byteReadPacket.getRemaining();
        if (remaining <= 2147483647L) {
            int r0 = (int) remaining;
            Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
            if (r0 != 0) {
                byte[] bArr = new byte[r0];
                boolean z2 = true;
                ChunkBuffer prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(byteReadPacket, 1);
                if (prepareReadFirstHead != null) {
                    int r5 = 0;
                    while (true) {
                        try {
                            int min = Math.min(r0, prepareReadFirstHead.writePosition - prepareReadFirstHead.readPosition);
                            BufferPrimitivesKt.readFully(prepareReadFirstHead, bArr, r5, min);
                            r0 -= min;
                            r5 += min;
                            if (r0 > 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                break;
                            }
                            try {
                                ChunkBuffer prepareReadNextHead = UnsafeKt.prepareReadNextHead(byteReadPacket, prepareReadFirstHead);
                                if (prepareReadNextHead == null) {
                                    z2 = false;
                                    break;
                                }
                                prepareReadFirstHead = prepareReadNextHead;
                            } catch (Throwable th) {
                                th = th;
                                z2 = false;
                                if (z2) {
                                    UnsafeKt.completeReadHead(byteReadPacket, prepareReadFirstHead);
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    if (z2) {
                        UnsafeKt.completeReadHead(byteReadPacket, prepareReadFirstHead);
                    }
                }
                if (r0 > 0) {
                    prematureEndOfStream(r0);
                    throw null;
                }
                return bArr;
            }
            return UnsafeKt.EmptyByteArray;
        }
        throw new IllegalArgumentException("Unable to convert to a ByteArray: packet is too big");
    }

    public static String readText$default(Input input, Charset charset) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        CharsetDecoder newDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(newDecoder, "charset.newDecoder()");
        return EncodingKt.decode(newDecoder, input, Integer.MAX_VALUE);
    }

    public static final void writeText(Output output, CharSequence text, int r9, int r10, Charset charset) {
        int r1;
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (charset == Charsets.UTF_8) {
            ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, null);
            while (true) {
                try {
                    int m1659encodeUTF8lBXzO7A = UTF8Kt.m1659encodeUTF8lBXzO7A(prepareWriteHead.memory, text, r9, r10, prepareWriteHead.writePosition, prepareWriteHead.limit);
                    int r2 = ((short) (m1659encodeUTF8lBXzO7A >>> 16)) & 65535;
                    r9 += r2;
                    prepareWriteHead.commitWritten(((short) (m1659encodeUTF8lBXzO7A & 65535)) & 65535);
                    if (r2 == 0 && r9 < r10) {
                        r1 = 8;
                    } else if (r9 < r10) {
                        r1 = 1;
                    } else {
                        r1 = 0;
                    }
                    if (r1 > 0) {
                        prepareWriteHead = UnsafeKt.prepareWriteHead(output, r1, prepareWriteHead);
                    } else {
                        return;
                    }
                } finally {
                    output.afterHeadWrite();
                }
            }
        } else {
            CharsetEncoder newEncoder = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
            EncodingKt.encodeToImpl(newEncoder, output, text, r9, r10);
        }
    }
}
