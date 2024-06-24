package aws.smithy.kotlin.runtime.client;

import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SdkLogMode.kt */
/* loaded from: classes.dex */
public abstract class SdkLogMode {
    public final int mask;

    /* compiled from: SdkLogMode.kt */
    /* loaded from: classes.dex */
    public static final class Default extends SdkLogMode {
        public static final Default INSTANCE = new Default();

        public Default() {
            super(0);
        }

        @Override // aws.smithy.kotlin.runtime.client.SdkLogMode
        public final String toString() {
            return "Default";
        }
    }

    /* compiled from: SdkLogMode.kt */
    /* loaded from: classes.dex */
    public static final class LogRequest extends SdkLogMode {
        public static final LogRequest INSTANCE = new LogRequest();

        public LogRequest() {
            super(1);
        }

        @Override // aws.smithy.kotlin.runtime.client.SdkLogMode
        public final String toString() {
            return "LogRequest";
        }
    }

    /* compiled from: SdkLogMode.kt */
    /* loaded from: classes.dex */
    public static final class LogRequestWithBody extends SdkLogMode {
        public static final LogRequestWithBody INSTANCE = new LogRequestWithBody();

        public LogRequestWithBody() {
            super(2);
        }

        @Override // aws.smithy.kotlin.runtime.client.SdkLogMode
        public final String toString() {
            return "LogRequestWithBody";
        }
    }

    /* compiled from: SdkLogMode.kt */
    /* loaded from: classes.dex */
    public static final class LogResponse extends SdkLogMode {
        public static final LogResponse INSTANCE = new LogResponse();

        public LogResponse() {
            super(4);
        }

        @Override // aws.smithy.kotlin.runtime.client.SdkLogMode
        public final String toString() {
            return "LogResponse";
        }
    }

    /* compiled from: SdkLogMode.kt */
    /* loaded from: classes.dex */
    public static final class LogResponseWithBody extends SdkLogMode {
        public static final LogResponseWithBody INSTANCE = new LogResponseWithBody();

        public LogResponseWithBody() {
            super(8);
        }

        @Override // aws.smithy.kotlin.runtime.client.SdkLogMode
        public final String toString() {
            return "LogResponseWithBody";
        }
    }

    public SdkLogMode(int r1) {
        this.mask = r1;
    }

    public final boolean isEnabled(SdkLogMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        if ((mode.mask & this.mask) != 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt__CollectionsKt.listOf((Object[]) new SdkLogMode[]{LogRequest.INSTANCE, LogRequestWithBody.INSTANCE, LogResponse.INSTANCE, LogResponseWithBody.INSTANCE}), "|", "SdkLogMode(", ")", new Function1<SdkLogMode, CharSequence>() { // from class: aws.smithy.kotlin.runtime.client.SdkLogMode$toString$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(SdkLogMode sdkLogMode) {
                SdkLogMode mode = sdkLogMode;
                Intrinsics.checkNotNullParameter(mode, "mode");
                if (SdkLogMode.this.isEnabled(mode)) {
                    return mode.toString();
                }
                return "";
            }
        }, 24);
    }
}
