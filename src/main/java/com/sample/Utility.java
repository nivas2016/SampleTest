package com.sample;

import org.drools.spi.KnowledgeHelper;

public class Utility {

	public static void help(final KnowledgeHelper drools, final String message){
		System.out.println("sent message is"+message);
		System.out.println("rule is"+drools.getRule().getName());
	}
	
	public static void helper(final KnowledgeHelper drools){
		System.out.println("rule is "+drools.getRule().getName());
	}
}
