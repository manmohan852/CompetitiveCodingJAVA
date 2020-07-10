package site.javaTest.concurrency.leetcode;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class WebCrawlerMultithreaded3 {

    private String host = "";
    private ConcurrentHashMap<String, String> done = new ConcurrentHashMap<>();

    class FJT extends ForkJoinTask<String> {

        String url;
        HtmlParser htmlParser;

        public FJT(String url, HtmlParser htmlParser) {
            this.url = url;
            this.htmlParser = htmlParser;
        }

        @Override
        public String getRawResult() {
            return null;
        }

        @Override
        protected void setRawResult(String value) {

        }

        @Override
        protected boolean exec() {
            List<FJT> newFJT = new ArrayList<>();
            if (done.put(url, "") == null) {
                List<String> crawled = htmlParser.getUrls(url);
                if (crawled != null) {
                    for (String newUrl : crawled) {
                        try {
                            URL u = new URL(newUrl);
                            if (!u.getHost().equalsIgnoreCase(host)) {
                                continue;
                            }
                        } catch (MalformedURLException e) {
                        }
                        if (!done.containsKey(newUrl)) {
                            newFJT.add(new FJT(newUrl, htmlParser));
                        }
                    }
                }
            }

            invokeAll(newFJT);

            return true;
        }
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        try {
            URL url = new URL(startUrl);
            host = url.getHost();
        } catch (
                MalformedURLException e) {
            throw new RuntimeException(e);
        }
        ForkJoinPool.commonPool().invoke(new FJT(startUrl, htmlParser));
        return new ArrayList<>(done.keySet());
    }

    class HtmlParser {
        List<String> urls;

        public List<String> getUrls(String url) {
            return urls;
        }

        public void setUrls(List<String> urls) {
            this.urls = urls;
        }
    }
}
