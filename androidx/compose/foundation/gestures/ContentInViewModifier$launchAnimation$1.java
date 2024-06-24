package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ContentInViewModifier;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* compiled from: ContentInViewModifier.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1", f = "ContentInViewModifier.kt", l = {193}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ContentInViewModifier$launchAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ContentInViewModifier this$0;

    /* compiled from: ContentInViewModifier.kt */
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1$1", f = "ContentInViewModifier.kt", l = {198}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Job $animationJob;
        public /* synthetic */ Object L$0;
        public int label;
        public final /* synthetic */ ContentInViewModifier this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ContentInViewModifier contentInViewModifier, Job job, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = contentInViewModifier;
            this.$animationJob = job;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$animationJob, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1, types: [androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1$1$1] */
        /* JADX WARN: Type inference failed for: r6v3, types: [androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1$1$2] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int r1 = this.label;
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                final ScrollScope scrollScope = (ScrollScope) this.L$0;
                final ContentInViewModifier contentInViewModifier = this.this$0;
                contentInViewModifier.animationState.value = ContentInViewModifier.access$calculateScrollDelta(contentInViewModifier);
                final Job job = this.$animationJob;
                ?? r3 = new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewModifier.launchAnimation.1.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Float f) {
                        float f2;
                        float floatValue = f.floatValue();
                        if (ContentInViewModifier.this.reverseDirection) {
                            f2 = 1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        float scrollBy = scrollScope.scrollBy(f2 * floatValue) * f2;
                        if (scrollBy < floatValue) {
                            job.cancel(ExceptionsKt.CancellationException("Scroll animation cancelled because scroll was not consumed (" + scrollBy + " < " + floatValue + ')', null));
                        }
                        return Unit.INSTANCE;
                    }
                };
                ?? r6 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewModifier.launchAnimation.1.1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        boolean z;
                        boolean m257equalsimpl0;
                        ContentInViewModifier contentInViewModifier2 = ContentInViewModifier.this;
                        BringIntoViewRequestPriorityQueue bringIntoViewRequestPriorityQueue = contentInViewModifier2.bringIntoViewRequests;
                        while (true) {
                            z = true;
                            if (!bringIntoViewRequestPriorityQueue.requests.isNotEmpty()) {
                                break;
                            }
                            MutableVector<ContentInViewModifier.Request> mutableVector = bringIntoViewRequestPriorityQueue.requests;
                            if (!mutableVector.isEmpty()) {
                                Rect invoke = mutableVector.content[mutableVector.size - 1].currentBounds.invoke();
                                if (invoke == null) {
                                    m257equalsimpl0 = true;
                                } else {
                                    m257equalsimpl0 = Offset.m257equalsimpl0(contentInViewModifier2.m34relocationOffsetBMxPBkI(contentInViewModifier2.viewportSize, invoke), Offset.Zero);
                                }
                                if (!m257equalsimpl0) {
                                    break;
                                }
                                mutableVector.removeAt(mutableVector.size - 1).continuation.resumeWith(Unit.INSTANCE);
                            } else {
                                throw new NoSuchElementException("MutableVector is empty.");
                            }
                        }
                        if (contentInViewModifier2.trackingFocusedChild) {
                            Rect focusedChildBounds = contentInViewModifier2.getFocusedChildBounds();
                            if (focusedChildBounds == null || !Offset.m257equalsimpl0(contentInViewModifier2.m34relocationOffsetBMxPBkI(contentInViewModifier2.viewportSize, focusedChildBounds), Offset.Zero)) {
                                z = false;
                            }
                            if (z) {
                                contentInViewModifier2.trackingFocusedChild = false;
                            }
                        }
                        contentInViewModifier2.animationState.value = ContentInViewModifier.access$calculateScrollDelta(contentInViewModifier2);
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (contentInViewModifier.animationState.animateToZero(r3, r6, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentInViewModifier$launchAnimation$1(ContentInViewModifier contentInViewModifier, Continuation<? super ContentInViewModifier$launchAnimation$1> continuation) {
        super(2, continuation);
        this.this$0 = contentInViewModifier;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ContentInViewModifier$launchAnimation$1 contentInViewModifier$launchAnimation$1 = new ContentInViewModifier$launchAnimation$1(this.this$0, continuation);
        contentInViewModifier$launchAnimation$1.L$0 = obj;
        return contentInViewModifier$launchAnimation$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ContentInViewModifier$launchAnimation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object scroll;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        CancellationException cancellationException = null;
        ContentInViewModifier contentInViewModifier = this.this$0;
        try {
            try {
                if (r1 != 0) {
                    if (r1 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Job job = JobKt.getJob(((CoroutineScope) this.L$0).getCoroutineContext());
                    contentInViewModifier.isAnimationRunning = true;
                    ScrollableState scrollableState = contentInViewModifier.scrollState;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(contentInViewModifier, job, null);
                    this.label = 1;
                    scroll = scrollableState.scroll(MutatePriority.Default, anonymousClass1, this);
                    if (scroll == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                contentInViewModifier.bringIntoViewRequests.resumeAndRemoveAll();
                contentInViewModifier.isAnimationRunning = false;
                contentInViewModifier.bringIntoViewRequests.cancelAndRemoveAll(null);
                contentInViewModifier.trackingFocusedChild = false;
                return Unit.INSTANCE;
            } catch (CancellationException e) {
                cancellationException = e;
                throw cancellationException;
            }
        } catch (Throwable th) {
            contentInViewModifier.isAnimationRunning = false;
            contentInViewModifier.bringIntoViewRequests.cancelAndRemoveAll(cancellationException);
            contentInViewModifier.trackingFocusedChild = false;
            throw th;
        }
    }
}
