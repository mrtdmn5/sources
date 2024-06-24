package com.amazonaws.services.s3.model.lifecycle;

import java.util.List;

/* loaded from: classes.dex */
public final class LifecycleAndOperator extends LifecycleNAryOperator {
    public LifecycleAndOperator(List<LifecycleFilterPredicate> list) {
        super(list);
    }

    @Override // com.amazonaws.services.s3.model.lifecycle.LifecycleFilterPredicate
    public void accept(LifecyclePredicateVisitor lifecyclePredicateVisitor) {
        lifecyclePredicateVisitor.visit(this);
    }

    @Override // com.amazonaws.services.s3.model.lifecycle.LifecycleNAryOperator
    public /* bridge */ /* synthetic */ List getOperands() {
        return super.getOperands();
    }
}
