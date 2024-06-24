package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.io.SdkByteReadChannel;
import aws.smithy.kotlin.runtime.io.SdkSource;

/* compiled from: HttpBody.kt */
/* loaded from: classes.dex */
public abstract class HttpBody {
    public final boolean isOneShot = true;

    /* compiled from: HttpBody.kt */
    /* loaded from: classes.dex */
    public static abstract class Bytes extends HttpBody {
        public abstract byte[] bytes();

        @Override // aws.smithy.kotlin.runtime.http.HttpBody
        public final boolean isOneShot() {
            return false;
        }
    }

    /* compiled from: HttpBody.kt */
    /* loaded from: classes.dex */
    public static abstract class ChannelContent extends HttpBody {
        public abstract SdkByteReadChannel readFrom();
    }

    /* compiled from: HttpBody.kt */
    /* loaded from: classes.dex */
    public static final class Empty extends HttpBody {
        public static final Empty INSTANCE = new Empty();

        @Override // aws.smithy.kotlin.runtime.http.HttpBody
        public final Long getContentLength() {
            return 0L;
        }

        @Override // aws.smithy.kotlin.runtime.http.HttpBody
        public final boolean isOneShot() {
            return false;
        }
    }

    /* compiled from: HttpBody.kt */
    /* loaded from: classes.dex */
    public static abstract class SourceContent extends HttpBody {
        public abstract SdkSource readFrom();
    }

    public Long getContentLength() {
        return null;
    }

    public boolean isOneShot() {
        return this.isOneShot;
    }
}
