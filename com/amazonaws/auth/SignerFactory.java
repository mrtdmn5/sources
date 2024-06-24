package com.amazonaws.auth;

import com.amazonaws.internal.config.InternalConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class SignerFactory {
    private static final String NO_OP_SIGNER = "NoOpSignerType";
    private static final String QUERY_STRING_SIGNER = "QueryStringSignerType";
    private static final Map<String, Class<? extends Signer>> SIGNERS;
    private static final String VERSION_FOUR_SIGNER = "AWS4SignerType";

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        SIGNERS = concurrentHashMap;
        concurrentHashMap.put(QUERY_STRING_SIGNER, QueryStringSigner.class);
        concurrentHashMap.put(VERSION_FOUR_SIGNER, AWS4Signer.class);
        concurrentHashMap.put(NO_OP_SIGNER, NoOpSigner.class);
    }

    private SignerFactory() {
    }

    private static Signer createSigner(String str, String str2) {
        Class<? extends Signer> cls = SIGNERS.get(str);
        if (cls != null) {
            try {
                Signer newInstance = cls.newInstance();
                if (newInstance instanceof ServiceAwareSigner) {
                    ((ServiceAwareSigner) newInstance).setServiceName(str2);
                }
                return newInstance;
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Cannot create an instance of ".concat(cls.getName()), e);
            } catch (InstantiationException e2) {
                throw new IllegalStateException("Cannot create an instance of ".concat(cls.getName()), e2);
            }
        }
        throw new IllegalArgumentException();
    }

    public static Signer getSigner(String str, String str2) {
        return lookupAndCreateSigner(str, str2);
    }

    public static Signer getSignerByTypeAndService(String str, String str2) {
        return createSigner(str, str2);
    }

    private static Signer lookupAndCreateSigner(String str, String str2) {
        return createSigner(InternalConfig.Factory.getInternalConfig().getSignerConfig(str, str2).getSignerType(), str);
    }

    public static void registerSigner(String str, Class<? extends Signer> cls) {
        if (str != null) {
            if (cls != null) {
                SIGNERS.put(str, cls);
                return;
            }
            throw new IllegalArgumentException("signerClass cannot be null");
        }
        throw new IllegalArgumentException("signerType cannot be null");
    }
}
