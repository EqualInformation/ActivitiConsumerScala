package com.equalinformation.bpm.poc.consumer.scala.ws.test

import java.lang.reflect.Type

import com.equalinformation.bpm.poc.consumer.scala.ws.domain.Task
import com.google.gson.reflect.TypeToken
import com.google.gson.{Gson, JsonElement, JsonObject, JsonParser}
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter
import com.sun.jersey.api.client.{Client, ClientResponse, WebResource}


/**
  * Created by bpupadhyaya on 11/30/15.
  */
object JerseyClientTest {
  def main(args: Array[String]) {
    try {
      val client: Client = Client.create
      client.addFilter(new HTTPBasicAuthFilter("kermit", "kermit"))
      val webResource: WebResource = client.resource("http://localhost:8091/activiti-rest/service/runtime/tasks?candidateUser?kermit")
      val response: ClientResponse = webResource.accept("application/json").get(classOf[ClientResponse])

      if (response.getStatus != 200) {
        throw new RuntimeException("Activiti call failed : HTTP error code : " + response.getStatus)
      }

      println("Response status: " + response.getStatus)
      val output: String = response.getEntity(classOf[String])
      println("Output from Server .... \n")
      println(output)

      val parser: JsonParser = new JsonParser
      val rootObject: JsonObject = parser.parse(output).getAsJsonObject
      val taskElement: JsonElement = rootObject.get("data")
      val gson: Gson = new Gson
      var taskList: java.util.List[Task] = new java.util.ArrayList[Task]

      if (taskElement.isJsonObject) {
        val task: Task = gson.fromJson(taskElement, classOf[Task])
        taskList.add(task)
      }
      else if (taskElement.isJsonArray) {
        val projectListType: Type = new TypeToken[java.util.List[Task]]() {
        }.getType
        taskList = gson.fromJson(taskElement, projectListType)
      }

      println("Size of list: " + taskList.size)
      println("Some data from first element: " + taskList.get(0).name)
    }
    catch {
      case e: Exception => {
        e.printStackTrace
      }
    }

  }

}

