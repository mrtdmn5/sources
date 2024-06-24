package com.amplifyframework.core;

/* loaded from: classes.dex */
public final class NoOpConsumer<T> implements Consumer<T> {
    private NoOpConsumer() {
    }

    public static <T> NoOpConsumer<T> create() {
        return new NoOpConsumer<>();
    }

    public boolean equals(Object obj) {
        return obj instanceof NoOpConsumer;
    }

    public int hashCode() {
        return NoOpConsumer.class.hashCode();
    }

    public String toString() {
        return "NoOpConsumer {}";
    }

    @Override // com.amplifyframework.core.Consumer
    public void accept(T t) {
    }
}
