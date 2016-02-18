package com.selonj.supports;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebAssert;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-2-18.
 */
public class ApplicationDriver {
    private Page page;
    private WebClient client;
    private Application application;

    public ApplicationDriver(Application application) {
        this.application = application;
        client = new WebClient();
    }

    public void get(String url) throws IOException {
        page = client.getPage(absolutePath(url));
    }

    private URL absolutePath(String url) throws MalformedURLException {
        return new URL(application.webRootAsURL(), url);
    }

    public void hasSentMessageContaining(String pieceOfContent) {
        assertThat(page.getWebResponse().getContentAsString(),containsString(pieceOfContent));
    }

    public void close() {
        client.closeAllWindows();
    }
}
