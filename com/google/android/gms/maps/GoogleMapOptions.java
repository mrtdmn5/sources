package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import io.ktor.http.UrlKt;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class GoogleMapOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new zzab();
    public static final Integer zza = Integer.valueOf(Color.argb(255, 236, 233, 225));
    public Boolean zzb;
    public Boolean zzc;
    public int zzd;
    public CameraPosition zze;
    public Boolean zzf;
    public Boolean zzg;
    public Boolean zzh;
    public Boolean zzi;
    public Boolean zzj;
    public Boolean zzk;
    public Boolean zzl;
    public Boolean zzm;
    public Boolean zzn;
    public Float zzo;
    public Float zzp;
    public LatLngBounds zzq;
    public Boolean zzr;
    public Integer zzs;
    public String zzt;

    public GoogleMapOptions() {
        this.zzd = -1;
        this.zzo = null;
        this.zzp = null;
        this.zzq = null;
        this.zzs = null;
        this.zzt = null;
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        Float f;
        Float f2;
        Float f3;
        Float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        String string;
        LatLngBounds latLngBounds = null;
        if (context == null || attributeSet == null) {
            return null;
        }
        Resources resources = context.getResources();
        int[] r2 = R$styleable.MapAttrs;
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, r2);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(15)) {
            googleMapOptions.zzd = obtainAttributes.getInt(15, -1);
        }
        if (obtainAttributes.hasValue(25)) {
            googleMapOptions.zzb = Boolean.valueOf(obtainAttributes.getBoolean(25, false));
        }
        if (obtainAttributes.hasValue(24)) {
            googleMapOptions.zzc = Boolean.valueOf(obtainAttributes.getBoolean(24, false));
        }
        if (obtainAttributes.hasValue(16)) {
            googleMapOptions.zzg = Boolean.valueOf(obtainAttributes.getBoolean(16, true));
        }
        if (obtainAttributes.hasValue(18)) {
            googleMapOptions.zzk = Boolean.valueOf(obtainAttributes.getBoolean(18, true));
        }
        if (obtainAttributes.hasValue(20)) {
            googleMapOptions.zzr = Boolean.valueOf(obtainAttributes.getBoolean(20, true));
        }
        if (obtainAttributes.hasValue(19)) {
            googleMapOptions.zzh = Boolean.valueOf(obtainAttributes.getBoolean(19, true));
        }
        if (obtainAttributes.hasValue(21)) {
            googleMapOptions.zzj = Boolean.valueOf(obtainAttributes.getBoolean(21, true));
        }
        if (obtainAttributes.hasValue(23)) {
            googleMapOptions.zzi = Boolean.valueOf(obtainAttributes.getBoolean(23, true));
        }
        if (obtainAttributes.hasValue(22)) {
            googleMapOptions.zzf = Boolean.valueOf(obtainAttributes.getBoolean(22, true));
        }
        if (obtainAttributes.hasValue(13)) {
            googleMapOptions.zzl = Boolean.valueOf(obtainAttributes.getBoolean(13, false));
        }
        if (obtainAttributes.hasValue(17)) {
            googleMapOptions.zzm = Boolean.valueOf(obtainAttributes.getBoolean(17, true));
        }
        if (obtainAttributes.hasValue(0)) {
            googleMapOptions.zzn = Boolean.valueOf(obtainAttributes.getBoolean(0, false));
        }
        if (obtainAttributes.hasValue(4)) {
            googleMapOptions.zzo = Float.valueOf(obtainAttributes.getFloat(4, Float.NEGATIVE_INFINITY));
        }
        if (obtainAttributes.hasValue(4)) {
            googleMapOptions.zzp = Float.valueOf(obtainAttributes.getFloat(3, Float.POSITIVE_INFINITY));
        }
        if (obtainAttributes.hasValue(1)) {
            googleMapOptions.zzs = Integer.valueOf(obtainAttributes.getColor(1, zza.intValue()));
        }
        if (obtainAttributes.hasValue(14) && (string = obtainAttributes.getString(14)) != null && !string.isEmpty()) {
            googleMapOptions.zzt = string;
        }
        TypedArray obtainAttributes2 = context.getResources().obtainAttributes(attributeSet, r2);
        float f9 = 0.0f;
        if (obtainAttributes2.hasValue(11)) {
            f = Float.valueOf(obtainAttributes2.getFloat(11, 0.0f));
        } else {
            f = null;
        }
        if (obtainAttributes2.hasValue(12)) {
            f2 = Float.valueOf(obtainAttributes2.getFloat(12, 0.0f));
        } else {
            f2 = null;
        }
        if (obtainAttributes2.hasValue(9)) {
            f3 = Float.valueOf(obtainAttributes2.getFloat(9, 0.0f));
        } else {
            f3 = null;
        }
        if (obtainAttributes2.hasValue(10)) {
            f4 = Float.valueOf(obtainAttributes2.getFloat(10, 0.0f));
        } else {
            f4 = null;
        }
        obtainAttributes2.recycle();
        if (f != null && f2 != null && f3 != null && f4 != null) {
            latLngBounds = new LatLngBounds(new LatLng(f.floatValue(), f2.floatValue()), new LatLng(f3.floatValue(), f4.floatValue()));
        }
        googleMapOptions.zzq = latLngBounds;
        TypedArray obtainAttributes3 = context.getResources().obtainAttributes(attributeSet, r2);
        if (obtainAttributes3.hasValue(5)) {
            f5 = obtainAttributes3.getFloat(5, 0.0f);
        } else {
            f5 = 0.0f;
        }
        if (obtainAttributes3.hasValue(6)) {
            f6 = obtainAttributes3.getFloat(6, 0.0f);
        } else {
            f6 = 0.0f;
        }
        LatLng latLng = new LatLng(f5, f6);
        if (obtainAttributes3.hasValue(8)) {
            f7 = obtainAttributes3.getFloat(8, 0.0f);
        } else {
            f7 = 0.0f;
        }
        if (obtainAttributes3.hasValue(2)) {
            f8 = obtainAttributes3.getFloat(2, 0.0f);
        } else {
            f8 = 0.0f;
        }
        if (obtainAttributes3.hasValue(7)) {
            f9 = obtainAttributes3.getFloat(7, 0.0f);
        }
        obtainAttributes3.recycle();
        googleMapOptions.zze = new CameraPosition(latLng, f7, f9, f8);
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public final String toString() {
        Objects.ToStringHelper toStringHelper = new Objects.ToStringHelper(this);
        toStringHelper.add(Integer.valueOf(this.zzd), "MapType");
        toStringHelper.add(this.zzl, "LiteMode");
        toStringHelper.add(this.zze, "Camera");
        toStringHelper.add(this.zzg, "CompassEnabled");
        toStringHelper.add(this.zzf, "ZoomControlsEnabled");
        toStringHelper.add(this.zzh, "ScrollGesturesEnabled");
        toStringHelper.add(this.zzi, "ZoomGesturesEnabled");
        toStringHelper.add(this.zzj, "TiltGesturesEnabled");
        toStringHelper.add(this.zzk, "RotateGesturesEnabled");
        toStringHelper.add(this.zzr, "ScrollGesturesEnabledDuringRotateOrZoom");
        toStringHelper.add(this.zzm, "MapToolbarEnabled");
        toStringHelper.add(this.zzn, "AmbientEnabled");
        toStringHelper.add(this.zzo, "MinZoomPreference");
        toStringHelper.add(this.zzp, "MaxZoomPreference");
        toStringHelper.add(this.zzs, "BackgroundColor");
        toStringHelper.add(this.zzq, "LatLngBoundsForCameraTarget");
        toStringHelper.add(this.zzb, "ZOrderOnTop");
        toStringHelper.add(this.zzc, "UseViewLifecycleInFragment");
        return toStringHelper.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza2 = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeByte(parcel, 2, UrlKt.zza(this.zzb));
        OnTimeoutKt.writeByte(parcel, 3, UrlKt.zza(this.zzc));
        OnTimeoutKt.writeInt(parcel, 4, this.zzd);
        OnTimeoutKt.writeParcelable(parcel, 5, this.zze, r5);
        OnTimeoutKt.writeByte(parcel, 6, UrlKt.zza(this.zzf));
        OnTimeoutKt.writeByte(parcel, 7, UrlKt.zza(this.zzg));
        OnTimeoutKt.writeByte(parcel, 8, UrlKt.zza(this.zzh));
        OnTimeoutKt.writeByte(parcel, 9, UrlKt.zza(this.zzi));
        OnTimeoutKt.writeByte(parcel, 10, UrlKt.zza(this.zzj));
        OnTimeoutKt.writeByte(parcel, 11, UrlKt.zza(this.zzk));
        OnTimeoutKt.writeByte(parcel, 12, UrlKt.zza(this.zzl));
        OnTimeoutKt.writeByte(parcel, 14, UrlKt.zza(this.zzm));
        OnTimeoutKt.writeByte(parcel, 15, UrlKt.zza(this.zzn));
        OnTimeoutKt.writeFloatObject(parcel, 16, this.zzo);
        OnTimeoutKt.writeFloatObject(parcel, 17, this.zzp);
        OnTimeoutKt.writeParcelable(parcel, 18, this.zzq, r5);
        OnTimeoutKt.writeByte(parcel, 19, UrlKt.zza(this.zzr));
        Integer num = this.zzs;
        if (num != null) {
            parcel.writeInt(262164);
            parcel.writeInt(num.intValue());
        }
        OnTimeoutKt.writeString(parcel, 21, this.zzt);
        OnTimeoutKt.zzb(parcel, zza2);
    }

    public GoogleMapOptions(byte b, byte b2, int r5, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11, Float f, Float f2, LatLngBounds latLngBounds, byte b12, Integer num, String str) {
        this.zzd = -1;
        this.zzo = null;
        this.zzp = null;
        this.zzq = null;
        this.zzs = null;
        this.zzt = null;
        this.zzb = UrlKt.zzb(b);
        this.zzc = UrlKt.zzb(b2);
        this.zzd = r5;
        this.zze = cameraPosition;
        this.zzf = UrlKt.zzb(b3);
        this.zzg = UrlKt.zzb(b4);
        this.zzh = UrlKt.zzb(b5);
        this.zzi = UrlKt.zzb(b6);
        this.zzj = UrlKt.zzb(b7);
        this.zzk = UrlKt.zzb(b8);
        this.zzl = UrlKt.zzb(b9);
        this.zzm = UrlKt.zzb(b10);
        this.zzn = UrlKt.zzb(b11);
        this.zzo = f;
        this.zzp = f2;
        this.zzq = latLngBounds;
        this.zzr = UrlKt.zzb(b12);
        this.zzs = num;
        this.zzt = str;
    }
}
