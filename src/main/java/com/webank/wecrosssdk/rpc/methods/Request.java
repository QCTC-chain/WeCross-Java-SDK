package com.webank.wecrosssdk.rpc.methods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webank.wecrosssdk.rpc.common.Version;
import com.webank.wecrosssdk.rpc.common.WeCrossCallback;

public class Request<T> {
    private String version = Version.CURRENT_VERSION;
    private String path;
    private String method;
    private T data;

    @JsonIgnore private WeCrossCallback callback;

    public Request() {}

    public Request(String path, String method, T data) {
        this.path = path;
        this.method = method;
        this.data = data;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public WeCrossCallback getCallback() {
        return callback;
    }

    public void setCallback(WeCrossCallback callback) {
        this.callback = callback;
    }

    @Override
    public String toString() {
        String result =
                "Request{"
                        + "version='"
                        + version
                        + '\''
                        + ", path='"
                        + path
                        + '\''
                        + ", method='"
                        + method
                        + '\'';
        result += (data == null) ? "" : ", data=" + data;
        result += '}';
        return result;
    }
}
