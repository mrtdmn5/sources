package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.auth.Signer;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.http.ExecutionContext;
import java.net.URI;
import java.util.List;

/* loaded from: classes.dex */
public class S3ExecutionContext extends ExecutionContext {
    private Signer signer;

    public S3ExecutionContext(List<RequestHandler2> list, boolean z, AmazonWebServiceClient amazonWebServiceClient) {
        super(list, z, amazonWebServiceClient);
    }

    @Override // com.amazonaws.http.ExecutionContext
    public Signer getSignerByURI(URI r1) {
        return this.signer;
    }

    @Override // com.amazonaws.http.ExecutionContext
    public void setSigner(Signer signer) {
        this.signer = signer;
    }
}
