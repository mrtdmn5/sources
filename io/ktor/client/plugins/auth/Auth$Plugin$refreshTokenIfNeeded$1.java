package io.ktor.client.plugins.auth;

import com.animaconnected.secondo.R;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.auth.Auth;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Auth.kt */
@DebugMetadata(c = "io.ktor.client.plugins.auth.Auth$Plugin", f = "Auth.kt", l = {R.styleable.AppTheme_stepsHistoryBackgroundDetail}, m = "refreshTokenIfNeeded")
/* loaded from: classes3.dex */
public final class Auth$Plugin$refreshTokenIfNeeded$1 extends ContinuationImpl {
    public HttpClientCall L$0;
    public AuthProvider L$1;
    public AtomicCounter L$2;
    public Map L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ Auth.Plugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Auth$Plugin$refreshTokenIfNeeded$1(Auth.Plugin plugin, Continuation<? super Auth$Plugin$refreshTokenIfNeeded$1> continuation) {
        super(continuation);
        this.this$0 = plugin;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Auth.Plugin.access$refreshTokenIfNeeded(this.this$0, null, null, null, this);
    }
}
