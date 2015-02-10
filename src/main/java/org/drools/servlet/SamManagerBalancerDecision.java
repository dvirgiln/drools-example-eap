package org.drools.servlet;


public interface SamManagerBalancerDecision {

	void addObject(Object object);
	SamManager getBestSamManager();
}
