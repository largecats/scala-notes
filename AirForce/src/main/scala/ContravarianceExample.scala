package main.scala

object ContravarianceExample extends App {
  // aircrafts
  val u2 = new SpyAircraft("Lockheed U-2")
  val b2 = new BomberAircraft("Northrop Grumman B-2 Spirit")
  val f22 = new FighterAircraft("Lockheed Martin F-22 Raptor")

  // pilots
  val genericPilot = new GenericPilot()
  val combatPilot = new CombatPilot()
  val fighterPilot = new FighterPilot()

  // fly methods
  def fly_generic(pilot: Pilot[Aircraft], aircraft: Aircraft): Unit = pilot.fly(aircraft)
  def fly_combat(pilot: Pilot[CombatAircraft], aircraft: CombatAircraft): Unit = pilot.fly(aircraft)
  def fly_fighter(pilot: Pilot[FighterAircraft], aircraft: FighterAircraft): Unit = pilot.fly(aircraft)

  // flying!
  fly_fighter(fighterPilot, f22)

  fly_combat(combatPilot, b2)
  fly_fighter(combatPilot, f22)

  fly_generic(genericPilot, u2)
  fly_combat(genericPilot, b2)
  fly_fighter(genericPilot, f22)
}
