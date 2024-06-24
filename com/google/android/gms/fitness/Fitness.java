package com.google.android.gms.fitness;

import android.accounts.Account;
import androidx.collection.ArraySet;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.fitness.zzab;
import com.google.android.gms.internal.fitness.zzaj;
import com.google.android.gms.internal.fitness.zzar;
import com.google.android.gms.internal.fitness.zzaz;
import com.google.android.gms.internal.fitness.zzbh;
import com.google.android.gms.internal.fitness.zzm;
import com.google.android.gms.internal.fitness.zzu;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class Fitness {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        int r0 = zzaz.$r8$clinit;
        int r02 = zzar.$r8$clinit;
        Api api = zzbh.zzf;
        Api api2 = zzaj.zzf;
        int r03 = zzab.$r8$clinit;
        int r04 = zzu.$r8$clinit;
        int r05 = zzm.$r8$clinit;
        new Scope(1, "https://www.googleapis.com/auth/fitness.activity.read");
        new Scope(1, "https://www.googleapis.com/auth/fitness.activity.write");
        new Scope(1, "https://www.googleapis.com/auth/fitness.location.read");
        new Scope(1, "https://www.googleapis.com/auth/fitness.location.write");
        new Scope(1, "https://www.googleapis.com/auth/fitness.body.read");
        new Scope(1, "https://www.googleapis.com/auth/fitness.body.write");
        new Scope(1, "https://www.googleapis.com/auth/fitness.nutrition.read");
        new Scope(1, "https://www.googleapis.com/auth/fitness.nutrition.write");
        new Scope(1, "https://www.googleapis.com/auth/fitness.heart_rate.read");
        new Scope(1, "https://www.googleapis.com/auth/fitness.heart_rate.write");
        new Scope(1, "https://www.googleapis.com/auth/fitness.respiratory_rate.read");
        new Scope(1, "https://www.googleapis.com/auth/fitness.respiratory_rate.write");
        new Scope(1, "https://www.googleapis.com/auth/fitness.sleep.read");
        new Scope(1, "https://www.googleapis.com/auth/fitness.sleep.write");
        Account account = new Account("none", "com.google");
        GoogleSignInAccount.zaa(null, null, account.name, null, null, null, null, 0L, account.name, new ArraySet());
    }
}
