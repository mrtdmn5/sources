package com.animaconnected.watch.account.strava;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.account.ErrorResponse;
import com.animaconnected.watch.utils.WatchLibException;
import com.animaconnected.watch.utils.WatchLibResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: Errors.kt */
/* loaded from: classes3.dex */
public final class ErrorsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final WatchLibResult.Failure<Boolean, WatchLibException> createFailureResponse(final String str, Integer num) {
        LogKt.warn$default((Object) Unit.INSTANCE, StravaClient.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.account.strava.ErrorsKt$createFailureResponse$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return str;
            }
        }, 6, (Object) null);
        return new WatchLibResult.Failure<>(new WatchLibException(new ErrorResponse(num, str, Boolean.FALSE)));
    }

    public static /* synthetic */ WatchLibResult.Failure createFailureResponse$default(String str, Integer num, int r2, Object obj) {
        if ((r2 & 2) != 0) {
            num = null;
        }
        return createFailureResponse(str, num);
    }
}
