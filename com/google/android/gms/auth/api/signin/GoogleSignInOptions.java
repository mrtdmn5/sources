package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlinx.coroutines.selects.OnTimeoutKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;
    public static final GoogleSignInOptions DEFAULT_SIGN_IN;
    public static final Scope zac;
    public static final Scope zad;
    public static final Scope zae;
    public static final zac zag;
    public final int zaf;
    public final ArrayList zah;
    public final Account zai;
    public final boolean zaj;
    public final boolean zak;
    public final boolean zal;
    public final String zam;
    public final String zan;
    public final ArrayList zao;
    public final String zap;
    public final Map zaq;

    static {
        Scope scope = new Scope(1, "profile");
        new Scope(1, "email");
        Scope scope2 = new Scope(1, "openid");
        zac = scope2;
        Scope scope3 = new Scope(1, "https://www.googleapis.com/auth/games_lite");
        zad = scope3;
        zae = new Scope(1, "https://www.googleapis.com/auth/games");
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        hashSet.add(scope2);
        hashSet.add(scope);
        if (hashSet.contains(zae)) {
            Scope scope4 = zad;
            if (hashSet.contains(scope4)) {
                hashSet.remove(scope4);
            }
        }
        DEFAULT_SIGN_IN = new GoogleSignInOptions(3, new ArrayList(hashSet), null, false, false, false, null, null, hashMap, null);
        HashSet hashSet2 = new HashSet();
        HashMap hashMap2 = new HashMap();
        hashSet2.add(scope3);
        hashSet2.addAll(Arrays.asList(new Scope[0]));
        if (hashSet2.contains(zae)) {
            Scope scope5 = zad;
            if (hashSet2.contains(scope5)) {
                hashSet2.remove(scope5);
            }
        }
        new GoogleSignInOptions(3, new ArrayList(hashSet2), null, false, false, false, null, null, hashMap2, null);
        CREATOR = new zae();
        zag = new zac();
    }

    public GoogleSignInOptions(int r1, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, String str3) {
        this.zaf = r1;
        this.zah = arrayList;
        this.zai = account;
        this.zaj = z;
        this.zak = z2;
        this.zal = z3;
        this.zam = str;
        this.zan = str2;
        this.zao = new ArrayList(map.values());
        this.zaq = map;
        this.zap = str3;
    }

    public static GoogleSignInOptions zab(String str) throws JSONException {
        String str2;
        Account account;
        String str3;
        String str4 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int r5 = 0; r5 < length; r5++) {
            hashSet.add(new Scope(1, jSONArray.getString(r5)));
        }
        if (jSONObject.has("accountName")) {
            str2 = jSONObject.optString("accountName");
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            account = new Account(str2, "com.google");
        } else {
            account = null;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        boolean z = jSONObject.getBoolean("idTokenRequested");
        boolean z2 = jSONObject.getBoolean("serverAuthRequested");
        boolean z3 = jSONObject.getBoolean("forceCodeForRefreshToken");
        if (jSONObject.has("serverClientId")) {
            str3 = jSONObject.optString("serverClientId");
        } else {
            str3 = null;
        }
        if (jSONObject.has("hostedDomain")) {
            str4 = jSONObject.optString("hostedDomain");
        }
        return new GoogleSignInOptions(3, arrayList, account, z, z2, z3, str3, str4, new HashMap(), null);
    }

    public static HashMap zam(ArrayList arrayList) {
        HashMap hashMap = new HashMap();
        if (arrayList == null) {
            return hashMap;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable = (GoogleSignInOptionsExtensionParcelable) it.next();
            hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.zab), googleSignInOptionsExtensionParcelable);
        }
        return hashMap;
    }

    public final boolean equals(Object obj) {
        String str = this.zam;
        ArrayList arrayList = this.zah;
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.zao.size() <= 0) {
                ArrayList arrayList2 = googleSignInOptions.zao;
                ArrayList arrayList3 = googleSignInOptions.zah;
                if (arrayList2.size() <= 0 && arrayList.size() == new ArrayList(arrayList3).size() && arrayList.containsAll(new ArrayList(arrayList3))) {
                    Account account = this.zai;
                    Account account2 = googleSignInOptions.zai;
                    if (account != null ? account.equals(account2) : account2 == null) {
                        boolean isEmpty = TextUtils.isEmpty(str);
                        String str2 = googleSignInOptions.zam;
                        if (isEmpty) {
                            if (TextUtils.isEmpty(str2)) {
                            }
                        } else if (!str.equals(str2)) {
                        }
                        if (this.zal == googleSignInOptions.zal && this.zaj == googleSignInOptions.zaj && this.zak == googleSignInOptions.zak) {
                            if (TextUtils.equals(this.zap, googleSignInOptions.zap)) {
                                return true;
                            }
                        }
                    }
                }
            }
        } catch (ClassCastException unused) {
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.zah;
        int size = arrayList2.size();
        int r3 = 0;
        for (int r4 = 0; r4 < size; r4++) {
            arrayList.add(((Scope) arrayList2.get(r4)).zzb);
        }
        Collections.sort(arrayList);
        int hashCode3 = (arrayList.hashCode() + (1 * 31)) * 31;
        Account account = this.zai;
        if (account == null) {
            hashCode = 0;
        } else {
            hashCode = account.hashCode();
        }
        int r0 = (hashCode3 + hashCode) * 31;
        String str = this.zam;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int r02 = (((((((r0 + hashCode2) * 31) + (this.zal ? 1 : 0)) * 31) + (this.zaj ? 1 : 0)) * 31) + (this.zak ? 1 : 0)) * 31;
        String str2 = this.zap;
        if (str2 != null) {
            r3 = str2.hashCode();
        }
        return r02 + r3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeInt(parcel, 1, this.zaf);
        OnTimeoutKt.writeTypedList(parcel, 2, new ArrayList(this.zah));
        OnTimeoutKt.writeParcelable(parcel, 3, this.zai, r5);
        OnTimeoutKt.writeBoolean(parcel, 4, this.zaj);
        OnTimeoutKt.writeBoolean(parcel, 5, this.zak);
        OnTimeoutKt.writeBoolean(parcel, 6, this.zal);
        OnTimeoutKt.writeString(parcel, 7, this.zam);
        OnTimeoutKt.writeString(parcel, 8, this.zan);
        OnTimeoutKt.writeTypedList(parcel, 9, this.zao);
        OnTimeoutKt.writeString(parcel, 10, this.zap);
        OnTimeoutKt.zzb(parcel, zza);
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    /* loaded from: classes3.dex */
    public static final class Builder {
        public final HashSet zaa;
        public final boolean zab;
        public final boolean zac;
        public final boolean zad;
        public final String zae;
        public final Account zaf;
        public final String zag;
        public final HashMap zah;
        public String zai;

        public Builder() {
            this.zaa = new HashSet();
            this.zah = new HashMap();
        }

        public final GoogleSignInOptions build() {
            Scope scope = GoogleSignInOptions.zae;
            HashSet hashSet = this.zaa;
            if (hashSet.contains(scope)) {
                Scope scope2 = GoogleSignInOptions.zad;
                if (hashSet.contains(scope2)) {
                    hashSet.remove(scope2);
                }
            }
            if (this.zad && (this.zaf == null || !hashSet.isEmpty())) {
                hashSet.add(GoogleSignInOptions.zac);
            }
            return new GoogleSignInOptions(3, new ArrayList(hashSet), this.zaf, this.zad, this.zab, this.zac, this.zae, this.zag, this.zah, this.zai);
        }

        public Builder(GoogleSignInOptions googleSignInOptions) {
            this.zaa = new HashSet();
            this.zah = new HashMap();
            Preconditions.checkNotNull(googleSignInOptions);
            this.zaa = new HashSet(googleSignInOptions.zah);
            this.zab = googleSignInOptions.zak;
            this.zac = googleSignInOptions.zal;
            this.zad = googleSignInOptions.zaj;
            this.zae = googleSignInOptions.zam;
            this.zaf = googleSignInOptions.zai;
            this.zag = googleSignInOptions.zan;
            this.zah = GoogleSignInOptions.zam(googleSignInOptions.zao);
            this.zai = googleSignInOptions.zap;
        }
    }
}
