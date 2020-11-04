package main.scala

trait Wing[+A] {
  val name: String // immutable
  val aircrafts: List[A] // immutable, so safe to be covariant in A
}

case class GenericWing(name: String, aircrafts: List[Aircraft]) extends Wing[Aircraft]

case class CombatWing(name: String, aircrafts: List[CombatAircraft]) extends Wing[CombatAircraft]

case class FighterWing(name: String, aircrafts: List[FighterAircraft]) extends Wing[FighterAircraft]

object Wing {
  def print_wing_profile(wing: Wing[Aircraft]): Unit = {
    println(s"${wing.name} is a ${wing.getClass.getSimpleName} consisting of ${wing.aircrafts.map(_.name)}")
  }
}
