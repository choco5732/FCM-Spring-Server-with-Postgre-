package com.example.demo2.domain.fcmPatient

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "fcm_patient")
class FcmPatient(
        id: Int,
        patient_id: Int,
        patient_name: String,
        start_time: Long,
        fcm_token: String,
        isend: Boolean
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "patient_id", nullable = false)
    var patient_id: Int = patient_id

    @Column(name = "patient_name", nullable = false)
    var patient_name: String = patient_name

    @Column(name = "start_time", nullable = false)
    var start_time: Long = start_time

    @Column(name = "fcm_token", nullable = false)
    var fcm_token: String = fcm_token

    @Column(name = "isend", nullable = false)
    var isend: Boolean = isend
}