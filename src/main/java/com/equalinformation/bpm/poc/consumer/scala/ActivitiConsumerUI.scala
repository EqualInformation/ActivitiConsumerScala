package com.equalinformation.bpm.poc.consumer.scala

import vaadin.scala._
import vaadin.scala.server.ScaladinRequest

/**
  * Created by bpupadhyaya on 11/28/15.
  */
class ActivitiConsumerUI extends UI(title = "Activiti Consumer") {

  val layout = new VerticalLayout {
    sizeFull()
  }

  val headerLayout = new VerticalLayout {
    width = 100 pct;
    height = 70 px;
  }

  val contentLayout = new VerticalLayout {
    sizeFull()
    margin = true
  }

  override def init(request: ScaladinRequest) {
    val navigator = new Navigator(this, contentLayout) {
      addView(SampleView.VIEW1, new SampleView)
      //addView(SampleView.VIEW2, classOf[SampleView])
      addView(SampleView.VIEW2, new SampleView)
      addView(SampleView.VIEW3, new SampleView)
      addView(SampleView.VIEW4, new SampleView)
    }

    navigator_=(navigator)

    content_=(layout)

    //Check what headers needed
    headerLayout.add(buildApplicationHeader)
    headerLayout.add(buildApplicationMenu(navigator))

    layout.add(headerLayout)
    layout.add(contentLayout, ratio = 1)

  }

  private def buildApplicationHeader: HorizontalLayout = new HorizontalLayout {
    width = 100 pct;
    height = 45 px;
    add(alignment = Alignment.MiddleLeft, component = new Label {
      value = "Activiti Consumer Application"
    })
//    add(alignment = Alignment.MiddleCenter, component = new Label {
//      value = "Activiti Consumer"
//    })
//    add(alignment = Alignment.MiddleRight, component = new Label {
//      value = "Activiti Message"
//    })
  }

  private def buildApplicationMenu(navigator: Navigator): HorizontalLayout = new HorizontalLayout {
    width = 100 pct;
    height = 25 px;

    val menuBar = new MenuBar {
//      addItem("Tasks", (e: MenuBar.MenuItem) => navigator.navigateTo(SampleView.VIEW1))
//      addItem("Processes", (e: MenuBar.MenuItem) => navigator.navigateTo(SampleView.VIEW2))
//      addItem("Reports", (e: MenuBar.MenuItem) => navigator.navigateTo(SampleView.VIEW3))
//      addItem("Manage", (e: MenuBar.MenuItem) => navigator.navigateTo(SampleView.VIEW4))

      val tasks = addItem("Tasks")
      val processes = addItem("Processes")
      val reports = addItem("Reports")
      val manage = addItem("Manage")

      val inbox = tasks.addItem("Inbox")
      val queued = tasks.addItem("Queued")
      val involved = tasks.addItem("Involved")
      val archived = tasks.addItem("Archived")

      val myInstances = processes.addItem("My instances")
      val deployedProcessDefinition = processes.addItem("Deployed process definitions")


    }
    addComponent(menuBar)
  }

}

object SampleView {
  val VIEW1 = ""
  val VIEW2 = "ClassBasedView"
  val VIEW3 = ""
  val VIEW4 = ""

  private var count = 1

  private def inc = {
    count += 1; count
  }
}

class SampleView extends VerticalLayout with Navigator.View {
//  val label = Label("Label for SampleView")
  val label = Label("")

  def init() {

    val layout = new VerticalLayout() {
      sizeFull()
      add(label)
    }
    layout.margin = true
    add(layout)
  }

  init()

  override def enter(event: Navigator.ViewChangeEvent) {
    val viewName = event.viewName.getOrElse("")
    if (viewName == SampleView.VIEW2) {
      SampleView.inc
    }
//    label.value = "Test message from view " + viewName + ", the view has been created " + SampleView.count + " times."
    Notification.show("Entering view " + viewName)
  }
}