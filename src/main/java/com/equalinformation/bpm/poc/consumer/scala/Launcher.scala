package com.equalinformation.bpm.poc.consumer.scala

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.webapp.WebAppContext


/**
  * Created by bpupadhyaya on 11/28/15.
  */
object Launcher {
  def main(args: Array[String]): Unit = {
    try {
      val root = new WebAppContext();
      root.setContextPath("/");
      root.setDescriptor("src/main/webapp/WEB-INF/web.xml");
      root.setResourceBase("target/classes");
      root.setParentLoaderPriority(true);

      println("Starting Jetty Server...")
      val s = new Server(9000)
      s.setHandler(root);
      s.start();

      println("... done!")
      println("Application deployed at: http://localhost:9000")

      s.join();
    } catch {
      case e: Exception => println("Failed to start the server at port 9000.")
    }
  }
}
