package com.google.android.gms.auth.api.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import androidx.concurrent.futures.AbstractResolvableFuture$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class Storage {
    public static final ReentrantLock zaa = new ReentrantLock();
    public static Storage zab;
    public final ReentrantLock zac = new ReentrantLock();
    public final SharedPreferences zad;

    public Storage(Context context) {
        this.zad = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static Storage getInstance(Context context) {
        Preconditions.checkNotNull(context);
        ReentrantLock reentrantLock = zaa;
        reentrantLock.lock();
        try {
            if (zab == null) {
                zab = new Storage(context.getApplicationContext());
            }
            return zab;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static final String zae(String str, String str2) {
        return AbstractResolvableFuture$$ExternalSyntheticOutline0.m(str, ":", str2);
    }

    public final GoogleSignInAccount getSavedDefaultGoogleSignInAccount() {
        String zaa2;
        String zaa3 = zaa("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(zaa3) && (zaa2 = zaa(zae("googleSignInAccount", zaa3))) != null) {
            try {
                return GoogleSignInAccount.zab(zaa2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public final GoogleSignInOptions getSavedDefaultGoogleSignInOptions() {
        String zaa2;
        String zaa3 = zaa("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(zaa3) || (zaa2 = zaa(zae("googleSignInOptions", zaa3))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.zab(zaa2);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final void saveDefaultGoogleSignInAccount(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        Preconditions.checkNotNull(googleSignInOptions);
        String str = googleSignInAccount.zak;
        zad("defaultGoogleSignInAccount", str);
        String zae = zae("googleSignInAccount", str);
        JSONObject jSONObject = new JSONObject();
        try {
            String str2 = googleSignInAccount.zad;
            if (str2 != null) {
                jSONObject.put(ConfigurationItem.COLUMN_NAME_ID, str2);
            }
            String str3 = googleSignInAccount.zae;
            if (str3 != null) {
                jSONObject.put("tokenId", str3);
            }
            String str4 = googleSignInAccount.zaf;
            if (str4 != null) {
                jSONObject.put("email", str4);
            }
            String str5 = googleSignInAccount.zag;
            if (str5 != null) {
                jSONObject.put("displayName", str5);
            }
            String str6 = googleSignInAccount.zal;
            if (str6 != null) {
                jSONObject.put("givenName", str6);
            }
            String str7 = googleSignInAccount.zam;
            if (str7 != null) {
                jSONObject.put("familyName", str7);
            }
            Uri uri = googleSignInAccount.zah;
            if (uri != null) {
                jSONObject.put("photoUrl", uri.toString());
            }
            String str8 = googleSignInAccount.zai;
            if (str8 != null) {
                jSONObject.put("serverAuthCode", str8);
            }
            jSONObject.put("expirationTime", googleSignInAccount.zaj);
            jSONObject.put("obfuscatedIdentifier", str);
            JSONArray jSONArray = new JSONArray();
            List list = googleSignInAccount.zac;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, com.google.android.gms.auth.api.signin.zaa.zaa);
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.zzb);
            }
            jSONObject.put("grantedScopes", jSONArray);
            jSONObject.remove("serverAuthCode");
            zad(zae, jSONObject.toString());
            String zae2 = zae("googleSignInOptions", str);
            String str9 = googleSignInOptions.zan;
            String str10 = googleSignInOptions.zam;
            ArrayList arrayList = googleSignInOptions.zah;
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONArray jSONArray2 = new JSONArray();
                Collections.sort(arrayList, GoogleSignInOptions.zag);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(((Scope) it.next()).zzb);
                }
                jSONObject2.put("scopes", jSONArray2);
                Account account = googleSignInOptions.zai;
                if (account != null) {
                    jSONObject2.put("accountName", account.name);
                }
                jSONObject2.put("idTokenRequested", googleSignInOptions.zaj);
                jSONObject2.put("forceCodeForRefreshToken", googleSignInOptions.zal);
                jSONObject2.put("serverAuthRequested", googleSignInOptions.zak);
                if (!TextUtils.isEmpty(str10)) {
                    jSONObject2.put("serverClientId", str10);
                }
                if (!TextUtils.isEmpty(str9)) {
                    jSONObject2.put("hostedDomain", str9);
                }
                zad(zae2, jSONObject2.toString());
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final String zaa(String str) {
        ReentrantLock reentrantLock = this.zac;
        reentrantLock.lock();
        try {
            return this.zad.getString(str, null);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void zad(String str, String str2) {
        ReentrantLock reentrantLock = this.zac;
        reentrantLock.lock();
        try {
            this.zad.edit().putString(str, str2).apply();
        } finally {
            reentrantLock.unlock();
        }
    }
}
