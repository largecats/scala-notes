package main.scala

trait Formation[+A] { // covariant in A
  val leader: A
  val wingman: A
}

class GenericFormation(val leader: Aircraft, val wingman: Aircraft) extends Formation[Aircraft]

class CombatFormation(val leader: CombatAircraft, val wingman: CombatAircraft) extends Formation[CombatAircraft]

class FighterFormation(val leader: FighterAircraft, val wingman: FighterAircraft) extends Formation[FighterAircraft]