package org.drools.servlet;

public class DecisionParameter {
	private Integer emisor;
	private Long monto;

	public Integer getEmisor() {
		return emisor;
	}

	public void setEmisor(Integer emisor) {
		this.emisor = emisor;
	}

	public Long getMonto() {
		return monto;
	}

	public void setMonto(Long monto) {
		this.monto = monto;
	}
}
