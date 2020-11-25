package main.scala

trait Aircraft {
  val name: String
}

class CombatAircraft(val name: String) extends Aircraft
class NonCombatAircraft(val name: String) extends Aircraft

class FighterAircraft(override val name: String) extends CombatAircraft(name)
class BomberAircraft(override val name: String) extends CombatAircraft(name)

class CargoAircraft(override val name: String) extends NonCombatAircraft(name)
class ReconnaissanceAircraft(override val name: String)  extends NonCombatAircraft(name)