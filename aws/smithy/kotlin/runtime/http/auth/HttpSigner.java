package aws.smithy.kotlin.runtime.http.auth;

import kotlin.Unit;

/* compiled from: HttpSigner.kt */
/* loaded from: classes.dex */
public interface HttpSigner {

    /* compiled from: HttpSigner.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static final HttpSigner$Companion$Anonymous$1 Anonymous = new HttpSigner$Companion$Anonymous$1();
    }

    Unit sign();
}
