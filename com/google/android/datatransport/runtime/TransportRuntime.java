package com.google.android.datatransport.runtime;

import android.content.Context;
import androidx.emoji2.text.FontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda0;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes3.dex */
public final class TransportRuntime implements TransportInternal {
    public static volatile DaggerTransportRuntimeComponent instance;
    public final Clock eventClock;
    public final Scheduler scheduler;
    public final Uploader uploader;
    public final Clock uptimeClock;

    public TransportRuntime(Clock clock, Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        this.eventClock = clock;
        this.uptimeClock = clock2;
        this.scheduler = scheduler;
        this.uploader = uploader;
        workInitializer.getClass();
        workInitializer.executor.execute(new FontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda0(1, workInitializer));
    }

    public static TransportRuntime getInstance() {
        DaggerTransportRuntimeComponent daggerTransportRuntimeComponent = instance;
        if (daggerTransportRuntimeComponent != null) {
            return daggerTransportRuntimeComponent.transportRuntimeProvider.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void initialize(Context context) {
        if (instance == null) {
            synchronized (TransportRuntime.class) {
                if (instance == null) {
                    context.getClass();
                    instance = new DaggerTransportRuntimeComponent(context);
                }
            }
        }
    }

    public final TransportFactoryImpl newFactory(CCTDestination cCTDestination) {
        Set singleton;
        if (cCTDestination instanceof EncodedDestination) {
            cCTDestination.getClass();
            singleton = Collections.unmodifiableSet(CCTDestination.SUPPORTED_ENCODINGS);
        } else {
            singleton = Collections.singleton(new Encoding("proto"));
        }
        AutoValue_TransportContext.Builder builder = TransportContext.builder();
        cCTDestination.getClass();
        builder.setBackendName("cct");
        builder.extras = cCTDestination.getExtras();
        return new TransportFactoryImpl(singleton, builder.build(), this);
    }
}
