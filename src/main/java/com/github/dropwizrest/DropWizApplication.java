package com.github.dropwizrest;

import com.github.dropwizrest.resources.SampleResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropWizApplication extends Application<DropWizConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropWizApplication().run(args);
    }

    @Override
    public void initialize(final Bootstrap<DropWizConfiguration> bootstrap) {
        // application initialization
    }

	@Override
	public void run(DropWizConfiguration config, Environment env) throws Exception {
		// register services
		final SampleResource resource = new SampleResource();
		    env.jersey().register(resource);
	}
}
