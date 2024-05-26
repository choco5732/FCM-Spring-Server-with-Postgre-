package com.example.demo2.domain.fcmPatient

import org.springframework.data.jpa.repository.JpaRepository

interface FcmPatientRepository : JpaRepository<FcmPatient, Long> {
}