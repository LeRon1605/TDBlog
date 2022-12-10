package core.Cache;

import java.time.LocalDateTime;

public class CacheItem<T>{
	private String key;
	private T value;
	private LocalDateTime expireAt;
	
	public CacheItem(String key, T value, LocalDateTime expireAt) {
		this.key = key;
		this.value = value;
		this.expireAt = expireAt;
	}
	
	public String getKey() {
		return key;
	}
	public T getValue() {
		return value;
	}
	public LocalDateTime getExpireAt() {
		return expireAt;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public void setExpireAt(LocalDateTime expireAt) {
		this.expireAt = expireAt;
	}
}
