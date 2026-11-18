package enriquez.mariajose.mipokedexcompose.model.domain

import android.media.Image
import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    val id: Int = -1,
    val name: String,
    val number: Int,
    val  type: String,
    val description: String,
    val height: Float,
    val weight: Float,
    val favorite: Boolean,
    val ability: String,
    val image: Int,
    val sqlImage: ByteArray? = null,
    val companionSince: String = ""
)
