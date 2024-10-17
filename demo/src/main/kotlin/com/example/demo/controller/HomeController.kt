package com.example.demo.controller

import com.example.demo.model.Model
import jakarta.websocket.server.PathParam
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

    @GetMapping()
    fun home(@RequestBody model:Model): String{
        return "Hello, World! ${model.id  } ${model.name  } ${model.age}"
    }

}