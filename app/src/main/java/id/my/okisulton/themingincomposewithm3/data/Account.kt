package id.my.okisulton.themingincomposewithm3.data

/**
 *Created by osalimi on 24-09-2024.
 **/
import androidx.annotation.DrawableRes

/**
 * An object which represents an account which can belong to a user. A single user can have
 * multiple accounts.
 */
data class Account(
    val id: Long,
    val uid: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val altEmail: String,
    @DrawableRes val avatar: Int,
    var isCurrentAccount: Boolean = false
) {
    val fullName: String = "$firstName $lastName"
}