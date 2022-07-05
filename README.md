# Generic Tool Plugin

## Introduction

This plugin provides a "Generic Tool" tool installation for use in Pipelines.

It's a lighter weight alternative to installing plugins like Ant, Groovy, etc. when all you need is the tool installation definition for use with the `tool` step.

## Getting started

The tool configuration can be found in _Manage Jenkins » Global Tool Configuration » Generic Tool_.

The tool installations configured there can be used with the `tool` step in Pipelines. 

You can also use [Tool Environment Plugin](https://plugins.jenkins.io/toolenv/) to make these tools available to other job types.
[Extra Tool Installers Plugin](https://plugins.jenkins.io/extra-tool-installers/) provides additional tool installers that can be used for the Generic Tools you define with this plugin.

## Contributing

Refer to our [contribution guidelines](https://github.com/jenkinsci/.github/blob/master/CONTRIBUTING.md)

## LICENSE

Licensed under MIT, see [LICENSE](LICENSE.md)
