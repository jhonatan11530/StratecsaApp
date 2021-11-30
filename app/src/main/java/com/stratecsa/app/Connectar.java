package com.stratecsa.app;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class Connectar {

    private AsyncHttpClient cliente = new AsyncHttpClient();
    private RequestParams params = new RequestParams();
    private String url = "https://google.com";

    public void get(String key, String value) {
        params.put("owner", key);
        params.put("repo", value);

        cliente.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                System.out.println("OK " + statusCode);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("ERROR " + statusCode);
            }
        });
    }

}
