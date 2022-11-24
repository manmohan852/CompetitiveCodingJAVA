package site.javaTest.concurrency.leetcode;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
//https://leetcode.com/problems/web-crawler-multithreaded/discuss/639730/Java-BFS-with-easily-scalable-design
public class WebCrawlerMultithreaded4 {

    private static int N = 5;

    private static int getIdx(String s) {
        return Math.abs(s.hashCode()) % N;
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {

        Crawler[] crawlers = new Crawler[N];
        CountDownLatch latch = new CountDownLatch(N);

        for(int i=0; i<N; i++) {
            crawlers[i] = new Crawler(htmlParser, crawlers, latch);
            new Thread(crawlers[i]).start();
        }

        crawlers[getIdx(startUrl)].q.offer(startUrl);

        try {
            latch.await();
            return Arrays.stream(crawlers).flatMap(c -> c.parsed.stream()).collect(Collectors.toList());
        } catch (InterruptedException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    class Crawler implements Runnable {
        private final HtmlParser parser;
        private final Crawler[] crawlers;
        private final CountDownLatch latch;
        private final BlockingQueue<String> q;
        private final Set<String> parsed;

        Crawler(HtmlParser parser, Crawler[] crawlers, CountDownLatch latch){
            this.q = new LinkedBlockingDeque<>();
            this.parser = parser;
            this.crawlers = crawlers;
            this.latch = latch;
            this.parsed = new HashSet<>();
        }

        @Override
        public void run() {
            try {
                String url = q.poll(100, TimeUnit.MILLISECONDS);
                while(url != null) {
                    if (parsed.add(url)) {
                        String host = url.split("\\/")[2];
                        List<String> urls = parser.getUrls(url);
                        for(String u : urls) {
                            if (u.split("\\/")[2].equals(host)) {
                                crawlers[getIdx(u)].q.offer(u);
                            }
                        }
                    }
                    url = q.poll(100, TimeUnit.MILLISECONDS);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }
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
