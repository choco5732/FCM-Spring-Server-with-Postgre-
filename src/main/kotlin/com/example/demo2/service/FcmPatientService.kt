package com.example.demo2.service

import com.example.demo2.domain.fcmPatient.FcmPatient
import com.example.demo2.domain.fcmPatient.FcmPatientRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class FcmPatientService(
        val fcmPatientRepository: FcmPatientRepository
) {
    fun findAll(): MutableList<FcmPatient> = fcmPatientRepository.findAll()
    fun updateFcmToken(patientId: Long, newFcmToken: String): FcmPatient {
        val patient = fcmPatientRepository.findById(patientId)
                .orElseThrow { EntityNotFoundException("Patient not found with id: $patientId") }

        patient.fcm_token = newFcmToken // 새로운 fcm_token으로 업데이트

        return fcmPatientRepository.save(patient) // 업데이트된 엔티티 반환
    }

    fun updateStartTime(patientId: Long): FcmPatient {
        val target = fcmPatientRepository.findById(patientId)
                .orElseThrow { EntityNotFoundException("타겟 스캔 실패: $patientId")}

        target.start_time = LocalDateTime.now()

        return fcmPatientRepository.save(target)
    }
}