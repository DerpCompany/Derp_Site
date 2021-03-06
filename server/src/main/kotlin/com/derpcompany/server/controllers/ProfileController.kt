package com.derpcompany.server.controllers

import com.derpcompany.server.controllers.data.toProfileResponse
import com.derpcompany.server.network.wiretypes.ProfileResponse
import com.derpcompany.server.network.wiretypes.RolesWireType
import com.derpcompany.server.repositories.ProfileRepository
import com.derpcompany.server.services.data.toProfile
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Author: garci
 * Version: 1.0
 * Date: 6/29/2022 14:26
 */

@RestController
@RequestMapping("/api")
class ProfileController(
    private val profileRepository: ProfileRepository,
) {
    /**
     * Query all profiles.
     */
    @GetMapping("/profile")
    fun getAllProfiles(): ResponseEntity<List<ProfileResponse>> {
        val profiles = profileRepository.findAll().map { it.toProfile().toProfileResponse() }

        return ResponseEntity.ok(profiles)
    }

    /**
     * Query profile by ID.
     */
    @GetMapping("/profile/{id}")
    fun getOneProfileById(@PathVariable("id") id: String): ResponseEntity<ProfileResponse> {
        val profile = profileRepository.findOneByProfileId(ObjectId(id)).toProfile().toProfileResponse()

        return ResponseEntity.ok(profile)
    }

    /**
     * Query profile by username.
     */
    @GetMapping("/profile/username/{username}")
    fun getOneProfileByUsername(@PathVariable("username") username: String): ResponseEntity<ProfileResponse> {
        val profile = profileRepository.findByUsername(username).toProfile().toProfileResponse()

        return ResponseEntity.ok(profile)
    }

    /**
     * Query all profiles with specific role
     */
    @GetMapping("/profile/role/{role}")
    fun getProfilesByRole(@PathVariable("role") role: RolesWireType): ResponseEntity<List<ProfileResponse>> {
        val profiles = profileRepository.findByRole(role.toString()).map { it.toProfile().toProfileResponse() }

        return ResponseEntity.ok(profiles)
    }
}
