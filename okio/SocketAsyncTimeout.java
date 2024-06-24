package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* compiled from: JvmOkio.kt */
/* loaded from: classes4.dex */
public final class SocketAsyncTimeout extends AsyncTimeout {
    public final Socket socket;

    public SocketAsyncTimeout(Socket socket) {
        this.socket = socket;
    }

    @Override // okio.AsyncTimeout
    public final IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // okio.AsyncTimeout
    public final void timedOut() {
        Socket socket = this.socket;
        try {
            socket.close();
        } catch (AssertionError e) {
            if (Okio.isAndroidGetsocknameError(e)) {
                Okio__JvmOkioKt.logger.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
                return;
            }
            throw e;
        } catch (Exception e2) {
            Okio__JvmOkioKt.logger.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
        }
    }
}
