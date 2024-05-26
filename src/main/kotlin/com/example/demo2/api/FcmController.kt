package com.example.demo2.api

import com.example.demo2.domain.fcmPatient.FcmPatient
import com.example.demo2.service.FcmPatientService
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime


@RestController
class FcmController (
        private val fcmPatientService: FcmPatientService

){
//    @GetMapping("/test")
//    fun testApiMethod(): String {
//        var result = fcmPatientService.findAll()
//        return result[0].patient_name
//    }
//    @GetMapping("/test/string")
//    fun testCode(): String {
//        return "테스트테스트!"
//    }

    @GetMapping("/list")
    @ResponseBody
    fun list(): List<FcmPatient>? {
        var users: List<FcmPatient>? = null
        try {
            users = fcmPatientService.findAll()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return users
    }

//    @PutMapping("/patients/{id}/fcmToken")
//    fun updateFcmToken(@RequestParam id: Long, @RequestParam newFcmToken: String): FcmPatient {
//        return fcmPatientService.updateFcmToken(id, newFcmToken)
    @PutMapping("/patients/fcmToken")
    fun updateFcmToken(@RequestParam id: Long, @RequestParam newFcmToken: String): FcmPatient {
        return fcmPatientService.updateFcmToken(id, newFcmToken)
    }

    @PutMapping("/startTime")
    fun updateStartTime(@RequestParam id: Long) : FcmPatient {
        return fcmPatientService.updateStartTime(id)
    }
}