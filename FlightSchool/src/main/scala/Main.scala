import main.scala.{AirToAirStrikeTask, AirToAirStrikeFlightSchool, AirToAirStrikeMission, AirToAirStrikePilot, AirToGroundStrikeTask, CarryCargoTask, CarryPassengerTask, FlightSchool, GenericMission, GenericPilot, MilitaryMission, MilitaryPilot}

object Main extends App {
  val commercialFlight = new CarryPassengerTask("commercial flight")
  val cargoFlight = new CarryCargoTask("cargo flight")

  val dropBomb = new AirToGroundStrikeTask("drop bomb")
  val fireMissile = new AirToAirStrikeTask("fire missile")
  val dogFight = new AirToAirStrikeTask("dog fight")

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