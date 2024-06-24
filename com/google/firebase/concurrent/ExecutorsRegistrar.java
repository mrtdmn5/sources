package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticOutline0;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Lazy;
import com.google.firebase.components.Qualified;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

@SuppressLint({"ThreadPoolCreation"})
/* loaded from: classes3.dex */
public class ExecutorsRegistrar implements ComponentRegistrar {
    public static final Lazy<ScheduledExecutorService> BG_EXECUTOR = new Lazy<>(new ExecutorsRegistrar$$ExternalSyntheticLambda1());
    public static final Lazy<ScheduledExecutorService> LITE_EXECUTOR = new Lazy<>(new ExecutorsRegistrar$$ExternalSyntheticLambda2());
    public static final Lazy<ScheduledExecutorService> BLOCKING_EXECUTOR = new Lazy<>(new ExecutorsRegistrar$$ExternalSyntheticLambda3());
    public static final Lazy<ScheduledExecutorService> SCHEDULER = new Lazy<>(new ExecutorsRegistrar$$ExternalSyntheticLambda4());

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List<Component<?>> getComponents() {
        Qualified qualified = new Qualified(Background.class, ScheduledExecutorService.class);
        Qualified[] qualifiedArr = {new Qualified(Background.class, ExecutorService.class), new Qualified(Background.class, Executor.class)};
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(qualified);
        for (Qualified qualified2 : qualifiedArr) {
            if (qualified2 == null) {
                throw new NullPointerException("Null interface");
            }
        }
        Collections.addAll(hashSet, qualifiedArr);
        Component component = new Component(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 0, new ExecutorsRegistrar$$ExternalSyntheticLambda5(), hashSet3);
        Qualified qualified3 = new Qualified(Blocking.class, ScheduledExecutorService.class);
        Qualified[] qualifiedArr2 = {new Qualified(Blocking.class, ExecutorService.class), new Qualified(Blocking.class, Executor.class)};
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        HashSet hashSet6 = new HashSet();
        hashSet4.add(qualified3);
        for (Qualified qualified4 : qualifiedArr2) {
            if (qualified4 == null) {
                throw new NullPointerException("Null interface");
            }
        }
        Collections.addAll(hashSet4, qualifiedArr2);
        Component component2 = new Component(null, new HashSet(hashSet4), new HashSet(hashSet5), 0, 0, new ExecutorsRegistrar$$ExternalSyntheticLambda6(), hashSet6);
        Qualified qualified5 = new Qualified(Lightweight.class, ScheduledExecutorService.class);
        Qualified[] qualifiedArr3 = {new Qualified(Lightweight.class, ExecutorService.class), new Qualified(Lightweight.class, Executor.class)};
        HashSet hashSet7 = new HashSet();
        HashSet hashSet8 = new HashSet();
        HashSet hashSet9 = new HashSet();
        hashSet7.add(qualified5);
        for (Qualified qualified6 : qualifiedArr3) {
            if (qualified6 == null) {
                throw new NullPointerException("Null interface");
            }
        }
        Collections.addAll(hashSet7, qualifiedArr3);
        Component component3 = new Component(null, new HashSet(hashSet7), new HashSet(hashSet8), 0, 0, new CoreTextFieldKt$$ExternalSyntheticOutline0(), hashSet9);
        Qualified qualified7 = new Qualified(UiThread.class, Executor.class);
        Qualified[] qualifiedArr4 = new Qualified[0];
        HashSet hashSet10 = new HashSet();
        HashSet hashSet11 = new HashSet();
        HashSet hashSet12 = new HashSet();
        hashSet10.add(qualified7);
        for (Qualified qualified8 : qualifiedArr4) {
            if (qualified8 == null) {
                throw new NullPointerException("Null interface");
            }
        }
        Collections.addAll(hashSet10, qualifiedArr4);
        return Arrays.asList(component, component2, component3, new Component(null, new HashSet(hashSet10), new HashSet(hashSet11), 0, 0, new ExecutorsRegistrar$$ExternalSyntheticLambda8(), hashSet12));
    }
}
