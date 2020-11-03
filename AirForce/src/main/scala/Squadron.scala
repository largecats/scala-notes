package main.scala

trait Squadron[+A] {
  val name: String // immutable
  val aircrafts: List[A] // immutable, so safe to be covariant in A
}

case class GenericSquadron(name: String, aircrafts: List[Aircraft]) extends Squadron[Aircraft]

case class CombatSquadron(name: String, aircrafts: List[CombatAircraft]) extends Squadron[CombatAircraft]

case class FighterSquadron(name: String, aircrafts: List[FighterAircraft]) extends Squadron[FighterAircraft]

object Squadron {
  def print_squadron_profile(squadron: Squadron[Aircraft]): Unit = {
    println(s"${squadron.name} is a ${squadron.getClass.getSimpleName} consisting of ${squadron.aircrafts.map(_.name)}")
  }
}
