package com.diyasylum.formfiller;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

class i589FillerTest {

    private byte[] getCurrentFormFromResources() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("i-589.pdf");
        assertNotNull(is);
        return is.readAllBytes();
    }

    private byte[] getCurrentFormFromWebsite() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(I589Filler.FORM_URL))
                .build();
        HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());
        assertEquals(200, response.statusCode());
        return response.body();

    }

    @Test
    void assertVersionIsCurrent() throws IOException, InterruptedException {
        // This code is functionally useless if it is out of sync with the current form
        String savedPdfSha = DigestUtils.sha256Hex(getCurrentFormFromResources());
        String downloadedPdfSha = DigestUtils.sha256Hex(getCurrentFormFromWebsite());
        assertEquals(savedPdfSha, downloadedPdfSha, "The website checksum matches what we support");
    }

}