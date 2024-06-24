package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.EngineWrapper;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* loaded from: classes3.dex */
public final class EngineFactory<T_WRAPPER extends EngineWrapper<T_ENGINE>, T_ENGINE> {
    public static final EngineFactory<EngineWrapper.TCipher, Cipher> CIPHER;
    public static final EngineFactory<EngineWrapper.TMac, Mac> MAC;
    public static final ArrayList defaultPolicy;
    public static final Logger logger = Logger.getLogger(EngineFactory.class.getName());
    public final T_WRAPPER instanceBuilder;
    public final List<Provider> policy = defaultPolicy;

    static {
        boolean z;
        try {
            Class.forName("android.app.Application", false, null);
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            String[] strArr = {"GmsCore_OpenSSL", "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int r0 = 0; r0 < 2; r0++) {
                String str = strArr[r0];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    logger.info(String.format("Provider %s not available", str));
                }
            }
            defaultPolicy = arrayList;
        } else {
            defaultPolicy = new ArrayList();
        }
        CIPHER = new EngineFactory<>(new EngineWrapper.TCipher());
        MAC = new EngineFactory<>(new EngineWrapper.TMac());
    }

    public EngineFactory(T_WRAPPER instanceBuilder) {
        this.instanceBuilder = instanceBuilder;
    }

    public final T_ENGINE getInstance(String str) throws GeneralSecurityException {
        Iterator<Provider> it = this.policy.iterator();
        Exception exc = null;
        while (true) {
            boolean hasNext = it.hasNext();
            T_WRAPPER t_wrapper = this.instanceBuilder;
            if (hasNext) {
                try {
                    return (T_ENGINE) t_wrapper.getInstance(str, it.next());
                } catch (Exception e) {
                    if (exc == null) {
                        exc = e;
                    }
                }
            } else {
                return (T_ENGINE) t_wrapper.getInstance(str, null);
            }
        }
    }
}
