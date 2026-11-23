package com.waqarinstitute.crypto

import de.mkammerer.argon2.Argon2Factory
import de.mkammerer.argon2.Argon2

class Argon2idHasher {
    private val argon2: Argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id)

    fun hash(password: CharArray): String =
        argon2.hash(3, 65536, 4, password)

    fun verify(hash: String, password: CharArray): Boolean =
        argon2.verify(hash, password)

    fun wipe(password: CharArray) {
        argon2.wipeArray(password)
    }
}