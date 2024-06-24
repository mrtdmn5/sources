package com.animaconnected.watch.device;

/* compiled from: DeviceWriter.kt */
/* loaded from: classes3.dex */
public final class CommandTooLargeException extends RuntimeException {
    public CommandTooLargeException() {
        super("Msgpack is larger than 247");
    }
}
