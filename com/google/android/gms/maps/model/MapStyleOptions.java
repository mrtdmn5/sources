package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.util.IOUtils;
import com.kronaby.watch.app.R;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class MapStyleOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MapStyleOptions> CREATOR = new zzh();
    public final String zzb;

    public MapStyleOptions(String str) {
        if (str != null) {
            this.zzb = str;
            return;
        }
        throw new NullPointerException("json must not be null");
    }

    public static MapStyleOptions loadRawResourceStyle(Context context) throws Resources.NotFoundException {
        InputStream openRawResource = context.getResources().openRawResource(R.raw.style_map_dark_no_street_names);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    int read = openRawResource.read(bArr, 0, 1024);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        IOUtils.closeQuietly(openRawResource);
                        IOUtils.closeQuietly(byteArrayOutputStream);
                        return new MapStyleOptions(new String(byteArrayOutputStream.toByteArray(), Constants.DEFAULT_ENCODING));
                    }
                } catch (Throwable th) {
                    IOUtils.closeQuietly(openRawResource);
                    IOUtils.closeQuietly(byteArrayOutputStream);
                    throw th;
                }
            }
        } catch (IOException e) {
            throw new Resources.NotFoundException(ConstraintSet$$ExternalSyntheticOutline0.m("Failed to read resource 2131951625: ", e.toString()));
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r4) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeString(parcel, 2, this.zzb);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
