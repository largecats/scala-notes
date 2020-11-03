import main.scala._

object Main extends App {
  val commercialFlight = new CarryPassengerTask("commercial flight")
  val cargoFlight = new CarryCargoTask("cargo flight")

  val dropBomb = new AirToGroundStrikeTask("drop bomb")
  val fireMissile = new AirToAirStrikeTask("fire missile")
  val dogFight = new AirToAirStrikeTask("dog fight")

  val convoyMission = new GenericMission(List(cargoFlight, fireMissile))
  val militaryMission = new MilitaryMission(List(fireMissile, dropBomb))
  val airToAirStrikeMission = new AirToAirStrikeMission(
    List(fireMissile, dogFight)
  )

  val maverick = new AirToAirStrikePilot("Maverick")
  val tony = new MilitaryPilot("Tony")
  val steve = new GenericPilot("Steve")

  val TopGun =
    new AirToAirStrikeFlightSchool(List(airToAirStrikeMission), maverick)

  Pilot.perform_air_to_air_strike(maverick, airToAirStrikeMission)

  Pilot.perform_military(tony, militaryMission)
  Pilot.perform_air_to_air_strike(tony, airToAirStrikeMission)

  Pilot.perform_generic(steve, convoyMission)
  Pilot.perform_military(steve, militaryMission)
  Pilot.perform_air_to_air_strike(steve, airToAirStrikeMission)
}
