package com.airbnb.lottie;

import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class LottieAnimationView$$ExternalSyntheticLambda2 implements LottieListener {
    @Override // com.airbnb.lottie.LottieListener
    public final void onResult(Object obj) {
        boolean z;
        Throwable th = (Throwable) obj;
        LottieAnimationView$$ExternalSyntheticLambda2 lottieAnimationView$$ExternalSyntheticLambda2 = LottieAnimationView.DEFAULT_FAILURE_LISTENER;
        Utils.AnonymousClass1 anonymousClass1 = Utils.threadLocalPathMeasure;
        if (!(th instanceof SocketException) && !(th instanceof ClosedChannelException) && !(th instanceof InterruptedIOException) && !(th instanceof ProtocolException) && !(th instanceof SSLException) && !(th instanceof UnknownHostException) && !(th instanceof UnknownServiceException)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            Logger.warning("Unable to load composition.", th);
            return;
        }
        throw new IllegalStateException("Unable to parse composition", th);
    }
}
