package com.equalinformation.bpm.poc.consumer.scala;

import java.util.Date

import com.vaadin.annotations.Theme
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._;

/**
 *
 */
@Theme("mytheme")
class ActivitiConsumerUI extends UI {
    override def init(request: VaadinRequest) = {
        val content: VerticalLayout = new VerticalLayout
        setContent(content)

        val label: Label = new Label("Test label")
        content addComponent label

        // Handle user interaction
        content addComponent new Button("Click here",
                new Button.ClickListener {
            override def buttonClick(event: ClickEvent) =
                    Notification.show("The time is " + new Date)
        })
    }
}
//@Theme("mytheme")
//@Widgetset("com.equalinformation.bpm.poc.consumer.scala.MyAppWidgetset")
//public class MyUI extends UI {
//
//    @Override
//    protected void init(VaadinRequest vaadinRequest) {
//        final VerticalLayout layout = new VerticalLayout();
//        layout.setMargin(true);
//        setContent(layout);
//
//        Button button = new Button("Click Me");
//        button.addClickListener(new Button.ClickListener() {
//            @Override
//            public void buttonClick(ClickEvent event) {
//                layout.addComponent(new Label("Thank you for clicking"));
//            }
//        });
//        layout.addComponent(button);
//
//    }
//
//    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
//    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
//    public static class MyUIServlet extends VaadinServlet {
//    }
//}
