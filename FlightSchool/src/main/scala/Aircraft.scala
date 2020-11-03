package main.scala

trait Aircraft {
  def name: String
}

class CivilianAircraft(val name: String) extends Aircraft
class MilitaryAircraft(val name: String) extends Aircraft

class PassengerAircraft(override val name: String) extends CivilianAircraft(name)
class CargoAircraft(override val name: String) extends CivilianAircraft(name)

class FighterAircraft(override val name: String) extends MilitaryAircraft(name)
class BomberAircraft(override val name: String)  extends MilitaryAircraft(name)

