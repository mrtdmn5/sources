package com.animaconnected.secondo.behaviour.webhook;

import com.amazonaws.services.s3.internal.Constants;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.behaviour.util.VibratorPatterns;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: Webhook.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.webhook.Webhook$execute$1", f = "Webhook.kt", l = {49}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Webhook$execute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ URL $url;
    int label;
    final /* synthetic */ Webhook this$0;

    /* compiled from: Webhook.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.behaviour.webhook.Webhook$execute$1$1", f = "Webhook.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.behaviour.webhook.Webhook$execute$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ Webhook this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Webhook webhook, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = webhook;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            WatchProvider watchProvider;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                watchProvider = this.this$0.watchProvider;
                watchProvider.startVibratorWithPattern(VibratorPatterns.getError());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Webhook$execute$1(URL url, Webhook webhook, Continuation<? super Webhook$execute$1> continuation) {
        super(2, continuation);
        this.$url = url;
        this.this$0 = webhook;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Webhook$execute$1(this.$url, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        try {
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                URLConnection openConnection = this.$url.openConnection();
                Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setConnectTimeout(Constants.MAXIMUM_UPLOAD_PARTS);
                int responseCode = httpURLConnection.getResponseCode();
                httpURLConnection.disconnect();
                if (responseCode == 200) {
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    MainCoroutineDispatcher mainCoroutineDispatcher = MainDispatcherLoader.dispatcher;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
                    this.label = 1;
                    if (BuildersKt.withContext(mainCoroutineDispatcher, anonymousClass1, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            }
        } catch (IOException unused) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Webhook$execute$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
