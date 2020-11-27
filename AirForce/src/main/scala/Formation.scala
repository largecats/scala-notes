package main.scala

trait Formation[+A] { // covariant in A
  val leader: A
  val wingman: A
}

case class GenericFormation(leader: Aircraft, wingman: Aircraft) extends Formation[Aircraft]

case class CombatFormation(leader: CombatAircraft, wingman: CombatAircraft) extends Formation[CombatAircraft]

case class FighterFormation(leader: FighterAircraft, wingman: FighterAircraft) extends Formation[FighterAircraft]