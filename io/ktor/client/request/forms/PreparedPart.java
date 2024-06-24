package io.ktor.client.request.forms;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.Input;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FormDataContent.kt */
/* loaded from: classes3.dex */
public abstract class PreparedPart {
    public final byte[] headers;
    public final Long size;

    /* compiled from: FormDataContent.kt */
    /* loaded from: classes3.dex */
    public static final class ChannelPart extends PreparedPart {
        public final Function0<ByteReadChannel> provider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ChannelPart(byte[] bArr, Function0<? extends ByteReadChannel> provider, Long l) {
            super(bArr, l);
            Intrinsics.checkNotNullParameter(provider, "provider");
            this.provider = provider;
        }
    }

    /* compiled from: FormDataContent.kt */
    /* loaded from: classes3.dex */
    public static final class InputPart extends PreparedPart {
        public final Function0<Input> provider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public InputPart(byte[] bArr, Function0<? extends Input> provider, Long l) {
            super(bArr, l);
            Intrinsics.checkNotNullParameter(provider, "provider");
            this.provider = provider;
        }
    }

    public PreparedPart(byte[] bArr, Long l) {
        this.headers = bArr;
        this.size = l;
    }
}
