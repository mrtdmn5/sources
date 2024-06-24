package io.reactivex;

/* loaded from: classes3.dex */
public interface ObservableTransformer<Upstream, Downstream> {
    Observable apply(Observable observable);
}
