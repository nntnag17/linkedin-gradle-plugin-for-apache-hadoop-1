/*
 * Copyright 2014 LinkedIn Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.linkedin.gradle.hadoopdsl;

/**
 * Base implementation of Visitor to make it easy to implement visitor subclasses. By default, the
 * multi-method overloads will simply call the overload for the base type. This will make it easy
 * for subclasses that want to only override the overload for the base type.
 */
abstract class BaseVisitor implements Visitor {

  void visitScopeContainer(BaseNamedScopeContainer container) {
    // Visit each job
    container.jobs.each() { Job job ->
      visitJob(job);
    }

    // Visit each properties object
    container.properties.each() { Properties props ->
      visitProperties(props);
    }

    // Visit each workflow
    container.workflows.each() { Workflow workflow ->
      visitWorkflow(workflow);
    }
  }

  @Override
  void visitPlugin(HadoopDslPlugin plugin) {
    visitScopeContainer(plugin);
    visitExtension(plugin.extension);
  }

  @Override
  void visitExtension(HadoopDslExtension hadoop) {
    visitScopeContainer(hadoop);
  }

  @Override
  void visitProperties(Properties props) {
  }

  @Override
  void visitWorkflow(Workflow workflow) {
    visitScopeContainer(workflow);
  }

  @Override
  void visitJob(Job job) {
  }

  @Override
  void visitJob(CommandJob job) {
    visitJob((Job)job);
  }

  @Override
  void visitJob(HadoopJavaJob job) {
    visitJob((Job)job);
  }

  @Override
  void visitJob(HiveJob job) {
    visitJob((Job)job);
  }

  @Override
  void visitJob(JavaJob job) {
    visitJob((Job)job);
  }

  @Override
  void visitJob(JavaProcessJob job) {
    visitJob((Job)job);
  }

  @Override
  void visitJob(KafkaPushJob job) {
    visitJob((Job)job);
  }

  @Override
  void visitJob(NoOpJob job) {
    visitJob((Job)job);
  }

  @Override
  void visitJob(PigJob job) {
    visitJob((Job)job);
  }

  @Override
  void visitJob(VoldemortBuildPushJob job) {
    visitJob((Job)job);
  }
}