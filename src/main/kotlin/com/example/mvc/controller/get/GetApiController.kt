package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController         // REST API Controller 동작
@RequestMapping("/api") // http://localhost:8000/api
class GetApiController {

    @GetMapping(path = ["/hello", "/abcd"]) // GET http://localhost:8000/api/hello, http://localhost:8000/api/abcd
    fun hello(): String {
        return "hello kotlin"
    }

    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"]) // GET http://localhost:8000/api/request-mapping
    fun requestMapping(): String {
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}") // GET http://localhost:8080/api/get-mapping/path-variable/steve
    fun pathVariable(@PathVariable name: String, @PathVariable age : Int): String {
        println("${name} , ${age}")
        return name + " " + age
    }


    @GetMapping("/get-mapping/path-variable2/{name}/{age}") // GET http://localhost:8080/api/get-mapping/path-variable/steve
    fun pathVariable2(@PathVariable(value = "name") _name: String, @PathVariable(name = "age") age : Int): String {
        val name = "Kotlin"

        return _name + " " + age
    }

    // https://localhost:8080/api/page?key=value&key2=value2&key3=value3

    @GetMapping("/get-mapping/query-param") // ?name=lee&age=28
    fun queryParam(
        @RequestParam(name = "name") name: String,
        @RequestParam(value = "age") age: Int
    ): String {
        println("${name}, ${age}")

        return name + " "  + age
    }

    // name, age, address, email
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map : Map<String, Any>): Map<String, Any> {
        println(map)
        val phoneNumber = map["phone-number"]

        return map
    }
}