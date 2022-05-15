package io.foxcapades.lib.unsato

import java.math.BigInteger
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.read
import kotlin.concurrent.write

data class AtomicUInt(private var actual: UByte = 0u) {
  private val lock = ReentrantReadWriteLock()

  val value
    get() = lock.read { actual }

  operator fun inc() =
    lock.write { actual++; this }

  operator fun dec() =
    lock.write { actual--; this }

  // region +=

  /**
   * Adds the given value to this [AtomicUInt].
   *
   * @param add Value to add.
   */
  operator fun plusAssign(add: UByte) =
    lock.write { actual = (actual + add).toUByte() }

  /**
   * Adds the given value to this [AtomicUInt].
   *
   * @param add Value to add.
   */
  operator fun plusAssign(add: UShort) =
    lock.write { actual = (actual + add).toUByte() }

  /**
   * Adds the given value to this [AtomicUInt].
   *
   * @param add Value to add.
   */
  operator fun plusAssign(add: UInt) =
    lock.write { actual = (actual + add).toUByte() }

  /**
   * Adds the given value to this [AtomicUInt].
   *
   * @param add Value to add.
   */
  operator fun plusAssign(add: ULong) =
    lock.write { actual = (actual + add).toUByte() }

  /**
   * Adds the given value to this [AtomicUInt].
   *
   * @param add Value to add.
   */
  operator fun plusAssign(add: Byte) =
    lock.write { actual = (actual.toInt() + add).toUByte() }

  /**
   * Adds the given value to this [AtomicUInt].
   *
   * @param add Value to add.
   */
  operator fun plusAssign(add: Short) =
    lock.write { actual = (actual.toInt() + add).toUByte() }

  /**
   * Adds the given value to this [AtomicUInt].
   *
   * @param add Value to add.
   */
  operator fun plusAssign(add: Int) =
    lock.write { actual = (actual.toInt() + add).toUByte() }

  /**
   * Adds the given value to this [AtomicUInt].
   *
   * @param add Value to add.
   */
  operator fun plusAssign(add: Long) =
    lock.write { actual = (actual.toInt() + add).toUByte() }

  /**
   * Adds the given value to this [AtomicUInt].
   *
   * @param add Value to add.
   */
  operator fun plusAssign(add: AtomicUByte) =
    lock.write { actual = (actual + add.value).toUByte() }

  /**
   * Adds the given value to this [AtomicUInt].
   *
   * @param add Value to add.
   */
  operator fun plusAssign(add: AtomicUShort) =
    lock.write { actual = (actual + add.value).toUByte() }

  /**
   * Adds the given value to this [AtomicUInt].
   *
   * @param add Value to add.
   */
  operator fun plusAssign(add: AtomicUInt) =
    lock.write { actual = (actual + add.value).toUByte() }

  /**
   * Adds the given value to this [AtomicUInt].
   *
   * @param add Value to add.
   */
  operator fun plusAssign(add: AtomicULong) =
    lock.write { actual = (actual + add.value).toUByte() }

  // endregion +=

  // region -=

  /**
   * Subtracts the given value from this [AtomicUInt].
   *
   * @param sub Value to subtract.
   */
  operator fun minusAssign(sub: UByte) =
    lock.write { actual = (actual - sub).toUByte() }

  /**
   * Subtracts the given value from this [AtomicUInt].
   *
   * @param sub Value to subtract.
   */
  operator fun minusAssign(sub: UShort) =
    lock.write { actual = (actual - sub).toUByte() }

  /**
   * Subtracts the given value from this [AtomicUInt].
   *
   * @param sub Value to subtract.
   */
  operator fun minusAssign(sub: UInt) =
    lock.write { actual = (actual - sub).toUByte() }

  /**
   * Subtracts the given value from this [AtomicUInt].
   *
   * @param sub Value to subtract.
   */
  operator fun minusAssign(sub: ULong) =
    lock.write { actual = (actual - sub).toUByte() }

  /**
   * Subtracts the given value from this [AtomicUInt].
   *
   * @param sub Value to subtract.
   */
  operator fun minusAssign(sub: Byte) =
    lock.write { actual = (actual.toInt() - sub).toUByte() }

  /**
   * Subtracts the given value from this [AtomicUInt].
   *
   * @param sub Value to subtract.
   */
  operator fun minusAssign(sub: Short) =
    lock.write { actual = (actual.toInt() - sub).toUByte() }

  /**
   * Subtracts the given value from this [AtomicUInt].
   *
   * @param sub Value to subtract.
   */
  operator fun minusAssign(sub: Int) =
    lock.write { actual = (actual.toInt() - sub).toUByte() }

  /**
   * Subtracts the given value from this [AtomicUInt].
   *
   * @param sub Value to subtract.
   */
  operator fun minusAssign(sub: Long) =
    lock.write { actual = (actual.toInt() - sub).toUByte() }

  /**
   * Subtracts the given value from this [AtomicUInt].
   *
   * @param sub Value to subtract.
   */
  operator fun minusAssign(sub: AtomicUByte) =
    lock.write { actual = (actual - sub.value).toUByte() }

  /**
   * Subtracts the given value from this [AtomicUInt].
   *
   * @param sub Value to subtract.
   */
  operator fun minusAssign(sub: AtomicUShort) =
    lock.write { actual = (actual - sub.value).toUByte() }

  /**
   * Subtracts the given value from this [AtomicUInt].
   *
   * @param sub Value to subtract.
   */
  operator fun minusAssign(sub: AtomicUInt) =
    lock.write { actual = (actual - sub.value).toUByte() }

  /**
   * Subtracts the given value from this [AtomicUInt].
   *
   * @param sub Value to subtract.
   */
  operator fun minusAssign(sub: AtomicULong) =
    lock.write { actual = (actual - sub.value).toUByte() }

  // endregion -=

  // region /=

  /**
   * Divides this [AtomicUInt] by the given value.
   *
   * @param div Value to divide by.
   */
  operator fun divAssign(div: UByte) =
    lock.write { actual = (actual / div).toUByte() }

  /**
   * Divides this [AtomicUInt] by the given value.
   *
   * @param div Value to divide by.
   */
  operator fun divAssign(div: UShort) =
    lock.write { actual = (actual / div).toUByte() }

  /**
   * Divides this [AtomicUInt] by the given value.
   *
   * @param div Value to divide by.
   */
  operator fun divAssign(div: UInt) =
    lock.write { actual = (actual / div).toUByte() }

  /**
   * Divides this [AtomicUInt] by the given value.
   *
   * @param div Value to divide by.
   */
  operator fun divAssign(div: ULong) =
    lock.write { actual = (actual / div).toUByte() }

  /**
   * Divides this [AtomicUInt] by the given value.
   *
   * @param div Value to divide by.
   */
  operator fun divAssign(div: Byte) =
    lock.write { actual = (actual.toInt() / div).toUByte() }

  /**
   * Divides this [AtomicUInt] by the given value.
   *
   * @param div Value to divide by.
   */
  operator fun divAssign(div: Short) =
    lock.write { actual = (actual.toInt() / div).toUByte() }

  /**
   * Divides this [AtomicUInt] by the given value.
   *
   * @param div Value to divide by.
   */
  operator fun divAssign(div: Int) =
    lock.write { actual = (actual.toInt() / div).toUByte() }

  /**
   * Divides this [AtomicUInt] by the given value.
   *
   * @param div Value to divide by.
   */
  operator fun divAssign(div: Long) =
    lock.write { actual = (actual.toInt() / div).toUByte() }

  /**
   * Divides this [AtomicUInt] by the given value.
   *
   * @param div Value to divide by.
   */
  operator fun divAssign(div: AtomicUByte) =
    lock.write { actual = (actual / div.value).toUByte() }

  /**
   * Divides this [AtomicUInt] by the given value.
   *
   * @param div Value to divide by.
   */
  operator fun divAssign(div: AtomicUShort) =
    lock.write { actual = (actual / div.value).toUByte() }

  /**
   * Divides this [AtomicUInt] by the given value.
   *
   * @param div Value to divide by.
   */
  operator fun divAssign(div: AtomicUInt) =
    lock.write { actual = (actual / div.value).toUByte() }

  /**
   * Divides this [AtomicUInt] by the given value.
   *
   * @param div Value to divide by.
   */
  operator fun divAssign(div: AtomicULong) =
    lock.write { actual = (actual / div.value).toUByte() }

  // endregion /=

  // region *=

  /**
   * Multiplies this [AtomicUInt] by the given value.
   *
   * @param mul Value to multiply by.
   */
  operator fun timesAssign(mul: UByte) =
    lock.write { actual = (actual * mul).toUByte() }

  /**
   * Multiplies this [AtomicUInt] by the given value.
   *
   * @param mul Value to multiply by.
   */
  operator fun timesAssign(mul: UShort) =
    lock.write { actual = (actual * mul).toUByte() }

  /**
   * Multiplies this [AtomicUInt] by the given value.
   *
   * @param mul Value to multiply by.
   */
  operator fun timesAssign(mul: UInt) =
    lock.write { actual = (actual * mul).toUByte() }

  /**
   * Multiplies this [AtomicUInt] by the given value.
   *
   * @param mul Value to multiply by.
   */
  operator fun timesAssign(mul: ULong) =
    lock.write { actual = (actual * mul).toUByte() }

  /**
   * Multiplies this [AtomicUInt] by the given value.
   *
   * @param mul Value to multiply by.
   */
  operator fun timesAssign(mul: Byte) =
    lock.write { actual = (actual.toInt() * mul).toUByte() }

  /**
   * Multiplies this [AtomicUInt] by the given value.
   *
   * @param mul Value to multiply by.
   */
  operator fun timesAssign(mul: Short) =
    lock.write { actual = (actual.toInt() * mul).toUByte() }

  /**
   * Multiplies this [AtomicUInt] by the given value.
   *
   * @param mul Value to multiply by.
   */
  operator fun timesAssign(mul: Int) =
    lock.write { actual = (actual.toInt() * mul).toUByte() }

  /**
   * Multiplies this [AtomicUInt] by the given value.
   *
   * @param mul Value to multiply by.
   */
  operator fun timesAssign(mul: Long) =
    lock.write { actual = (actual.toInt() * mul).toUByte() }

  /**
   * Multiplies this [AtomicUInt] by the given value.
   *
   * @param mul Value to multiply by.
   */
  operator fun timesAssign(mul: AtomicUByte) =
    lock.write { actual = (actual * mul.value).toUByte() }

  /**
   * Multiplies this [AtomicUInt] by the given value.
   *
   * @param mul Value to multiply by.
   */
  operator fun timesAssign(mul: AtomicUShort) =
    lock.write { actual = (actual * mul.value).toUByte() }

  /**
   * Multiplies this [AtomicUInt] by the given value.
   *
   * @param mul Value to multiply by.
   */
  operator fun timesAssign(mul: AtomicUInt) =
    lock.write { actual = (actual * mul.value).toUByte() }

  /**
   * Multiplies this [AtomicUInt] by the given value.
   *
   * @param mul Value to multiply by.
   */
  operator fun timesAssign(mul: AtomicULong) =
    lock.write { actual = (actual * mul.value).toUByte() }

  // endregion *=

  // region < >

  operator fun compareTo(other: AtomicUByte) =
    lock.read { if (actual < other.value) -1 else if (actual > other.value) 1 else 0 }

  operator fun compareTo(other: AtomicUShort) =
    lock.read { if (actual < other.value) -1 else if (actual > other.value) 1 else 0 }

  operator fun compareTo(other: AtomicUInt) =
    lock.read { if (actual < other.value) -1 else if (actual > other.value) 1 else 0 }

  operator fun compareTo(other: AtomicULong) =
    lock.read { if (actual < other.value) -1 else if (actual > other.value) 1 else 0 }

  operator fun compareTo(other: UByte) =
    lock.read { if (actual < other) -1 else if (actual > other) 1 else 0 }

  operator fun compareTo(other: UShort) =
    lock.read { if (actual < other) -1 else if (actual > other) 1 else 0 }

  operator fun compareTo(other: UInt) =
    lock.read { if (actual < other) -1 else if (actual > other) 1 else 0 }

  operator fun compareTo(other: ULong) =
    lock.read { if (actual < other) -1 else if (actual > other) 1 else 0 }

  operator fun compareTo(other: Byte) =
    lock.read { actual.toInt().compareTo(other) }

  operator fun compareTo(other: Short) =
    lock.read { actual.toInt().compareTo(other) }

  operator fun compareTo(other: Int) =
    lock.read { actual.toInt().compareTo(other) }

  operator fun compareTo(other: Long) =
    lock.read { actual.toInt().compareTo(other) }

  operator fun compareTo(other: BigInteger) =
    lock.read { BigInteger.valueOf(actual.toLong()).compareTo(other) }

  // endregion < >

  override fun equals(other: Any?) =
    lock.read { if (other !is AtomicUInt) false else other.value == actual }

  override fun hashCode() =
    lock.read { actual.hashCode() }
}