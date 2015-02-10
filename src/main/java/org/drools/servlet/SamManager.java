package org.drools.servlet;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SamManager implements Serializable {
	private static final long serialVersionUID = 6336453484618064506L;

	private Long id;

	private String url;
	private Map<Integer, Long> emisores = new HashMap<Integer, Long>();
	private long operations;
	private boolean enabled;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Long getId() {
		return id;
	}

	public void setEmisores(Map<Integer, Long> emisores) {
		this.emisores = emisores;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getOperations() {
		return operations;
	}

	public void setOperations(long operations) {
		this.operations = operations;
	}

	public Long getMontoEmisor(Integer emisorId) {
		return emisores.get(emisorId);
	}

	public void addEmisor(Integer emisorId, Long amount) {
		emisores.put(emisorId, amount);
	}

	public Map<Integer, Long> getEmisores() {
		return emisores;
	}
}
