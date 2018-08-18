package com.sample;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.definition.KnowledgePackage;
import org.drools.definition.process.Process;
import org.drools.definition.rule.Query;
import org.drools.definition.rule.Rule;
import org.drools.definition.type.FactType;
import org.drools.event.knowledgebase.KnowledgeBaseEventListener;
import org.drools.io.ResourceFactory;
import org.drools.runtime.Environment;
import org.drools.runtime.KnowledgeSessionConfiguration;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.StatelessKnowledgeSession;

import com.sample.ItemCity.City;
import com.sample.ItemCity.Type;




public class ItemCityTest {

	public static void main(String args[]){
		KnowledgeBase kbase=readKnowledgeBase();
		StatefulKnowledgeSession ksession=kbase.newStatefulKnowledgeSession();
		ItemCity item1=new ItemCity();
		item1.setPurchaseCity(City.PUNE);
		item1.setTypeofitem(Type.MEDICINES);
		item1.setSp(new BigDecimal(10));
		ksession.insert(item1);
		
		ItemCity item2=new ItemCity();
		item2.setPurchaseCity(City.PUNE);
		item2.setTypeofitem(Type.GROCERIES);
		item2.setSp(new BigDecimal(10));
		ksession.insert(item2);
		
		ItemCity item3=new ItemCity();
		item3.setPurchaseCity(City.NAGPUR);
		item3.setTypeofitem(Type.MEDICINES);
		item3.setSp(new BigDecimal(10));
		ksession.insert(item3);
		
		ItemCity item4=new ItemCity();
		item4.setPurchaseCity(City.NAGPUR);
		item4.setTypeofitem(Type.GROCERIES);
		item4.setSp(new BigDecimal(10));
		ksession.insert(item4);
		
		ksession.fireAllRules();
		
		System.out.println(item1.getPurchaseCity().toString()+""+item1.getTax().intValue());
		System.out.println(item2.getPurchaseCity().toString()+""+item2.getTax().intValue());
		System.out.println(item3.getPurchaseCity().toString()+""+item3.getTax().intValue());
		System.out.println(item4.getPurchaseCity().toString()+""+item4.getTax().intValue());
	}
	
	public static KnowledgeBase readKnowledgeBase() {
		
		KnowledgeBuilder kbuilder=KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("Pune.drl"),ResourceType.DRL);
		kbuilder.add(ResourceFactory.newClassPathResource("Nagpur.drl"),ResourceType.DRL);
		
		KnowledgeBuilderErrors errors=kbuilder.getErrors();
		if(errors.size()>0){
			for(KnowledgeBuilderError error:errors){
				System.out.println(error);
			}
			throw new IllegalArgumentException("not parse");
		}
		
		KnowledgeBase kbase=KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
				
		return kbase;
		
	}
}
