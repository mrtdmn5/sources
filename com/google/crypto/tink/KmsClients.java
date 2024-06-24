package com.google.crypto.tink;

import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public final class KmsClients {
    public static final CopyOnWriteArrayList<KmsClient> clients = new CopyOnWriteArrayList<>();

    public static KmsClient get(String keyUri) throws GeneralSecurityException {
        Iterator<KmsClient> it = clients.iterator();
        while (it.hasNext()) {
            KmsClient next = it.next();
            if (next.doesSupport(keyUri)) {
                return next;
            }
        }
        throw new GeneralSecurityException(ConstraintSet$$ExternalSyntheticOutline0.m("No KMS client does support: ", keyUri));
    }
}
