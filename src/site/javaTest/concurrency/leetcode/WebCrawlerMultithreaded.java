package site.javaTest.concurrency.leetcode;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.*;

//https://leetcode.com/problems/web-crawler-multithreaded/
public class WebCrawlerMultithreaded {
    ExecutorService service;

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        return crawlHelper(startUrl, htmlParser);
    }

    public List<String> crawlHelper(String startUrl, HtmlParser htmlParser) {
        this.service = Executors.newCachedThreadPool(r -> {
            Thread t = Executors.defaultThreadFactory().newThread(r);
            t.setDaemon(true);
            return t;
        });

        Set<String> set = ConcurrentHashMap.newKeySet();
        Queue<String> queue = new LinkedList<>();
        String hostname = getHostname(startUrl);

        queue.offer(startUrl);
        set.add(startUrl);

        try {
            while (!queue.isEmpty()) {
                List<Task> tasks = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    final String poll = queue.poll();
                    Task task = new Task(poll, htmlParser);
                    tasks.add(task);
                }

                List<Future<List<String>>> futures = service.invokeAll(tasks);

                for (Future<List<String>> future : futures) {
                    List<String> nextUrls = future.get();
                    for (String nextUrl : nextUrls) {
                        if (nextUrl.contains(hostname) && !set.contains(nextUrl)) {

                            boolean added = set.add(nextUrl);
                            queue.add(nextUrl);

                        }
                    }
                }
            }
        } catch (InterruptedException | ExecutionException executionException) {

        } finally {

        }

        return new ArrayList<>(set);

    }

    private String getHostname(String url) {
        URL url1 = null;
        try {
            url1 = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url1.getHost();
    }


    class Task implements Callable<List<String>> {

        String url;
        HtmlParser htmlParser;

        Task(String url, HtmlParser htmlParser) {
            this.url = url;
            this.htmlParser = htmlParser;
        }

        @Override
        public List<String> call() throws Exception {
            return htmlParser.getUrls(url);

        }
    }

    class HtmlParser{
        List<String> urls;

        public List<String> getUrls(String url) {
            return urls;
        }

        public void setUrls(List<String> urls) {
            this.urls = urls;
        }
    }
}
