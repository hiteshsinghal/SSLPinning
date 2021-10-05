package com.sslpinningdemo;

import com.facebook.react.modules.network.OkHttpClientFactory;
import com.facebook.react.modules.network.OkHttpClientProvider;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;

public class SSLPinnerFactory implements OkHttpClientFactory {
    private static String hostname = "google.com";

    public OkHttpClient createNewNetworkModuleClient() {
        CertificatePinner certificatePinner = new CertificatePinner.Builder()
                .add(hostname, "sha256/NDk+N6iMr8DmO5s4DkSdafrt456hyMYcyzYlvPLknQ=")
                .build();
        // Get a OkHttpClient builder with all the React Native defaults
        OkHttpClient.Builder clientBuilder = OkHttpClientProvider.createClientBuilder();
        return clientBuilder
                .certificatePinner(certificatePinner)
                .build();
    }
}