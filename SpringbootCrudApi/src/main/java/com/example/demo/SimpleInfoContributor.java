package com.example.demo;

import java.security.SecureRandom;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import javassist.expr.NewArray;
@Component
public class SimpleInfoContributor implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		builder.withDetail("simple", new SecureRandom().nextLong());
		
		
	}

}
