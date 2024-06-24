package com.google.android.gms.common.internal;

import android.accounts.Account;
import androidx.collection.ArraySet;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class ClientSettings {
    public final Account zaa;
    public final Set zab;
    public final Set zac;
    public final Map zad;
    public final String zag;
    public final String zah;
    public final SignInOptions zai;
    public Integer zaj;

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    /* loaded from: classes3.dex */
    public static final class Builder {
        public Account zaa;
        public ArraySet zab;
        public String zac;
        public String zad;
    }

    public ClientSettings(Account account, ArraySet arraySet, String str, String str2) {
        Set unmodifiableSet;
        SignInOptions signInOptions = SignInOptions.zaa;
        this.zaa = account;
        if (arraySet == null) {
            unmodifiableSet = Collections.emptySet();
        } else {
            unmodifiableSet = Collections.unmodifiableSet(arraySet);
        }
        this.zab = unmodifiableSet;
        Map emptyMap = Collections.emptyMap();
        this.zad = emptyMap;
        this.zag = str;
        this.zah = str2;
        this.zai = signInOptions;
        HashSet hashSet = new HashSet(unmodifiableSet);
        Iterator it = emptyMap.values().iterator();
        while (it.hasNext()) {
            ((zab) it.next()).getClass();
            hashSet.addAll(null);
        }
        this.zac = Collections.unmodifiableSet(hashSet);
    }
}
