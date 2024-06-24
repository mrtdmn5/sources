package com.google.firebase.messaging;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public final class DisplayNotification {
    public final Context context;
    public final ExecutorService networkIoExecutor;
    public final NotificationParams params;

    public DisplayNotification(Context context, NotificationParams notificationParams, ExecutorService executorService) {
        this.networkIoExecutor = executorService;
        this.context = context;
        this.params = notificationParams;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(81:20|(80:274|275|(1:24)|25|26|27|(1:29)|271|31|(3:33|34|(76:36|(69:38|(1:40)|41|(1:43)|44|(1:46)|47|(58:49|(1:237)|53|(1:55)|56|(1:58)(2:227|(1:232)(1:231))|(1:60)|61|(1:63)(5:215|(1:217)|218|(1:220)(1:226)|(1:222)(2:223|(1:225)))|64|(1:66)(6:194|(5:197|(1:209)(1:203)|(2:205|206)(1:208)|207|195)|210|211|(1:213)|214)|67|(1:69)(1:193)|(1:71)|72|(41:189|190|(1:78)|79|(1:81)|82|(35:84|(1:183)|(1:89)|90|(31:92|(1:181)|(1:97)|98|(27:100|(1:102)|(1:104)|105|(23:176|177|(1:109)|110|(3:166|167|(20:169|(1:171)|172|(1:114)|115|(4:117|118|119|(2:121|(14:123|(3:125|(1:130)(1:128)|129)|131|(1:133)|134|(1:136)|137|(1:139)|140|(4:147|148|(1:150)(1:153)|151)|142|(1:144)|145|146)(2:158|159))(2:160|161))|165|(0)|131|(0)|134|(0)|137|(0)|140|(0)|142|(0)|145|146)(2:173|174))|112|(0)|115|(0)|165|(0)|131|(0)|134|(0)|137|(0)|140|(0)|142|(0)|145|146)|107|(0)|110|(0)|112|(0)|115|(0)|165|(0)|131|(0)|134|(0)|137|(0)|140|(0)|142|(0)|145|146)|180|(0)|105|(0)|107|(0)|110|(0)|112|(0)|115|(0)|165|(0)|131|(0)|134|(0)|137|(0)|140|(0)|142|(0)|145|146)|182|(0)|98|(0)|180|(0)|105|(0)|107|(0)|110|(0)|112|(0)|115|(0)|165|(0)|131|(0)|134|(0)|137|(0)|140|(0)|142|(0)|145|146)|184|(0)|90|(0)|182|(0)|98|(0)|180|(0)|105|(0)|107|(0)|110|(0)|112|(0)|115|(0)|165|(0)|131|(0)|134|(0)|137|(0)|140|(0)|142|(0)|145|146)|74|(41:185|186|(0)|79|(0)|82|(0)|184|(0)|90|(0)|182|(0)|98|(0)|180|(0)|105|(0)|107|(0)|110|(0)|112|(0)|115|(0)|165|(0)|131|(0)|134|(0)|137|(0)|140|(0)|142|(0)|145|146)|76|(0)|79|(0)|82|(0)|184|(0)|90|(0)|182|(0)|98|(0)|180|(0)|105|(0)|107|(0)|110|(0)|112|(0)|115|(0)|165|(0)|131|(0)|134|(0)|137|(0)|140|(0)|142|(0)|145|146)|238|(60:247|248|249|(1:246)|53|(0)|56|(0)(0)|(0)|61|(0)(0)|64|(0)(0)|67|(0)(0)|(0)|72|(0)|74|(0)|76|(0)|79|(0)|82|(0)|184|(0)|90|(0)|182|(0)|98|(0)|180|(0)|105|(0)|107|(0)|110|(0)|112|(0)|115|(0)|165|(0)|131|(0)|134|(0)|137|(0)|140|(0)|142|(0)|145|146)|242|(1:244)|246|53|(0)|56|(0)(0)|(0)|61|(0)(0)|64|(0)(0)|67|(0)(0)|(0)|72|(0)|74|(0)|76|(0)|79|(0)|82|(0)|184|(0)|90|(0)|182|(0)|98|(0)|180|(0)|105|(0)|107|(0)|110|(0)|112|(0)|115|(0)|165|(0)|131|(0)|134|(0)|137|(0)|140|(0)|142|(0)|145|146)|253|(71:255|(1:257)|41|(0)|44|(0)|47|(0)|238|(1:240)|247|248|249|(0)|246|53|(0)|56|(0)(0)|(0)|61|(0)(0)|64|(0)(0)|67|(0)(0)|(0)|72|(0)|74|(0)|76|(0)|79|(0)|82|(0)|184|(0)|90|(0)|182|(0)|98|(0)|180|(0)|105|(0)|107|(0)|110|(0)|112|(0)|115|(0)|165|(0)|131|(0)|134|(0)|137|(0)|140|(0)|142|(0)|145|146)(1:266)|258|(3:260|(1:262)(1:264)|263)|265|41|(0)|44|(0)|47|(0)|238|(0)|247|248|249|(0)|246|53|(0)|56|(0)(0)|(0)|61|(0)(0)|64|(0)(0)|67|(0)(0)|(0)|72|(0)|74|(0)|76|(0)|79|(0)|82|(0)|184|(0)|90|(0)|182|(0)|98|(0)|180|(0)|105|(0)|107|(0)|110|(0)|112|(0)|115|(0)|165|(0)|131|(0)|134|(0)|137|(0)|140|(0)|142|(0)|145|146))|267|41|(0)|44|(0)|47|(0)|238|(0)|247|248|249|(0)|246|53|(0)|56|(0)(0)|(0)|61|(0)(0)|64|(0)(0)|67|(0)(0)|(0)|72|(0)|74|(0)|76|(0)|79|(0)|82|(0)|184|(0)|90|(0)|182|(0)|98|(0)|180|(0)|105|(0)|107|(0)|110|(0)|112|(0)|115|(0)|165|(0)|131|(0)|134|(0)|137|(0)|140|(0)|142|(0)|145|146)|22|(0)|25|26|27|(0)|271|31|(0)|267|41|(0)|44|(0)|47|(0)|238|(0)|247|248|249|(0)|246|53|(0)|56|(0)(0)|(0)|61|(0)(0)|64|(0)(0)|67|(0)(0)|(0)|72|(0)|74|(0)|76|(0)|79|(0)|82|(0)|184|(0)|90|(0)|182|(0)|98|(0)|180|(0)|105|(0)|107|(0)|110|(0)|112|(0)|115|(0)|165|(0)|131|(0)|134|(0)|137|(0)|140|(0)|142|(0)|145|146) */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x01f0, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x01f1, code lost:            android.util.Log.w("FirebaseMessaging", "Couldn't get own application info: " + r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x00b5, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x00b6, code lost:            android.util.Log.w("FirebaseMessaging", "Couldn't get own application info: " + r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b2, code lost:            if (r0 != null) goto L39;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x04fe  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x059b  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x05ad  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0627  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x05c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x04b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0474 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x038e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0367 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b0 A[Catch: NameNotFoundException -> 0x00b5, TRY_LEAVE, TryCatch #4 {NameNotFoundException -> 0x00b5, blocks: (B:27:0x00aa, B:29:0x00b0), top: B:26:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0434  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean handleNotification() {
        /*
            Method dump skipped, instructions count: 1599
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.DisplayNotification.handleNotification():boolean");
    }
}
