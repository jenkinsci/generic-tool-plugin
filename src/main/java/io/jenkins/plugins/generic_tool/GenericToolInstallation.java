package io.jenkins.plugins.generic_tool;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.EnvVars;
import hudson.Extension;
import hudson.model.EnvironmentSpecific;
import hudson.model.Node;
import hudson.model.PersistentDescriptor;
import hudson.model.TaskListener;
import hudson.slaves.NodeSpecific;
import hudson.tools.ToolDescriptor;
import hudson.tools.ToolInstallation;
import hudson.tools.ToolProperty;
import java.io.IOException;
import java.util.List;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;

public class GenericToolInstallation extends ToolInstallation
        implements NodeSpecific<GenericToolInstallation>, EnvironmentSpecific<GenericToolInstallation> {

    @DataBoundConstructor
    public GenericToolInstallation(String name, String home, List<? extends ToolProperty<?>> properties) {
        super(name, home, properties);
    }

    @Override
    public GenericToolInstallation forEnvironment(EnvVars environment) {
        return new GenericToolInstallation(
                getName(), environment.expand(getHome()), getProperties().toList());
    }

    @Override
    public GenericToolInstallation forNode(@NonNull Node node, TaskListener log)
            throws IOException, InterruptedException {
        return new GenericToolInstallation(
                getName(), translateFor(node, log), getProperties().toList());
    }

    @Extension
    @Symbol("generic")
    public static class DescriptorImpl extends ToolDescriptor<GenericToolInstallation> implements PersistentDescriptor {
        @NonNull
        @Override
        public String getDisplayName() {
            return "Generic Tool";
        }

        @Override
        public void setInstallations(GenericToolInstallation... installations) {
            super.setInstallations(installations);
            save();
        }
    }
}
