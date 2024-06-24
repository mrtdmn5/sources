package okhttp3.internal.connection;

/* compiled from: ExchangeFinder.kt */
/* loaded from: classes4.dex */
public interface ExchangeFinder {
    RealConnection find();

    RoutePlanner getRoutePlanner();
}
