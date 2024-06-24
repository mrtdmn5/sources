package com.animaconnected.future.runner;

import com.animaconnected.future.Future;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public interface BackgroundRunner {
    <T> Future<T> submit(Callable<T> callable);
}
