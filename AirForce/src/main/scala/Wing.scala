package main.scala

trait Wing[+A] { // covariant in A
  val aircrafts: List[A] // immutable, so safe to be covariant in A
}

case class GenericWing(aircrafts: List[Aircraft]) extends Wing[Aircraft]

case class CombatWing(aircrafts: List[CombatAircraft]) extends Wing[CombatAircraft]

case class FighterWing(aircrafts: List[FighterAircraft]) extends Wing[FighterAircraft]

object Wing {
  def print_wing_profile(wing: Wing[Aircraft]): Unit = {
    println(s"A ${wing.getClass.getSimpleName} consisting of ${wing.aircrafts.map(_.name)}")
  }
}
