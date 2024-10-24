package com.example.demo.controller

import com.example.demo.model.Model
import com.example.model.JsendResponse
import jakarta.websocket.server.PathParam
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/home")
class HomeController {

    /*@GetMapping("/{id}")
    fun home(@PathVariable ("id") id: Int ):String{
        return "Hello, World! $id"

    }*/

/* @GetMapping()
fun home(@PathParam ("id") id: Int ): String{
   return "Hello, World! $id"
}*/

/*  @GetMapping()
 fun home(@RequestBody model:Model): String{
     return "Hello, World! ${model.id  } ${model.name  } ${model.age}"
 }*/


    @RestController
    @RequestMapping("/api")
    class MyController {

        // Respuesta de éxito (success)
        @GetMapping("/success")
        fun getSuccessResponse(): ResponseEntity<JsendResponse<Map<String, String>>> {
            val data = mapOf("user" to "John Doe", "age" to "30")
            val response = JsendResponse(status = "success", data = data)
            return ResponseEntity.ok(response)
        }

        // Respuesta de fallo (fail)
        @GetMapping("/fail")
        fun getFailResponse(): ResponseEntity<JsendResponse<Map<String, String>>> {
            val failData = mapOf("email" to "Email is required")
            val response = JsendResponse(status = "fail", data = failData)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response)
        }

        // Respuesta de error (error)
        @GetMapping("/error")
        fun getErrorResponse(): ResponseEntity<JsendResponse<Any>> {
            val response = JsendResponse(
                status = "error",
                message = "Internal server error",
                code = 500
            )
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response)
        }
    }



}