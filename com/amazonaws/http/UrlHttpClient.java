package com.amazonaws.http;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.internal.Constants;
import com.amplifyframework.core.model.ModelIdentifier;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes.dex */
public class UrlHttpClient implements HttpClient {
    private static final int BUFFER_SIZE_MULTIPLIER = 8;
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    private static final String TAG = "amazonaws";
    private static final Log log = LogFactory.getLog((Class<?>) UrlHttpClient.class);
    private final ClientConfiguration config;
    private TLS12SocketFactory customTrustTls12SocketFactory;
    private SSLContext customTrustSSLContext = null;
    private final TLS12SocketFactory tls12SocketFactory = TLS12SocketFactory.createTLS12SocketFactory();

    /* loaded from: classes.dex */
    public final class CurlBuilder {
        private final URL url;
        private String method = null;
        private final HashMap<String, String> headers = new HashMap<>();
        private String content = null;
        private boolean contentOverflow = false;

        public CurlBuilder(URL url) {
            if (url != null) {
                this.url = url;
                return;
            }
            throw new IllegalArgumentException("Must have a valid url");
        }

        public String build() {
            if (isValid()) {
                StringBuilder sb = new StringBuilder("curl");
                if (this.method != null) {
                    sb.append(" -X ");
                    sb.append(this.method);
                }
                for (Map.Entry<String, String> entry : this.headers.entrySet()) {
                    sb.append(" -H \"");
                    sb.append(entry.getKey());
                    sb.append(":");
                    sb.append(entry.getValue());
                    sb.append(ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR);
                }
                if (this.content != null) {
                    sb.append(" -d '");
                    sb.append(this.content);
                    sb.append("'");
                }
                sb.append(" ");
                sb.append(this.url.toString());
                return sb.toString();
            }
            throw new IllegalStateException("Invalid state, cannot create curl command");
        }

        public boolean isValid() {
            return !this.contentOverflow;
        }

        public CurlBuilder setContent(String str) {
            this.content = str;
            return this;
        }

        public CurlBuilder setContentOverflow(boolean z) {
            this.contentOverflow = z;
            return this;
        }

        public CurlBuilder setHeaders(Map<String, String> map) {
            this.headers.clear();
            this.headers.putAll(map);
            return this;
        }

        public CurlBuilder setMethod(String str) {
            this.method = str;
            return this;
        }
    }

    public UrlHttpClient(ClientConfiguration clientConfiguration) {
        this.config = clientConfiguration;
    }

    private void enableCustomTrustManager(HttpsURLConnection httpsURLConnection) {
        if (this.customTrustSSLContext == null) {
            TrustManager[] trustManagerArr = {this.config.getTrustManager()};
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                this.customTrustSSLContext = sSLContext;
                sSLContext.init(null, trustManagerArr, null);
                if (this.customTrustTls12SocketFactory == null) {
                    this.customTrustTls12SocketFactory = TLS12SocketFactory.createTLS12SocketFactory(this.customTrustSSLContext);
                }
            } catch (GeneralSecurityException e) {
                throw new RuntimeException(e);
            }
        }
        TLS12SocketFactory tLS12SocketFactory = this.customTrustTls12SocketFactory;
        if (tLS12SocketFactory != null) {
            httpsURLConnection.setSSLSocketFactory(tLS12SocketFactory);
        } else {
            httpsURLConnection.setSSLSocketFactory(this.customTrustSSLContext.getSocketFactory());
        }
    }

    private void write(InputStream inputStream, OutputStream outputStream, CurlBuilder curlBuilder, ByteBuffer byteBuffer) throws IOException {
        byte[] bArr = new byte[DfuBaseService.ERROR_REMOTE_MASK];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                if (byteBuffer != null) {
                    try {
                        byteBuffer.put(bArr, 0, read);
                    } catch (BufferOverflowException unused) {
                        curlBuilder.setContentOverflow(true);
                    }
                }
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public HttpURLConnection applyHeadersAndMethod(HttpRequest httpRequest, HttpURLConnection httpURLConnection) throws ProtocolException {
        return applyHeadersAndMethod(httpRequest, httpURLConnection, null);
    }

    public void configureConnection(HttpRequest httpRequest, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(this.config.getConnectionTimeout());
        httpURLConnection.setReadTimeout(this.config.getSocketTimeout());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setUseCaches(false);
        if (httpRequest.isStreaming()) {
            httpURLConnection.setChunkedStreamingMode(0);
        }
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            if (this.config.getTrustManager() != null) {
                enableCustomTrustManager(httpsURLConnection);
                return;
            }
            TLS12SocketFactory tLS12SocketFactory = this.tls12SocketFactory;
            if (tLS12SocketFactory != null) {
                TLS12SocketFactory.fixTLSPre21(httpsURLConnection, tLS12SocketFactory);
            }
        }
    }

    public HttpResponse createHttpResponse(HttpRequest httpRequest, HttpURLConnection httpURLConnection) throws IOException {
        String responseMessage = httpURLConnection.getResponseMessage();
        int responseCode = httpURLConnection.getResponseCode();
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream == null && !"HEAD".equals(httpRequest.getMethod())) {
            try {
                errorStream = httpURLConnection.getInputStream();
            } catch (IOException unused) {
            }
        }
        HttpResponse.Builder content = HttpResponse.builder().statusCode(responseCode).statusText(responseMessage).content(errorStream);
        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                content.header(entry.getKey(), entry.getValue().get(0));
            }
        }
        return content.build();
    }

    @Override // com.amazonaws.http.HttpClient
    public HttpResponse execute(HttpRequest httpRequest) throws IOException {
        CurlBuilder curlBuilder;
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpRequest.getUri().toURL().openConnection();
        if (this.config.isCurlLogging()) {
            curlBuilder = new CurlBuilder(httpRequest.getUri().toURL());
        } else {
            curlBuilder = null;
        }
        configureConnection(httpRequest, httpURLConnection);
        applyHeadersAndMethod(httpRequest, httpURLConnection, curlBuilder);
        writeContentToConnection(httpRequest, httpURLConnection, curlBuilder);
        if (curlBuilder != null) {
            if (curlBuilder.isValid()) {
                printToLog(curlBuilder.build());
            } else {
                printToLog("Failed to create curl, content too long");
            }
        }
        return createHttpResponse(httpRequest, httpURLConnection);
    }

    public HttpURLConnection getUrlConnection(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    public void printToLog(String str) {
        log.debug(str);
    }

    public void writeContentToConnection(HttpRequest httpRequest, HttpURLConnection httpURLConnection) throws IOException {
        writeContentToConnection(httpRequest, httpURLConnection, null);
    }

    public HttpURLConnection applyHeadersAndMethod(HttpRequest httpRequest, HttpURLConnection httpURLConnection, CurlBuilder curlBuilder) throws ProtocolException {
        if (httpRequest.getHeaders() != null && !httpRequest.getHeaders().isEmpty()) {
            if (curlBuilder != null) {
                curlBuilder.setHeaders(httpRequest.getHeaders());
            }
            for (Map.Entry<String, String> entry : httpRequest.getHeaders().entrySet()) {
                String key = entry.getKey();
                if (!key.equals("Content-Length") && !key.equals(HttpHeader.HOST)) {
                    key.equals(HttpHeader.EXPECT);
                    httpURLConnection.setRequestProperty(key, entry.getValue());
                }
            }
        }
        String method = httpRequest.getMethod();
        httpURLConnection.setRequestMethod(method);
        if (curlBuilder != null) {
            curlBuilder.setMethod(method);
        }
        return httpURLConnection;
    }

    public void writeContentToConnection(HttpRequest httpRequest, HttpURLConnection httpURLConnection, CurlBuilder curlBuilder) throws IOException {
        ByteBuffer byteBuffer;
        if (httpRequest.getContent() == null || httpRequest.getContentLength() < 0) {
            return;
        }
        httpURLConnection.setDoOutput(true);
        if (!httpRequest.isStreaming()) {
            httpURLConnection.setFixedLengthStreamingMode((int) httpRequest.getContentLength());
        }
        OutputStream outputStream = httpURLConnection.getOutputStream();
        if (curlBuilder != null) {
            if (httpRequest.getContentLength() < 2147483647L) {
                byteBuffer = ByteBuffer.allocate((int) httpRequest.getContentLength());
                write(httpRequest.getContent(), outputStream, curlBuilder, byteBuffer);
                if (curlBuilder != null && byteBuffer != null && byteBuffer.position() != 0) {
                    curlBuilder.setContent(new String(byteBuffer.array(), Constants.DEFAULT_ENCODING));
                }
                outputStream.flush();
                outputStream.close();
            }
            curlBuilder.setContentOverflow(true);
        }
        byteBuffer = null;
        write(httpRequest.getContent(), outputStream, curlBuilder, byteBuffer);
        if (curlBuilder != null) {
            curlBuilder.setContent(new String(byteBuffer.array(), Constants.DEFAULT_ENCODING));
        }
        outputStream.flush();
        outputStream.close();
    }

    @Override // com.amazonaws.http.HttpClient
    public void shutdown() {
    }
}
