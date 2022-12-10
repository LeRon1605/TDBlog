package core.Cache;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class InMemoryCache {
	private Map<String, Object> data;
	private static InMemoryCache instance;
	
	private InMemoryCache() {
		data = Collections.synchronizedMap(new HashMap<String, Object>());
	}
	
	public <T> T get(String key) {
		if (data.containsKey(key)) {
			CacheItem<T> item = (CacheItem<T>) data.get(key);
			if (item.getExpireAt().isAfter(LocalDateTime.now()))
				return item.getValue();
			else
				data.remove(key);
		}
		return null;
	}
	
	public <T> void put(String key, T value, int expireAfter) {
		CacheItem<T> item = new CacheItem<T>(key, value, LocalDateTime.now().plusSeconds(expireAfter));
		data.put(key, item);
	}
	
	public static InMemoryCache getInstance() {
		if (instance == null)
			instance = new InMemoryCache();
		return instance;
	}
}
