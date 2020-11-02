import main.scala.{AirToAirStrike, AirToAirStrikeFlightSchool, AirToAirStrikeMission, AirToAirStrikePilot, AirToGroundStrike, CarryCargo, CarryPassenger, FlightSchool, GenericMission, GenericPilot, MilitaryMission, MilitaryPilot}

object Main extends App {
  val commercialFlight = new CarryPassenger("commercial flight")
  val cargoFlight = new CarryCargo("cargo flight")

  val dropBomb = new AirToGroundStrike("drop bomb")
  val fireMissile = new AirToAirStrike("fire missile")
  val dogFight = new AirToAirStrike("dog fight")

  val convoyMission = new GenericMission(List(cargoFlight, fireMissile))
  val militaryMission = new MilitaryMission(List(fireMissile, dropBomb))
  val airToAirStrikeMission = new AirToAirStrikeMission(List(fireMissile, dogFight))

  val maverick = new AirToAirStrikePilot("Maverick")
  val tony = new MilitaryPilot("Tony")
  val steve = new GenericPilot("Steve")

  val TopGun = new AirToAirStrikeFlightSchool(List(airToAirStrikeMission), maverick)

  println(maverick.perform(airToAirStrikeMission))
  println(tony.perform(militaryMission))

  println(steve.perform(convoyMission))
  println(steve.perform(militaryMission))
  println(steve.perform(airToAirStrikeMission))
}