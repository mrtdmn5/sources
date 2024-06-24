package kotlinx.coroutines.channels;

import androidx.core.content.res.CamUtils;

/* compiled from: Channel.kt */
/* loaded from: classes4.dex */
public interface Channel<E> extends SendChannel<E>, ReceiveChannel<E> {
    public static final Factory Factory = Factory.$$INSTANCE;

    /* compiled from: Channel.kt */
    /* loaded from: classes4.dex */
    public static final class Factory {
        public static final /* synthetic */ Factory $$INSTANCE = new Factory();
        public static final int CHANNEL_DEFAULT_CAPACITY = (int) CamUtils.systemProp("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);
    }
}
