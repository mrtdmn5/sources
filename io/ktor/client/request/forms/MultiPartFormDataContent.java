package io.ktor.client.request.forms;

import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import io.ktor.client.request.forms.PreparedPart;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.PartData;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.OutputKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: FormDataContent.kt */
/* loaded from: classes3.dex */
public final class MultiPartFormDataContent extends OutgoingContent.WriteChannelContent {
    public final int BODY_OVERHEAD_SIZE;
    public final byte[] BOUNDARY_BYTES;
    public final byte[] LAST_BOUNDARY_BYTES;
    public final int PART_OVERHEAD_SIZE;
    public final Long contentLength;
    public final ContentType contentType;
    public final ArrayList rawParts;

    public MultiPartFormDataContent() {
        throw null;
    }

    public MultiPartFormDataContent(ArrayList arrayList) {
        byte[] encodeToByteArray;
        byte[] encodeToByteArray2;
        PreparedPart channelPart;
        byte[] bArr = FormDataContentKt.RN_BYTES;
        StringBuilder sb = new StringBuilder();
        for (int r1 = 0; r1 < 32; r1++) {
            int nextInt = Random.Default.nextInt();
            CharsKt__CharKt.checkRadix(16);
            String num = Integer.toString(nextInt, 16);
            Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
            sb.append(num);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        String take = StringsKt___StringsKt.take(70, sb2);
        this.contentType = ContentType.MultiPart.FormData.withParameter("boundary", take);
        String m = zzav$$ExternalSyntheticOutline0.m("--", take, "\r\n");
        Charset charset = Charsets.UTF_8;
        if (Intrinsics.areEqual(charset, charset)) {
            encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(m);
        } else {
            CharsetEncoder newEncoder = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
            encodeToByteArray = CharsetJVMKt.encodeToByteArray(newEncoder, m, m.length());
        }
        this.BOUNDARY_BYTES = encodeToByteArray;
        String m2 = zzav$$ExternalSyntheticOutline0.m("--", take, "--\r\n");
        if (Intrinsics.areEqual(charset, charset)) {
            encodeToByteArray2 = StringsKt__StringsJVMKt.encodeToByteArray(m2);
        } else {
            CharsetEncoder newEncoder2 = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(newEncoder2, "charset.newEncoder()");
            encodeToByteArray2 = CharsetJVMKt.encodeToByteArray(newEncoder2, m2, m2.length());
        }
        this.LAST_BOUNDARY_BYTES = encodeToByteArray2;
        this.BODY_OVERHEAD_SIZE = encodeToByteArray2.length;
        this.PART_OVERHEAD_SIZE = (FormDataContentKt.RN_BYTES.length * 2) + encodeToByteArray.length;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                PartData partData = (PartData) it.next();
                BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null);
                for (Map.Entry<String, List<String>> entry : partData.headers.entries()) {
                    String key = entry.getKey();
                    List<String> value = entry.getValue();
                    StringBuilder m3 = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(key, ": ");
                    m3.append(CollectionsKt___CollectionsKt.joinToString$default(value, "; ", null, null, null, 62));
                    StringsKt.writeText(bytePacketBuilder, r5, 0, m3.toString().length(), Charsets.UTF_8);
                    OutputKt.writeFully(bytePacketBuilder, r5, 0, FormDataContentKt.RN_BYTES.length - 0);
                }
                List<String> list = HttpHeaders.UnsafeHeadersList;
                String str = partData.headers.get("Content-Length");
                Long valueOf = str != null ? Long.valueOf(Long.parseLong(str)) : null;
                if (partData instanceof PartData.FileItem) {
                    channelPart = new PreparedPart.InputPart(StringsKt.readBytes$default(bytePacketBuilder.build()), null, valueOf != null ? Long.valueOf(valueOf.longValue() + this.PART_OVERHEAD_SIZE + r3.length) : null);
                } else if (partData instanceof PartData.BinaryItem) {
                    channelPart = new PreparedPart.InputPart(StringsKt.readBytes$default(bytePacketBuilder.build()), ((PartData.BinaryItem) partData).provider, valueOf != null ? Long.valueOf(valueOf.longValue() + this.PART_OVERHEAD_SIZE + r3.length) : null);
                } else if (partData instanceof PartData.FormItem) {
                    BytePacketBuilder bytePacketBuilder2 = new BytePacketBuilder(null);
                    try {
                        StringsKt.writeText(bytePacketBuilder2, r1, 0, ((PartData.FormItem) partData).value.length(), Charsets.UTF_8);
                        final byte[] readBytes$default = StringsKt.readBytes$default(bytePacketBuilder2.build());
                        Function0<ByteReadPacket> function0 = new Function0<ByteReadPacket>() { // from class: io.ktor.client.request.forms.MultiPartFormDataContent$rawParts$1$provider$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final ByteReadPacket invoke() {
                                byte[] bArr2 = readBytes$default;
                                BytePacketBuilder bytePacketBuilder3 = new BytePacketBuilder(null);
                                try {
                                    OutputKt.writeFully(bytePacketBuilder3, bArr2, 0, bArr2.length - 0);
                                    return bytePacketBuilder3.build();
                                } catch (Throwable th) {
                                    bytePacketBuilder3.close();
                                    throw th;
                                }
                            }
                        };
                        if (valueOf == null) {
                            StringsKt.writeText(bytePacketBuilder, r4, 0, ("Content-Length: " + readBytes$default.length).length(), Charsets.UTF_8);
                            OutputKt.writeFully(bytePacketBuilder, r4, 0, FormDataContentKt.RN_BYTES.length - 0);
                        }
                        channelPart = new PreparedPart.InputPart(StringsKt.readBytes$default(bytePacketBuilder.build()), function0, Long.valueOf(readBytes$default.length + this.PART_OVERHEAD_SIZE + r3.length));
                    } catch (Throwable th) {
                        bytePacketBuilder2.close();
                        throw th;
                    }
                } else if (partData instanceof PartData.BinaryChannelItem) {
                    byte[] readBytes$default2 = StringsKt.readBytes$default(bytePacketBuilder.build());
                    r2 = valueOf != null ? Long.valueOf(valueOf.longValue() + this.PART_OVERHEAD_SIZE + readBytes$default2.length) : null;
                    ((PartData.BinaryChannelItem) partData).getClass();
                    channelPart = new PreparedPart.ChannelPart(readBytes$default2, null, r2);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                arrayList2.add(channelPart);
            } else {
                this.rawParts = arrayList2;
                Long l = 0L;
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        r2 = l;
                        break;
                    }
                    Long l2 = ((PreparedPart) it2.next()).size;
                    if (l2 == null) {
                        break;
                    } else {
                        l = l != null ? Long.valueOf(l2.longValue() + l.longValue()) : null;
                    }
                }
                this.contentLength = r2 != null ? Long.valueOf(r2.longValue() + this.BODY_OVERHEAD_SIZE) : r2;
                return;
            }
        }
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final Long getContentLength() {
        return this.contentLength;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final ContentType getContentType() {
        return this.contentType;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|98|6|7|8|(2:(0)|(1:52))) */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0098, code lost:            r10 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0171, code lost:            r11 = r10;     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x004f, code lost:            r10 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0050, code lost:            r11 = r10;        r10 = r2;     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x016f, code lost:            r11 = th;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x001f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ab A[Catch: all -> 0x016f, TRY_LEAVE, TryCatch #7 {all -> 0x016f, blocks: (B:13:0x002e, B:20:0x00a5, B:22:0x00ab, B:30:0x00de, B:43:0x0158, B:76:0x0176, B:91:0x009e), top: B:7:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f9 A[Catch: all -> 0x0098, TRY_LEAVE, TryCatch #4 {all -> 0x0098, blocks: (B:34:0x00f4, B:36:0x00f9, B:41:0x011a, B:58:0x012a, B:60:0x012e, B:57:0x0129, B:85:0x0071, B:87:0x0082, B:89:0x0094, B:51:0x0127, B:55:0x0124, B:50:0x011f, B:37:0x0103, B:40:0x0118, B:83:0x0060), top: B:7:0x001f, inners: #3, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012a A[Catch: all -> 0x0098, TryCatch #4 {all -> 0x0098, blocks: (B:34:0x00f4, B:36:0x00f9, B:41:0x011a, B:58:0x012a, B:60:0x012e, B:57:0x0129, B:85:0x0071, B:87:0x0082, B:89:0x0094, B:51:0x0127, B:55:0x0124, B:50:0x011f, B:37:0x0103, B:40:0x0118, B:83:0x0060), top: B:7:0x001f, inners: #3, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00dd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0176 A[Catch: all -> 0x016f, TRY_LEAVE, TryCatch #7 {all -> 0x016f, blocks: (B:13:0x002e, B:20:0x00a5, B:22:0x00ab, B:30:0x00de, B:43:0x0158, B:76:0x0176, B:91:0x009e), top: B:7:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x016c -> B:19:0x0040). Please report as a decompilation issue!!! */
    @Override // io.ktor.http.content.OutgoingContent.WriteChannelContent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writeTo(io.ktor.utils.io.ByteWriteChannel r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.request.forms.MultiPartFormDataContent.writeTo(io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
