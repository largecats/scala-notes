package main.scala

trait Aircraft {
  def name: String
}

case class CivilianAircraft(val name: String) extends Aircraft
case class MilitaryAircraft(val name: String) extends Aircraft

case class PassengerAircraft(override val name: String) extends CivilianAircraft(name)
case class CargoAircraft(override val name: String) extends CivilianAircraft(name)

case class FighterAircraft(override val name: String) extends MilitaryAircraft(name)
case class BomberAircraft(override val name: String)  extends MilitaryAircraft(name)

