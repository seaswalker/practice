package something;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用读写锁实现缓存，以前使用的ConcurrentHashMap，没有想到这个
 * @author skywalker
 *
 */
public class Cache<K, V> {

	private Map<K, V> cache = new HashMap<K, V>();
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private Lock readLock = lock.readLock();
	private Lock writeLock = lock.writeLock();
	
	public V get(K key) {
		try {
			readLock.lock();
			return cache.get(key);
		} finally {
			readLock.unlock();
		}
	}
	
	public void put(K key, V value) {
		try {
			writeLock.lock();
			cache.put(key, value);
		} finally {
			writeLock.unlock();
		}
	}
	
	public void clear() {
		try {
			writeLock.lock();
			cache.clear();
		} finally {
			writeLock.unlock();
		}
	}
	
}
