package com.equalinformation.bpm.poc.consumer.scala

import vaadin.scala._

/**
  * Created by bpupadhyaya on 11/28/15.
  */
class ActivitiConsumerUI extends UI {
  content = Button("Click here!", Notification.show("This is a test program!"))
}