package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR;
    public static final Status RESULT_CANCELED;
    public static final Status RESULT_INTERNAL_ERROR;
    public static final Status RESULT_INTERRUPTED;
    public static final Status RESULT_SUCCESS;
    public static final Status RESULT_TIMEOUT;
    public final int zzb;
    public final int zzc;
    public final String zzd;
    public final PendingIntent zze;
    public final ConnectionResult zzf;

    static {
        new Status(-1, null);
        RESULT_SUCCESS = new Status(0, null);
        RESULT_INTERRUPTED = new Status(14, null);
        RESULT_INTERNAL_ERROR = new Status(8, null);
        RESULT_TIMEOUT = new Status(15, null);
        RESULT_CANCELED = new Status(16, null);
        new Status(17, null);
        new Status(18, null);
        CREATOR = new zzb();
    }

    public Status() {
        throw null;
    }

    public Status(int r1, int r2, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.zzb = r1;
        this.zzc = r2;
        this.zzd = str;
        this.zze = pendingIntent;
        this.zzf = connectionResult;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.zzb != status.zzb || this.zzc != status.zzc || !Objects.equal(this.zzd, status.zzd) || !Objects.equal(this.zze, status.zze) || !Objects.equal(this.zzf, status.zzf)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), this.zzd, this.zze, this.zzf});
    }

    public final boolean isSuccess() {
        if (this.zzc <= 0) {
            return true;
        }
        return false;
    }

    public final String toString() {
        Objects.ToStringHelper toStringHelper = new Objects.ToStringHelper(this);
        String str = this.zzd;
        if (str == null) {
            int r1 = this.zzc;
            switch (r1) {
                case -1:
                    str = "SUCCESS_CACHE";
                    break;
                case 0:
                    str = "SUCCESS";
                    break;
                case 1:
                case 9:
                case 11:
                case 12:
                default:
                    str = SubMenuBuilder$$ExternalSyntheticOutline0.m("unknown status code: ", r1);
                    break;
                case 2:
                    str = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    str = "SERVICE_DISABLED";
                    break;
                case 4:
                    str = "SIGN_IN_REQUIRED";
                    break;
                case 5:
                    str = "INVALID_ACCOUNT";
                    break;
                case 6:
                    str = "RESOLUTION_REQUIRED";
                    break;
                case 7:
                    str = "NETWORK_ERROR";
                    break;
                case 8:
                    str = "INTERNAL_ERROR";
                    break;
                case 10:
                    str = "DEVELOPER_ERROR";
                    break;
                case 13:
                    str = "ERROR";
                    break;
                case 14:
                    str = "INTERRUPTED";
                    break;
                case 15:
                    str = "TIMEOUT";
                    break;
                case 16:
                    str = "CANCELED";
                    break;
                case 17:
                    str = "API_NOT_CONNECTED";
                    break;
                case 18:
                    str = "DEAD_CLIENT";
                    break;
                case 19:
                    str = "REMOTE_EXCEPTION";
                    break;
                case 20:
                    str = "CONNECTION_SUSPENDED_DURING_CALL";
                    break;
                case 21:
                    str = "RECONNECTION_TIMED_OUT_DURING_UPDATE";
                    break;
                case 22:
                    str = "RECONNECTION_TIMED_OUT";
                    break;
            }
        }
        toStringHelper.add(str, "statusCode");
        toStringHelper.add(this.zze, "resolution");
        return toStringHelper.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeInt(parcel, 1, this.zzc);
        OnTimeoutKt.writeString(parcel, 2, this.zzd);
        OnTimeoutKt.writeParcelable(parcel, 3, this.zze, r5);
        OnTimeoutKt.writeParcelable(parcel, 4, this.zzf, r5);
        OnTimeoutKt.writeInt(parcel, 1000, this.zzb);
        OnTimeoutKt.zzb(parcel, zza);
    }

    public Status(int r7, String str) {
        this(1, r7, str, null, null);
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this;
    }
}
