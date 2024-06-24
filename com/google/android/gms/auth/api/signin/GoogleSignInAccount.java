package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlinx.coroutines.selects.OnTimeoutKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zab();
    public final int zab;
    public final List zac;
    public final String zad;
    public final String zae;
    public final String zaf;
    public final String zag;
    public final Uri zah;
    public String zai;
    public final long zaj;
    public final String zak;
    public final String zal;
    public final String zam;
    public final HashSet zan = new HashSet();

    public GoogleSignInAccount(int r2, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, ArrayList arrayList, String str7, String str8) {
        this.zab = r2;
        this.zad = str;
        this.zae = str2;
        this.zaf = str3;
        this.zag = str4;
        this.zah = uri;
        this.zai = str5;
        this.zaj = j;
        this.zak = str6;
        this.zac = arrayList;
        this.zal = str7;
        this.zam = str8;
    }

    public static GoogleSignInAccount zaa(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set set) {
        long longValue = l.longValue();
        Preconditions.checkNotEmpty(str7);
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, longValue, str7, new ArrayList(set), str5, str6);
    }

    public static GoogleSignInAccount zab(String str) throws JSONException {
        Uri uri;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        if (!TextUtils.isEmpty(optString)) {
            uri = Uri.parse(optString);
        } else {
            uri = null;
        }
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int r5 = 0; r5 < length; r5++) {
            hashSet.add(new Scope(1, jSONArray.getString(r5)));
        }
        String optString2 = jSONObject.optString(ConfigurationItem.COLUMN_NAME_ID);
        if (jSONObject.has("tokenId")) {
            str2 = jSONObject.optString("tokenId");
        } else {
            str2 = null;
        }
        if (jSONObject.has("email")) {
            str3 = jSONObject.optString("email");
        } else {
            str3 = null;
        }
        if (jSONObject.has("displayName")) {
            str4 = jSONObject.optString("displayName");
        } else {
            str4 = null;
        }
        if (jSONObject.has("givenName")) {
            str5 = jSONObject.optString("givenName");
        } else {
            str5 = null;
        }
        if (jSONObject.has("familyName")) {
            str6 = jSONObject.optString("familyName");
        } else {
            str6 = null;
        }
        GoogleSignInAccount zaa = zaa(optString2, str2, str3, str4, str5, str6, uri, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        if (jSONObject.has("serverAuthCode")) {
            str7 = jSONObject.optString("serverAuthCode");
        }
        zaa.zai = str7;
        return zaa;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (!googleSignInAccount.zak.equals(this.zak) || !googleSignInAccount.getRequestedScopes().equals(getRequestedScopes())) {
            return false;
        }
        return true;
    }

    public final HashSet getRequestedScopes() {
        HashSet hashSet = new HashSet(this.zac);
        hashSet.addAll(this.zan);
        return hashSet;
    }

    public final int hashCode() {
        return getRequestedScopes().hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.zak, 527, 31);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeInt(parcel, 1, this.zab);
        OnTimeoutKt.writeString(parcel, 2, this.zad);
        OnTimeoutKt.writeString(parcel, 3, this.zae);
        OnTimeoutKt.writeString(parcel, 4, this.zaf);
        OnTimeoutKt.writeString(parcel, 5, this.zag);
        OnTimeoutKt.writeParcelable(parcel, 6, this.zah, r5);
        OnTimeoutKt.writeString(parcel, 7, this.zai);
        OnTimeoutKt.writeLong(parcel, 8, this.zaj);
        OnTimeoutKt.writeString(parcel, 9, this.zak);
        OnTimeoutKt.writeTypedList(parcel, 10, this.zac);
        OnTimeoutKt.writeString(parcel, 11, this.zal);
        OnTimeoutKt.writeString(parcel, 12, this.zam);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
