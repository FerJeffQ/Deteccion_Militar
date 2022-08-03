package org.tensorflow.lite.examples.objectdetection;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\u0006\u0010%\u001a\u00020\u0013J\u000e\u0010&\u001a\u00020#2\u0006\u0010\'\u001a\u00020(J\u000e\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0004J\u000e\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020(J\u0006\u0010/\u001a\u00020#R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!\u00a8\u00060"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/socketConnection;", "", "()V", "host", "", "getHost", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "inetAddress", "Ljava/net/InetAddress;", "getInetAddress", "()Ljava/net/InetAddress;", "isConnected", "", "()Z", "setConnected", "(Z)V", "mSocket", "Ljava/net/Socket;", "getMSocket", "()Ljava/net/Socket;", "setMSocket", "(Ljava/net/Socket;)V", "port", "", "getPort", "()I", "setPort", "(I)V", "socketAddress", "Ljava/net/SocketAddress;", "getSocketAddress", "()Ljava/net/SocketAddress;", "closeConnection", "", "connect", "getSocket", "sendByteArrayOpeningSocket", "byteArray", "", "sendData", "dataTest", "sendDataOpeningSocket", "data", "sendImageByteArray", "imgByteArray", "setSocket", "app_debug"})
public final class socketConnection {
    private boolean isConnected = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String host = "192.168.4.1";
    private int port = 4000;
    @org.jetbrains.annotations.NotNull()
    private java.net.Socket mSocket;
    @org.jetbrains.annotations.NotNull()
    private final java.net.InetAddress inetAddress = null;
    @org.jetbrains.annotations.NotNull()
    private final java.net.SocketAddress socketAddress = null;
    
    public final boolean isConnected() {
        return false;
    }
    
    public final void setConnected(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHost() {
        return null;
    }
    
    public final void setHost(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getPort() {
        return 0;
    }
    
    public final void setPort(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.net.Socket getMSocket() {
        return null;
    }
    
    public final void setMSocket(@org.jetbrains.annotations.NotNull()
    java.net.Socket p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.net.InetAddress getInetAddress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.net.SocketAddress getSocketAddress() {
        return null;
    }
    
    public socketConnection() {
        super();
    }
    
    public final void connect() {
    }
    
    public final void sendData(@org.jetbrains.annotations.NotNull()
    java.lang.String dataTest) {
    }
    
    public final void sendImageByteArray(@org.jetbrains.annotations.NotNull()
    byte[] imgByteArray) {
    }
    
    public final void sendDataOpeningSocket(@org.jetbrains.annotations.NotNull()
    java.lang.String data) {
    }
    
    public final void sendByteArrayOpeningSocket(@org.jetbrains.annotations.NotNull()
    byte[] byteArray) {
    }
    
    public final void setSocket() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.Synchronized()
    public final synchronized java.net.Socket getSocket() {
        return null;
    }
    
    @kotlin.jvm.Synchronized()
    public final synchronized void closeConnection() {
    }
}