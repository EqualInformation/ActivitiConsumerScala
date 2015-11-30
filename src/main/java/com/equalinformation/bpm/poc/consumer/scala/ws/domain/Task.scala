package com.equalinformation.bpm.poc.consumer.scala.ws.domain

import com.vaadin.ui.Button


/**
  * Created by bpupadhyaya on 11/29/15.
  */
class Task {
  var id: String = _
  var url: String = _
  var owner: String = _
  var assignee: String = _
  var delegationState: String = _
  var name: String = _
  var description: String = _
  var createTime: String = _
  var dueDate: String = _
  var priority: String = _
  var suspended: String = _
  var taskDefinitionKey: String = _
  var tenantId: String = _
  var category: String = _
  var formKey: String = _
  var parentTaskId: String = _
  var parentTaskURL: String = _
  var executionId: String = _
  var executionURL: String = _
  var processInstanceId: String = _
  var processInstanceURL: String = _
  var processDefinitionId: String = _
  var processDefinitionURL: String = _
  var variables: Array[String] = _
  var action: Button = _

}