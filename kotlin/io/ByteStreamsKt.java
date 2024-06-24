package kotlin.io;

import com.google.android.gms.internal.measurement.zzpg;
import com.google.android.gms.internal.measurement.zzph;
import com.google.android.gms.measurement.internal.zzdq;
import com.google.android.gms.measurement.internal.zzdu;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: IOStreams.kt */
/* loaded from: classes.dex */
public final class ByteStreamsKt implements zzdq {
    public static final /* synthetic */ ByteStreamsKt zza = new ByteStreamsKt();

    public static void copyTo$default(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[DfuBaseService.ERROR_REMOTE_MASK];
        int read = inputStream.read(bArr);
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            read = inputStream.read(bArr);
        }
    }

    public static final byte[] readBytes(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(DfuBaseService.ERROR_REMOTE_MASK, inputStream.available()));
        copyTo$default(inputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Boolean.valueOf(((zzph) zzpg.zza.zzb.zza()).zza());
    }
}
