package site.systemDesign.lruCache;

public interface ICache<T> {
    public void put(T key, Object value);
    public Object get(T key);
}